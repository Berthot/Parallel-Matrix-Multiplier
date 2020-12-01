package TCP;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;

public class RecebeObjeto extends Thread{


    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Aguardando uma conexão ...");
            Socket socket = server.accept();
            ObjectInputStream leitor = new ObjectInputStream(socket.getInputStream());
            System.out.println("Aguardando um objeto ...");
            Integer k = (Integer) leitor.readObject();
            System.out.println("Recebido o Integer com valor " + k);
            socket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
