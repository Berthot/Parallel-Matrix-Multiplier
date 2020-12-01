import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CoordinatorOperationServer extends Thread {

    private Socket socket;
    private ObjectToSendToCalculator receiveFromCalculator;
    private Matrix response;

    public CoordinatorOperationServer(Socket socket, ObjectToSendToCalculator receiveFromCalculator) {
        this.socket = socket;
        this.receiveFromCalculator = receiveFromCalculator;
    }

    @Override
    public void run() {

        try {
            ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
            writer.writeObject(this.receiveFromCalculator);

            ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());

            response = (Matrix) reader.readObject();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Matrix getResponse() {
        return response;
    }
}
