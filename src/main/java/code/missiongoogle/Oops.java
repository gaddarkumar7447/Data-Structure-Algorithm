package code.missiongoogle;


import java.util.*;

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
    public void show(){
        System.out.println("Sub");
        super.show();
    }

    public static void main(String[] args) {
        Sub a = new Sub();
        a.show();
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
 class Exception extends Throwable {
     Exception(){

    }
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
        /*String str = null;
        try {
            System.out.println(str.toUpperCase());
        }catch (NullPointerException e){
            System.out.println(e);
        }*/

        try{
            System.out.println("Statement1");
            System.out.println("Statement2");
            c = a/2;
            System.out.println(c);
            String n = null;
            String p = n.toUpperCase();
            System.out.println("Statement3");
        }
        catch (ArithmeticException o){
            System.out.println(o);
        }
        catch (NullPointerException r){
            System.out.println("Hello");
        }
        finally {
            System.out.println("Finally block");
        }
        System.out.println("Gaddar");
    }
}

class Check{
    public void m1(){
        System.out.println("Rajen");
    }
}
class Che extends Check{
    @Override
    public void m1() {
        super.m1();
        System.out.println("Gaddar");
    }

    public static void main(String[] args) {
        Che a = new Che();
        a.m1();
    }
}

// Inheritance
class Inheritance {
    static class A1 {
        A1(){
            System.out.println("Constructor");
        }
        void method(int a, int b){
            System.out.println(a + b);
            System.out.println("Gaddar");
        }
    }
    static class A2 extends A1{
        void method() {
            super.method(1,2);
            System.out.println("Another method");
        }
        public static void main(String[] args) {
            A2 a = new A2();
            a.method();
        }
    }
}

// Object class

class Finalize{
    public static void main(String[] args) {
        Finalize a = new Finalize();
        System.out.println(a.hashCode());
        a = null;
        System.out.println(a);
        System.out.println("end garbage collector");
    }
}
// Throw
class ThrowKey{
    public static int check(int a, int b) throws ArithmeticException{
        return a/b;
    }
    public static void main(String[] args) throws InvalidAgeException {
        /*try {
            check(23,0);
        }catch (ArithmeticException e){
            System.out.println("Cont divided in to zero");
        }
        System.out.println("rest");*/
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 18){
            throw new InvalidAgeException("Not handle");
        }
    }

    private static class InvalidAgeException extends Throwable {
        public InvalidAgeException(String st){
            System.out.println(st);
        }
    }
}

class Assignment4{

    void show(int a, int b){
        System.out.println(Math.max(a,b));
    }

    void show(double a, double b){
        System.out.println(Math.max(a,b));
    }

    public static void main(String[] args) {
        Assignment4 a = new Assignment4();
        a.show(1,2);
        a.show(1.1,12.1);
    }
}

class Point{
    int x, y;
    Point(){
        this.x = 0;
        this.y = 0;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void calDis(Point b){
        int pow = (int) Math.pow((this.x-b.x),2);
    }
}

class Complex{
    int r, i;
    Complex(){
        this.i = 0;
        this.r = 0;
    }
    void setR(int r){
        this.r = r;
    }
    void setI(int i){
        this.i = i;
    }
    int getR(){
        return this.r;
    }
    int getI(){
        return this.i;
    }
    void add(Complex b){
        System.out.println((this.r + b.r)+"+"+"i"+(this.i + b.i));
    }

    public static void main(String[] args) {
        Complex a = new Complex();
        a.setI(3);
        a.setR(5);
        a.add(a);
    }
}

class Shape{
    int x, y;
    void getXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    void showXY(){
        System.out.println(this.x +" "+this.y);
    }
    public static void main(String[] args) {
        Rectangle a = new Rectangle();
        a.getXY(3,5);
        a.showXY();
    }
}
class Rectangle extends Shape{
    @Override
    void getXY(int len, int bre) {
        super.getXY(bre, len);
        areaRec(len, bre);
    }
    void areaRec(int l, int b){
        System.out.println(l * b);
    }
}

class Add{
    int a, b;
    Add(int a, int b){
        this.a = a;
        this.b = b;
    }
     void sub(Add b){
        System.out.println((b.b + this.b)+" "+(b.a + this.a));
    }

    @Override
    public String toString() {
        return "Add{" + "a=" + a + ", b=" + b + '}';
    }

    public static void main(String[] args) {
        Add a = new Add(1,2);
        Add b = new Add(3,4);
        System.out.println(a);
        a.sub(b);
    }
}

class Shape1{
    int x, y;

    void getXY(){
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
    }
    void show(){
        System.out.println("X "+x);
        System.out.println("Y "+y);
    }
}
class Rectangle1 extends Shape1{
    int len, bre;
    @Override
    void getXY() {
        super.getXY();
        System.out.println("Enter the len and bre");
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        bre = sc.nextInt();
    }
    @Override
    void show() {
        super.show();
        System.out.println("rectangle: "+len*bre);
    }

    public static void main(String[] args) {
        Shape1 a = new Rectangle1();
        a.getXY();
        a.show();
    }
}

abstract class Dimension{
    double height, width;
    void setValue(int height, int width){
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
    abstract double getA();
}
class Rec extends Dimension{

    @Override
    double getA() {
        return getHeight() * getWidth();
    }
}
class Tri extends Dimension{
    @Override
        double getA(){
            return (getHeight() * getWidth())/2;
        }
}
class Test1{
    public static void main(String[] args) {
        Dimension a = new Rec();
        a.setValue(2,7);
        System.out.println(a.getA());

        a = new Tri();
        a.setValue(2,7);
        System.out.println(a.getA());
    }
}

interface Area{
    double pi = 3.14;
    double cal(double w, double h);

}
class Rect implements Area{
    @Override
    public double cal(double r, double h){
        return 4 * r;
    }
}
class Cir implements Area{

    @Override
    public double cal(double r, double h) {
        return pi * r * r;
    }
}
class Test2{
    public static void main(String[] args) {
        Area a = new Rect();
        System.out.println(a.cal(12,5));
        Area b = new Cir();
        System.out.println(b.cal(12,4));
    }
}

interface Area1{
    double compute(double x, double y);
    final double pi = 3.14;
}
interface Display{
    void show(double r);
}
class Rect1 implements Area1, Display{
    @Override
    public double compute(double x, double y) {
        return 0;
    }

    @Override
    public void show(double r) {
        System.out.println("Show interfce rex");
    }
}
class Cir1 implements Area1, Display{
    @Override
    public double compute(double x, double y) {
        return 0;
    }

    @Override
    public void show(double r) {
        System.out.println("Multiple interface circle");
    }
}
class Te{
    public static void main(String[] args) {
        Area1 a = new Rect1();
        a.compute(12,34);
        Display d = new Rect1();
        d.show(2);
    }
}
