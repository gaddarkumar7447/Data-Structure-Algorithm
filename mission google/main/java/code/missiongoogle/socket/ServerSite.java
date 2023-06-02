package code.missiongoogle.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSite {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(1234);
            Socket socket = ss.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String s = "";
            while (!s.equals("stop")){
                s = dis.readUTF();
                System.out.println("Client says: "+s);
                dos.writeUTF(sc.nextLine());
                dos.flush();
            }
            dis.close();
            ss.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
