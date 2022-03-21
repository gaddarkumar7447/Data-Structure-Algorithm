package code.missiongoogle;

import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class LeeCode {
    /*static Node head;
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.next = null;
            this.data = data;
        }
    }*/
        public void addList(int data){
           Node newNode = new Node(data);
           if (head == null){
               head = newNode;
               return;
           }
           newNode.next = head;
           head = newNode;
        }

        public  void printList(){
            Node co = head;
            if (co == null) return;
            while (co != null){
                System.out.print(" "+co.data);
                co = co.next;
            }
        }

    public void removeDuplicateFromSortedList(){
        Node dummy = new Node(-1);
        dummy.next = head;
        Node cu = head;
        while (cu != null && cu.next != null){
            if (cu.data == cu.next.data){
                cu.next = cu.next.next;
            }
            else cu = cu.next;
        }
        while (dummy != null){
            System.out.println(" "+dummy.data);
            dummy = dummy.next;
        }
    }

public static int climbingStairs(int num){
        int a = 1 , b = 1;
        for (int i = 0; i < num - 1; i++) {
        int tem = a;
        a = a + b;
        b = tem;
    }
    return a;
}
public static boolean uglyNumber(int num){
        if (num == 2 || num == 3 || num == 5) return true;
        if (num == 0) return false;
        while (num % 2 == 0){
            num = num /2;
            System.out.println("Divide by 2- "+num);
        }
        while (num % 3 == 0){
        num = num /3;
            System.out.println("Divided by 3- "+num);
        }
        while (num % 5 == 0){
        num = num /5;
            System.out.println("Divided by 5- "+num);
        }
        return num == 1;
}
public static int fibo(int num){
        if(num == 1 || num == 0) return num;
//        System.out.print(" "+num);
        return fibo(num -1)+ fibo(num -2);

}
    static String whoCanFitTheNumber(String numString)
    {
        String answer = "";
        try{
            long num = Long.parseLong(numString);
            answer = numString + " can be fitted in:\n";
            if((num<=Byte.MAX_VALUE) && (num>=Byte.MIN_VALUE)){
                answer = answer.concat("* byte\n* short\n* int\n* long");
            }
            else if((num <= Short.MAX_VALUE) && (num >= Short.MIN_VALUE)){
                answer = answer.concat("* short\n* int\n* long");
            }
            else if((num <= Integer.MAX_VALUE) && (num >= Integer.MIN_VALUE)){
                answer = answer.concat("* int\n* long");
            }
            else{
                answer = answer.concat("* long");
            }
        }catch (NumberFormatException e){
            answer = numString+" can't be fitted anywhere.";
        }
        return answer;
    }
    public static Object a(int k){
        if (k == 0) return 7383;
        if (k > 0) return 'R';
        return "String";
    }

    /*static Scanner sc = new Scanner(System.in);
    static int a = sc.nextInt();
    static int b = sc.nextInt();
    static boolean flag = true;
    static{
        try {
            if (a <= 0 || b <= 0){
                flag = false;
                System.out.println("Enter the positive number");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }*/

public static boolean check(int num){
    boolean []arr = new boolean[1000];
//    Arrays.fill(arr,false);
    while(num != 0){
        int sum = 0;
        while (num != 0){
            int b = num % 10;
            sum = sum +(int) Math.pow(b,2);
            num /= 10;
        }
        if (sum == 1) return true;
        if (arr[sum] == true) break;
        arr[sum] = true;
        num = sum;

    }
    return false;
}

    /*Cracking the coding interview*/
    public static   boolean isUnique(String input) {
        if (input.length() > 26) return false;
        char []c = input.toCharArray();
        Arrays.sort(c);
        for (int i = 0; i < input.length() -1; i++) {
            if (c[i] == c[i+1]) return false;
        }
        /*int checker = 0;
        for(char c : input.toCharArray()) {
            int charBitVector = 1 << (c-'a');
            if((checker & charBitVector) > 0 )
                return false;
            checker = checker | charBitVector;
        }*/
        return true;
    }

    public static void swap(int []arr, int i, int j){
        int tem = arr[j];
        arr[j] = arr[i];
        arr[i] = tem;
    }
    public static int quick(int []arr, int l, int h){
        int pivot = arr[h];
        int low = (l-1);
        for (int i = low; i <= h-1; i++) {
            if (pivot > arr[i]){
                low++;
                swap(arr,low,i);
            }
        }
        swap(arr,low+1,h);
        return low + 1;
    }

    public static void quickSort(int []arr,int l, int h){
            int p = quick(arr,l,h);
            quickSort(arr,l,p-1);
            quickSort(arr,p+1,h);
    }

    public static int First_Unique(String s){
        /*char []q = s.toCharArray();*/
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c,0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.get(c) == 1) return i;
        }

        /*for (int i = 0; i < s.length() ; i++) {
            for (int j = i+1; j <s.length()-1 ; j++) {
                if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) return i;
            }
        }*/
        return -1;
    }

    public static boolean permutation(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        char []x1 = s1.toCharArray();
        char []x2 = s2.toCharArray();
        Arrays.sort(x1);
        Arrays.sort(x2);
        for (int i = 0; i < s1.length(); i++) {
            if (x1[i] != x2[i]){
                return false;
            }
        }
        return true;
    }

    public static int lengthOfLastWord(String s){
        int result = 0;
        char []c = s.toCharArray();
        int n = c.length;
        while (n>0){
            if (c[--n] != ' ') result++;
            else if (result > 0) return result;
        }
        return result;
    }

    public static String findDay(int dd, int month, int year){
        LocalDate localDate = LocalDate.of(year,month,dd);
        return localDate.getDayOfWeek().name();
    }
    public static void movesZero(int []num){
        /*ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0){
                arrayList.add(i);
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (i < num.length){
                num[i] = arrayList.get(i);
            }
            else num[i] = 0;
        }*/

        /*for (int i = 0; i < num.length; i++) {
            for (int j = 1; j < num.length; j++) {
                if (num[j-1] == 0){
                    int tem = num[j-1];
                    num[j-1] = num[j];
                    num[j] = tem;
                }
            }
        }*/
        int store = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0){
                num[store] = num[i];
                store++;
            }
        }
        for (int i = store; i < num.length; i++) {
            num[i] = 0;
        }
    }
    public static boolean wordPattern(String pattern, String s){
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char current = pattern.charAt(i);
            if (hashMap.containsKey(current)){
                if (!hashMap.get(current).equals(words[i])){
                    return false;
                }
            }
            else {
                if (hashMap.containsValue(words[i]))
                    return false;
                hashMap.put(current,words[i]);
            }
        }
        return true;
    }

    public static boolean wordPattern1(String pattern, String s){
        String[] arr= s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }
    public static void addBinary(String a, String b){
        BigInteger a1 = new BigInteger(a,2);
        BigInteger a2 = new BigInteger(b,2);
        System.out.println(a1.add(a2).toString(2));
    }

    public static String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;   // i is the pointer of "a" string
        int j = b.length() - 1;   // j is the pointer of "b" string

        int carry = 0;

        while( i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';  // to get the value like 1 - 0 = 1 & 0 - 0 = 0
            if(j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum%2);
            carry = sum / 2;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void L1(int d){
        Node newNode = new Node(d);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void L2(int d){
        Node newNode = new Node(d);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void printL(){
        Node newNode = head;
        if (head == null)return;
        while (newNode != null){
            System.out.print(newNode.data +" -> ");
            newNode = newNode.next;
        }
    }
    public static Node addTwoNumber(Node l1, Node l2){
        return l1;
    }
    public static int nthDigit(int num){
       StringBuilder s = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            s.append(i);
        }
//       return Character.getNumericValue(s.charAt(num));
        return Character.getNumericValue(s.charAt(num));
    }

    public static boolean isPerfectSquare(int num) {
        /*double ans = Math.sqrt(num);
        double a = Math.floor(ans);
        //double b = Math.ceil(ans);
        if (ans == a)return true;*/

        /*int low = 1;
        while (true){
            int ans = low * low;
            ++low;
            if (ans == num)
            return true;
            if (ans > num) break;
        }
        return false;*/
        long low = 0, high = num;
        while (low <= high){
            long mid = (low + high) / 2;
            long ans = mid * mid;
            if (ans == num) return true;
            else if (ans > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    public static boolean stringPalindrome(String s){
       return true;
    }

    public static int scoreOfParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(')');
                score++;
            }

        }


        return 0;
    }
    public static int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                st.push(score);
                score = 0;
            }
              else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }
    public static int singleNumber(int []arr){
        /*int result = 0;
        for (int i : arr)
        {
            result ^= i;
        }
        return result;*/
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] != arr[i]){
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }


    public static boolean is(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        char []c = s1.toCharArray();
        char []c1 = s2.toCharArray();
        Arrays.sort(c);
        Arrays.sort(c1);

        for (int i = 0; i < c.length; i++) {
                if (c[i] != c1[i]){
                    return false;
                }

        }
        return true;
    }

    public static int reverseInteger(int num){
        long sum = 0;

        int rem;
        while (num > 0){
            rem = num % 10;
            sum = sum * 10 + rem;
            num/= 10;
        }
        if (Integer.MAX_VALUE < sum){
            return 0;
        }

        return (int) sum;
    }
    public static List<String> latterCombination(String digits){
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return  result;
        HashMap<String, String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        Deque<String> deque = new ArrayDeque<>();
        deque.add("");
        for (int i = 0; i < digits.length(); i++) {
            String d = digits.substring(i,i+1);
            String fromMap = map.get(d);
            int n = deque.size();
            for (int j = 0; j < n; j++) {
                String pull = deque.pollFirst();
                for (int k = 0; k < fromMap.length(); k++) {
                    String  temp = pull.concat(fromMap.charAt(k)+"");
                    deque.add(temp);
                }
            }
        }
        while(!deque.isEmpty()){
            result.add(deque.poll());
        }
        return result;
    }

    public static int[] PlusOne(int []digits){
       int sum = 0;
        for (int digit : digits) {
            sum = sum * 10 + digit;
        }
        sum = sum + 1;
        String c = Integer.toString(sum);
        int []d = new int[c.length()];
        for (int i = 0; i < d.length; i++) {
            d[i] = c.charAt(i) - '0';
        }
        return d;
    }

    public static int majorityElement(int []arr){
        /*int maxTerm = 0;
        int index = -1;
        for (int i : arr) {
            int count = 0;
            for (int j :arr) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > maxTerm){
                maxTerm = count;
                index = i;
            }
        }
        if (maxTerm > arr.length/2){
            return arr[index];
        }
     return 0;*/
        int store = 0;
        int count = 0;
        for (int i : arr) {
            if(count == 0)
                store = i;
            if(i == store)
                count += 1;
            else
                count -= 1;
        }
        return store;
    }
    public static void main(String[] args) {
        int []arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));

        /*int []arr = {9,9,9,0,9};
        System.out.println(Arrays.toString(PlusOne(arr)));*/
//        System.out.println(latterCombination("2347"));
       /* int []a = {5,4,3,8,7};
        for (int i = 0; i < a.length / 2; i++) {
            int o = a.length -1 -i;
            int t = a[i];
            a[i] = a[o];
            a[o]= t;
        }
        System.out.println(Arrays.toString(a));*/

//        System.out.println(reverseInteger(1534236469));
//        System.out.println(Integer.MIN_VALUE);
        /*String s1 = "gaddar";
        String s2 = "rgadda";
        boolean a = is(s1,s2);
        out.printf(String.valueOf(a));*/

//        out.println(singleNumber(arr));
//        out.println(scoreOfParentheses("((()(()))"));
//        out.println(stringPalindrome("gaddar"));
//        out.println(isPerfectSquare(45));
//        double sqrt = 5.12547;
//        double a = Math.floor(sqrt);
//        out.println(a);

//        out.println(nthDigit(29));

        /*LeeCode d = new LeeCode();
        d.L1(2);
        d.L1(4);
        d.L1(3);
        printL();

        d.L2(5);
        d.L2(6);
        d.L2(7);*/
       /* String a = "101";
        String b = "100";
        System.out.println(addBinary1(a,b));*/

        /*int s = 45871254;
        String c = Integer.toBinaryString(s);
        System.out.println(c);*/
        /*String s = "dog dog dog dog";
        String pattern = "abba";
        System.out.println(wordPattern1(pattern,s));*/

        /*String []strings = s.split(" ");
        System.out.println(Arrays.toString(strings));*/
        /*
        System.out.println(wordPattern(pattern,s));*/
       /*
       String s = "This is a sample sentence.";
        String[] words = s.split("\\s+");*/
        /*for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }*/
//        System.out.println(Arrays.toString(words));
       /* int []num = {0,1,0,3,12};
        movesZero(num);
        System.out.println(Arrays.toString(num));*/
//        System.out.println(findDay(13,3,2022));
//        int a = lengthOfLastWord("gaddar Kumar chaudhary village ");
//        Calendar calendar = new GregorianCalendar();
//        System.out.println(permutation("gaddar","raid"));
        /*Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int a = First_Unique(s);
        System.out.println(a);*/
//        System.out.println(isUnique("gaddar"));
        /*int []arr = {5,3,2,4,8,1,9};
        quickSort(arr,0,arr.length-1);
        for (int j : arr) {
            System.out.print(" " + j);
        }*/

        /*Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(check(a));*/

        /*try{
            int n = sc.nextInt();
            String str = Integer.toString(n);
            if (n == Integer.parseInt(str)){
                System.out.println("Good job");
            }
        }
        catch (Exception e) {
            System.out.println("Wrong answer");
        }*/

//        System.out.println("Second");
        /*if (flag){
            int d = a*b;
            System.out.println(d);
        }*/
//        System.out.println(a(-25));
        /*Scanner sc = new Scanner(System.in);
        int i = 0;
        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(i+""+""+str);
            i++;
        }*/

        /*Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt() ;
        scanner.nextLine();
        for(int i=0; i<numTestCases;i++){
            String numString = scanner.nextLine();
            System.out.println(whoCanFitTheNumber(numString));
        }*/
//        System.out.println(" "+fibo(5));

        /*int num = 8;
        fibo(num);
        for (int i = 0; i < num; i++) {
            System.out.print(" "+fibo(i));
        }*/
        /*int num = 1500;
        System.out.println(uglyNumber(num));*/
        /*int p = climbingStairs(5);
        System.out.println(p);*/

            /*LeeCode c = new LeeCode();
            c.addList(8);
            c.addList(4);
            c.addList(4);
            c.addList(2);
            c.removeDuplicateFromSortedList();*/
    }
}
