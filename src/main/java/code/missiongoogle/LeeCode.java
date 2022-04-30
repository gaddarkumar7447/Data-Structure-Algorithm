package code.missiongoogle;
import java.math.BigInteger;
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
    public void addList(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node co = head;
        if (co == null) return;
        while (co != null) {
            System.out.print(" " + co.data);
            co = co.next;
        }
    }

    public void removeDuplicateFromSortedList() {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node cu = head;
        while (cu != null && cu.next != null) {
            if (cu.data == cu.next.data) {
                cu.next = cu.next.next;
            } else cu = cu.next;
        }
        while (dummy != null) {
            System.out.println(" " + dummy.data);
            dummy = dummy.next;
        }
    }

    public static int climbingStairs(int num) {
        int a = 1, b = 1;
        for (int i = 0; i < num - 1; i++) {
            int tem = a;
            a = a + b;
            b = tem;
        }
        return a;
    }

    public static boolean uglyNumber(int num) {
        if (num == 2 || num == 3 || num == 5) return true;
        if (num == 0) return false;
        while (num % 2 == 0) {
            num = num / 2;
            System.out.println("Divide by 2- " + num);
        }
        while (num % 3 == 0) {
            num = num / 3;
            System.out.println("Divided by 3- " + num);
        }
        while (num % 5 == 0) {
            num = num / 5;
            System.out.println("Divided by 5- " + num);
        }
        return num == 1;
    }

    public static int fibo(int num) {
        if (num == 1 || num == 0) return num;
//        System.out.print(" "+num);
        return fibo(num - 1) + fibo(num - 2);
    }

    static String whoCanFitTheNumber(String numString) {
        String answer = "";
        try {
            long num = Long.parseLong(numString);
            answer = numString + " can be fitted in:\n";
            if ((num <= Byte.MAX_VALUE) && (num >= Byte.MIN_VALUE)) {
                answer = answer.concat("* byte\n* short\n* int\n* long");
            } else if ((num <= Short.MAX_VALUE) && (num >= Short.MIN_VALUE)) {
                answer = answer.concat("* short\n* int\n* long");
            } else if ((num <= Integer.MAX_VALUE) && (num >= Integer.MIN_VALUE)) {
                answer = answer.concat("* int\n* long");
            } else {
                answer = answer.concat("* long");
            }
        } catch (NumberFormatException e) {
            answer = numString + " can't be fitted anywhere.";
        }
        return answer;
    }

    public static Object a(int k) {
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

    public static boolean check(int num) {
        boolean[] arr = new boolean[1000];

//    Arrays.fill(arr,false);
        while (num != 0) {
            int sum = 0;
            while (num != 0) {
                int b = num % 10;
                sum = sum + (int) Math.pow(b, 2);
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
    public static boolean isUnique(String input) {
        if (input.length() > 26) return false;
        char[] c = input.toCharArray();
        Arrays.sort(c);
        for (int i = 0; i < input.length() - 1; i++) {
            if (c[i] == c[i + 1]) return false;
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

    public static void swap(int[] arr, int i, int j) {
        int tem = arr[j];
        arr[j] = arr[i];
        arr[i] = tem;
    }

    public static int quick(int[] arr, int l, int h) {
        int pivot = arr[h];
        int low = (l - 1);
        for (int i = low; i <= h - 1; i++) {
            if (pivot > arr[i]) {
                low++;
                swap(arr, low, i);
            }
        }
        swap(arr, low + 1, h);
        return low + 1;
    }

    public static void quickSort(int[] arr, int l, int h) {
        int p = quick(arr, l, h);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, h);
    }

    public static int First_Unique(String s) {
        /*char []q = s.toCharArray();*/
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
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

    public static boolean permutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] x1 = s1.toCharArray();
        char[] x2 = s2.toCharArray();
        Arrays.sort(x1);
        Arrays.sort(x2);
        for (int i = 0; i < s1.length(); i++) {
            if (x1[i] != x2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int lengthOfLastWord(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        int n = c.length;
        while (n > 0) {
            if (c[--n] != ' ') result++;
            else if (result > 0) return result;
        }
        return result;
    }

    public static String findDay(int dd, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, dd);
        return localDate.getDayOfWeek().name();
    }

    public static void movesZero(int[] num) {
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
            if (num[i] != 0) {
                num[store] = num[i];
                store++;
            }
        }
        for (int i = store; i < num.length; i++) {
            num[i] = 0;
        }
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char current = pattern.charAt(i);
            if (hashMap.containsKey(current)) {
                if (!hashMap.get(current).equals(words[i])) {
                    return false;
                }
            } else {
                if (hashMap.containsValue(words[i]))
                    return false;
                hashMap.put(current, words[i]);
            }
        }
        return true;
    }

    public static boolean wordPattern1(String pattern, String s) {
        String[] arr = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if (arr.length != pattern.length())
            return false;
        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i]))
                    return false;
            } else {
                if (map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }

    public static void addBinary(String a, String b) {
        BigInteger a1 = new BigInteger(a, 2);
        BigInteger a2 = new BigInteger(b, 2);
        System.out.println(a1.add(a2).toString(2));
    }

    public static String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;   // i is the pointer of "a" string
        int j = b.length() - 1;   // j is the pointer of "b" string

        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';  // to get the value like 1 - 0 = 1 & 0 - 0 = 0
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void L1(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void L2(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void printL() {
        Node newNode = head;
        if (head == null) return;
        while (newNode != null) {
            System.out.print(newNode.data + " -> ");
            newNode = newNode.next;
        }
    }

    public static Node addTwoNumber(Node l1, Node l2) {
        return l1;
    }

    public static int nthDigit(int num) {
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
        while (low <= high) {
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

    public static boolean stringPalindrome(String s) {
        return true;
    }

    public static int scoreOfParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
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
            if (c == '(') {
                st.push(score);
                score = 0;
            } else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }

    public static int singleNumber(int[] arr) {
        /*int result = 0;
        for (int i : arr)
        {
            result ^= i;
        }
        return result;*/

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] != arr[i]) {
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }


    public static boolean is(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c = s1.toCharArray();
        char[] c1 = s2.toCharArray();
        Arrays.sort(c);
        Arrays.sort(c1);

        for (int i = 0; i < c.length; i++) {
            if (c[i] != c1[i]) {
                return false;
            }
        }
        return true;
    }

    public static int reverseInteger(int num) {
        long sum = 0;

        int rem;
        while (num > 0) {
            rem = num % 10;
            sum = sum * 10 + rem;
            num /= 10;
        }

        if (Integer.MAX_VALUE < sum) {
            return 0;
        }

        return (int) sum;
    }

    public static List<String> latterCombination(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        Deque<String> deque = new ArrayDeque<>();
        deque.add("");
        for (int i = 0; i < digits.length(); i++) {
            String d = digits.substring(i, i + 1);
            String fromMap = map.get(d);
            int n = deque.size();
            for (int j = 0; j < n; j++) {
                String pull = deque.pollFirst();
                for (int k = 0; k < fromMap.length(); k++) {
                    String temp = pull.concat(fromMap.charAt(k) + "");
                    deque.add(temp);
                }
            }
        }
        while (!deque.isEmpty()) {
            result.add(deque.poll());
        }
        return result;
    }

    public static int[] PlusOne(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum = sum * 10 + digit;
        }
        sum = sum + 1;
        String c = Integer.toString(sum);
        int[] d = new int[c.length()];
        for (int i = 0; i < d.length; i++) {
            d[i] = c.charAt(i) - '0';
        }
        return d;
    }


    public static int majorityElement(int[] arr) {

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
            if (count == 0)
                store = i;
            if (i == store)
                count += 1;
            else
                count -= 1;
        }
        return store;
    }

    public static int stringToInteger(String s) {
        int num = 0;
//        char []c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            num = num * 10 + s.charAt(i);

        }
        return num;
    }

    public static int addDigit(int num) {
//        return  num==0 ? 0:(num % 9 == 0 ?0:(num % 9));
        int temp = 0;
        while (num > 0) {
            temp = temp + num % 10;
            if (temp >= 10) {
                temp = temp / 10 + temp % 10;
            }
            num /= 10;
        }
        return temp;
    }


    public static boolean fourthPower(int num) {
        if (num == 1) return true;
        for (int i = 0; i < Math.sqrt(num); i++) {
            if (num == Math.pow(4, i))
                return true;
        }
        return false;
    }


    public static int ncr(int n, int r) {
        if (n <= 0 || r < 0) return 0;
        if (r > n) return 0;
        return fact(n) / (fact(n - r) * fact(r));
    }

    static int fact(int num) {
        if (num == 1 || num == 0) return num;
        return num * fact(num - 1);
    }

    public static char findTheDifference(String s, String t) {
        if (s.length() == t.length()) return 0;
        char[] as = s.toCharArray();
        char[] at = t.toCharArray();
        Arrays.sort(as);
        Arrays.sort(at);

        for (int i = 0; i < as.length; i++) {
            if (as[i] != at[i]) {
                return at[i];
            }
        }
        return at[at.length - 1];
    }

    public static void reverseString(char[] c) {
        for (int i = 0; i < c.length / 2; i++) {
            int temp = c.length - 1 - i;
            char o = c[i];
            c[i] = c[temp];
            c[temp] = o;
        }
        System.out.println(Arrays.toString(c));
    }

    public static void swapO(int[] arr) {
        int a = arr.length - 1;
        int i = 0;
        int b = arr[i];
        while (i < a) {
            arr[a] = arr[a] ^ arr[i];
            arr[i] = arr[a] ^ arr[i];
            arr[a] = arr[a] ^ arr[i];
            a--;
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void putBracket(int num) {
        /*List<String> list = new ArrayList<>();
        String s = "(";
        String p = ")";
        int j = 0;
        for (int i = 0; i < num; i++) {
            list.add(s);
        }
        for (int i = 0; i < num; i++) {
            list.add(p);
        }
        System.out.print(list);*/

        List<String> result = new ArrayList<>();
        findAll("(", 1, 0, result, num);
        System.out.println(result);
    }

    public static void findAll(String s, int o, int c, List<String> result, int num) {
        if (s.length() == 2 * num) {
            result.add(s);
            return;
        }
        if (o < num) findAll(s + "(", o + 1, c, result, num);
        if (c < o) findAll(s + ")", o, c + 1, result, num);
    }

    public static int missingNumber(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(sum);
        return arr.length * (arr.length + 1) / 2 - sum;
    }

    public static boolean IsSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        /*int count = 0;
        for (int i = 0; i < t.length() && count < s.length(); i++) {
            if (s.charAt(count) == t.charAt(i)){
                count ++;
            }
        }
        if (count == s.length()) return true;
        return false;*/
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                count++;
            }
        }
        return count == a.length;
    }

    public static boolean ransomNote(String s, String t) {
        char[] c = new char[26];
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        for (char p : b) {
            c[p - 'a']++;
        }
        for (char p : a) {
            c[p - 'a']--;
        }
        for (int i : c) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    public static int binarySe(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // TODO: 26-03-2022 Not completed this  question
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        for (int i = 1; i < n; i++) {
            if (duration != i) {
                return timeSeries[i];
            }
        }
        return 1;
    }

    public static String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < k - 1; i++) {
            int a = k - 1;
            char p = c[i];
            c[i] = c[a];
            c[a] = p;
        }
        return String.valueOf(c);
    }


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int rem = target - num;
            if (hash.containsKey(rem)) {
                int index = hash.get(rem);
                if (index == i) continue;
                return new int[]{nums[i], nums[index]};
            }
        }
        return new int[]{};
    }


    public static ArrayList<Integer> threeSum(int[] arr) {
        /*Set<List<Integer>> list = new HashSet<>();
        for(int i = 0; i <arr.length; i++){
            for(int j = i+1; j <arr.length; j++){
                for(int k = j+1; k <arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        list.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    }
                }
            }
        }
        return new HashSet<>(list);*/
        /*Arrays.sort(arr);
        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < arr.length-2; i++) {
            int j = i+1;
            int k = arr.length-1;
            while (k > j){
                int sum = arr[j] + arr[k];
                if (sum == -arr[i]){
                    list.add(Arrays.asList(arr[i], arr[j++], arr[k--]));
                }
                else if (sum > -arr[i]) k--;
                else if (sum < -arr[i]) j++;
            }
        }
        return new ArrayList<>(list);*/
        return null;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        /*Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    for(int l = k+1; l < nums.length; l++){
                        set.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                    }
                }
            }
        }
        return new ArrayList<>(set);*/

        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int start = j + 1;
                int last = nums.length - 1;
                while (last > start) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[last];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[start++], nums[last--]));
                    } else if (sum > target) last--;
                    else start++;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static int divide(int dividend, int divisor) {
        if (divisor < 0 || dividend < 0)
            return dividend / divisor;
        if (dividend == divisor)
            return 1;
        int i = 0;
        int sum = dividend;
        while (sum > divisor) {
            int a = sum - divisor;
            i++;
            if (sum < 3) {
                return i + 1;
            }
            sum = a;
            if (a == divisor)
                return i + 1;
        }
        return i;
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length;
            while (end > start) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    list.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                } else if (sum > target) end--;
                else start++;
            }

        }
        return new ArrayList<>(list);
    }


    public static void nextPermutation(int[] arr) {

        //Arrays.sort(arr);
        /*for (int i = 0; i < arr.length/2; i++) {
            int j = i+1;
            int k = arr.length-1;
            int swap = arr[j];
            arr[j] = arr[k];
            arr[k] = swap;
        }*/

//     }
        // int sum = 0;
        // List<List<Integer>> list = new ArrayList<>();
        // for(int i= 0; i < nums.length; i++){
        //     sum += nums[i];
        // }
        // for(int i= 1; i < nums.length-1; i++){
        //     for(int j= i+2; j < nums.length-1; j++){
        //         for(int k= i+1; k < nums.length-1; k++){
        //             if(sum == nums[i]+nums[j]+nums[k]){
        //                 list.add(Arrays.asList(nums[i], nums[j], nums[k]));
        //             }
        //         }
        //     }
        // }

    }

    public static List<Integer> longestSubsequence(int[] arr) {
        int[] arr2 = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && 1 + arr2[j] > arr2[i]) {
                    arr2[i] = 1 + arr2[j];
                    list.add(arr2[i]);
                }
            }
        }
        return new ArrayList<>(list);
    }

    public static int maxSubArray(int[] nums) {
        /* 4,5,-2,2,-1,6,-7 */
        int max = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
            if (nums[i] > sum) {
                sum = nums[i];
            }
        }
        return max;
    }

    public static int lengthOfLongestIncreasingSubSequence(int[] nums) {
        int[] list = new int[nums.length];
        Arrays.fill(list, 1);
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + list[j] > list[i]) {
                    list[i] = list[j] + 1;
                    maxLength = Math.max(list[i], maxLength);
                }
            }
        }
        return maxLength;
    }

    public static int longestIncreasingSubsequence(int[] arr) {
        int[] list = new int[arr.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = arr[i];
        }
        int maxLength = list[0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && arr[i] + list[j] > list[i]) {
                    list[i] = arr[i] + list[j];
                    maxLength = Math.max(maxLength, list[j]);
                }
            }
        }
        return maxLength;

    }

    public static int longestCommonSubSequence(String s1, String s2) {
        return 1 + lCS(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    public static int lCS(String s1, String s2, int l1, int l2) {
        if (l1 == 0 || l2 == 0) return 0;
        if (s1.charAt(l1) == s2.charAt(l2)) {
            return 1 + lCS(s1, s2, l1 - 1, l2 - 1);
        }
        return Math.max(lCS(s1, s2, l1 - 1, l2), lCS(s1, s2, l1, l2 - 1));
    }

    public static boolean divideArray(int[] nums) {
        /*Arrays.sort(nums);
        for(int i = 0; i < nums.length; i+= 2){
            if(nums[i] != nums[i+1]){
                return false;
            }
        }
        return true;*/
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key) % 2 != 0) {
                return false;
            }
        }
        return false;
    }

    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(mid, nums, m)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    public static boolean check(int mid, int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                return false;
            }
            sum += nums[i];
            if (sum > mid) {
                count++;
                sum = nums[i];
            }
        }
        count++;
        if (count <= k) {
            return true;
        }
        return false;
    }
    /*public static int splitArray(int[] nums, int m) {
        int []arr = new int[nums.length];
        for(int i = 2; i < nums.length; i++){
            arr[i] = nums[i];
        }

        return 0;
    }*/

    public static int findDuplicate(int[] nums) {
        if (nums.length == 0)
            return 0;
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            if (slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            if (slow == nums[slow])
                return slow;
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static int countOdds(int low, int high) {
       /*int count = 0;
        for(int i = low; i<= high; i++){
            if(i % 2 != 0){
                count ++;
            }
        }
        return count;*/
        if (low % 2 != 0) low--;
        if (high % 2 != 0) high++;
        return (high - low) / 2;
    }

    public static int countPrime(int n) {
        int count = 0;
        boolean[] prime = new boolean[n];
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j < n; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                count++;
            }
        }
        return count;
    }


    public static boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int a = 0;
        int b = arr.length - 1;
        while (a < b) {
            if (arr[a] == arr[b]) {
                ++a;
                --b;
            } else {
                int m = a + 1;
                int n = b;
                boolean x = true;
                boolean y = true;
                while (m < n) {
                    if (arr[m] != arr[n]) {
                        x = false;
                        break;
                    }
                    ++m;
                    --n;
                }
                m = a;
                n = b - 1;
                while (m < n) {
                    if (arr[m] != arr[n]) {
                        y = false;
                        break;
                    }
                    ++m;
                    --n;
                }
                return x || y;
            }
        }
        return true;
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int store = 0, count = 0;
        if (nums.length < 3) return 0;
        for (int i = 2; i <= nums.length-1; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                count += 1;
                store += count;
            }
            else
                count = 0;
        }
        return store;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // transfer results from list to int[];
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = list.get(i);

        return res;
    }

    public static int findPeakElement(int[] nums) {
/*int max = nums[0];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                index++;
            }
        }
        return index;*/
        if(nums.length == 1) return 0;
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] > nums[mid+1]){
                high = mid;
            }
            else
                low = mid +1;
        }
        return low;
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i = 0; i < nums1.length; i++){
            boolean found = false;
            int val = -1;
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    found = true;
                    continue;
                }
                if(found && nums2[j] > nums1[i]){
                    val = nums2[j];
                    break;
                }
            }
            nums1[i] = val;
        }
        return nums1;
    }
    public static int maxArea(int []arr){
        int l = 0;
        int r = arr.length-1;
        int max = 0;
        while(l < r){
            int lh = arr[l];
            int rh = arr[r];
            int min = Math.min(lh,rh);
            max = Math.max(max,lh * rh);
            if (lh < rh) l++;
            else r--;
        }
        return max;
    }

    public static List<List<String>> groupAnagrams(String [] strings){
       if (strings == null || strings.length == 0) return new ArrayList<>();
       HashMap<String, List<String>> list = new HashMap<>();
       for (String str: strings){
           char [] chars = str.toCharArray();
           Arrays.sort(chars);
           String string = new String(chars);
           if (!list.containsKey(string)){
               list.put(string, new ArrayList<>());
           }
           list.get(string).add(str);
       }
       return new ArrayList<>(list.values());
    }


    public static int threeSumMulti(int[] arr, int target) {
        /*int count  = 0;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++){
            int j = i+1;
            int k = nums.length-1;
            while(k > j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    count++;
                }
                else if (sum > target) j++;
                else k--;
            }
        }
        //System.out.println(Arrays.asList(set));
        return count;*/
       int count = 0;
         /*for(int i = 0; i <nums.length; i++){
            for(int j = i+1; j <nums.length; j++){
                for(int k = j+1; k <nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == target){
                        count ++;
                    }
                }
            }
        }*/
        /*for(int i = 0; i <nums.length; i++){
            for(int j = i+1; j <nums.length; j++) {
                int k = target - nums[i] - nums[j];

            }

        }
        return count;*/
        int mod=1000000007;
        long ans=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++)
        {
            int j = i + 1, k = arr.length - 1;
            while(j<k)
            {
                int tmp=arr[i]+arr[j]+arr[k];
                if(tmp==target)
                {
                    if(arr[j]==arr[k])
                    {
                        int n=k-j+1;
                        int m=n*(n-1);
                        m/=2;
                        ans+=m;
                        break;
                    }
                    else
                    {
                        int re=0,le=0,n=arr[j],m=arr[k];
                        while(j<=k &&arr[j]==n)
                        {
                            le++;
                            j++;
                        }
                        while(k>=j && m==arr[k])
                        {
                            re++;
                            k--;
                        }
                        int tmpans=re*le;
                        ans+=tmpans;
                    }
                }
                else if(tmp<target)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        ans = ans % mod;
        return (int)ans;
    }


    public static int[] productExceptSelf(int[] nums) {
        // TODO https://leetcode.com/problems/product-of-array-except-self/discuss/1599115/238.-Product-of-Array-Except-Self%3A-Java-Solution
        // O(n2)
        /*int n = nums.length;
        int []ans = new int[n];
        for(int i = 0; i < n; i++) {
            int pro = 1;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                pro *= nums[j];
            }
            ans[i] = pro;
        }
        return ans;*/
        int []ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int mul = 1;
            //ans[i] = mul;
            mul *= nums[i];
        }
        return nums;
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }

        System.out.println(queue);
        while (queue.size() > 1) {
            int firstStone = queue.poll();
            int lastStone = queue.poll();
            if (firstStone != lastStone) {
                queue.add(Math.abs(firstStone - lastStone));
            }
        }
        if (queue.size() == 0) {
            return 0;
        }
        return queue.poll();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        /*Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k= 0;
        while(nums1.length > i && nums2.length > j){
            if (nums1[i] < nums2[j]){
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else if(nums1[i] == nums2[j]){
                if(nums1[k++] == nums1[i]){
                    i++;
                    j++;
                }
            }
        }
        return Arrays.copyOfRange(nums1,0,k);*/
        List newList= new ArrayList<>();
        int[] count = new int[1001];

        for(int item : nums1) {
            count[item]++;
        }

        for(int i:nums2) {
            if (count[i] != 0) {
                count[i]--;
                newList.add(i);
            }
        }
        int[] arr = new int[newList.size()];
        int i = 0;
        for(Object x : newList){
            arr[i++] = (int) x;
        }
        return arr;
    }
    public static void printMatrix(){
        int [][] matrix = new int[3][3];
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " +ints[j]);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] temp = grid;

        while (k --> 0) {
            // init for each loop
            temp = new int[n][m];
            // 1. shift right
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    temp[i][j] = grid[i][j - 1];
                }
            }
            // 2. move last one in this row to the next row
            for (int i = 1; i < n; i++) {
                temp[i][0] = grid[i - 1][m - 1];
            }
            // 3. move the last one to the first place
            temp[0][0] = grid[n - 1][m - 1];
            // repeat
            grid = temp;
        }
        return (List)Arrays.asList(temp);
    }

    public static int minimumEffortPath(int [][] heights){
        int l = 0, r = 10000001;
        while(l < r){
            int limit = (l + r ) / 2;
            if(isGood(heights, limit)){
                r = limit;
            }
            else {
                l = limit + 1;
            }
        }
        return l;

    }

    private static boolean isGood(int[][] h, int limit){
        int R = h.length;
        int C = h[0].length;
        Queue<int []> q = new LinkedList<>();
        q.add(new int []{0,0});
        boolean [][] visited = new boolean[R][C];
        int [][] dir = new int[][]{{1,0}, {0 , 1}, {-1, 0}, {0, -1}};
        while(q.size() > 0){
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            if (x == R -1 && y == C -1)
                return true;
            for (int [] d: dir) {
                int nx = x + d[0];
                int ny = y  + d[1];
                if(nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny]){
                    if (Math.abs(h[x][y] - h[nx][ny]) <= limit){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }

    PriorityQueue<Integer> queue;
    final int h;
    LeeCode(int k, int []nums){
        this.h = k;
        queue = new PriorityQueue<>(h);
        for (int num: nums) {
            queue.add(num);
        }
    }
    public int add(int val){
        queue.offer(val);
        if (queue.size() > h){
            queue.poll();
        }
        return queue.peek();
    }

    public static int baseBallGame(String []str){
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("C") && !str[i].equals("D") && !str[i].equals("+")){
                int roundScore = Integer.parseInt(str[i]);
                sum += roundScore;
                list.add(roundScore);
            }
            else if (str[i].equals("C")){
                sum -= list.get(list.size() -1);
                list.remove(list.size()-1);
            }
            else if (str[i].equals("D")){
                int roundS =  2 * list.get(list.size()-1);
                sum += roundS;
                list.add(roundS);
            }
            else {
                int round = list.get(list.size()-1) + list.get(list.size()-2);
                list.add(round);
                sum += round;
            }
        }
        System.out.println(list);
        return sum;
    }

    public static List<List<Integer>> shift2DGrid(int [][] grid, int k){
        List<List<Integer>> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;
        for (int i = 0; i < m; i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int index = (i * n + j + total - k) % total;
                sublist.add(grid[index/n][index%n]);
            }
            list.add(sublist);
        }
        return list;
    }

   /* private int findShiftIndex(int i, int j, int k, int col, int total){
        return (i * col + j + total - k) % total;
    }*/

    public static void main(String[] args) {

        /*int [][]grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(shift2DGrid(grid,1));*/

        /*String [] str = {"5","2","C","D","+"};
        System.out.println(baseBallGame(str));*/

        /*int []nums = {4,5,8,2};
        LeeCode leeCode = new LeeCode(3,nums);
        leeCode.add(3);*/
        /*int [][]matrix = {{1,2,2},{3,8,2},{5,3,5}};
        int a = minimumEffortPath(matrix);
        System.out.println(a);*/
        /*int [][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        System.out.println(shiftGrid(grid,k));*/
        /*int []nums1 = {4,9,5};
        int []nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));*/
        /*for (int i = 10; i --> 0;) {
            System.out.println(i);
        }*/
       // PriorityQueue<Integer> pri = new PriorityQueue<>();
        /*pri.add(45);
        pri.add(12);
        pri.add(78);
        pri.add(69);
        pri.add(6);
        pri.add(95);
        System.out.println(pri);*/
        //System.out.println(lastStoneWeight(arr));
        /*int []arr = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));*/
        //System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
        /* [["bat"],["nat","tan"],["ate","eat","tea"]] */

        /*int [] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));*/

        /*HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(1,100);
        hash.put(2,200);
        hash.put(3,300);
        hash.put(4,400);
        hash.put(5,500);
        System.out.println(hash.getOrDefault(0,101258) + 1);*/

        /*for (var a: hash.entrySet()) {
            System.out.println(a);
        }*/
        /*Stack<Integer> stack = new Stack<>();
        int []arr = {45,43,56,76,12,48,36};
        for (int j : arr) {
            stack.push(j);
        }
        System.out.println(stack.peek());*/

        /*int []arr = {1,8,4,5,2,3};
        System.out.println(findPeakElement(arr));*/

       // System.out.println(numberOfArithmeticSlices(arr));

        /*System.out.println(validPalindrome("abcdda"));
        System.out.println(countPrime(10));*/
        //System.out.println(countOdds(3,11));
        /*String [] s = {"ga", "j"};*/

        /*String s = "java";
        char []a = s.toCharArray();
        for (int i = a.length-1; i>= 0; i--) {
            System.out.print(a[i]);
        }*/
       /* for (int i = 1; i <= 10; i++) {
            if (i == 5){
                //System.out.print(" "+i);
                continue;
            }
            System.out.println(" "+i);
        }*/
        /*int []arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));*/
        /*for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                if (j >= k){
                    System.out.print("*");
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }*/
        /*String []s = {"java", "python", "html"};
        for(String g: s){
            System.out.println(g);
        }*/


        /*int []arr = {7,2,5,10,8};
        int num = 2;
        System.out.println(splitArray(arr, num));*/

        /*String s1 = "abc";
        String s2 = "abc";
        System.out.println(longestCommonSubSequence(s1,s2));
*/
        /*byte->short->int -> float -> double -> char-> boolean*/

        /*String a = "JAVA";
        int b = 10, c = 20, d = 30;
        System.out.println(b+c+a+d);*/

        /*int []arr = {7,1,4,8,11,2,14,3};
        System.out.println(longestIncreasingSubsequence(arr));*/
       /* int []arr = {1,2,3,4,5,6,7,8};
        for (int i = 0; i < arr.length/2; i++) {
            int j = i+1;
            int k = arr.length-1;
            int swap = arr[j];
            arr[j] = arr[k];
            arr[k] = swap;
        }
        System.out.println(Arrays.toString(arr));*/

//        Scanner sc = new Scanner(System.in);
//        double num = sc.nextDouble();
//        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
//        String us = n.format(num);
//        System.out.println(us);

        //System.out.println(divide(12000,2));
        /*int []arr = {1,0,-1,0,-2,2};
        System.out.println(fourSum(arr,0));*/
        //System.out.println(reverseStr("abcdefg",2));
        /*int []arr = {1,4};
        System.out.println(findPoisonedDuration(arr,2));*/
        //System.out.println(IsSubsequence("axc",""));

        /*int [] arr = {9,6,4,2,3,5,7,1,0};
        Arrays.sort(arr);
        System.out.println(missingNumber(arr));
        putBracket(3);*/

        //System.out.println(Integer.toBinaryString(5));

        /*int []arr = {23,54,23,67,432,45};
        swapO(arr);*/

        //System.out.println(findTheDifference("abcd", "abcde"));
//        System.out.println(ncr(9,4));
//        System.out.println(fourthPower(256));
        /*int []arr = {-1,0,1,2,-1,-4};
        threeSum(arr);*/
       // System.out.println(addDigit(387));

        /*int []arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));*/

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
