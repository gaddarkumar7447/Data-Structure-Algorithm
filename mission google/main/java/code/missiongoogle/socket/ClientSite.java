package code.missiongoogle.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSite {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 1234);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            Scanner sc = new Scanner(System.in);
            String str = "";
            while (!str.equals("stop")){
                dos.writeUTF(sc.nextLine());
                str = dis.readUTF();
                System.out.println("Server Says: "+str);
            }
            dos.flush();
            dos.close();
            socket.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
