package code.missiongoogle.oopsdesign;

import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generic {
    public static void main(String[] args) {
        Printer<String> str = new Printer<>("Gaddar");
        Printer<Integer> num = new Printer<>(10);
        Printer<Character> chr = new Printer<>('A');
        Printer<Double> dou = new Printer<>(12.33);
        str.show();
        num.show();
        chr.show();
        dou.show();

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        Cat cat = new Cat();
        cat.bark();
        System.out.println(cats.get(0));
        sout("Gaddar");
        sout(2);
        sout(12.3);
        sout('A');
        System.out.println(method("gaddar", 19));
    }
    public static <T> void sout(T a){
        System.out.println(a);
    }
    public static <T, V> T method(T fist, V second){
        System.out.println(second);
        return fist;
    }
}
