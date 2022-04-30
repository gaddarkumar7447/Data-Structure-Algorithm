package code.missiongoogle;

import java.lang.String;
import java.util.Stack;

abstract class Teacher{
    Teacher(){
        System.out.println("Welcome students");
    }
    public void teach(){
        System.out.println("Teacher's is teaching us");
    }
}
class School extends Teacher{
    School(){
        super();
    }
    public void teach(){
        System.out.println("Teacher's is teaching math");
    }
}

class collage extends Teacher{
    collage(){
        super();
    }
    public void teach(){
        System.out.println("Teacher's is teaching english");
    }
}


public class Test {
    static private int age;
    static String name;
    static String branch;
    public String nam(){
        return name;
    }
    public int ag(){
        return age;
    }
    public String b(){
        return branch;
    }

    public void setName(String name1){
        name = name1;
    }
    public void setBranch(String branch1)
    {
        branch = branch1;
    }
    public void setAge(int age1){
        age = age1;
    }
    /*static class A{

            public void show1(){
                System.out.println("Hello");
            }
    }
    static class B extends A{
        public void show(){
            super.show1();
            System.out.println("Gaddar");
        }
    }*/

    interface A {
        void display();

        default void a1() {
            System.out.println("Gaddar");
        }
    }

    static class a {

    }

    static class myThread {
        int[] a = {2, 3, 5, 7, 9, 5, 4, 3};

        public void s() {
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                System.out.println(a[i]);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {

                }
            }
        }

    }

    public static class S {
        int count;

        public void run() {
            count++;
        }
    }

    static class Stud implements Comparable<Stud> {
        int roll, id;
        String name;

        public Stud(int roll, int id, String name) {
            this.roll = roll;
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Stud{" + "roll=" + roll + ", data=" + id + ", name='" + name + '\'' + '}';
        }

        @Override
        public int compareTo(Stud o) {
            return roll > o.roll ? 1 : -1;
        }
    }

    private static void lo(String chars) {
        System.out.println(chars.toUpperCase());
    }

    private static void up(String chars) {

        System.out.println(chars.toLowerCase());

    }

    public static int check(String ch, String c) {
        if (c.length() == 0) return 0;
        for (int i = 0; i < ch.length(); i++) {
            int j = 0;
            for (; j < c.length() && (i + j) >= c.length(); j++) {
                if (ch.charAt(i + j) == c.charAt(j)) {
                    continue;
                } else
                    break;
            }
            if (j == c.length())
                return i;
        }
        return -1;
    }

    public static int d(int dividend, int divisor) {
        if (divisor == dividend) return 1;
        if (divisor > dividend) return 0;
        if (divisor == 0) return 0;
        int i = 0;
        while (divisor != 0) {
            dividend -= divisor;
            i++;
            if (divisor >= dividend) {
                return dividend + i - 1;
            }
        }
        return divisor;
    }

    public static int search(int[] num, int target) {
        if (num == null) return target;
        int j = 0;
        for (int i = 0; i < num.length; i++) {
            j++;
            if (num[i] >= target) {
                return j - 1;
            }
        }
        return j;
    }

    public static boolean validString(String str) {
//        if (str.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                stack.push(')');
            }
            else if (str.charAt(i) == '['){
                stack.push(']');
            }
            else if (str.charAt(i) == '{'){
                stack.push('}');
            }
            else {
                if (stack.isEmpty() || stack.pop() != str.charAt(i)){
                    return false;
                }
            }

        }
        /*for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }

        }*/
        return stack.isEmpty();
    }
        /*Stack<Character> stack = new Stack<Character>();
        for (char c: str.toCharArray()) {
            if (c == '('){
                stack.push(')');
            }
            else if (c == '{'){
                stack.push('}');
            }
            else if (c == '['){
                stack.push(']');
            }
            else if (stack.empty() && stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();*/

   static class MyClass{
        int k, t;
        MyClass(){
            System.out.println("Hello there");
        }
        MyClass(int a, int b){
            this.t = a;
            this.k = b;
        }
        public void show(){
            System.out.println(this.t+" "+this.k);
        }
    }
    public static void main(int a){
        System.out.println("Java is best");
    }
    public static void main(String[] args) {
        System.out.println("Hello Gaddar");
        Test test = new Test();
        test.main(7);

       /*MyClass my = new MyClass(45,36);
       my.show();*/
        /*collage c = new collage();
        School sc = new School();
        c.teach();
        sc.teach();*/
        /*Test t = new Test();
        t.setAge(455);
        t.setName("Gaddar");
        t.setBranch("CSE");
        System.out.println(t.ag());
        System.out.println(t.b());
        System.out.println(t.nam());*/
        /*Scanner keyboard = new Scanner (System.in);
        System.out.print("Please Type a word: ");
        String word = keyboard.nextLine();
        int stringLength = word.length();
        String letter1 = word.substring (0,1);
        String lastletter = word.substring ((stringLength-1),(stringLength));
        String newWord =letter1.toUpperCase() + lastletter.toUpperCase();
        System.out.println("The word with first letter capitalized is: " + letter1 );*/

        /*Scanner sc = new Scanner(System.in);
        String s = new String(sc.next());
        char []c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[0] >= 97 && c[0] <= 123){
                c[0] -= 32;
            }
        }
        System.out.println(c);*/
        /*int []num =new int[] {1,2,5,7,9};
        int target = 3;
        System.out.println(search(num,target));*/
        /*String str = "([}}])";
        System.out.println(validString(str));*/
//        System.out.println(" "+d(8,12));

        /*Scanner sc = new Scanner(System.in);
        String haystack = new String(sc.next());
        String needle = "aaaa";
        System.out.println(check(haystack,needle));;*/
        }





        /*int i = 0;
        if (arr.length == 0) return 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i])
            {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;*/
        /*Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char []chars = str.toCharArray();
        int lower = 0, upper = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 97){
                lower++;
            }
            else {
                upper++;
            }
        }
        if (lower==upper){
            up(str);
        }
        else if (lower < upper)
            lo(str);
        else
            up(str);*/

        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year: ");
        int num = sc.nextInt();
        int b = num/100 % 10;
        System.out.println(b);*/
           /*while (num >= 1000 && num <= 9999){
               num++;
               int a= num/1000;
               int b = num/100 % 10;
               int c = num/10 % 10;
               int d = num % 10;
               if (a != b && a != c && a != d && b != c && b != d && c != d){
                   System.out.println(num);
                   break;
               }
           }*/

        /*Scanner sc = new Scanner(System.in);
        System.out.println("Write anyThings");

        for (int i = 0; i < 3; i++) {
            String a = sc.next();
            int n = sc.nextInt();

            System.out.printf("%-15s",a);
            System.out.printf("%03d\n",n);
        }*/
        /*StringBuilder word = new StringBuilder();
        for (char c: a.toCharArray()){
            if (Character.isDigit(c)) num.append(c);
            else word.append(c);
        }
        System.out.println(num);
        System.out.println(word);*/


        /*List<Stud> studs = new ArrayList<>();
        studs.add(new Stud(25,1,"Arun"));
        studs.add(new Stud(26,2,"Mohan"));
        studs.add(new Stud(27,3,"kamal"));
        studs.add(new Stud(28,4,"tarun"));
        studs.add(new Stud(29,5,"barun"));
        studs.add(new Stud(30,6,"anil"));

        Collections.sort(studs);
        Iterator iterator = studs.iterator();
        while (iterator.hasNext()){
            String str = iterator.next().toString();
            System.out.println(str);
        }*/

        /*List<Integer> list = new ArrayList<>();
        list.add(450);
        list.add(863);
        list.add(987);
        list.add(852);
        list.add(981);
        Collections.sort(list,(i, j) -> i % 10 > j % 10 ? 1: -1);
        Iterator i = list.listIterator();
        while (i.hasNext()){
            Object a = i.next();
            System.out.println(a);
        }*/
//        S s = new S();

       /* s.run();
        System.out.println(s.count);*/

        /*Thread sa = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    s.run();
                }
            }
        });
        sa.run();
        System.out.println(s.count);*/
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.'){
                output.append("0");
            }
            else if (input.charAt(i) == '-'){
                if (input.charAt(i+1) == '.'){
                    output.append("1");
                    i++;
                }
                else
                {
                    output.append("2");
                    i++;
                }
            }

        }
        System.out.println(output);*/

        /*myThread m = new myThread();
        m.s();*/
        /*student s = new student();
        s.setName("Gaddar");
        s.setRoll(25);
        System.out.println(s.name);
        System.out.println(s.roll);*/

//        A a = () -> System.out.println("Hello world");
//        a.a1();
//        a.display();
        /*try {
            int i = 9/0;
        }
        catch (Exception e){
            System.err.println("Error");
        }*/
        /*System.out.println("Enter the number: ");
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(b.readLine());
        System.out.println(a);
        Scanner sx = new Scanner(System.in);*/
}

