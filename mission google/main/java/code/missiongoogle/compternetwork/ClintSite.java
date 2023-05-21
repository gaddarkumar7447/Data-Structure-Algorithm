package code.missiongoogle.compternetwork;

import java.io.DataOutputStream;
import java.net.Socket;

public class ClintSite {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 6666);
            DataOutputStream dataInputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream.writeUTF("Hello Server");
            dataInputStream.flush();
            dataInputStream.close();
            socket.close();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
