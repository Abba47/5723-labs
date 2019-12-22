import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class OutThread extends Thread {

    InetAddress ipAddress;
    int port;
    DatagramSocket sender;

    public OutThread(InetAddress ip, int port, DatagramSocket socket) {
        this.ipAddress = ip;
        this.port = port;
        this.sender = socket;
    }

    public void run() {
        String name = "You";
        Path currentRelativePath = Paths.get("");
        String currKatalog = currentRelativePath.toAbsolutePath().toString();
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println(name+": ");
            String send= scan.nextLine();
            if(send.equals("@name")) {
                System.out.println("input your name: ");
                name = scan.nextLine();
                continue;
            }
            if(send.equals("@quit")){
                sender.close();
                return;
            }
            
            DatagramPacket dp =new DatagramPacket(send.getBytes(),send.getBytes().length,ipAddress,port);
            try {
                sender.send(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
