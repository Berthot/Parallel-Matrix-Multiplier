import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class CalculatorClient{

    private static Socket socket;

    public static void main(String[] args)
    {
        try {
            socket = connectar();
            ObjectToSendToCalculator response = (ObjectToSendToCalculator) read();
            var matrix = new Calculators(response).CalculateMatrix();
            write(matrix);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static Socket connectar() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(Ports.PORT_COORDINATOR));
        return socket;
    }


    private static void write(Object obj) throws IOException {
        final ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(obj);
    }

    private static Object read() throws IOException, ClassNotFoundException {
        final ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        return inputStream.readObject();
    }
}
