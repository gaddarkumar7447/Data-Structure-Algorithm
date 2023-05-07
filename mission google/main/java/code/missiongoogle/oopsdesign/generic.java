package code.missiongoogle.oopsdesign;

import java.util.*;
import java.util.stream.Collectors;

public class generic {
    static class Gen<T> {
        T[] arr = (T[]) new Object[10];
        int count = 0;

        public void add(T a) {
            arr[count++] = a;
        }

        public T get(int index) {
            return arr[index];
        }
    }

    enum NAM {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY;

    }

    static class ApiResponce <T>{
        T data;
        String message;
        ApiResponce(T data, String message){
            this.data = data;
            this.message = message;
        }
        static class Loading<T> extends ApiResponce<T>{
            Loading(T data, String message) {
                super(null, null);
            }
        }
        static class Success<T> extends ApiResponce<T>{
            Success(T data, String message) {
                super(data, message);
            }
        }
        static class Error<T> extends ApiResponce<T>{
            Error(String message) {
                super(null, message);
            }
        }
    }
    public static  <T extends Comparable<T>> T genericMethod(T num1, T num2){
        return (num1.compareTo(num2) < 0) ? num1 : num2;
    }

    public static <T> void funName(T name){
        System.out.println(name);
    }
    public static <K, V> void keyAndValue(K key, V value){
        System.out.println(key+":"+value);
    }
    public static <K, V, M> void funKeyValueANdMenu(K key, V value, M menu){
        System.out.println(key+":"+value+":"+menu);
    }
    class GenericClass <K, V>{
        private K key;
        private V value;
        GenericClass(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void put(K key, V value){

        }
    }
    record Person(String name , String full_name){}
    interface Printer{
        void print(String message, int num);
    }
    static class PrintT{
        String message;
        int num;
        public PrintT(String message, int num) {
            this.message = message;
            this.num = num;
        }

        private static void print(String message, int num) {
            System.out.println(message + ":" + num);
        }

        public void printMessage(Printer printer){
            printer.print(message, num);
        }
        public void show(){
            printMessage(new Printer() {
                @Override
                public void print(String message, int num) {
                    System.out.println(message +":"+num);
                }
            });
        }
    }
    static class Movie{
        private String name ;
        private int id ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Movie(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    static class DownloadPath implements Runnable{
        @Override
        public void run() {
            System.out.println("Start DownLoad: "+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(new DownloadPath());
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,3));
        System.out.println(arrayList);
        try {
            Thread.sleep(2000);
            thread.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Runtime.getRuntime().availableProcessors());

        /*PrintT a11 = new PrintT("Gaddar Kumar Chaudhary",20);
        a11.show();*/
        //IntStream.of(1,2,3,4,4).filter(value -> value % 2 == 0).map(i -> i * 2).forEach(System.out::println);
        int []nums = {11,2,3,14,5,6,7,8,9};
        //Arrays.stream(nums).filter(o -> o % 2 == 0).forEach(value -> System.out.println(value));
       /* var stream = Stream.generate(Math::random);
        stream.limit(10).map(a -> a * 1000).forEach(System.out::println);
        Stream.iterate(1, a -> a + 1).limit(10).forEach(System.out::println);*/
        List<Movie> movies = List.of(
                new Movie("Rama", 10),
                new Movie("Shayama", 20),
                new Movie("Kama", 30),
                new Movie("Ratna", 50),
                new Movie("Matana", 60),
                new Movie("Karana", 70));
        //Predicate<Movie> predicate = m -> m.getId() > 10;
        //movies.stream().filter(predicate).forEach(value -> System.out.println(value.getName()));
        //movies.stream().limit(5).skip(3).forEach(value -> System.out.println(value.getName()));
        //movies.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).forEach(movie -> System.out.println(movie.getName()));
        //movies.stream().sorted(Comparator.comparing(Movie::getName).reversed()).forEach(System.out::println);
        var as = movies.stream().map(Movie::getId).reduce(Integer::sum);
       // System.out.println(as.orElse(0));
        var list = movies.stream().collect(Collectors.summarizingInt(Movie::getId));
        //System.out.println(list);

        /*Person a = new Person("Gaddar", "Gaddar Kumar Chaudhary");
        System.out.println(a);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(12,12);
        funKeyValueANdMenu(10, "Gaddar", 81182.12);
        keyAndValue(10, "Gaddar");
        var number = genericMethod(1.2,12.1);
        System.out.println(number);*/
    }
    public static <T> void soutMethod(T a){
        System.out.println(a);
    }
    public static <T, V> T method(T fist, V second){
        System.out.println(second);
        return fist;
    }
}
