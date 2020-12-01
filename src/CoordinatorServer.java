import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CoordinatorServer extends Thread {
    private Coordinator coordinator;

    public CoordinatorServer(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    @Override
    public void run() {
        try {

            ServerSocket s = new ServerSocket();
            s.bind(new InetSocketAddress(Ports.PORT_COORDINATOR));
            System.out.println("Servidor de envio de matrix");
            List<CoordinatorOperationServer> coordinatorList = new ArrayList<>();

            for (ObjectToSendToCalculator sendToCalculator : this.coordinator.sendToCalculators) {
                final Socket socket = s.accept();
                System.out.println("Matrix recebida");
                var thread = new CoordinatorOperationServer(socket, sendToCalculator);
                thread.start();
                coordinatorList.add(thread);
            }

            for (var x :coordinatorList){
                x.join();
            }

            this.coordinator.MergeMatrix(coordinatorList.get(0).getResponse(),coordinatorList.get(1).getResponse(),
                    coordinatorList.get(2).getResponse(),coordinatorList.get(3).getResponse());


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
