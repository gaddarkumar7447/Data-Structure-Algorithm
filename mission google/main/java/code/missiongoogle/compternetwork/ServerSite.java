package code.missiongoogle.compternetwork;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSite {
    public static void main(String []args){
        Scanner sv = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
            String str = dataInputStream.readUTF();
            System.out.println("message: "+str);
            ss.close();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
