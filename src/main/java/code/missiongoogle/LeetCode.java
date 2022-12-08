package code.missiongoogle;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class LeetCode {
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

    public static Object abc(int k) {
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
                if (hashMap.containsValue(words[i])) return false;
                hashMap.put(current, words[i]);
            }
        }
        return true;
    }

    public static boolean wordPattern1(String pattern, String s) {
        String[] arr = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if (arr.length != pattern.length()) return false;
        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i])) return false;
            } else {
                if (map.containsValue(arr[i])) return false;
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

    public static Node addTwoNumber(Node l1, int l2) {
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
            else if (ans > num) high = mid - 1;
            else low = mid + 1;
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

        /*Arrays.sort(arr);
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] != arr[i]) {
                return arr[i];
            }
        }
        return arr[arr.length - 1];*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        int ans = 0;
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                ans = i;
            }
        }
        return ans;

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
            if (count == 0) store = i;
            if (i == store) count += 1;
            else count -= 1;
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
            if (num == Math.pow(4, i)) return true;
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

            /*int total = 0;
            for (int i = 0; i < timeSeries.length-1; i++) {
                if (timeSeries[i+1] <= timeSeries[i] + duration-1) {
                    total += timeSeries[i+1] - timeSeries[i];
                }
                else {
                    total += duration;
                }
            }
            total += duration;
            return total;*/

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

    public static int divide(int dividend, int divisor) {
        if (divisor < 0 || dividend < 0) return dividend / divisor;
        if (dividend == divisor) return 1;
        int i = 0;
        int sum = dividend;
        while (sum > divisor) {
            int a = sum - divisor;
            i++;
            if (sum < 3) {
                return i + 1;
            }
            sum = a;
            if (a == divisor) return i + 1;
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
        return count <= k;
    }
    /*public static int splitArray(int[] nums, int m) {
        int []arr = new int[nums.length];
        for(int i = 2; i < nums.length; i++){
            arr[i] = nums[i];
        }

        return 0;
    }*/

    public static int findDuplicate(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            if (slow == nums[slow]) return slow;
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            if (slow == nums[slow]) return slow;
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
        for (int i = 2; i <= nums.length - 1; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count += 1;
                store += count;
            } else count = 0;
        }
        return store;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

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
        if (nums.length == 1) return 0;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else low = mid + 1;
        }
        return low;
    }

    public static int maxArea(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int max = 0;
        while (l < r) {
            int lh = arr[l];
            int rh = arr[r];
            int min = Math.min(lh, rh);
            max = Math.max(max, lh * rh);
            if (lh < rh) l++;
            else r--;
        }
        return max;
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
        int mod = 1000000007;
        long ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1, k = arr.length - 1;
            while (j < k) {
                int tmp = arr[i] + arr[j] + arr[k];
                if (tmp == target) {
                    if (arr[j] == arr[k]) {
                        int n = k - j + 1;
                        int m = n * (n - 1);
                        m /= 2;
                        ans += m;
                        break;
                    } else {
                        int re = 0, le = 0, n = arr[j], m = arr[k];
                        while (j <= k && arr[j] == n) {
                            le++;
                            j++;
                        }
                        while (k >= j && m == arr[k]) {
                            re++;
                            k--;
                        }
                        int tmpans = re * le;
                        ans += tmpans;
                    }
                } else if (tmp < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        ans = ans % mod;
        return (int) ans;
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


    public static void printMatrix() {
        int[][] matrix = new int[3][3];
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + ints[j]);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] temp = grid;

        while (k-- > 0) {
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
        return (List) Arrays.asList(temp);
    }

    /*public static int minimumEffortPath(int[][] heights) {
        int l = 0, r = 10000001;
        while (l < r) {
            int limit = (l + r) / 2;
            if (isGood(heights, limit)) {
                r = limit;
            } else {
                l = limit + 1;
            }
        }
        return l;

    }*/

    /*private static boolean isGood(int[][] h, int limit) {
        int R = h.length;
        int C = h[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[][] visited = new boolean[R][C];
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (q.size() > 0) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            if (x == R - 1 && y == C - 1) return true;
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny]) {
                    if (Math.abs(h[x][y] - h[nx][ny]) <= limit) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }*/

    PriorityQueue<Integer> queue;
    final int h;

    LeetCode(int k, int[] nums) {
        this.h = k;
        queue = new PriorityQueue<>(h);
        for (int num : nums) {
            queue.add(num);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > h) {
            queue.poll();
        }
        return queue.peek();
    }

    public static int baseBallGame(String[] str) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("C") && !str[i].equals("D") && !str[i].equals("+")) {
                int roundScore = Integer.parseInt(str[i]);
                sum += roundScore;
                list.add(roundScore);
            } else if (str[i].equals("C")) {
                sum -= list.get(list.size() - 1);
                list.remove(list.size() - 1);
            } else if (str[i].equals("D")) {
                int roundS = 2 * list.get(list.size() - 1);
                sum += roundS;
                list.add(roundS);
            } else {
                int round = list.get(list.size() - 1) + list.get(list.size() - 2);
                list.add(round);
                sum += round;
            }
        }
        System.out.println(list);
        return sum;
    }

    public static List<List<Integer>> shift2DGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;
        for (int i = 0; i < m; i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int index = (i * n + j + total - k) % total;
                sublist.add(grid[index / n][index % n]);
            }
            list.add(sublist);
        }
        return list;
    }

   /* private int findShiftIndex(int i, int j, int k, int col, int total){
        return (i * col + j + total - k) % total;
    }*/

    public static List<Integer> spiralMatrixOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col - 1, bottom = row - 1, top = 0, dir = 0;
        while (left <= right && top <= bottom) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                dir = 1;
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                dir = 2;
            } else if (dir == 2) {
                for (int i = left; i >= right; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                dir = 3;
            } else {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
                dir = 0;
            }
        }
        return list;
    }

    public static int[][] generateMatrix(int num) {
        int left = 0, right = num - 1;
        int top = 0, bottom = num - 1;
        int val = 1;
        int[][] matrix = new int[num][num];
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++)
                matrix[top][i] = val++;
            top++;

            for (int i = top; i <= bottom; i++)
                matrix[i][right] = val++;
            right--;

            for (int i = right; i >= left; i--)
                matrix[bottom][i] = val++;
            bottom--;

            for (int i = bottom; i >= top; i--)
                matrix[i][left] = val++;
            left++;

        }
        return matrix;
    }

    public static int[][] matrix(int num) {
        int[][] m = new int[num][num];
        int val = 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = val++;
            }
        }
        return m;
    }

    public static void m(int m) {
        int[][] matrix = new int[m][m];
        int val = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = val++;
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    static HashMap<String, String> hashMap = new HashMap<>();

    public static String encode(String longURL) {
        String s = "http://LC/" + hashMap.size();
        hashMap.put(s, longURL);
        return s;
    }

    public static String decode(String shortURL) {
        return hashMap.get(shortURL);
    }

    public static boolean backSpaceStringCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] != '#') {
                stack1.push(s.charAt(i));
            } else if (stack1.size() == 0) {
                continue;
            } else stack1.pop();
        }

        for (int i = 0; i < c.length; i++) {
            if (c[i] != '#') {
                stack2.push(s.charAt(i));
            } else if (stack2.size() == 0) {
                continue;
            } else stack2.pop();
        }
        return stack1.equals(stack2);
    }

    public static int[] sortedArrayByPriority(int[] nums) {
        int[] arr = new int[nums.length];
        int first = 0, last = nums.length - 1;
        // 3 1 2 4
        for (int num : nums) {
            if (num % 2 == 0) {
                arr[first] = num;
                first++;

            } else {
                arr[last] = num;
                last--;
            }
        }
        return arr;
    }

    public static List<Integer> findDisappearedNumber(int[] nums) {
        /*List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        int []arr = new int[nums.length];
        for (int i = 1; i < nums.length+1; i++){
            list.add(i);
        }
        *//*for (int i = 0; i < nums.length; i++) {
            arr[i] = list.get(i);
        }*//*

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == list.indexOf(i)){
                list.remove(nums[i]);
            }
        }
        return list;*/

        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) ans.add(j + 1);
        }

        return ans;
    }


    public static int[] intersectionOfTwoArray(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }
        HashSet<Integer> hash = new HashSet<>();
        for (int i : nums2) {
            if (hashSet.contains(i)) {
                hash.add(i);
            }
        }
        int[] copy = new int[hash.size()];
        int index = 0;
        for (int i : hash) {
            copy[index++] = i;
        }

        return copy;
    }

    public static int maxOperations(int[] nums, int k) {
        int first = 0, last = nums.length - 1;
        Arrays.sort(nums);
        int ans = 0;
        while (last > first) {
            if (k == nums[first] + nums[last]) {
                ++ans;
                --last;
                ++first;
            } else if (k > nums[first] + nums[last]) {
                ++first;
            } else --last;
        }
        return ans;

    }

    public static int[] insertionOfTwoArray(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> lis = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                lis.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] copy = new int[lis.size()];
        for (int k = 0; k < lis.size(); k++) {
            copy[i] = lis.get(i);
        }
        return copy;
    }

    /*public static class MyStack {
        Queue<Integer> q= new LinkedList<>();
        public  MyStack() {

        }

        public void push(int x) {
            q.add(x);
            for (int i = 0; i < q.size(); i++) {
                q.add(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }*/

    public static String removerAllAdjacentDuplicate(String s, int k) {
        Stack<Counter> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char chr : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().c != chr) {
                stack.push(new Counter(chr, 1));
            } else {
                stack.push(new Counter(chr, stack.peek().num + 1));
            }
            if (stack.peek().num == k) {
                int n = k;
                while (n > 0) {
                    stack.pop();
                    n--;
                }
            }
        }
        if (!stack.isEmpty()) {
            sb.append(stack.pop().c);
        }
        return sb.reverse().toString();
    }

    public static class Counter {
        int num;
        char c;

        Counter(char a, int val) {
            this.c = a;
            this.num = val;
        }
    }

    public boolean find132pattern(int[] nums) {
        int min = nums[0];
        for (int j = 0; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (min < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
                min = Math.min(min, nums[j]);
            }
        }
        return false;
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) return mat;
        int[][] newMat = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                newMat[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    row++;
                    col = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(newMat));
        return newMat;
    }

    public static boolean isValid(String nums) {
        return (nums.charAt(0) == nums.charAt(1) && nums.charAt(1) == nums.charAt(2));
    }

    public static String largestGoodInteger(String nums) {
        String ans = "";
        for (int i = 0; i < nums.length() - 2; i++) {
            String s = nums.substring(i, i + 3);
            if (isValid(s)) {
                if (s.compareTo(ans) > 0) {
                    ans = s;
                }
            }
        }
        return ans;
        //Stack<Pair> stack = new Stack<>();
        //int []c = s.toCharArray();
        /*HashSet<Character> hashSet = new HashSet<>();
        String s = "";
        for(char c : num.toCharArray()){
            if(stack.isEmpty() && stack.peek().c != c){
                stack.push(new Pair(c,1));
            }
            else {
                stack.push(new Pair(c, stack.peek().val + 1));
            }
            if (stack.peek().val == 3){

            }
        }
        return s;
    }
    public static class Pair{
        char c;
        int val;
        Pair(char c, int val){
            this.c = c;
            this.val = val;
        }*/

    }

    public static boolean containsDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (end > start) {
            if (nums[start] == nums[end]) {
                return true;
            } else if (start + 1 == end) {
                if (nums[start + 1] == nums[end]) {
                    return true;
                }
                start++;
            }
            end--;
        }
        return false;
    }

    public static int findNumberOfLIS(int[] nums) {
        if (isSorted(nums)) {
            return nums.length;
        }
        int[] copy = new int[nums.length];
        int index = 0;
        for (int i : nums) {
            copy[index++] = i;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (copy[i] == nums[i]) {
                count++;
            }
        }

        return (count + 1) / 2;
    }

    public static boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static int thirdMax(int[] nums) {
        /*Arrays.sort(nums);
        if(nums.length < 3){
            return nums[nums.length -1];
        }
        return nums[nums.length - 2];*/
        int fmax = nums[0];
        int smax = nums[1];
        int tmax = nums[0];
        if (nums.length < 3) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return nums[i];
                } else {
                    return nums[i + 1];
                }
            }
        } else {
            for (int i = 1; i < nums.length; i++) {
                if (fmax < nums[i]) {
                    fmax = nums[i];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (fmax != nums[i]) {
                    if (smax < nums[i]) {
                        smax = nums[i];
                    }
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (fmax != nums[i] && smax != nums[i]) {
                    if (tmax < nums[i]) {
                        tmax = nums[i];
                    }
                }
            }
        }

        return tmax;
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (k <= 0 || k > 9 || n <= 0 || n > 45 || (k == 1 && n > 9) || (k == 9 && n != 45) || (n < k * (k + 1) / 2)) {
            return result;
        }
        if (k == 1) {
            result.add(List.of(n));
            return result;
        }
        if (k == 9) {
            result.add(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            return result;
        }

        combinationSum3(1, k, n, new ArrayList<>(), result);
        return result;
    }

    public static void combinationSum3(int start, int k, int n, List<Integer> tempList, List<List<Integer>> result) {
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > n) {
                break;
            }
            tempList.add(i);
            combinationSum3(i + 1, k - 1, n - i, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static int[] intersectionII(int[] nums1, int[] nums2) {
        int[] count = new int[10001];
        List<Integer> list = new ArrayList<>();
        for (int item : nums1) {
            count[item]++;
        }
        for (int i : nums2) {
            if (count[i] != 0) {
                count[i]--;
                list.add(i);
            }
        }
        int[] newA = new int[list.size()];
        int j = 0;
        for (Object k : newA) {
            newA[j++] = (int) k;
        }
        return newA;
    }

    public static int varArgMethod(int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    public static int maxProfit(int[] nums) {
        // brute force technique
        /*int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] <  nums[j]){
                    sum = nums[j] - nums[i];
                    max = Math.max(sum, max);
                }
            }
        }
        return max;*/
        int maxp = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] - min > maxp) {
                maxp = nums[i] - min;
            }
        }
        return maxp;
    }

    public static List<String> latterCombination(String digits) {
        /*List<String> result = new ArrayList<>();
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
        return result;*/
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        HashMap<String, String> store = new HashMap<>();
        store.put("2", "abc");
        store.put("3", "def");
        store.put("4", "ghi");
        store.put("5", "jkl");
        store.put("6", "mno");
        store.put("7", "pqrs");
        store.put("8", "tuv");
        store.put("9", "wxyz");

        Deque<String> deque = new ArrayDeque<>();
        deque.add("");
        for (int i = 0; i < digits.length() - 1; i++) {
            String d = digits.substring(i, i + 1);
            String fromMap = store.get(d);
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                String pull = deque.pollFirst();
                for (int k = 0; k < fromMap.length(); k++) {
                    String temp = pull.concat(fromMap.charAt(k) + "");
                    deque.add(temp);
                }
            }
        }
        while (!deque.isEmpty()) {
            list.add(deque.poll());
        }
        return list;
    }

    public static boolean anagram(String s, String t) {
        char[] c = s.toCharArray();
        char[] c1 = t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(c1);
        for (int i = 0; i < c.length; i++) {
            if (c[i] != c1[i]) return false;
        }
        return true;
    }

    public static int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);
        int count = 0;

        for (int i = 0; i < s.length() - k + 1; i++) {
            String temp = s.substring(i, i + k);
            if (Integer.parseInt(temp) > 0 && num % Integer.parseInt(temp) == 0) {
                count++;
            }
        }

        return count;
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        for (int i = releaseTimes.length - 1; i >= 1; i--) {
            releaseTimes[i] = releaseTimes[i] - releaseTimes[i - 1];
        }
        System.out.println(Arrays.toString(releaseTimes));
        int max = releaseTimes[0];
        int count = 0;
        char[] c = keysPressed.toCharArray();
        for (int i = 0; i < releaseTimes.length; i++) {
            if (releaseTimes[i] > max) {
                max = releaseTimes[i];
                count++;
            } else if (releaseTimes[i] == max) {
                if (i > count) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return c[count];
    }

    public static int getMaximumGenerated(int n) {
        int ans = 1;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 1; (2 * i + 1) <= n; i++) {
            arr[2 * i] = arr[i];
            arr[2 * i + 1] = arr[i] + arr[i + 1];
            ans = Math.max(ans, arr[2 * i + 1]);
        }
        System.out.println(Arrays.toString(arr));
        return ans;
    }

    public static boolean isPowerOfTwo(int n) {
        for (int i = 0; i < Math.ceil(Math.sqrt(n)); i++) {
            if (Math.pow(2, i) == n) return true;
        }
        return false;
    }

    public static int titleToNumber(String columnTitle) {
        int sum = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            int a = columnTitle.charAt(i) - 'A' + 1;
            sum = sum * 26 + 1;
            System.out.println(a);
        }

        return sum;
    }

    public int dayOfYear(String date) {
        return LocalDate.parse(date).getDayOfYear();
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (checkSelfD(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean checkSelfD(int num) {
        int a = num;
        while (num != 0) {
            int rem = num % 10;
            if (rem == 0) return false;
            else if (a % rem != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public static int countEven(int num) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (digit(i) % 2 == 0) {
                count++;
                list.add(i);
            }
        }
        System.out.println(list);
        return count;
    }

    public static int digit(int num) {
        int s = 0;
        while (num != 0) {
            int rem = num % 10;
            s += rem;
            num /= 10;
        }
        return s;
    }

    public static int countOperations(int num1, int num2) {
        int count = 0;
        if (num1 == 0 || num2 == 0) return 0;
        if (num1 == num2) return 1;
        while (num1 != 0 || num2 != 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            count++;
            if (num2 == 0 || num1 == 0) {
                break;
            }
        }
        return count;
    }

    public static int[] constructRectangle(int area) {
        /*int []size = new int[2];
        int a = area;
        int n = 1;
        while(a >= n){
            if(area % n == 0){
                a = area / n;
                size[0] = n;
                size[1] = a;
            }
            n++;
        }
        return size;*/
        for (var i = (int) Math.sqrt(area); i >= 0; i--) {
            if (i * (area / i) == area) {
                return new int[]{area / i, i};
            }
        }
        return null;
    }

    public static boolean checkStraightLine(int[][] c) {
        int a = c.length;
        if (a == 2) return true;
        for (int i = 2; i < c[0].length; i++) {
            if (((c[0][0] - c[1][0]) * (c[0][1] - c[1][i])) != ((c[0][1] - c[1][1]) * (c[0][0] - c[i][0]))) {
                return false;
            }
        }
        return true;
    }

    public static int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;
        while (n != 0) {
            int rem = n % 10;
            sum += rem;
            mul *= rem;
            n /= 10;
        }
        return mul - sum;
    }

    public static int numberOfSteps(int num) {
        int count = 0;
        int a = num;
        while (a != 0) {
            if (a % 2 == 0) {
                a = a / 2;
            } else {
                a -= 1;
            }
            count++;
        }
        return count;
    }

    public static boolean isSameAfterReversals(int num) {
        int sum = 0;
        int sum1 = 0;
        int a = num;
        while (num != 0) {
            int rem = num % 10;
            sum = sum * 10 + rem;
            num /= 10;
        }

        while (sum != 0) {
            int rem = sum % 10;
            sum1 = sum1 * 10 + rem;
            sum /= 10;
        }

        System.out.println(sum);
        System.out.println(sum1);
        return sum1 == a;
    }

    public static int[] getNoZeroIntegers(int n) {
        if (n == 2) return new int[]{1, 1};
        for (int i = 2; i <= n; i++) {
            if (i + (n - i) != 0 && check11(n - i) && check11(i)) {
                return new int[]{i, (n - i)};
            }
        }
        return null;
    }

    public static boolean check11(int num) {
        while (num != 0) {
            int rem = num % 10;
            if (rem == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    row = i;
                    col = j;
                    char num = board[i][j];
                    if (!isSafe(board, row, col, num)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = col + 1; i < board.length; i++) {
            if (board[row][i] == num) return false;
        }
        for (int i = row + 1; i < board.length; i++) {
            if (board[i][col] == num) return false;
        }
        int sqrt = (int) Math.sqrt(board.length);
        int temprow = row - row % sqrt;
        int tempCol = col - col % sqrt;
        for (int i = temprow; i < sqrt + temprow; i++) {
            for (int j = tempCol; j < sqrt + tempCol; j++) {
                if (board[i][j] == num && !(i == row && j == col)) return false;
            }
        }
        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] n = setArray(ransomNote);
        int[] m = setArray(magazine);

        for (int i = 0; i < n.length; i++) {
            if (n[i] != 0) {
                if (n[i] > m[i]) return false;
            }
        }
        return true;
    }

    public static int[] setArray(String string) {
        int[] countArray = new int[26];
        for (char c : string.toCharArray()) {
            int index = c - 'a';
            countArray[index] += 1;
        }
        return countArray;
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                list.add("" + i);
            }
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                list.add("Fizz");
            }
            if (i % 5 == 0) {
                list.add("Bizz");
            }
        }
        return list;
    }

    public static int numberOfMatches(int n) {
        int sum = 0;
        int a = n;
        while (n != 1) {
            int mat = n / 2;
            int adj = n - mat;
            sum += mat;
            n = adj;
        }
        return sum;
    }

    public static int countTriples(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                double s = Math.sqrt((i * i) + (j * j));
                if (s == (int) s && s <= n) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] uniqueIntegerSumUpToZero(int num) {
        int[] arr = new int[num];
        if (num == 1) arr[0] = 0;
        for (int i = 0; i < num; i++) {
            if (num % 2 == 0 && i >= num / 2) {
                arr[i] = -num / 2 + (i + 1);
            } else {
                arr[i] = -num / 2 + i;
            }
        }
        return arr;
    }

    public static boolean squareIsWhite(String s) {
        if (s.charAt(0) % 2 == 0 && s.charAt(1) % 2 != 0) return true;
        return s.charAt(0) % 2 != 0 && s.charAt(1) % 2 == 0;
    }

    public static int hammingWeight(int n) {
        //return Integer.bitCount(n);
        int count = 0;
        for (char i : Integer.toBinaryString(n).toCharArray()) {
            if (Integer.parseInt(String.valueOf(i)) == 1) {
                count++;
            }
        }
        return count;
    }

    public static int percentageLetter(String s, char letter) {
        int l = s.length();
        char[] c = s.toCharArray();
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (c[i] == letter) {
                count++;
            }
        }
        double a = ((double) count / (double) l) * 100;
        return Math.round((int) a);
    }

    public static boolean canMakeArithmeticProgression(int[] nums) {
        Arrays.sort(nums);
        int sum = nums[1] - nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (sum != nums[i + 1] - nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] closestDivisors(int num) {
        int[] arr = new int[2];
        int a = (int) Math.sqrt(num + 2);
        for (int i = a; i >= 1; i--) {
            if ((num + 1) % i == 0) {
                /*arr[0] = i;
                arr[1] = (num + 1) /i;*/
                return new int[]{i, (num + 1) / i};
            }
            if ((num + 2) % i == 0) {
                arr[0] = i;
                arr[1] = (num + 2) / i;
                break;
            }
        }
        return arr;
    }

    public static boolean reorderedPowerOf2(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (Math.pow(2, i) == n || Math.pow(2, i) == c(n)) return true;

        }
        return false;
    }

    public static int c(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum = sum * 10 + rem;
            n /= 10;
        }
        return sum;
    }

    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0, count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                count++;
            }
            res += count;
        }
        return res;
        /*int sum = 0;
        int []arr = new int[nums.length];
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] != nums[i]){
                arr[i] = arr[i-1] +1;
            }
            arr[i] = arr[i-1];
        }
        for (int j : arr) {
            sum += j;
        }
        return sum;*/
    }

    public boolean gcdSort(int[] nums) {
        //Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (checkGcd(i, j) != nums[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int checkGcd(int num1, int num2) {
        int gcd = 1;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println(gcd);
        return gcd;
    }

    public static boolean hasAllCodes(String s, int k) {
        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            hash.add(s.substring(i, i + k));
        }
        return hash.size() == (int) Math.pow(2, k);
    }

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total < cost1 && total < cost2) return 1;
        int count = 0;

        for (int i = 0; i <= total / cost1; i++) {
            count += ((total - i * cost1) / cost2) + 1;
            //System.out.println((total - i * cost1) /cost2);
        }

        return count;
    }


    public static int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] mat = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                mat[j][i] = matrix[i][j];
            }
        }
        return mat;
    }

    public static boolean checkValid1(int[][] matrix) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!set.add(matrix[i][j] + "Row" + i) || !set.add(matrix[i][j] + "col" + j)) return false;
            }
        }
        return true;
    }

    public static long[] sumOfThree(long num) {
        long[] arr = new long[3];
        if (num % 3 != 0) return new long[]{};
        long a = num / 3;
        arr[0] = a - 1;
        arr[1] = a;
        arr[2] = a + 1;

        return arr;
    }

    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int prev_rem = 0;
        for (int i = 1; i <= k; i++) {
            prev_rem = (prev_rem * 10 + 1) % k;

            if (prev_rem == 0) {
                return i;
            }
        }

        return -1;
    }

    public static int minMaxGame(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] newNum = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            if (i % 2 == 0) {
                newNum[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNum[i] = Math.max(nums[2 * i], nums[2 * i + 1]);

            }
        }
        int ans = minMaxGame(newNum);
        return ans;
    }


    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        reverse(nums);
        int c = 0, start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (start - nums[i] > k) {
                start = nums[i];
                c++;
            }
        }

        return c + 1;
    }

    public static void reverse(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }

    public static int computeArea(int x1, int y1, int x2, int y2, int X1, int Y1, int X2, int Y2) {
        int area1 = (x2 - x1) * (y2 - y1);
        int area2 = (X2 - X1) * (Y2 - Y1);

        int overlap = 0;
        int left = Math.max(x1, X1);
        int right = Math.min(x2, X2);
        int bottom = Math.max(y1, Y1);
        int top = Math.min(y2, Y2);

        System.out.println(area1);
        System.out.println(area2);

        /*System.out.println(left);
        System.out.println(right);*/

        if (left < right && bottom < top) overlap = (right - left) * (top - bottom);

        return area1 + area2 - overlap;

    }

    public static int consecutiveNumbersSum(int n) {
        int count = 0, i = 1;
        while (n > 0) {
            n -= i;
            if (n % i == 0) count++;
            i++;
        }
        return count;
    }

    public static int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        if (list.size() < k) return -1;
        System.out.println(list);
        return list.get(k - 1);
    }

    public static int removePalindromeSub(String s) {
        if (s.length() == 0) return 0;
        if (isPelindrome(s)) return 1;
        return 2;
    }

    public static boolean isPelindrome(String s) {
        StringBuffer st = new StringBuffer(s);
        st.reverse();
        String data = st.toString();
        return s.equals(data);
    }

    public static double calculateTax(int[][] brackets, int income) {
        if (income == 0) return 0.0;
        double ans = 0.0;
        int pre = 0;
        for (int i = 0; i < brackets.length; i++) {
            int inc = brackets[i][0];
            int tax = brackets[i][1];
            int actual = Math.min(inc, income);
            ans += ((actual - pre) * tax * 1.0) / 100.0;
            if (inc >= income) {
                break;
            }
            pre = brackets[i][0];
        }
        return ans;
    }

    public static int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        int sum = 0;
        for (int i : hashSet) {
            sum += i;
        }
        System.out.println(hashSet);
        return sum;
    }

    public static void slidingWindowTech(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length - k; i++) {
            max = nums[i];
            for (int j = 1; j <= k; j++) {
                if (nums[i + j] > max) {
                    max = nums[i + j];
                }
            }
            System.out.print(" " + max);
        }
    }

    public static void makePattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - i; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j < n; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static int arrangingCoins(int num) {
        int rowCount = 0;
        while (num > 0) {
            rowCount++;
            num -= rowCount;
        }
        return num == 0 ? rowCount : rowCount - 1;
    }

    public static int findPoisonedDuration1(int[] timeSeries, int duration) {
        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] <= timeSeries[i] + duration - 1) {
                total += timeSeries[i + 1] - timeSeries[i];
            } else {
                total += duration;
            }
        }
        total += duration;
        return total;
    }

    public static int sum(int num) {
        if (num == 0) return 0;
        return num + sum(num - 1);
    }

    public static int top(int[] arr, int n) {
        int[] array = new int[n + 1];
        if (n < 2) return n;
        if (array[n] == 0) {
            array[n] = top(arr, n - 1) + top(arr, n - 2);
        }
        return array[n];
    }

    public static int lcs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcs(s1, s2, n - 1, m - 1);
        }
        return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }

    public static int longestCommonSub_Sequenece(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }

    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1, d;
        for (int i = 3; i <= n; i++) {
            d = Math.max(a + b, c);
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static int longestCommonSubString(String s1, String s2, int l1, int l2, int lcs) {
        if (l1 == 0 || l2 == 0) return lcs;
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            lcs = 1 + longestCommonSubString(s1, s2, l1 - 1, l2 - 1, 1 + lcs);
        }
        int count1 = longestCommonSubString(s1, s2, l1 - 1, l2, 0);
        int count2 = longestCommonSubString(s1, s2, l1, l2 - 1, 0);
        return Math.max(lcs, Math.max(count1, count2));
    }

    public static int longestCommonSubStringBottomUp(String s1, String s2) {
        int lcs = 0;
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 == 0 || l2 == 0) return 0;
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    lcs = Math.max(lcs, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return lcs;
    }

    public static int rangeAdditionII(int m, int n, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            m = Math.min(matrix[i][0], m);
            n = Math.min(matrix[i][1], n);
        }
        return m * n;
    }

    public static String greatestLetter(String s) {
        boolean[] up = new boolean[26];
        boolean[] bot = new boolean[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (Character.isLowerCase(c)) {
                bot[c - 'a'] = true;
            }
            if (Character.isUpperCase(c)) {
                up[c - 'A'] = true;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (up[i] && bot[i]) {
                return (char) (i + 'A') + "";
            }
        }
        return "";

    }

    public static int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        for (int i = 1; i <= 10; i++) {
            int res = i * k;
            if (res % 10 == num % 10 && res <= num) {
                return i;
            }
        }
        return -1;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double runingsum = 0;
        int slow = 0;
        double result = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            runingsum += nums[i];
        }
        result = Math.max(result, runingsum);
        for (int i = k; i < nums.length; i++) {
            runingsum += nums[i];
            runingsum -= nums[slow];
            result = Math.max(runingsum, result);
            slow++;
        }
        return result / k;
    }

    public static int longestPalindromeSubseq(String s) {
        return lcs(s, 0, s.length() - 1);
    }

    public static int lcs(String s, int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;
        if (s.charAt(start) == s.charAt(end)) {
            return 2 + lcs(s, start + 1, end - 1);
        }
        return Math.max(lcs(s, start + 1, end), lcs(s, start, end - 1));
    }

    public static int longestPalindromeSubseq1(String s) {
        int ans = lcs1(s, 0, s.length() - 1);
        return ans;
    }

    public static int lcs1(String s, int start, int end) {
        int[][] dp = new int[s.length()][s.length()];
        if (start > end) return 0;
        if (start == end) return 1;
        if (dp[start][end] == 0) {
            if (s.charAt(start) == s.charAt(end)) {
                dp[start][end] = 2 + lcs1(s, start + 1, end - 1);
            } else {
                dp[start][end] = Math.max(lcs1(s, start + 1, end), lcs1(s, start, end - 1));
            }
        }
        return dp[start][end];
    }

    public static boolean canPartitionSubSets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int buket = sum / k;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, buket);
    }

    public static boolean canPartition(int[] nums, boolean[] visited, int start, int k, int curSum, int buket) {
        if (k == 0) return true;
        if (curSum > buket) return false;
        if (curSum == buket) {
            return canPartition(nums, visited, 0, k - 1, 0, buket);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (canPartition(nums, visited, 1 + i, k, curSum + nums[i], buket)) return true;
            visited[i] = false;
        }
        return false;
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swapII(nums, i, j);
        }
        reverseII(nums, i + 1);
        printfII(nums);
    }

    private static void reverseII(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swapII(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swapII(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void printfII(int[] nums) {
        int[] arr = new int[nums.length];
        int index = 0;
        for (int i : nums) {
            arr[index++] = i;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static double trimMean(int[] arr) {
        int l = arr.length;
        int start = arr.length / 20;
        int end = arr.length - start;
        Arrays.sort(arr);
        double sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - 2 * start);
    }

    public static String firstPalindrome(String[] words) {
        int length = words.length;
        for (int i = 0; i < words.length; i++) {
            if (checkPalindrome(words[i])) {
                return words[i];
            }
        }
        return "";
    }

    public static boolean checkPalindrome(String string) {
        int start = 0;
        int end = string.length() - 1;
        while (start < end) {
            if (string.charAt(start++) != string.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            str.append(word1.charAt(i));
            str.append(word2.charAt(j));
            i++;
            j++;
        }
        if (i < word1.length()) {
            str.append(word1.substring(i));
        }
        if (j < word2.length()) {
            str.append(word2.substring(j));
        }
        return str.toString();
    }

    public static String reversePrefix(String word, char ch) {
        StringBuilder str = new StringBuilder();
        String s = "";
        int i = 0;
        char[] a = word.toCharArray();
        int index = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[i] == ch) {
                index++;
            }
        }
        if (index == 1) System.out.println(word);

        for (i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ch) {
                str.append(word.charAt(i));
            } else {
                break;
            }
        }

        s = ch + "" + str.reverse() + word.substring(i + 1);
        return s;
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean verdict = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    verdict = false;
                    break;
                }
            }
            if (verdict) {
                ++ans;
            }
        }
        return ans;
    }

    public static boolean checkIfExist(int[] arr) {
        /*for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == 2 * arr[i] && i != j){
                    return true;
                }
            }
        }*/
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if ((hash.contains(2 * arr[i]) || (arr[i] % 2 == 0 && hash.contains(arr[i] / 2)))) {
                return true;
            }
            hash.add(arr[i]);
        }
        return false;
    }

    public static boolean validPalindrome1(String s) {
        if (s.isEmpty()) return true;
        //Todo s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static String reverseVowel(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (!isVowel(s.charAt(i))) i++;
            else if (!isVowel(s.charAt(j))) j--;
            else {
                char tem = chars[i];
                chars[i] = chars[j];
                chars[j] = tem;
                i++;
                j--;
            }
        }
        return String.copyValueOf(chars);
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static int balancedStringSplit(String s) {
        int lc = 0, rc = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') lc++;
            else rc++;
            if (lc == rc) c++;
        }
        return c;
    }

    public static boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j || i + j == grid[0].length - 1) {
                    if (grid[i][j] == 0) return false;
                } else {
                    if (grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }

    public int countHousePlacements(int n) {
        if (n == 1) return 4;
        int m = fibo(n) * fibo(n);
        return m;
    }

    public static int fibo(int num) {
        if (num == 1 || num == 0) return num;
        return fibo(num - 1) + fibo(num - 2);
    }

    public static boolean judgeSquareSum(int c) {
        double i = 0;
        double j = (int) Math.sqrt(c) + 1;
        while (i <= j) {
            long sum = (long) (i * i + j * j);
            if (sum < c) i++;
            else if (sum > c) j--;
            else return true;
        }
        return false;
    }

    public static int largestPerimeter(int[] nums) {
        int end = nums.length - 1;
        Arrays.sort(nums);
        while (1 < end) {
            if (nums[end] + nums[end - 1] > nums[end - 2] && nums[end] + nums[end - 2] > nums[end - 1] && nums[end - 1] + nums[end - 2] > nums[end]) {
                return nums[end] + nums[end - 1] + nums[end - 2];
            }
            end--;
        }
        return 0;
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        int minDist = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int dist = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if (dist < minDist) {
                    minDist = dist;
                    minIdx = i;
                }
            }
        }
        if (minIdx != Integer.MAX_VALUE) {
            return minIdx;
        }
        return -1;
    }

    public static int findFinalValue(int[] nums, int original) {
        int sum = 1;
        int org = original;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == org) {
                org = org * 2;
                i = -1;
            }
        }
        return org;
    }

    public static int problem1(int a, int b, int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int div = sum / b;
        return sum - b * div;
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c = s1.toCharArray();
        char[] c1 = s2.toCharArray();
        for (int i = 0; i <= s1.length() / 2; i++) {
            int temp = c.length - 1 - i;
            char o = c[i];
            c[i] = c[temp];
            c[temp] = o;
        }
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(c1));
        return Arrays.equals(c, c1);
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

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return letters[start % letters.length];
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            int val = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    found = true;
                    continue;
                }
                if (found && nums2[j] > nums1[i]) {
                    val = nums2[j];
                    break;
                }
            }
            nums1[i] = val;
        }
        return nums1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans[0] = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    public static int maximumWealth(int[][] accounts) {
        int row = accounts.length;
        int col = accounts[0].length;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < row; i++) {
            sum = 0;
            for (int j = 0; j < col; j++) {
                sum += accounts[i][j];
            }
            if (sum > max) max = sum;
        }
        return max;
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes);
        System.out.println(Arrays.toString(boxTypes));
        return 0;
    }

    public static String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    public static int sumOddLengthSubarrays(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j += 2) {
                int[] copy = Arrays.copyOfRange(nums, i, j + 1);
                for (int value : copy) {
                    sum += value;
                }
            }
        }
        return sum;
    }

    /*public static String decodeMessage1(String key, String message) {
        HashMap<Character, Character> um = new HashMap<>();
        char temp  = 'a';
        char []k = new char[key.length()];
        for(int i = 0; i < key.length(); i++) {
            if(k[i] != ' ' && um.find(k[i]) == um.end()) {
                um[k[i]] = temp;
                temp++;
            }

        }

        string ans = "";

        for(int i = 0; i < message.length(); i++) {
            if(message[i] != ' ') {
                ans += um[message[i]];
            }
            else {
                ans += " ";
            }
        }
        return ans;
    }*/
    public static String decodeMessage(String key, String message) {
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0, j = 0; i < key.length(); i++) {
            if (key.charAt(i) != ' ' && !map.containsKey(key.charAt(i) - 'a')) {
                map.put(key.charAt(i) - 'a', (char) (j + 97));
                j++;
            }
        }
        String ans = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                ans += map.get(message.charAt(i) - 'a');
            } else {
                ans += " ";
            }
        }
        return ans;
    }

    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        /*int j = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            while (j < nums2.length){
                if (i <= j && nums1[i] <= nums2[j]){
                    set.add(j - i);
                }
                j++;
            }
            j = 0;
        }
        Object o = Collections.max(set);
        return (int) o;*/
        int i = 0, j = 0, diff = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                i++;
            }
            diff = Math.max(diff, j - i);
            j++;
        }
        return diff;
    }

    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                i = mid + 1;
            }
            j = mid - 1;
        }
        return -1;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] nums = new int[5];
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count <= k) {
                nums[i] = count;
            }
            count = 0;
        }
        return nums;
    }

    public static int specialArray(int[] nums) {
        for (int j = 1; j < 1001; j++) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (j <= nums[i]) {
                    count++;
                }
            }
            if (j == count) {
                return j;
            }
        }
        return -1;
    }

    public static boolean areAlmostEqual1(String s1, String s2) {
        /*if(s1.length() != s2.length()) return false;
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(a != b){
                count++;
            }
            if(count > 2){
                return false;
            }
            arr1[a -'a']++;
            arr2[b -'a']++;
        }
        return Arrays.equals(arr1,arr2);*/
        if (s1.equals(s2)) return true;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 2) return false;
        }
        if (count == 2) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            return String.valueOf(chars1).equals(String.valueOf(chars2));
        }
        return false;
    }

    // TODO again understaint the solution
    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                sb.append(find(s.substring(i - 2, i)));
                i = i - 2;
            } else {
                sb.append(find(s.substring(i, i + 1)));
            }
        }
        return sb.reverse().toString();
    }

    public static char find(String str) {
        int x = Integer.parseInt(str);
        return (char) ('a' + x - 1);
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        if (n <= 1) return true;

        for (int i = 0; i < n - 1; i++) {
            if (!isSorted(words[i], words[i + 1], order)) {
                return false;
            }
        }
        return true;
    }


    public static boolean isSorted(String s1, String s2, String order) {
        int m = s1.length(), n = s2.length();
        for (int i = 0; i < m; i++) {
            if (i >= n) {
                return false;
            }
            int val1 = order.indexOf(s1.charAt(i));
            int val2 = order.indexOf(s2.charAt(i));
            if (val1 > val2) {
                return false;
            } else if (val1 < val2) {
                return true;
            }
        }
        return true;
    }

    public static int[] sortByBits(int[] arr) {
        insertionSort(arr);
        return arr;
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                int firstBit = findBits(arr[j]);
                int secondBit = findBits(arr[j - 1]);
                if (firstBit < secondBit) swap(arr, j, j - 1);
                else if (firstBit == secondBit) {
                    if (arr[j] < arr[j - 1]) swap(arr, j, j - 1);
                } else break;
            }
        }
    }

    private static int findBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n -= (n & -n);
        }
        return count;
    }

    public static List<List<Integer>> pascalsTriangle(int nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> pre = null;
        for (int i = 0; i < nums; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            list.add(row);
        }
        return list;
    }

    public static int findClosestNumber(int[] nums) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < max) {
                max = Math.abs(nums[i]);
                min = Math.min(nums[i], max);
            }
            if (Math.abs(nums[i]) == max) {
                min = Math.max(max, nums[i]);
            }
        }
        return min;
    }

    public static int countSegments(String s) {
        int count = 0;
        if (s.length() == 0) return 0;
        String[] sp = s.split(" ");
        for (int i = 0; i < sp.length; i++) {
            if (sp[i].equals("")) {
                continue;
            }
            count++;
        }
        System.out.println(Arrays.toString(sp));
        return count;
    }

    public static int minCostToMoveChips(int[] nums) {
        int even = 0, odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if (nums.length == even || nums.length == odd) return 0;
        return Math.min(even, odd);
    }

    public static int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            right += num;
        }
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (right == left) {
                return i;
            }
            left += nums[i];
        }
        return -1;
       /* for(int i = 0; i < nums.length; i ++){
            int left = 0;
            int right = 0;
            for(int j = i+1; j < nums.length; j++){
                left += nums[j];
            }
            for(int k = i - 1; k >= 0; k--){
                right += nums[k];
            }
            if(left == right){
                return i;
            }
        }
        return -1;*/
    }

    static char nonrepeatingCharacter(String S) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < S.length(); i++)
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) {
                return item.getKey();
            }
        }
        return '$';
    }


    public static int equalPairs(int[][] grid) {

        /*int ans = 0;
        int n = grid.length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                boolean flag = true;
                for(int k=0;k<n&&flag;k++) {
                    if(grid[i][k] != grid[k][j])
                        flag = false;
                }
                if(flag) ans++;
            }
        }
        return ans;*/

        int count = 0;
        int n = grid.length;
        int[][] trans = new int[n][n];
        transposeMatrix(trans, grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(grid[i], trans[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void transposeMatrix(int[][] trans, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                trans[i][j] = grid[j][i];
            }
        }
    }

    public static long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long ans = 0;
        for (int x : nums) {
            if (x == 0) {
                count++;
            } else {
                ans += ((count) * (count + 1)) / 2;
                count = 0;
            }
        }
        ans += ((count) * (count + 1)) / 2;
        return ans;
    }

    public static int fibonacci(int nums) {
        /*int a = 0, b = 1, c;
        System.out.print("0 1");
        for (int i = 2; i < nums; i++) {
            c = a+b;
            System.out.print(" "+c);
            a = b;
            b = c;
        }*/
        if (nums == 0 || nums == 1) return nums;
        return fibo(nums - 1) + fibo(nums - 2);

        /* write main function
        for (int i = 0; i < 5; i++){
            System.out.println(f(i));
        }*/
    }

    public static int commandLineArgumentCalculator(int a, String o, int b) {
        switch (o) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                System.out.println("Please inter the valid operator");
                return 0;
        }
        /* Write main function
        *int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[2]);
        String o = args[1];
        System.out.println("result: "+commandLineArgumentCalculator(a, o,b));*/
    }

    public static void marks(int mark) {
        if (mark < 50) {
            System.out.println("Fail");
        } else if (51 <= mark && mark < 60) {
            System.out.println("Poor");
        } else if (60 <= mark && mark < 70) {
            System.out.println("Average");
        } else if (70 <= mark && mark < 80) {
            System.out.println("Good");
        } else if (80 <= mark && mark < 90) {
            System.out.println("Excellent");
        } else {
            System.out.println("Outstanding");
        }
    }

    public static String bestHand(int[] ranks, char[] suits) {
        /*Map<Character, Integer> m = new HashMap<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < suits.length; i++) {
            m.put(suits[i], i);
        }
        if (m.size() == 1) return "Flush";
        for (int i = 0; i < ranks.length; i++) {
            mp.put(ranks[i], i);
        }
        for (int i = 0; i <= mp.size(); i++) {
            if (mp.size() >= 2){
                return "Three of a Kind";
            }else if(mp.size()==1)
            {
                return "Pair";
            }
        }
        return "High Card";*/
        Set<Character> set = new HashSet<>();
        for (char suit : suits) {
            set.add(suit);
        }
        if (set.size() == 1) return "Flush";
        int max = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            hash.put(ranks[i], hash.getOrDefault(ranks[i], 0) + 1);
            max = Math.max(max, hash.get(ranks[i]));
        }
        if (max >= 3) return "Three of a kinds";
        if (max == 2) return "pair";
        return "High Card";
    }

    public static List<Integer> intersection(int[][] nums) {
        int[] freq = new int[30];
        for (int[] arr : nums) {
            for (int a : arr) {
                freq[a]++;
            }
        }

        System.out.println(Arrays.toString(freq));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if (freq[i] == nums.length) list.add(i);
        }
        return list;
    }

    public static int pkString(int k, String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == 'p') {
                if (i == k) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int reduceArray(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != 0) {
                if (arr[i] % 2 == 0) {
                    arr[i] = arr[i] / 2;
                } else {
                    arr[i] = (arr[i] - 1) / 2;
                }
                count++;
            }
        }
        return count;
    }

    public static int beautyContest(int k, int[] a, int[] b) {
        boolean flag = true;
        for (int i = 0; i < k; i++) {
            if (a[i] - b[i] > b[i] - a[i]) {

            }
        }
        return 1;
    }

    public static int goodNeighbours(String a, String b) {
        String first = a.concat(b);
        String second = b.concat(a);
        char[] char1 = first.toCharArray();
        char[] char2 = second.toCharArray();
        int count = 1;
        int count1 = 1;
        for (int i = 0; i <= first.length() - 2; i++) {
            if (char1[i] == char2[i + 1]) {
                return 0;
            }
        }
        for (int j = 0; j <= second.length() - 2; j++) {
            if (char1[j] == char2[j + 1]) {
                return 0;
            }
        }
        /*System.out.println(count);
        System.out.println(count1);
        if (count == first.length() && count1 == second.length()) return 1;*/
        return 1;
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();


        return new ArrayList<>();
    }

    public static int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && (i == 0 || nums[i] > nums[i - 1])) ans++;
        }
        return ans;
        /*Arrays.sort(nums);
        int count = 0;
        int []arr = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0){
                co
            }
            else {
                for (int j = i; j < nums.length; j++) {
                    nums[i] -= nums[j];
                }
            }
        }
        return count;*/
        /*if (nums.length == 1) {
            if (nums[0] == 0) return 0;
            return 1;
        }

        Arrays.sort(nums);
        int count = 0;
        int zero = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i +1]){
                count++;
            }
            if (nums[i] == 0){
                zero++;
            }
        }
        return nums.length-count-zero;*/

        /*PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for (i = 0; i < nums.length; i++){
            if (i == nums.length - 1){
                if (pq.element() != nums[i - 1]){
                    pq.add(nums[i]);
                    break;
                }
            }
            if (nums[i] != nums[i + 1] || nums[i] == 0){
                pq.add(nums[i]);
            }
        }
        return pq.size();*/
        // HashMap solution
        /*HashMap<Integer, Integer> mp = new HashMap<>();
        for(int it:nums){
            if (it!=0){
                mp.put(it,0);
            }
        }
        System.out.println(mp);
        return mp.size();*/
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePathII(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (nums[0][i] == 1) break;
            else {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i][0] == 1) break;
            else {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix[0].length * matrix.length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr[index++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        int ele = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == k - 1) {
                ele = arr[i];
            }
        }
        return ele;
    }

    public static void primeNumber(int num) {
        boolean flag = num == 0 || num == 1;
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) System.out.println("Not prime");
        else System.out.println("Prime");
    }

    public static long countPairs(int[] nums, int k) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] * nums[j]) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long countPairsB(int[] nums, int k) {
        /*HashMap<Integer,Integer> hm=new HashMap<>();
        long c=0;
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            int gcd1 = gcd(nums[i],k);
            int gcd2 = k/gcd1;
            if(gcd2 == 1)
                c += i;
            else
            {
                for(Integer key: hm.keySet())
                {
                    if(key%gcd2 == 0)
                        c+=hm.get(key);
                }
            }
            if(hm.containsKey(gcd1))
                hm.put(gcd1,hm.get(gcd1)+1);
            else
                hm.put(gcd1,1);
        }
        return c;*/
        long ans = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gcdForm1 = gcd(nums[i], k);
            for (int gcdForm2 : hash.keySet()) {
                if ((long) gcdForm1 * gcdForm2 % k == 0) {
                    ans += hash.get(gcdForm2);
                }
            }
            hash.put(gcdForm1, hash.getOrDefault(gcdForm1, 0) + 1);
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int numSubArrayProductLessThanK(int[] nums, int k) {
        int count = 0, mul = 1;
        for (int i = 0; i < nums.length; i++) {
            mul = 1;
            for (int j = i; mul > k && j < nums.length; j++) {
                mul *= nums[j];
                if (k > mul) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int mexVal(int n, int k, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                --k;
                ans = i;
                if (k == 0) {
                    break;
                }
            }
        }
        return ans;
    }

    public static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s == arr[i] + arr[j]) {
                    list.add(i - 1);
                    list.add(j);
                }
            }
        }
        return list;
    }

    public static boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcd = GCD(gcd, nums[i]);
            if (gcd == 1) return true;
        }
        return gcd == 1;
    }

    private static int GCD(int gcd, int num) {
        if (num == 0) return gcd;
        return GCD(num, gcd % num);
    }

    /*public static int minOperations(int[] nums, int[] numsDivide) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i:nums){
            a.add(i);
        }
        int count = 0;
        for(int i = 0; i < numsDivide.length; i++){
            if (numsDivide[i] % a.get(i) == 0){
                count++;
            }
        }
        return count;
    }*/
    public int minOperations(int[] nums, int[] divs) {
        Arrays.sort(nums);
        int div = Arrays.stream(divs).reduce((a, b) -> gcd(a, b)).getAsInt();
        for (int i = 0; i < nums.length; ++i)
            if (div % nums[i] == 0) return i;
        return -1;
    }

    public static int finalValueAfterOperations(String[] operations) {
        int index = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("X--") || operations[i].equals("--X")) index--;
            else index++;
        }
        return index;
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < n; i++) {
            arr[i + i] = nums[i];
            arr[i + i + 1] = nums[n + i];
        }
        return arr;
    }

    public static int mostWordsFound(String[] s) {
        /*int []nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = s[i].split(" ").length;
        }
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        return nums[nums.length - 1];*/
        int max = 0;
        int temp = 0;
        for (int i = 0; i < s.length; i++) {
            temp = s[i].split(" ").length;
            if (temp > max) max = temp;
        }
        return max;
    }

    public static int uniquePathsIII(int[][] grid) {
        int zero = 0;
        int sx = 0;
        int sy = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) zero++;
                else if (grid[r][c] == 1) {
                    sx = r;
                    sy = c;
                }
            }
        }
        return dfs(grid, sx, sy, zero);
    }

    private static int dfs(int[][] grid, int x, int y, int zero) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) return (zero == -1) ? 1 : 0;
        grid[x][y] = -1;
        zero--;
        int totalPath = dfs(grid, x + 1, y, zero) + dfs(grid, x - 1, y, zero) + dfs(grid, x, y + 1, zero) + dfs(grid, x, y - 1, zero);
        grid[x][y] = 0;
        zero++;
        return totalPath;
    }

    public static long countBadPairs(int[] nums) {
        /*long count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (j - i != nums[j] - nums[i]){
                    count++;
                }
            }
        }
        return count;*/
        HashMap<Long, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put((long) i, nums[i]);
        }
        long pair = 0;
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1);
        Arrays.sort(items2);
        int i = 0, j = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (i < items1.length || j < items2.length) {
            if (items1[i][0] == items2[j][0]) {
                ans.get(i).add(items2[j][1] + items1[i][1]);
                i++;
                j++;
            } else if (items1[i][0] < items2[j][0]) {
                ans.get(i).add(items1[i][1]);
                i++;
            } else {
                ans.get(j).add(items2[j][1]);
                j++;
            }
        }

        while (i < items1.length) {
            ans.get(i).add(items1[i][1]);
            i++;
        }
        while (j < items2.length) {
            ans.get(j).add(items1[j][1]);
            j++;
        }
        return ans;
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        /*int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) count++;
                }
            }
        }
        return  count;*/
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (int i : nums) {
            if (map.containsKey(i + diff) && map.containsKey(i + diff + diff)) {
                count++;
            }
        }
        return count;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                hs.add(edges[i][j]);
            }
        }
        Arrays.sort(restricted);
        int count = 0;
        int x = 0;
        for (int a : hs) {
            if (x == 0) {
                x++;
                continue;
            }
            boolean st = true;
            for (int j = 0; j < restricted.length; j++) {
                if (a == restricted[j]) {
                    st = false;
                }
            }
            if (st) count++;
        }
        return count;
    }

    // Todo public static int findTheWinner(int n, int k) {
        /*if (n == 1) return 1;
        return (findTheWinner(n - 1, k) + k-1) % n + 1;*/

        /*Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            qu.add(i);
        }

        while (qu.size() != 1){
            for (int i = 1; i <= k-1; i++) {
                qu.add(qu.poll());
            }
            qu.poll();
        }
        return qu.poll();
    }*/

    /*public static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Integer []arr1 = arr.toArray(Integer[]::new);
        for (int i = 0; i < arr1.length; i++) {
            int start = i;
            int end = Math.min(i + k -1, arr1.length - 1);
            while (start <=end){
                int tem = arr1[start];
                arr1[start] = arr1[end];
                arr1[end] = tem;
                start++;
                end--;
            }
        }
        arr = new ArrayList<>(Arrays.asList(arr1));
        System.out.println(arr);
    }*/
    public static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        for (int i = 0; i < n; i = i + k) {
            if (i + k < n) reverse(arr, n, i, i + k - 1);
            else reverse(arr, n, i, n - 1);
        }
        System.out.println(arr);

    }

    public static void reverse(ArrayList<Integer> arr, int n, int left, int right) {
        while (left < right) {
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }
    }

    public static void yoyo(int[] arr, int key) {
        int stat = 0;
        int end = arr.length - 1;
        while (stat <= end) {
            int mid = (stat + end) / 2;
            if (arr[mid] == key) {
                System.out.println("find" + (mid + 1));
                return;
            } else if (arr[mid] > key) end = mid;
            else stat = mid;
        }
    }

    public static int[] beautifulArray(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        while (arrayList.size() < n) {
            ArrayList<Integer> arrList = new ArrayList<>();
            for (int i : arrayList) {
                if (2 * i - 1 <= n) {
                    arrList.add(2 * i - 1);
                }
            }
            for (int i : arrayList) {
                if (2 * i <= n) {
                    arrList.add(2 * i);
                }
            }
            arrayList = arrList;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public static int firstElementKTime(int[] a, int n, int k) {
        int count = 1;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] == a[i + 1]) count++;
            if (count == k) return a[i];
        }
        return -1;
    }

    public static void countFreq(int[] arr, int n) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hash.containsKey(arr[i])) {
                hash.put(arr[i], hash.get(arr[i]) + 1);
            } else {
                hash.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> h : hash.entrySet()) {
            System.out.println(h.getKey() + " " + h.getValue());
        }

        /*int count = 0;
        boolean []visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            count = 1;
            if (visited[i] == true) continue;
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]){
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] +" "+count);
        }*/
    }

    public static int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                hash.put(nums[i], hash.get(nums[i]) + 1);
            } else {
                hash.put(nums[i], 1);
            }
        }
        int[] num = new int[2];
        System.out.println(hash);

        return num;
    }

    public static int firstMissingPositive(int[] nums) {
        int size = nums.length;
        int[] arr = new int[size + 1];
        for (int i : nums) {
            if (i > 0 && i <= size) {
                arr[i]++;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) return i;
        }
        return size + 1;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i : nums1) {
            nums[index++] = i;
        }
        for (int i : nums2) {
            nums[index++] = i;
        }
        Arrays.sort(nums);
        double med = nums.length / 2;
        if (nums.length % 2 != 0) {
            return nums[(int) med];
        }
        System.out.println(nums[(int) med - 1] + " " + nums[(int) med]);
        return ((double) nums[(int) med - 1] + (double) nums[(int) med]) / 2;
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper) ans++;
            }
        }
        return ans;
    }

    public static int numberOfBeams(String[] bank) {
        int prevRowGuns = 0;
        int ans = 0;
        for (String b : bank) {
            int curRowGuns = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '1') {
                    curRowGuns++;
                }
            }
            if (curRowGuns != 0) {
                ans += prevRowGuns * curRowGuns;
                prevRowGuns = curRowGuns;
            }
        }
        return ans;
    }

    public int edgeScore(int[] edges) {
        int max = 0;
        int maxKey = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i], map.getOrDefault(edges[i], 0) + i);
            if (!map.containsKey(maxKey)) {
                maxKey = edges[i];
            } else {
                if (map.get(edges[i]) > map.get(maxKey)) {
                    maxKey = edges[i];
                }
                if (map.get(edges[i]) == map.get(maxKey) && edges[i] < maxKey) {
                    maxKey = edges[i];
                }
            }

        }
        return maxKey;
    }

    public String smallestNumber(String pattern) {
        String result = "";

        // create an empty stack of integers
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <= pattern.length(); i++) {
            s.push(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!s.empty()) {
                    result += (s.peek());
                    s.pop();
                }
            }
        }

        return result;
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int max;
        int[][] largest = new int[n - 2][n - 2];
        for (int h = 0; h < n - 2; h++) {
            for (int i = 0; i < n - 2; i++) {
                max = -1;
                for (int j = h; j < 3 + h; j++) {
                    for (int k = i; k < 3 + i; k++) {
                        if (max < grid[j][k]) {
                            max = grid[j][k];
                        }
                    }
                }
                largest[h][i] = max;
            }
        }
        return largest;
    }

    public int countSpecialNumbers(int n) {
        int ans = 0;
        String s = "";
        for (int i = 1; i <= n; i++) {
            Set<Integer> uniDigits = new HashSet<>();
            if (s.length() == uniDigits.size()) {
                ans++;
            }
        }
        return ans;
    }

    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    public static int firstUniqueChar(String s) {
        /*char[]c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (c[i] == c[j] && i!=j){
                    break;
                }
                else if (j == c.length-1){
                    return i;
                }
            }
        }
        return -1;*/

        /*for(int i =0; i<s.length();i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) return i;
        }
        return -1;*/
        HashMap<Integer, Character> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hash.put(i, s.charAt(i));
        }
        System.out.println(hash);
        return -1;
    }

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int count = 0;

        for (Integer num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        System.out.println(countMap);

        for (Integer currCount : countMap.values())
            count += currCount * (currCount - 1) / 2;

        return count;
    }

    public static String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];
        HashMap<Integer, Character> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }

    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
        }

        for (int i = 0; i < n; i++) {
            sum += mat[i][n - 1 - i];
        }
        //22
        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }

    public static int maxProductDifference(int[] nums) {
        /*Arrays.sort(nums);
        int max = Math.max(nums[1]- nums[0], nums[nums.length - 1]- nums[nums.length - 2]);
        return max;*/
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    public static int findGCD(int[] nums) {
        int small = nums[0];
        int max = nums[0];
        int gcd = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }

            if (nums[i] < small) {
                small = nums[i];
            }
        }

        for (int i = 1; i <= small && i <= max; i++) {
            if (max % i == 0 && small % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] tokens = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> sb = new HashSet<>();
        for (String i : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < i.length(); j++) {
                stringBuilder.append(tokens[i.charAt(j) - 'a']);
            }
            sb.add(stringBuilder.toString());
        }
        return sb.size();
    }

    public static int countNegatives(int[][] grid) {
        /*
        int count = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }*/

        int row = grid.length - 1, col = 0, M = grid[0].length, count = 0;
        while (row >= 0 && col < M) {
            if (grid[row][col] < 0) {
                count += M - col;
                row--;
            } else {
                col++;
            }
        }
        return count;
    }

    public static int heightChecker(int[] heights) {
        int[] arr = Arrays.copyOf(heights, heights.length);
        int count = 0;
        Arrays.sort(arr);
        int index = 0;
        for (int i : heights) {
            if (i != arr[index++]) count++;
        }
        return count;
    }

    public static int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        for (String op : ops) {
            switch (op) {
                case "C": {
                    sum -= list.removeLast();
                    break;
                }
                case "D": {
                    int item = list.getLast();
                    list.addLast(item * 2);
                    sum += item * 2;
                    break;
                }
                case "+": {
                    int value = list.get(list.size() - 2) + list.getLast();
                    list.addLast(value);
                    sum += value;
                    break;
                }
                default: {
                    list.addLast(Integer.parseInt(op));
                    sum += Integer.parseInt(op);
                    break;
                }
            }
        }
        return sum;
    }

    public static void pascalTriangle(int num) {
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            arr[i][i] = 1;
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }

    public static int findKthNumber(int m, int n, int k) {
        int[] arr = new int[m * n];
        int p = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[p++] = (i + 1) * (j + 1);
            }
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static boolean reorderedPowerOf(int N) {
        char[] res1 = String.valueOf(N).toCharArray();
        Arrays.sort(res1);
        for (int i = 0; i < 30; i++) {
            char[] res2 = String.valueOf(1 << i).toCharArray();
            Arrays.sort(res2);
            if (Arrays.equals(res1, res2)) return true;
        }
        return false;
    }

    public static void DecimalToBinary(int num) {
        int[] nums = new int[40];
        int index = 0;
        while (num != 0) {
            nums[index++] = num % 2;
            num /= 2;
        }
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(nums[i]);
        }
    }

    public static void BinaryToDecimal(int num) {
        int decimal = 0;
        int index = 0;
        while (true) {
            if (num == 0) break;
            else {
                int tem = num % 10;
                decimal += tem * Math.pow(2, index);
                num /= 10;
                index++;
            }
        }
        System.out.println(decimal);
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int[][] tmp = new int[k][2];
        for (int i = 0; i < k; i++) {
            tmp[i][0] = arr[i][0];
            tmp[i][1] = arr[i][1];
        }

        Arrays.sort(tmp, (a, b) -> a[1] - b[1]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = tmp[i][0];
        return res;
    }

    public static int[] answerQueries(int[] a, int[] q) {
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            a[i] += a[i - 1];
        }
        int[] res = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int sum = 0;
            int j = 0;
            for (j = 0; j < a.length; j++) {
                if (sum + a[j] > q[i]) break;
            }
            res[i] = j;
        }
        return res;
    }

    public static String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        char[] c = s.toCharArray();
        for (char i : c) {
            if (i == '*') {
                st.pop();
            } else {
                st.push(i);
            }
        }
        System.out.println(st);
        String res = "";
        while (!st.empty()) {
            res += st.pop();
        }
        StringBuilder sb = new StringBuilder(res);
        sb.reverse();
        res = sb.toString();
        return res;
    }

    public static String[] findRelativeRanks(int[] score) {
        /*int [] copy = new int[score.length];
        int i = 0;
        for (int j : score){
            copy[i++]= j;
        }
        Arrays.sort(score);
        System.out.println(Arrays.toString(copy));
        String [] str = new String[score.length];
        for (int j = 0; j < score.length; j++) {
            for (int k = 0; k < score.length; k++) {
                if (copy[j] == score[k]){
                    if (k == score.length - 1){
                        str[j] = "Gold Medal";
                    }
                    else if (k == score.length - 2){
                        str[j] = "Silver Medal";
                    }
                    else if (k == score.length - 3){
                        str[j] = "Bronze Medal";
                    }
                    else {
                        str[j] = Integer.toString(score.length - k);
                    }
                }
            }
        }*/
        /*int n = score.length;
        String[] res = new String[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(i);
        }
        System.out.println(pq);
        int i=1;
        while(!pq.isEmpty()){
            int idx = pq.poll();
            if(i>3){
                res[idx] = Integer.toString(i);
            }else if(i==1){
                res[idx] = "Gold Medal";
            }else if(i==2){
                res[idx] = "Silver Medal";
            }else if(i==3){
                res[idx] = "Bronze Medal";
            }
            i++;
        }
        return res;*/
        int[] copy = Arrays.copyOf(score, score.length);
        Arrays.sort(copy);
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = copy.length - 1; i >= 0; i--) {
            if (i == copy.length - 1) hashMap.put(copy[i], "Gold Medal");
            else if (i == copy.length - 2) hashMap.put(copy[i], "Silver Medal");
            else if (i == copy.length - 3) hashMap.put(copy[i], "Bronze Medal");
            else hashMap.put(copy[i], String.valueOf(copy.length - i));
        }

        String[] s = new String[copy.length];
        for (int i = 0; i < hashMap.size(); i++) {
            s[i] = hashMap.get(score[i]);
        }
        return s;
    }

    public static int findKthPositive(int[] arr, int k) {
        /*int n=arr.length;
        int j=0;
        int count=0;
        while(true){
            for(int i=0;i<n;i++){
                if(j+1!=arr[i]){
                    count++;
                    j++;
                    i--;
                }
                else{
                    j++;
                }
                if(count==k){
                    return j;
                }
            }
            break;
        }
        return arr[n-1]+k-count;*/
        if (arr[0] > k) {
            return k;
        }
        int n = k;
        for (int i : arr) {
            if (i <= n) {
                n++;
            } else break;
        }
        return n;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        /*int curr = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 1){
                max = Math.max(max, curr);
                curr = 0;
                continue;
            }
            curr++;
        }
        return Math.max(curr, max);*/
        int count = 0;
        int max = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public static boolean checkValid(int[][] matrix) {
        HashSet<Integer> set = null;
        for (int i = 0; i < matrix.length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (set.contains(matrix[i][j])) return false;
                else set.add(matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (set.contains(matrix[j][i])) return false;
                else set.add(matrix[j][i]);
            }
        }
        System.out.println(set);
        return true;
    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                int j = arr.length - 1;
                while (j > i) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                //arr[i + 1] = 0;
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void goodQuestions() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = sc.nextInt();
            }
            Arrays.sort(ints);
            int count = 0;
            for (int j = 0; j < n - 1; j++) {
                if (ints[j] == ints[j + 1]) {
                    count++;
                }
            }
            int distinct = n - count;
            if (distinct % 2 == 0) {
                System.out.println("YES");
            } else if ((distinct % 2) != 0 && count > 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            t--;
        }
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

    public static List<Integer> addToArrayForm(int[] num, int k) {
        /*List<Integer> list = new ArrayList<>();
        int p = 0;
        for (int i = 0; i < num.length; i++) {
            p = 10 * p + num[i];
        }
        int sum = p + k;
        System.out.println(sum);
        while (sum != 0){
            int rem = sum % 10;
            list.add(rem);
            sum /= 10;
        }
        Collections.reverse(list);
        return list;*/
        List<Integer> list = new ArrayList<>();
        int length = num.length;

        while (length-- > 0 || k > 0) {
            if (length >= 0) {
                k = k + num[length];
                list.add(k % 10);
                k = k / 10;
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i]) && (i - hash.get(nums[i])) <= k) {
                return true;
            }
            hash.put(nums[i], i);
        }
        return true;
    }


    public static String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] arr = new String[str.length];
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String a : str) {
            i = a.charAt(a.length() - 1) - '0';
            arr[i - 1] = a.substring(0, a.length() - 1);
        }
        for (int j = 0; j < arr.length - 1; j++) {
            stringBuilder.append(arr[j]).append(" ");
        }
        stringBuilder.append(arr[i]);
        return stringBuilder.toString();
    }

    public static int[] minOperations(String boxes) {
        /*int len = boxes.length();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int cost = 0;
            for (int j = 0; j < len; j++) {
                if (boxes.charAt(j) == '1') cost += Math.abs(i - j);
            }
            ans[i] = cost;
        }
        return ans;*/
        int size = boxes.length();
        int arr[] = new int[size];

        int rightSum = 0;
        int onesAtRight = 0;
        for (int i = 0; i < size; i++) {
            if (boxes.charAt(i) == '1') {
                onesAtRight++;
                rightSum += i;
            }
        }
        int leftSum = 0;
        int onesAtLeft = 0;
        for (int i = 0; i < size; i++) {
            leftSum += onesAtLeft;
            if (boxes.charAt(i) == '1') {
                onesAtRight--;
                onesAtLeft++;
            }
            arr[i] = rightSum + leftSum;
            rightSum -= onesAtRight;
        }
        return arr;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> dis = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        recursPermute(nums, list, dis, visited);
        return list;
    }

    public static void recursPermute(int[] nums, List<List<Integer>> list, List<Integer> dis, boolean[] visited) {
        if (dis.size() == nums.length) {
            list.add(new ArrayList<>(dis));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dis.add(nums[i]);
                recursPermute(nums, list, dis, visited);
                dis.remove(dis.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static boolean findSubarrays(int[] nums) {
        if (nums.length < 2) return false;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println(set);
            if (!set.add(nums[i] + nums[i + 1])) return true;
        }
        return false;
    }


    public static void rotate(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copy[j][matrix.length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = copy[i][j];
            }
        }

    }

    public static List<List<Integer>> combinationSumIII(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private static void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> list = new HashMap<>();
        for (String str : strings) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String string = new String(chars);
            if (!list.containsKey(string)) {
                list.put(string, new ArrayList<>());
            }
            list.get(string).add(str);
        }
        return new ArrayList<>(list.values());
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


        /*int []out = new int[nums.length];
        for (int i = 0, left = 1 ;i < nums.length; i++) {
            out[i] = left;
            left *= nums[i];
        }
        for (int i = nums.length - 1, right = 1 ;i >= 0; i--) {
            out[i] *= right;
            right *= nums[i];
        }
        return out;*/

        int length = nums.length;

        int[] left_products = new int[length];
        left_products[0] = 1;

        int[] right_products = new int[length];
        right_products[length - 1] = 1;

        int[] output = new int[length];

        for (int i = 1; i < length; i++) {
            left_products[i] = nums[i - 1] * left_products[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            right_products[i] = nums[i + 1] * right_products[i + 1];
        }

        for (int i = 0; i < length; i++) {
            output[i] = right_products[i] * left_products[i];
        }

        return output;
    }

    public static int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < operations.length; i++) {
            int index = map.get(operations[i][0]);
            nums[index] = operations[i][1];
            map.remove(operations[i][0]);
            map.put(operations[i][1], index);
        }
        return nums;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                int sum = min + triangle.get(i).get(j);

                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
        /*int sum = 0;
        int min = Integer.MAX_VALUE;
        for (List<Integer> i : triangle){
            for (int j : i){
                min = Math.min(min, j);
            }
            sum += min;
            min = Integer.MAX_VALUE;
        }
        return  sum;*/
    }

    public static int removeDuplicates(int[] nums) {
        /*if(nums.length == 0) return 0;
        int j = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j + 1;*/
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1]) nums[i++] = n;

        return i;
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

    public static int subArraySum(int[] nums, int k) {
        // Brute force
        /*int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;*/

        //Using hashMap
        /*int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            int remaining = prefixSum - k;
            if (hashMap.containsKey(remaining))
                count += hashMap.get(remaining);
            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;*/

        int count = 0, n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = nums[i];
            if (sum == k) {
                count++;
            }
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int s = k;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length - k + i; i++) {
            arr[k++] = nums[i];
        }

        int j = 0;
        for (int i = nums.length - s; i < nums.length; i++) {
            if (j < s) {
                arr[j++] = nums[i];
            }
        }

        int m = 0;
        for (int p : arr) {
            nums[m++] = p;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int findUnsortedSubArray(int[] nums) {
        int count = 0;
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        int start = 0, end = nums.length - 1;
        Arrays.sort(nums);
        for (; start < nums.length; start++) {
            if (nums[start] != copy[start]) {
                break;
            }
        }
        for (; end >= 0; end--) {
            if (nums[end] != copy[end]) {
                break;
            }
        }
        System.out.println("Start " + start);
        System.out.println("end " + end);
        return end + start - 1;
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

    // TODO underStand this solution
    public static int findNthPrime(int n) {
        int num = 1, count = 0, i;
        while (count < n) {
            num = num + 1;
            for (i = 2; i <= num; i++) {
                if (num % i == 0) {
                    break;
                }
            }
            if (i == num) {
                count = count + 1;
            }
        }
        return num;
    }

    public static int mostFrequentEven(int[] nums)/*Todo understand this problem */ {
        int[] map = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            ++map[nums[i]];
        }
        int max = 0;
        int ans = -1;
        for (int i = 0; i < map.length; i++) {
            if (i % 2 == 0) {
                if (map[i] > max) {
                    ans = i;
                    max = map[i];
                }
            }
        }
        return ans;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        System.out.println(Arrays.toString(nums1));

        /*int index = nums1.length-1;
        while (m>0 && n>0){
            if (nums1[m-1] < nums2[n-1]){
                if (nums1[index--] == nums2[--n]);
            }
            else {
                nums1[index--] = nums1[--m];
            }
            while (m>0){
                nums1[index--] = nums1[--m];
            }
            while (n>0){
                nums1[index--] = nums2[--n];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(" "+nums1[i]);
        }*/

    }

    public static int triangularSum(int[] nums) {
//        return find(nums,nums.length);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                nums[i] = nums[j] + (nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }

    public static int find(int[] a, int n) {
        if (n == 1) return a[0];

        for (int i = 0; i < n - 1; i++) {
            a[i] = (a[i] + a[i + 1]) % 10;
        }
        return find(a, n - 1);
    }

    public static String complexNumberMultiply(String num1, String num2) {
        String[] a = num1.split("\\+|i");
        String[] b = num2.split("\\+|i");
        int ar = Integer.parseInt(a[0]), ai = Integer.parseInt(a[1]);
        int br = Integer.parseInt(b[0]), bi = Integer.parseInt(b[1]);
        return String.format("%d+%di", ar * br - ai * bi, ar * bi + ai * br);
    }

    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[0];

        Arrays.sort(changed);
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : changed) map.put(num, map.getOrDefault(num, 0) + 1);
        int[] res = new int[changed.length / 2];
        int pointer = 0;

        for (int num : changed) {
            if (map.get(num) < 1) continue;
            if (map.getOrDefault(num * 2, 0) < 1) return new int[0];
            map.put(num, map.get(num) - 1);
            map.put(num * 2, map.get(num * 2) - 1);
            res[pointer++] = num;
        }
        return res;
    }

    public static int maxSatisfaction(int[] satisfaction) {
        int total = 0, res = 0;
        Arrays.sort(satisfaction);
        for (int i = satisfaction.length - 1; i >= 0 && satisfaction[i] > -total; i--) {
            total += satisfaction[i];
            res += total;
        }
        return res;
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);

        System.out.println(map.get(1 + 1));

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }
        return max;
    }

    public static int maxDepth(String s) {
        int count = 0;
        int max = 0;
        /*for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            max = Math.max(count, max);
        }*/
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
            }
        }
        return stack.size();
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (counter != 0) sb.append(c);
                counter++;
            } else {
                counter--;
                if (counter != 0) sb.append(c);
            }
        }

        return sb.toString();
    }

    public static boolean isValidParathesis(String s) {
        /*if(s.length() % 2 != 0) return false;
        Stack <Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else if(c == ')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }
             else if(c == ']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
            }
             else if(c == '}' && !stack.isEmpty() && stack.peek() =='{'){
                stack.pop();
            }

        }*/

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int num = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1) {
                num++;
            }
        }
        return num;
    }

    public int longestContinuousSubstring(String s) {
        int maxi = 1;
        int ans = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                ans++;
                maxi = Math.max(ans, maxi);
            } else {
                ans = 1;
            }
        }
        maxi = Math.max(maxi, ans);
        return maxi;
    }

    public List<String> cellsInRange(String s) {
        char c1 = s.charAt(0), c2 = s.charAt(3);
        char r1 = s.charAt(1), r2 = s.charAt(4);
        List<String> cells = new ArrayList<>();
        for (char c = c1; c <= c2; ++c) {
            for (char r = r1; r <= r2; ++r) {
                cells.add("" + c + r);
            }
        }
        return cells;
    }

    public static boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++)
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
        int value = hash.get(s.charAt(0));
        for (char c : hash.keySet()) {
            if (hash.get(c) != value)
                return false;
        }
        return true;
    }

    public static int findLength(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        for (int i : nums2) set2.add(i);
        if (set1.size() == 1 && set2.size() == 1) return nums1.length;
        int cout = 0;
        for (int i : set1) {
            if (set2.contains(i)) cout++;
        }
        return cout;
    }

    public static String truncateSentence(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = s.split(" ");
        for (int i = 0; i < k - 1; i++) {
            stringBuilder.append(str[i]).append(" ");
        }
        stringBuilder.append(str[k - 1]);
        return stringBuilder.toString();
    }

    private static char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for (int i = 4; i < length; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

    static public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sumfirst = 0, sumsecond = 0, sumtarget = 0;
        for (char c : firstWord.toCharArray()) {
            sumfirst += c - 'a';
            sumfirst *= 10;
        }
        for (char c : secondWord.toCharArray()) {
            sumsecond += c - 'a';
            sumsecond *= 10;
        }
        for (char c : targetWord.toCharArray()) {
            sumtarget += c - 'a';
            sumtarget *= 10;
        }

        return (sumfirst + sumsecond) == sumtarget;
    }

    public static int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, 2, n + 1, true);
        for (int i = 2; i * i <= n; i++)
            if (prime[i])
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;

        int cnt = 0;
        for (boolean b : prime)
            if (b)
                cnt++;

        return cnt;
    }

    public static List<String> simplifiedFractions(int n) {
        Set<Double> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (set.add((double) j / i)) {
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }

    private int maxWidthOfVerticalArea(int[][] points) {
        int L = points.length;
        int arr[] = new int[L];
        for (int i = 0; i < L; i++) {
            arr[i] = points[i][0];
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int diff = 0;

        for (int i = 1; i < L; i++) {
            if ((arr[i] - arr[i - 1]) > diff) {
                diff = Math.max(diff, arr[i] - arr[i - 1]);
            }
        }
        return diff;
    }

    private static String reverseWords(String str) {
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        for (; j < chars.length; j++) {
            if (chars[j] == ' ') {
                reverseWord(chars, i, j - 1);
                i = j + 1;
            }
        }
        reverseWord(chars, i, j - 1);
        return new String(chars);
    }

    private static void reverseWord(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }

    private static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        System.out.println(map);
        Arrays.sort(heights);
        String[] result = new String[heights.length];
        int index = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            result[index] = map.get(heights[i]);
            index++;
        }
        return result;
    }

    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List a : items) {
            if (ruleKey.equals("type") && a.get(0).equals(ruleValue)) {
                count++;
            }
            if (ruleKey.equals("color") && a.get(1).equals(ruleValue)) {
                count++;
            }
            if (ruleKey.equals("name") && a.get(2).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }

    public static int countAsterisks(String s) {
        boolean insidePipe = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                insidePipe = !insidePipe;
            }
            if (!insidePipe && s.charAt(i) == '*') {
                count++;
            }
        }
        return count;
    }

    public static int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for (int i = 0; i < pref.length - 1; i++) {
            arr[i + 1] = pref[i] ^ pref[i + 1];
        }
        return arr;
    }

    public static int hardestWorker(int n, int[][] logs) {
        int diff = logs[0][1] - 0;
        int id = logs[0][0];
        for (int i = 1; i <= logs.length - 1; i++) {
            int ans = logs[i][1] - logs[i - 1][1];
            if (ans == diff) {
                id = Math.min(id, logs[i][0]);
            }
            if (ans > diff) {
                diff = ans;
                id = logs[i][0];
            }
        }
        return id;
    }

    public static int largestOverlap(int[][] img1, int[][] img2) {
        int count1 = 0;
        int count2 = 0;
        for (int[] arr : img1) {
            for (int j : arr) {
                if (j == 1) count1++;
            }
        }
        for (int[] arr : img2) {
            for (int j : arr) {
                if (j == 1) count2++;
            }
        }
        return Math.min(count1, count2);
    }

    public static int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num - k)) {
                res += map.get(num - k);
                System.out.println(map.get(num - k));
            }
            if (map.containsKey(num + k)) {
                res += map.get(num + k);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        return res;
    }

    public int maxSum(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static long minValue(long[] a, long[] b, long n) {
        long min = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(b.length);
        for (int i = 0; i < n / 2; i++) {
            long temp = b[i];
            b[i] = b[b.length - 1 - i];
            b[b.length - 1 - i] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            min += a[i] * b[i];
        }
        System.out.println(Arrays.toString(b));
        return min;
    }

    public static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max = arr[n - 1];
        list.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static boolean increasingTriplet(int[] nums) {
        int max = Integer.MAX_VALUE, secMax = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= max) max = num;
            else if (num <= secMax) secMax = num;
            else return true;
        }
        return false;
    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int a = piles.length - 2;
        int sum = 0;
        for (int i = 0; i < piles.length / 3; i++) {
            sum += piles[a];
            a -= 2;
        }
        return sum;
    }

    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int index = 0;
        int in = 0;
        for (int i : nums) {
            if (i > 0) {
                pos[index++] = i;
            }
        }
        for (int i : nums) {
            if (i < 0) {
                neg[in++] = i;
            }
        }
        int[] arr = new int[nums.length];
        int d = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i += 2) {
            arr[i] = pos[d++];
            arr[i + 1] = neg[k++];
        }
        return arr;
    }

    public static ArrayList<Integer> duplicates(int[] arr) {
        ArrayList<Integer> ret = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                ret.add(arr[i]);
                i++;
            }
        }
        Set<Integer> set = new HashSet<>(ret);
        ArrayList<Integer> arrayList = new ArrayList<>(set);
        Collections.sort(arrayList);
        if (arrayList.size() == 0) arrayList.add(-1);
        return arrayList;
        /*int big = 100001;
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[arr[i] % big] += big;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] / big > 1) ret.add(i);
        }
        if (ret.size() == 0) ret.add(-1);
        return ret;*/
    }

    /*https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/*/
    public static long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        long ans = 0;
        int index = 0;
        for (int[] rectangle : rectangles) {
            Double ratio = 1.0 * rectangle[0] / rectangle[1];
            int prefrq = map.getOrDefault(ratio, 0);
            System.out.println(prefrq + " " + index++);
            ans += prefrq;
            map.put(ratio, prefrq + 1);
        }
        System.out.println(map);
        return ans;
    }

    public static String removeOccurrences(String s, String part) {
        StringBuilder stringBuilder = new StringBuilder(s);
        while (stringBuilder.indexOf(part) != -1) {
            stringBuilder.delete(stringBuilder.indexOf(part), stringBuilder.indexOf(part) + part.length());
        }
        return stringBuilder.toString();
    }

    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum += HammingDistance(nums[i], nums[j]);
            }
        }
        return sum;
    }

    public int HammingDistance(int a, int b) {
        return Integer.bitCount(a ^ b);
    }

    private static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        for (String s : words) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        List<String> res = new ArrayList<>(freq.keySet());
        Collections.sort(res, (a, b) -> freq.get(b) != freq.get(a) ? freq.get(b) - freq.get(a) : a.compareTo(b));
        return res.subList(0, k);
    }

    private static String customSortString(String order, String s) {
        String[] str = s.split("");
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return order.indexOf(o1) - order.indexOf(o2);
            }
        });
        return String.join("", str);
    }

    private static boolean sumOfNumberAndReverse(int num) {
        /*Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            set.add(i + Integer.parseInt(new StringBuilder(Integer.toString(i)).reverse().toString()));
        }
        return set.contains(num);*/
        for (int i = 0; i <= num; i++) {
            int rev = 0;
            int temp = i;
            while (temp != 0) {
                int r = temp % 10;
                rev = rev * 10 + r;
                temp = temp / 10;
            }
            if ((i + rev) == num) {
                return true;
            }
        }
        return false;
    }

    private int findMaxK(int[] nums) {
        int tem = 0, max = 0;
        Arrays.sort(nums);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                tem = nums[i];
                max = Math.max(tem, max);
            } else hashMap.put(nums[i], 1);
        }
        return max;
    }

    private static int isPanagram(String s) {
        String str1 = s.toLowerCase();
        String[] str = str1.split(" ");
        Set<Character> set = new HashSet<>();
        for (String a : str) {
            for (char b : a.toCharArray()) {
                set.add(b);
            }
        }
        if (set.size() == 26) return 1;
        return 0;
    }

    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countIdx(s);
        }
        return s;
    }

    public static String countIdx(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }

    private static String frequencySort(String s) {
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap1.put(s.charAt(i), hashMap1.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character>
                list = new PriorityQueue<>((a, b) -> hashMap1.get(b) - hashMap1.get(a));
        list.addAll(hashMap1.keySet());
        System.out.println(list);
        StringBuilder str = new StringBuilder();
        while (!list.isEmpty()) {
            char ch = list.remove();
            int count = hashMap1.get(ch);
            while (count != 0) {
                str.append(ch);
                count--;
            }
        }
        return str.toString();
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        /*StringBuilder stringBuilder = new StringBuilder();
        for(String i : word1){
            stringBuilder.append(i);
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        for(String i : word2){
            stringBuilder1.append(i);
        }
        return stringBuilder.toString().equals(stringBuilder1.toString());*/
        String str = String.join("", word1);
        String str1 = String.join("", word2);
        return str1.equals(str);
    }

    public static int maximum69Number(int num) {
        //return Integer.parseInt((""+num).replaceFirst("6","9"));
        StringBuilder s = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                s.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(String.valueOf(s));
    }

    public static String makeGood(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1) + 32 || s.charAt(i) == s.charAt(i + 1) - 32) {
                return makeGood(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;
    }

    public static int[] applyOperations(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
                i++;
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num != 0) {
                arr[count++] = num;
            }
        }
        return arr;
    }

    private static long maximumSubArraySum(int[] A, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        long mx = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1);

            if (i >= k - 1) {
                if (mp.size() == k) mx = Math.max(mx, sum);
                sum -= A[i - k + 1];
                mp.put(A[i - k + 1], mp.get(A[i - k + 1]) - 1);
                if (mp.get(A[i - k + 1]) == 0) mp.remove(A[i - k + 1]);
            }
        }
        return mx;
    }

    public static int averageValue(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 0 && i % 3 == 0) {
                sum += i;
            }
        }
        return sum / 2;
    }

    //Not implemented
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int sum = 0;
        double module = 1e9 + 7;

        return sum;
    }

    public static String removeDuplicate(String s) {
        /*char[] c = s.toCharArray();
        int i = 0;
        String res = "";
        while (c[i] != '\0'){
            if(c[i] != c[i+1]){
                res += c[i];
                i++;
            }
            if(c[i+1] != '\0' && c[i] == c[i+1]){
                while (c[i+1] != '\0' && c[i] == c[i+1]){
                    i++;
                }
                i++;
            }
        }*/
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int []maxRow = new int[n];
        int []maxCol = new int[m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                count += Math.min(maxRow[i], maxCol[j]) - grid[i][j];

        return count;
    }
    public static String reverseWord(String s){
        String [] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int end = words.length - 1;
        for(int i = 0; i<= end; i++){
            if(!words[i].isEmpty()) {
                sb.insert(0, words[i]);
                if(i < end) sb.insert(0, " ");
            }
        }
        return sb.toString();
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        int n = matches.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(matches[i][1])) {
                map.put(matches[i][1], map.get(matches[i][1]) + 1);
            } else {
                map.put(matches[i][1], 1);
            }
        }
        System.out.println(map);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                list1.add(e.getKey());
            }
        }
        TreeSet<Integer> ans = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(matches[i][0])) {
                ans.add(matches[i][0]);
            }
        }
        List<Integer> list2 = new ArrayList<>(ans);
//		System.out.println(list1);
//		System.out.println(list2);
        list.add(list2);
        list.add(list1);

        return list;
    }

    public static void main(String[] args) {
        int [][]matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(findWinners(matches));
        /*int [][]grid = {{0,0},
                        {0,1},
                        {1,0},
                        {1,2},
                        {2,1},
                        {2,2}};*/
        /*Character character = 'A';
        if (Character.isDigit(character)){
            System.out.println(character);
        }else {
            System.out.println("Null");
        }*/

        /*String []word1 = {"ab", "c"}, word2 = {"a", "bc"};
        String str = String.join("",word1);
        System.out.println(str);*/


        /*System.out.println(Integer.bitCount(2 ^ 6));
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeOccurrences(s, part));*/


        /*int[][] rectangles = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        System.out.println(interchangeableRectangles(rectangles));*/
        /*int[] nums = {16, 7, 5, 23, 5, 18, 23, 15, 5, 13, 18, 10, 22, 5, 17, 14, 5, 3, 15, 5, 12, 11, 15, 16, 9, 4, 15};
        System.out.println(duplicates(nums));*/

        /*String s = "Given a limited range? array contains both positive ! and non-positive numbers, i.e., elements are in the range";
        String punctuation = "!?',;.";
        for (char c : punctuation.toCharArray()) {
            s = s.replace(c, ' ');
        }
        System.out.println(s);*/

        /*Arrays.sort(nums, new Comparator<int []>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.valueOf(o1[0]).compareTo(o2[0]);
            }
        });*/

       /* Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]){
                return o1[0] - o2[0];
            }
        });*/
        /*System.out.println(increasingTriplet(nums));*/
        /*System.out.println(leaders(A, A.length));*/
        /*System.out.println(firstElementKTime1(A,A.length, 2));*/
        /*Integer []nums = {1,2,2,1,4,5,8,7,1,4,3,2};
        Arrays.sort(nums);
        Arrays.sort(nums, Comparator.reverseOrder());
        System.out.println(Arrays.toString(nums));*/
        /*System.out.println(countAsterisks("*yo|uar|e**|b|e***au|tifu|l"));*/
        /*List<List<String>> items = List.of(List.of("phone","blue","pixel"), List.of("computer","silver","phone"), List.of("phone","gold","iphone"));
        String ruleKey = "type", ruleValue = "phone";
        System.out.println(countMatches(items, ruleKey, ruleValue));*/
        /*int [] nums = {1,2,1,2,1,2,1,2,1,3,4,5,6,6,4,3,3,2,5};
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            if (hash.containsKey(num)) {
                hash.put(num, hash.get(num + 1));
            } else {
                hash.put(num, 1);
            }
        }
        for (Map.Entry entry : hash.entrySet()){
            System.out.println(entry.getKey() +" " + entry.getValue());
        }*/

        /*String [] patterns = {"a","abc","bc","d"};
        String word = "abc";
        System.out.println(numOfStrings(patterns, word));*/
        
        /*String []names = {"Mary","John","Emma"};
        int [] heights = {180,165,170};
        System.out.println(Arrays.toString(sortPeople(names, heights)));*/
        /*String firstWord = "acb", secondWord = "cba", targetWord = "cdb";
        System.out.println(isSumEqual(firstWord,secondWord,targetWord));*/
        /*System.out.println(Arrays.toString(generatePassword(8)));*/

        /*int k = 4;
        System.out.println(truncateSentence(s, k));*/

        /*String []word1 = {"ab", "c"}, word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));*/

        /*System.out.println(numJewelsInStones(jewels,stones));*/
        /*double time = 16.63026653034893;
        String s = String.format("%1.1f",time);
        System.out.println(s);*/

        /*LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm a");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);*/
        /*DateFormat dateFormat = DateFormat.getDateInstance(Instant.ofEpochSecond(time));*/
        // Todo Date Time Formate milli to local date
       /* Date date = new Date(time*1000L);
        SimpleDateFormat myDate = new SimpleDateFormat("HH:mm a");
        String formatted = myDate.format(date);
        System.out.println(formatted);*/

        /*int []nums1 = {1,2,3,0,0,0};
        int m = 3;
        int []nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);*/
        //System.out.println(countPrime(10));


        // Todo StringTokenizer
        /*StringTokenizer stringTokenizer = new StringTokenizer("Gaddar Kumar Chaudhary Computer Science engineer Siliguri");
        while(stringTokenizer.hasMoreElements()){
            System.out.println(stringTokenizer.nextToken());
        }*/

        // Todo StringJoiner
        /*StringJoiner a = new StringJoiner(",","[", "]");
        a.add("A").add("B").add("C");
        StringJoiner b = new StringJoiner(":");
        b.add("P").add("Q");
        a.merge(b);
        System.out.println(a);*/

        //System.out.println(subArraySum(nums, 3));
        /*List<List<Integer>> list = Arrays.asList(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3));
        System.out.println(minimumTotal(list));*/
        /*int []nums = {1,2,3,5};
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int num : nums){
            hashMap1.put(num, hashMap1.getOrDefault(num, 0) + 1);
        }
        System.out.println(hashMap1.get(2));*/
        /*int[] nums = {1, 2, 4, 6};
        int[][] operations = {{1, 3}, {4, 7}, {6, 1}};
        System.out.println(Arrays.toString(arrayChange(nums, operations)));*/
        /*String [] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));*/


        // System.out.println(Arrays.toString(minOperations(s)));
        //System.out.println(sortSentence(s));
        // System.out.println(sortSentence(s));

        /*var a = new int[]{1,2,3,4,5};
        var var = 10;
        System.out.println(Arrays.toString(a));
        System.out.println(((Object) a).getClass().getSimpleName());*/

        //System.out.println(Arrays.toString(maxSubsequence(nums, k)));
        /*int [][]arr = {{8,2,3}, {4,9,2}};
        Arrays.sort(arr, (a, b) -> b[0] - a [0]);
        System.out.println(Arrays.deepToString(arr));
        String[] months = {"January","February","March","April","May","June","July","August","September","October","December"};
        System.out.println(Arrays.toString(months)); *///printing before
        //neither this works:
        //Arrays.sort(months, (a, b) -> Integer.signum(a.length() - b.length()));
        //Arrays.sort(months, (String a, String b) -> { return Integer.signum(a.length() - b.length())) });
       /* Arrays.sort(months, (a, b) -> a.length() - b.length());
        System.out.println(Arrays.toString(months));*/ //printing after
        //System.out.println(reorderedPowerOf(85));

        //System.out.println(findKthNumber(3,3,5));
        //Bubble sort
       /*int []arr = {23,16,7,45,32,12};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    int tem = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tem;
                }
            }
        }
        System.out.println(Arrays.toString(arr));*/


        /*int [][]grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));*/

        /*String []words = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(words));*/
        /*ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List a = new ArrayList(Arrays.asList("gadd",8,'h',8.34));
        System.out.println(a);*/

//        reverseInGroups(list, 5, 3);

        /*String []sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(sentences));*/

        /*int []arr = {1,2,3,7,5};
        System.out.println(subArraySum(arr,5));*/
        /*int []nums= {10, 20, 20, 10, 10, 20, 5, 20};
        int n = nums.length;
        countFreq(nums, n);*/

//        System.out.println(subArraySum(nums, 3));

        //System.out.println(countPairs(nums, 2));
        /*int []matrix = {-1,-8,0,5,-9};
        System.out.println(maxSatisfaction(matrix));*/
        /*int []nums = {2,6,5,3,1};
        System.out.println(reduceArray(nums));*/
        /*tring a="1010", b="01010";
        System.out.println(goodNeighbours(a,b));*/

        /*String a = "haulwxw";
        System.out.println(pkString(3,a));*/
        /*List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,1,4,2,2,5,6,7,9);
        System.out.println(list);
        list.removeAll(Collections.singletonList(4));
        System.out.println(list);*/
        /*int [][]nums = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        System.out.println(intersection(nums));*/
        /*int []ranks = {4,4,2,4,4,3,3,3};
        char []suits = {'d','a','a','b','c'};
        System.out.println(bestHand(ranks,suits));*/

       /* int []nums = {1,0,3,0,0,2,0,0,0,0,4};
        System.out.println(zeroFilledSubarray(nums));*/
        /*int [][]grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(equalPairs(grid));*/
        /*String s = "abccbaacz";
        System.out.println(repeatedCharacter(s));*/
        /*int []nums = {4,4,2,4,4};
        char [] c = {'d','a','a','b','c'};
        System.out.println(bestHand(nums,c));*/


        /*String s = "Hello, my name is John";
        System.out.println(countSegments(s));*/

        /*BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
        int []nums = {-4,-2,1,4,8};
        System.out.println(findClosestNumber(nums));*/

        /* Make pattern
        int i, j, row = 6;
        for (i=0; i<row; i++)
        {
            for (j=row-i; j>1; j--)
            {
                System.out.print(" ");
            }
            for (j=0; j<=i; j++ )
            {
                System.out.print("* ");
            }
            System.out.println();
        }*/

//        System.out.println(pascalsTriangle(4));
        /*int []nums = {1,2,0,0};
        System.out.println(addToArrayForm(nums, 34));*/

        /*String []words = {"hello","leetcode"};
        System.out.println(isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));*/
        /*System.out.println(freqAlphabets("10#11#12"));*/
        /*int [][]mat = {{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}};
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));*/

        /*String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp heinous argv vcnjrdb";
        System.out.println(decodeMessage(key, message));*/

//        System.out.println(maximumUnits(accounts,7));
        /*int [] nums = {4,1,2};
        int [] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums,nums2)));*/

        /*String s = "bank";
        String s1 = "kanb";
        System.out.println(areAlmostEqual(s,s1));*/
        /*Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            int candies = 0;

            for(int j = 1; j <= n; j++) {
                candies += in.nextInt();
            }

            int leftCandies = candies % m;

            System.out.println("Case #" + i + ": " + leftCandies);
        }*/

        /*Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int []nums = new int[a];
        for (int i = 0; i < a; i++) {
            nums[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        System.out.println(problem1(a,b,nums));*/
        /*int [][] nums= {{1,2},{3,1},{2,4},{2,3},{4,4}};
        System.out.println(Arrays.deepToString(nums));*/
//        System.out.println(nearestValidPoint(3,4,nums));

        /*int []arr1 = {4,5,8};
        int []arr2 = {10,9,1,8};
        System.out.println(findTheDistanceValue(arr1,arr2,2));*/
        /*int []point = nums[1];
        System.out.println(Arrays.toString(point));*/


        /*int [][]grid = {{5,7,0},{0,3,1},{0,5,0}};
        System.out.println(checkXMatrix(grid));*/
        //Arrays.fill(nums, Integer.MAX_VALUE);
        /*String s = "hello";
        System.out.println(reverseVowel(s));*/

        /*System.out.println(checkIfExist(nums));*/
        /*StringBuilder s = new StringBuilder();
        words1 = words1.substring(3+1);
        System.out.println(words1);*/
        //System.out.println(reversePrefix(words1, 'd'));

        //System.out.println(mergeAlternately(words1, words2));

        //nextPermutation(nums);
        //System.out.println(trimMean(nums));
        /*String str = "hgfhdgvftfghd";
        System.out.println(longestPalindromeSubseq1(str));*/
        /*int []nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));*/
        /*String s = "lEeTcOdE";
        System.out.println(greatestLetter(s));*/
        /*int [][]nums = {{2,2}, {3,3}};
        System.out.println(rangeAdditionII(3,3,nums));*/
        //System.out.println(rangeAdditionII(3,3,nums));
        /*String s1 = "acde";
        String s2 = "ace";
        System.out.println(longestCommonSubStringBottomUp(s1, s2));*/


        /*int []arr = {1,4};
        int duration = 2;
        System.out.println(findPoisonedDuration1(arr,duration));*/
        /*String word1 = "eat";
        String word2 = "sea";
        System.out.println(minDistance(word1,word2));*/
        /*List<List<Integer>> list = new ArrayList<>();
        list = Arrays.asList(Arrays.asList(8),Arrays.asList(5,6), Arrays.asList(1,2,3),Arrays.asList(4,2,9,1));
        System.out.println(minimumTotal(list));*/

        //System.out.println(minimumTotal(nums));

        /*int []nums= {4,2,4,5,6};
        slidingWindowTech(nums, 2);*/
        /*int [][]nums = {{3,50},{7,10},{12,25}};
        System.out.println(calculateTax(nums,10));*/

        //System.out.println(intersection(nums));

        /*System.out.println(intersection(nums));*/
        //System.out.println(waysToBuyPensPencils(20,10,5));
        /*System.out.println(hasAllCodes("0000000001011100", 4));*/
        /*int []nums = {5,4,3,7,1};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        if (hashMap.containsKey(5)){
            System.out.println("yes");
        }

        char []chars = {'g','w','2','0'};
        System.out.println(chars);
        String s = new String(chars);

        System.out.println((Object) s.getClass().getSimpleName());*/

        /*System.out.println(reductionOperations(nums));*/
        /*System.out.println(c(218));
        System.out.println(reorderedPowerOf2(218));
        System.out.println(Math.pow(2,10));*/


        /*int n = 125;
        int []ae = new int[10];
        while (n != 0){
            ae[n%10]++;
            n/=10;
        }
        System.out.println(Arrays.toString(ae));*/
        /*System.out.println(Arrays.toString(closestDivisors(8)));*/
        /*int [][]matrix = {{1,2,3},{3,1,2},{2,3,1}};
        checkStraightLine(matrix);*/
        /*System.out.println(percentageLetter("foobar", 'o'));*/
        /*int [] nums= {8,19,4,2,15,3,7};
        System.out.println(canMakeArithmeticProgression(nums));*/
        //System.out.println(Arrays.toString(findRelativeRanks(nums)));
        //System.out.println(addToArrayForm(num,12));

        /*System.out.println(hammingWeight(00001000010001));*/
        /*System.out.println(new Object(){
            @Override
            public String toString() {
                return "hello java";
            }
        });*/


        //System.out.println(squareIsWhite("a1"));
        //System.out.println(Integer.parseInt((""+5461).replaceFirst("6","4")));
        //System.out.println(maximum69Number(9669));
        /*String a = new String("758435");
        System.out.println(a);*/
        /*System.out.println(Integer.parseInt((""+a).replaceFirst("6", "9")));*/
        /*int b = 410;
        double a = Math.sqrt(b);
        System.out.println(a);
        System.out.println((int) a);
        if (a == (int) a){
            System.out.println("It is perfact square");
        }
        else {
            System.out.println("Not");
        }*/
        //System.out.println(Arrays.asList(fizzBuzz(15)));
        /*long p = Long.MAX_VALUE;
        double d = Double.MAX_VALUE;
        int q = Integer.MAX_VALUE;
        byte b = Byte.MAX_VALUE;
        short s = Short.MAX_VALUE;*/

        /*System.out.println(canConstruct("aa","ab"));
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> q = new LinkedList<>();*/

        /*int [][]nums = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(Arrays.toString(getNoZeroIntegers(10402)));*/
        //System.out.println(Arrays.toString(constructRectangle(26)));

        //System.out.println(checkSelfD(21));
        /*long a = Integer.parseInt(num1);
        long b = Integer.parseInt(num2);*/
        /*BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger c = a.add(b);
        String s = String.valueOf(c);*/
        //System.out.println(Math.ceil(Math.sqrt(8)));
        /*int []nums = {12,23,36,46,62};
        System.out.println(slowestKey(nums,"spuda"));*/
        // System.out.println(divisorSubstrings(240,2));

        //System.out.println(firstUniqueChar("loveleetcode"));
        //System.out.println(Arrays.asList(pascalsTriangle(5)));
        //int []nums = {7,1,5,3,6,4};

        //System.out.println(maxProfit(nums));


        /*int []nums1 = {1,2,2,1};
        int []nums2 = {2,2};
        System.out.println(Arrays.toString(intersectionII(nums1, nums2)));*/

        /*int []count = new int[10];
        for (int item: nums){
            count[item]++;
        }
        System.out.println(Arrays.toString(count));*/
        //System.out.println(combinationSum3(3,9));

        /*System.out.println(Math.ceil(25.3));
        System.out.println(Math.floor(25.3));
        System.out.println(Math.round(5.5));*/
        /*double a = Math.random();
        System.out.println(a);
        System.out.println(Math.ceil(a*10));
        System.out.println(Math.ceil(10.1));*/


        //System.out.println(new Date());

        /*int []nums = {3,2,1,6};
        System.out.println(thirdMax( nums));*/

        /*int a = 123;
        String s = Integer.toString(a);
        char c;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            str.insert(0, c);
        }
        System.out.println(str);*/
        /*String num = "6777133339";
        System.out.println(largestGoodInteger(num));*/


        //System.out.println(pivotIndex(nums));
        /*int []nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));*/

       /* String s = "deeedbbcccbdaa";
        System.out.println(removerAllAdjacentDuplicate(s, 3));*/

        /*int [][]mat = {{1,2},{3,4}};
        System.out.println(Arrays.toString(matrixReshape(mat,1,4)));*/
        /*int []nums = {5,15,36,74,99,66,85,7,2,8,6};
        int max = nums[0];
        int second = nums[1];
        for (int i = 1; i < nums.length; i++) {
            if(max < nums[i]){
                max = nums[i];
            }
            max = Math.max(max,nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(max != nums[i]){
                second = Math.max(second,nums[i]);
            }
        }
        System.out.println(second);*/
        /*int r = 2, c = 4;
        int []copy = new int[r*c];
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                copy[(j*c)+i] = mat[i][j];
            }
        }
        System.out.println(Arrays.toString(copy));*/

        /*int []nums1 = {1,2,3};
        int[] count = new int[4];
        for(int item : nums1) {
            count[item]++;
        }
        System.out.println(Arrays.toString(count));*/

        //Stack<Integer> stack = new Stack<>();
        /*Queue<Integer> stack = new LinkedList<>();
        stack.add(4);
        stack.add(2);
        stack.add(3);
        stack.add(5);
        System.out.println(stack);
        System.out.println(stack.poll());*/

        /*int []nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        System.out.println(Arrays.toString(insertionOfTwoArray(nums1, nums2)));*/

        /*int []nums = {3,1,3,4,3};
        System.out.println(maxOperations(nums, 6));*/

        /*List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(65);
        list.add(32);
        list.add(51);
        list.add(54);
        int []copy = new int[list.size()];*/

        /*for (int i = 0; i<list.size(); i++){
            copy[i] = list.get(i);
        }*/
        //We copy in the array with the help of forEach and For loop
        /*int i = 0;
        for(int a: list){
            copy[i++] = a;
        }
        System.out.println(Arrays.toString(copy));*/

        /*int []nums1 = {1,2,2,1};
        int []nums2 = {2,2};
        System.out.println(Arrays.toString(intersectionOfTwoArray(nums1, nums2)));*/


        /*int []nums1 = {45,25,36,96};
        int []merge = new int[nums.length+nums1.length];
        for (int i = 0; i < nums.length; i++) {
            merge[i] = nums[i];
        }
        for (int j = nums.length, i = 0; j < merge.length; j++, i++) {
            merge[j] = nums1[i];
        }
        System.out.println(Arrays.toString(merge));*/


        /*String s = "ab#c";
        String t = "c";
        System.out.println(backSpaceStringCompare(s,t));*/


        /*int []arr = new int[nums.length + 1];
        for(int a: nums){
            arr[a] = a;
        }
        System.out.println(Arrays.toString(arr));*/
        /*System.out.println(Arrays.toString(sortedArrayByPriority(nums)));*/

        //System.out.println(Arrays.deepToString(matrix(3)));
        //m(5);

        /*int [][]matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(spiralMatrixOrder(matrix));*/
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
        System.out.println(longestCommonSubSequence(s1,s2));*/

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

        /*Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        String us = n.format(num);
        System.out.println(us);*/

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
       /* System.out.println(ncr(9,4));
        System.out.println(fourthPower(256));*/
        /*int []arr = {-1,0,1,2,-1,-4};
        threeSum(arr);*/
        // System.out.println(addDigit(387));

        /*int []arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));*/

        /*int []arr = {9,9,9,0,9};
        System.out.println(Arrays.toString(PlusOne(arr)));*/
        //System.out.println(latterCombination("2347"));
       /* int []a = {5,4,3,8,7};
        for (int i = 0; i < a.length / 2; i++) {
            int o = a.length -1 -i;
            int t = a[i];
            a[i] = a[o];
            a[o]= t;
        }
        System.out.println(Arrays.toString(a));*/

        /*System.out.println(reverseInteger(1534236469));
        System.out.println(Integer.MIN_VALUE);*/
        /*String s1 = "gaddar";
        String s2 = "rgadda";
        boolean a = is(s1,s2);
        out.printf(String.valueOf(a));*/

        /*out.println(singleNumber(arr));
        out.println(scoreOfParentheses("((()(()))"));
        out.println(stringPalindrome("gaddar"));
        out.println(isPerfectSquare(45));
        double sqrt = 5.12547;
        double a = Math.floor(sqrt);
        out.println(a);

        out.println(nthDigit(29));*/

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
        //System.out.println(Arrays.toString(words));
       /* int []num = {0,1,0,3,12};
        movesZero(num);
        System.out.println(Arrays.toString(num));*/
      /*  System.out.println(findDay(13,3,2022));
        int a = lengthOfLastWord("gaddar Kumar chaudhary village ");
        Calendar calendar = new GregorianCalendar();
        System.out.println(permutation("gaddar","raid"));*/
        /*Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int a = First_Unique(s);
        System.out.println(a);*/
        //System.out.println(isUnique("gaddar"));
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

        //System.out.println("Second");
        /*if (flag){
            int d = a*b;
            System.out.println(d);
        }*/
        //System.out.println(a(-25));
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
        //System.out.println(" "+fibo(5));

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
        /*int num1 = 21325436;
        // Todo output infinite in java
        double d = Math.floor(Math.log10(num1) +1);
        System.out.println("Output is "+d);*/
        /*File f = new File("C:\\Users\\Gaddar Kr Chaudhary\\OneDrive\\Desktop\\task.txt");
        if (f.exists()){
            System.out.println("File name: "+f.getName());
            System.out.println("file path: "+f.getAbsolutePath());
            System.out.println("file size: "+f.length());
            System.out.println("Write: "+f.canWrite());
            System.out.println("Read: "+f.canRead());
        }
        else {
            System.out.println("File does not exists ");
        }*/

        /*try {
            FileWriter fw = new FileWriter("C:\\Users\\Gaddar Kr Chaudhary\\OneDrive\\Desktop\\task.txt");
            try{
                fw.write("Gaddar Kumar chaudhary \nVillage: Malahi Tola,\nPost: Dhobini,\nPS: lauriya");
            }finally {
                fw.close();
            }
            System.out.println("successfully wrote your in file");
        }
        catch (IOException e) {
            e.getStackTrace();
            System.out.println("Error");
        }*/
        //Todo find the how many duplicates number in hashmap
        /*
         * HashMap<Integer, Integer> hash = new HashMap<>();
         * for(int i = 0; i < size; i++){
         *   hash.put(arr[i], hash.getOrDefault(arr[i], 0)+1);
         *   max = Math.max(max, hash.get(arr[i]);
         * }
         * */
        //Todo check data type in java --> System.out.println(((Object) <variable_Name>).getClass().getSimpleName());
    }
}
