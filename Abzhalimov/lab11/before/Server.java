import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket server = new DatagramSocket(Integer.parseInt(args[0]));
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
        server.receive(receivePacket);
        InetAddress ipAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        InThread input = new InThread(server);
        OutThread out = new OutThread(ipAddress,port,server);
        input.start();
        out.start();
        out.join();
    }
}
