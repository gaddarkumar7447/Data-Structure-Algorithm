package code.missiongoogle;

import java.util.*;
import java.util.stream.StreamSupport;

public class Oops extends Thread{
    /*@Override
    public void run(){
        try {
            System.out.println("Thread is running...");
        }
        catch (Exception e){
            System.out.println("Exception "+e);
        }
    }
    public static void sleep(int i) {
    }*/
}
class Dog{
    public void bark(){
        System.out.println("Barking");
    }
}
class Cat extends Dog{
    public void bark(){
        super.bark();
        System.out.println("Cat barking");
    }
    public static abstract class Animals{
        Animals(){
            System.out.println("All animals");
        }
        public abstract void sound();
    }

    public static class Dog extends Animals{
        @Override
        public void sound() {
            System.out.println("Dog is barking");
        }
    }
    public static class Lion extends Animals{
        @Override
        public void sound() {
            System.out.println("Lion is roaring");
        }
    }
}
// interface
interface Clint{
     void input();
     void output();
}

 class Raju implements Clint{
    String name;
    double sal;
    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");
        name = sc.nextLine();
        System.out.println("Enter the salary");
        sal = sc.nextDouble();
    }
    public void output(){
        System.out.println(name +" "+sal);
    }
}
// constructor overloading
class Ab{
    int a;
    String name;
    Ab(){
        System.out.println("Default");
    }
    Ab(int p, String n){
        a = p;
        name = n;
        System.out.println(a+" "+n);
    }
    Ab(float sal, String na){
        name = na;
        a = (int) sal;
    }
}
// instance & static
class Intence{
    {
        System.out.println("Intenece");
    }
    static{
        System.out.println("static");
    }
    /*public static void main(String[] args) {
        Intence a = new Intence();
    }*/
}
// Simple Inheritance
class Super{
    public  void show(){
        System.out.println("super class");
    }
}
class Sub extends  Super{
    public  void show(){
        super.show();
        System.out.println("sub class");
    }
}
// Multilevel inheritance
class Dina{
    String son;
    int sal;
    public void show(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter son name: ");
        son = scanner.next();
        System.out.println("Enter the salary: ");
        sal = scanner.nextInt();
        System.out.println(son +" "+sal);
    }
}
class Ram extends Dina{
    String a = son;
    int s = sal;
    public void dis() {
        super.show();
        System.out.println(a+" "+s);
    }
}
class Pawan extends Ram{
    String p = son;
    int anInt = sal;
    public void pa(){
        super.dis();
        System.out.println(son+" "+anInt);
    }

    public static void main(String[] args) {
        Pawan a = new Pawan();
        a.show();
        a.dis();
        a.pa();
    }
}
// super keywords

class Veg{
     Veg(int a){
        System.out.println(a);
    }
}

class Fruits extends Veg{
    int b = 38;
    Fruits(){
        super(100); // defaults
        System.out.println(b);
    }
    public static void main(String[] args) {
        Fruits g = new Fruits();
    }
}
// this
class This{
    This(){
        System.out.println("defaults");
    }
    int a; // instance variable
    This(int b /*local variable*/){
        this();
        this.a = b;
        System.out.println(b);
    }
    public static void main(String[] args) {
        This a = new This(100);
    }
}

// method overriding

class MethodOverriding{
    public void add(){
        int a = 100, b = 120;
        System.out.println("world");
    }
    /*public int add(int a, int b){
        return a*b;
    }
    public double add(int a, double c){
        double d = a +  c;
        System.out.println("world");
        return a - c;
    }
    public void add(int a){
        System.out.println("All parameters are different but method name is same ");
    }*/
}

class MethodEx extends MethodOverriding{
    @Override
    public void add(){
        super.add();
        System.out.println("hello");
    }
    public static void main(String[] args) {
        MethodEx a = new MethodEx();
        a.add();
    }
}
// Encapsulation

class Encap{
    private int value; // data hiding
    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
class Ex extends  Encap{
    public static void main(String[] args) {
        Encap a = new Encap();
        a.setValue(43);
        System.out.println(a.getValue());
    }
}

// Abstraction /*Abstract class*/
 class Abstract{
    public void show(){
        System.out.println("show");
    }
}
class Abc extends Abstract{
    public static void main(String[] args) {
        Abstract a = new Abc();
        a.show();
    }
}

abstract class Bank{
    public abstract int getInterest();
}
class SBI extends Bank{
    @Override
    public int getInterest() {
        return 7;
    }
}
class PNB extends Bank{
    @Override
    public int getInterest(){
        return 8;
    }
}
class TestBank{
    public static void main(String[] args) {
        Bank b = new SBI();
        System.out.println("Sbi interest "+b.getInterest());
        b = new PNB();
        System.out.println("Pnb interest "+b.getInterest());
    }
}

// Interface
interface PrintAble{
    public void show();
}
class Print implements PrintAble{
    @Override
    public void show() {
        System.out.println("print");
    }

    public static void main(String[] args) {
        PrintAble a = new Print();
        a.show();
    }
}

interface Client{
    void input();
    void output();
}
class Develop implements Client{
    String name;
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name: ");
        name = sc.nextLine();
    }
    @Override
    public void output() {
        System.out.println("Name : "+name);
    }
}

class FinalResult{
    public static void main(String[] args) {
        Develop a = new Develop();
        a.input();
        a.output();
    }
}

//Interface Method

interface Com{
    public void web();
    public void tech();
}
abstract class Sumit implements Com{
    @Override
    public void web(){
        System.out.println("Hiring");
    }
}
class Rahul extends Sumit{
    @Override
    public void web() {
        super.web();
        System.out.println("Working");
    }
    public void tech(){
        System.out.println("Both");
    }

    public static void main(String[] args) {
        Rahul a = new Rahul();
        a.tech();
        a.web();
    }
}

// Multiple interface
interface Mul{
    public abstract void s();
}
interface Til{
    public abstract void s();
}
class Final implements Mul, Til{
    @Override
    public void s() {
        System.out.println("shoe");
    }

    public static void main(String[] args) {
        Final a = new Final();
        a.s();
    }
}

// Extending interface
interface Ex1{
    public void ga();
}
interface pa extends Ex1{
    public default void pa(){
        System.out.println("gda");
    }
}
class T implements pa{
    @Override
    public void ga() {
        System.out.println("Gaddar");
    }
    public static void main(String[] args) {
        T t = new T();
        t.ga();
        t.pa();
    }
}

// After JDK 1.9
interface Af{
    default void call(){
        show();
    }
    private void show(){
        System.out.println(2+6);
    }
}
class Call implements Af{
    void show(int a, int b){
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        Call a = new Call();
        a.show(12,21); a.call();
    }
}
// Covarient
class Covarient{
    Covarient  method(){
        System.out.println("Super class");
        return this;
    }
}
class Co extends Covarient{
    @Override
    Co method(){
        super.method();
        System.out.println("Sub class");
        return this;
    }

    public static void main(String[] args) {
        Co co = new Co();
        co.method();
    }
}

// Var - args method
class Var{
    public static int varMethod(int ... g){
        int sum = 0;
        for (int i = 0; i < g.length; i++) {
            sum += g[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(varMethod(21,3,4,5,34,34,2,32,43));
        System.out.println(varMethod(21,3,4,32,43));
        System.out.println(varMethod(21,3,4,5,2,32,43));
    }
}

// Exception handling
class Exception{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 10, b = 0, c ;
        /*try {
            c = a/b;
            System.out.println(c);
        }
        catch (ArithmeticException e){
            System.out.println(e);
        }*/
        String str = null;
        try {
            System.out.println(str.toUpperCase());
        }catch (NullPointerException e){
            System.out.println(e);
        }
    }
}