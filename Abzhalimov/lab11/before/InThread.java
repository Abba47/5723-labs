import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class InThread extends Thread {

    private DatagramSocket server;

    public InThread(DatagramSocket server){
        this.server =  server;
    }

    public void run(){
        try {
            String name = "opponent";
            String sentence;
            while(true){
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
                server.receive(receivePacket);
                receiveData = receivePacket.getData();
                int length;
                for(length = 0; receiveData[length] != 0; length++);
                byte[] correctReceive = new byte[length];
                for(int j = 0; j < length; j++){
                    correctReceive[j] = receiveData[j];
                }
                sentence = new String(correctReceive);
                if (sentence.contains("name")){ 
                String[] subStr = sentence.split(" "); 
                name = subStr[1]; 
                continue; 
                }
                System.out.println(name+": "+sentence);
            }
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
