package abgabe1.aufgabe2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Receiver {
    DatagramSocket socket;
    static final Integer SOCKET_PORT = 50000;
    static final Integer BUFFER_SIZE = 256;

    public Receiver(Integer port) {
        try {
            this.socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        byte[] buffer = new byte[BUFFER_SIZE];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        try {
            System.out.println("Listening..");
            while (true) {
                this.socket.receive(dp);
                System.out.println("UDP listener: [" + new String(dp.getData(), 0, dp.getLength())+"]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Receiver receiver = new Receiver(SOCKET_PORT);
        receiver.listen();
    }

}
