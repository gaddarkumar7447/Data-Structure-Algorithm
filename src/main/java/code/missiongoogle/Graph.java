package code.missiongoogle;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class Mobile{
    public void makeCall(){
        System.out.println("Make Call anyone");
    }
    public void sendMessage(){
        System.out.println("Send message");
    }
    public void takePicture(){
        System.out.println("Take picture");
    }
}
public class Graph {
    void add(){
        int a= 10, b =10;
        System.out.println(a+b);
    }
    void sub(int x, int y){
        System.out.println(x - y);
    }

    int mul (){
        int a = 5, b = 2;
        return  a*b;
    }
    int div(int x, int y){
        return x/y;
    }

    public static void main(String[] args) {
        Graph a = new Graph();
        a.add();
        a.sub(10,5);
        System.out.println(a.mul());
        System.out.println(a.div(10,3));
        /*Mobile mobile = new Mobile();
        mobile.makeCall();
        mobile.sendMessage();
        mobile.takePicture();*/

       /* Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();*/

        /* Create custom Locale for India.
          I used the "IANA Language Subtag Registry" to find India's country code */
//        Locale indiaLocale = new Locale("en", "IN");

        /* Create NumberFormats using Locales */
       /* NumberFormat us     = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india  = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china  = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);*/

        /* Print output */
        /*System.out.println("US: "     + us.format(payment));
        System.out.println("India: "  + india.format(payment));
        System.out.println("China: "  + china.format(payment));
        System.out.println("France: " + france.format(payment));*/
        /*Scanner sc = new Scanner(System.in);
        double pay = sc.nextDouble();
        sc.close();
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        String us = n.format(pay);

        NumberFormat n1 = NumberFormat.getNumberInstance();
        String in = n1.format(pay);

        NumberFormat n2 = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String ch = n2.format(pay);

        NumberFormat n3 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = n3.format(pay);

        System.out.println("US: "+us);
        System.out.printf("India: Rs.%f",Integer.parseInt(in));
        System.out.println("China: "+ch);
        System.out.println("France: "+france);*/


    }
}
