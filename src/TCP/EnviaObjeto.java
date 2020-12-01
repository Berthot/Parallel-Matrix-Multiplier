package TCP;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class EnviaObjeto extends Thread{
    public static void main(String args[]) {
        try {
            Integer k = new Integer(50);
            Socket socket = new Socket("localhost", 6000);
            ObjectOutputStream gravador = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Enviando o Integer com valor " + k);
            gravador.writeObject(k);
            System.out.println("Enviado!");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
