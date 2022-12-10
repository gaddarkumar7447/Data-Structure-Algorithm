package code.missiongoogle.oopsdesign;

public class Printer <T>{
    T interPrinter;
    Printer(T interPrinter){
        this.interPrinter = interPrinter;
    }

    public void show(){
        System.out.println(interPrinter);
    }
}
