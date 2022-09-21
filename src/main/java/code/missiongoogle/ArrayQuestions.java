package code.missiongoogle;

import java.awt.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;




/*Multilevel inheritance */

public class ArrayQuestions {

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(double a, int b) {
        return (int) a + b;
    }

    public static int Search(int intArray[], int key, int lenght) {
        for (int i = 0; i < lenght; i++) {
            if (intArray[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /*static  {
        System.out.println("Hello");
    }*/

    public static void fibo(int num) {
        int n1 = 0, n2 = 1, n3;
        if (num > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" " + n3);
            fibo(num - 1);
        }
    }

    private static void isPelindrom(int num) {
        int rem, tem = num;
        int sum = 0;
        while (num > 0) {
            rem = num % 10;
            sum = sum * 10 + rem;
            num /= 10;
        }
        if (tem == sum) System.out.println("yes");
        else System.out.println("No");
    }

    public static void f(int num) {
        if (num <= 1) {
            return;
        }
//        return f(num - 1) + f(num - 2);
        int a = 0, b = 1;
        System.out.print(" " + a);
        for (int i = 1; i < num; i++) {
            System.out.print(" " + b);
            int c = a + b;
            a = b;
            b = c;
        }
    }

    public static int findFibbo(int num) {
        if (num == 0 || num == 1) return num;
        return findFibbo(num - 1) + findFibbo(num - 2);
    }

    public static void honnoiTower(int num, char from, char top, char des) {
        if (num == 1) {
            System.out.printf("Move disk 1 from %c to %c\n", from, top);
            return;
        }
        honnoiTower(num - 1, from, des, top);
        System.out.printf("Move disk %d from %c to %c\n", num, from, top);
        honnoiTower(num - 1, des, top, from);
    }

    public static int findPower(int num, int po) {
        if (po == 0) return 1;
        return num * findPower(num, po - 1);
    }

    public static void merge1(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;

            merge1(arr, l, mid);
            merge1(arr, mid + 1, h);
            mergeSo(arr, l, mid, h);
        }
    }

    private static void mergeSo(int[] arr, int l, int mid, int h) {
        int n1 = (mid - l + 1);
        int n2 = (h - mid);
        int i, j, k;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (j = 0; j < n2; j++) {
            R[j] = arr[mid + j + 1];
        }

        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
    }

    public static void opp(String a, int l) {
        if (l == 0) {
            System.out.println(a.charAt(l));
            return;
        }
        System.out.println(a.charAt(l));
        opp(a, l - 1);
    }

    static int fun1(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return fun1(a + a, b / 2);

        return fun1(a + a, b / 2) + a;
    }

    public static void luckyNumber(long num) {
        int a = 0;
        while (num != 0) {
            if (num % 10 == 4 || num % 10 == 7) {
                a++;
            }
            num = num / 10;
        }
        if (a == 7 || a == 4) {
            System.out.println("YES");
        } else
            System.out.println("No");
    }

    public static int sumA(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += arr[i];
        }
        return sum;
    }

    public static void subArray(int[] arr) {
        int max = arr[0];
        int cur = max;
        for (int i = 1; i < arr.length; i++) {
            cur = Math.max(arr[i] + cur, arr[i]);
            max = Math.max(cur, max);
        }
        System.out.println(max);
    }

    public static void kadens(int[] arr) {
        int max = arr[0];
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur = cur + arr[i];
            if (cur > max) {
                max = cur;
            }
            if (cur < 0) {
                cur = 0;
            }
            if (arr[i] > cur) {
                cur = arr[i];
            }
        }
        System.out.println("Maximum: " + max);
    }

    String a = "Black";
    /*static class ineer extends ArrayQuestions{
        String a = "Blue";
        public void show(){
            System.out.println(a);
            System.out.println(super.a);
        }
    }*/

    public static void makePattern(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (j >= 6 - i)
                    System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static void makePattern1(int num) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i >= j) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static <T> Object[] convertLinkedListToArray(LinkedList<T> linkedList) {
        Object[] array = linkedList.toArray();
        return array;
    }

    int roll;
    String name;
    float salery;

    ArrayQuestions(int roll, String name, float salery) {
        this.roll = roll;
        this.name = name;
        this.salery = salery;
    }

    void show() {
        System.out.println(roll + " " + name + " " + salery);
    }

    public static void main(String[] args) {


        /*DemoClass demo = new DemoClass();
        DemoClass.BinaryTreeBST p = new BinaryTreeBST();
        p.buildTree(arr);*/
        /*HashSet<Integer> set = new HashSet<>();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        set.add(1000000000);*/

        /*LinkedList<String> linkedList = new LinkedList<String>();

        // Adding elements to the linked list
        linkedList.add("G");
        linkedList.add("e");
        linkedList.add("e");
        linkedList.add("k");
        linkedList.add("s");
        Object[] objArray = convertLinkedListToArray(linkedList);
        String[] array = Arrays.copyOf(objArray, objArray.length, String[].class);
        System.out.println("Array: "+ Arrays.toString(array));*/

        /* makePattern1(2);*/
        /*ineer ineer = new ineer();
        ineer.show();*/
        /*ArrayQuestions a = new ArrayQuestions();
        System.out.println(a.sum(10,20));
        System.out.println(a.sum(10,20,40));
        System.out.println(a.sum(10.3,20));*/
        /*HashMap<Character,Integer> hashMap = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        String s = bf.readLine();
        int result = hashMap.get(s.charAt(s.length()-1));
        for (int i = s.length()-2; i >= 0; i--) {
            if (hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))){
                result -= hashMap.get(s.charAt(i));
            }
            else result += hashMap.get(s.charAt(i));
        }
        System.out.println(result);*/
        /*int []arr = {1,2,3,0,0,0};
        int[] arr1 = {2,5,6};
        int m = 3, n= 3;*/


        /*for(int i = 0; i<n; i++){
            arr[m + i] = arr1[i];
        }
        System.out.print(" "+Arrays.toString(arr));*/
        /*System.out.println();
        for (int i = 0; i < copy.length; i++) {
            for (int j = i+1; j < copy.length; j++) {
                if (copy[i] > copy[j]){
                    int tem = copy[i];
                    copy[i] = copy[j];
                    copy[j] = tem;
                }
            }
        }
        System.out.println(Arrays.toString(copy));*/

//        kadens(arr);
        /*int []num1 = {1,2,3,0,0,0};
        int []num2 = {2,5,6};
        merge(num1,3,num2,3);*/
//        System.out.println(sumA(arr));
        /*String []cu = {"flower","flow","flight"};
        String a = cu[0];
        for (int i = 0; i < cu.length; i++) {
            while (cu[i].indexOf(a) != 0){
                a = a.substring(0, a.length()-1);
            }
            System.out.println(a);
        }*/
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter the  number: ");
        long num = sc.nextLong();
        luckyNumber(num);*/
//        int [] intArray= new int[]{5,7,2,9,6};
        /*String a = "abcd";
            opp(a,3);*/
//        System.out.println(fun1(4,5));
        /*System.out.println("After sorting array");
        merge1(intArray,0, intArray.length-1);
        printArray(intArray);*/



        /*Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println("Enter the number: ");*/
//        int num = sc.nextInt();
//        Scanner sc = new Scanner(System.in);
        /*int num = sc.nextInt();
        int power = sc.nextInt();
       int a = findPower(num, power);
        System.out.println(a);*/

//        honnoiTower(num, 'A', 'C', 'B');
        //Todo Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        int [] fibo= new int[]{0,1,1,2,3,5,8,13};
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        /*System.out.println("Enter the number");
        int num = sc.nextInt();
        f(num);*/

       /*int num = sc.nextInt();
        int a = findFibbo(num);
        System.out.println(a);
        for (int i = 0; i <= num ; i++) {
            System.out.print(" \n"+findFibbo(i));
        }*/


//        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(11,20,44,23,45,22,12,89,45,34));

//        System.out.println(" "+linkedList);
//        isPelindrom(num);*/
//        System.out.println(" "+f(num));
        /*String original, reverse = ""; // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome");
        original = in.nextLine();
        int length = original.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse))
            System.out.println("Entered string/number is a palindrome.");
        else
            System.out.println("Entered string/number isn't a palindrome.");*/

        /*String original;
        String reverse = "";
        System.out.println("Enter number/ string: ");
        original = sc.nextLine();
        int l = original.length();
        for (int i = l-1; i >= 0 ; i--) {
            reverse = reverse + original.charAt(i);
        }
        if (original.equals(reverse)) System.out.println("yes");
        else System.out.println("No");*/


        /*int num = sc.nextInt();
        System.out.println("Fibonacci series");
        System.out.print("0 1 ");
        fibo(num - 2);*/
        /*System.out.println("Enter the power of the number");
        int p = sc.nextInt();
        System.out.println(Math.pow(num,p));*/
//        System.out.println("Gaddar");
        /*Character charecter;
        String str;
        System.out.println("Input charecter: ");*/
//        charecter = sc.next().charAt(5);
//        System.out.println("Input charecter is : "+charecter);
//        System.out.println("Enter the String: ");
//        str = sc.nextLine();
//        System.out.println("Input String is: "+str);
        /*int a = Search(intArray,15, intArray.length);
        if (a == -1){
            System.out.println("Key is present in the array");
        }
        else {
            System.out.println(a+1);
        }*/
        /*mergeSort(intArray,0,intArray.length -1);
        System.out.println("After sorted array");

        System.out.println(Arrays.toString(intArray));*/



        /*String [] stringArray = new String[]{"Sumit","Gaddar","Bhulan","Ramu"};*/

//        sum(2583);
        /*Array-Reversal*/
        //mySolutionReverseArray(intArray);
        //gfgSolutionWithBetterLogic(intArray);
        //gfgUsingCollection(intArray);

        /*Array Sort Check*/
        // System.out.println(mySolutionSortCheck(true,intArray));

        //TODO: check with recursive method(GFG solution)


        /*Find Maximum in array*/
        // System.out.println(String.valueOf(mySolutionMaximumInArray(intArray)));

        //  AshuArrays.reverseArray(intArray);
        //AshuArrays.sortCheck(intArray);

        /*Leet-code Problems*/
        /*Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
        * Example 1:

        Input: nums = [1,2,3,1], k = 3
        Output: true
        Example 2:

        Input: nums = [1,0,1,1], k = 1
        Output: true
        Example 3:

        Input: nums = [1,2,3,1,2,3], k = 2
        Output: false


        Constraints:

        1 <= nums.length <= 105
        -109 <= nums[i] <= 109
        0 <= k <= 105*/

        //System.out.println(containsDuplicate(1,intArray));



        /**/
//        pairSum(intArray,9);

//        System.out.println(fun2("Geeks"));
//        kthSmallest(intArray,intArray.length,15);
//        System.out.println(print(12));
//        print(12);
        /*1+2+3+4a+5*/
//        System.out.println(sumOfn(4));
//        System.out.println(sumOfDigitR(12434));
//        sum(023);

        /*int ma = 35;
        int in = 67;
        int sta = recurse(ma, in);
        System.out.println("static = " + sta + "tic");*/

        /*int ma = 35;
        int in = 67;
        int sta = recurse(ma, in);
        System.out.println("static = " + sta + "tic");*/

//        int a = 4;
//        fun(a);
//        System.out.println(" " + fun("SUMIT"));
//        abc("xyz");
//        fun(3);
        /*square(intArray);*/

//        duplicateArray(intArray);


//        findPrevious(fibo, 13);

        /*int []nums = {3,5,8,1,2,4,7,6};
        mergeSort(nums,0,arr.length-1);
        printArrays(nums, nums.length);*/
    }

    private static void findPrevious(int[] fibo, int num) {
        double k, p, num1;
        k = 1.0 + Math.sqrt(5);
        p = Math.round((2 * num) / (double) k);
        System.out.println(p);
    }

    /*Merge sort*/
    public static void printArrays(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] M = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[l + i];
        }
        for (int j = 0; j < n2; j++) {
            M[j] = array[m + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = M[j++];
            }
        }
        while (i < n1) {
            array[k++] = L[i++];
        }

        while (j < n2) {
            array[k++] = M[j++];
        }

    }

    /*Merge sort*/
    public static void mergeSort(int array[], int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }


    /*Remove Duplicates from Sorted Array*/
    private static void duplicateArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {

        }
    }


    private static void square(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (i % 2 == 0) {
                intArray[i] = intArray[i] * intArray[i];
            }
        }
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(" " + intArray[i]);
        }
    }


    static void fun(int n) {
        if (n > 0) {
            fun(n - 1);
            System.out.print(n + " ");
            fun(n - 1);
        }
    }

    static void abc(String s) {
        if (s.length() == 0)
            return;
        abc(s.substring(1));
        abc(s.substring(1));
        System.out.print(" " + s.charAt(0));
    }

    static String fun(String x) {
        return x.substring(1, 3);
    }

    /*static void fun(int x)
    {
        if(x > 0)
        {
            fun(--x);
            System.out.print(x + " ");
            fun(++x);
        }
    }*/


    public static int recurse(int pub, int lic) {
        if (pub % 13 == 0) {
            return pub + lic;
        }
        return recurse(pub++, lic / 2);
    }

    /*public static int recurse(int pub, int lic)
    {
        if (pub % 13 == 0)
        {
            return pub + lic;
        }
        return recurse(++pub, lic / 2);
    }*/

    private static void sum(double num) {

        double rem, sum = 0;
        while (num != 0) {
            rem = num % 10;
            sum = sum + rem;
            num = num / 10;
        }
        System.out.println(sum);
    }


    public static int sumOfDigitR(int num) {

        return num == 0 ? 0 : num % 10 + sumOfDigitR(num / 10);
    }

    public static int sumOfn(int num) {
        int sum = 0;
        if (num > 0) {
            return 0;
        } else
            return num + sumOfn(num - 1);
    }


    public static void print(int num) {
        if (num == 0) {
            return;
        }
        System.out.print(num % 2);
        print(num / 2);
    }


    static StringBuilder fun2(String str) {
        StringBuilder s1 = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            s1.append(str.charAt(i));
        }

        return s1;
    }


    public static int kthSmallest(int[] arr, int n, int k) {
        int temp = -1;
        int counter = 1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ". " + arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (temp < arr[i]) {
                temp = arr[i];
                if (k == counter) {
                    return temp;
                }
                counter++;
            }
        }
        return 0;
    }
//    static int kthSmallestWithRecursion(){
//        return 0;
//    }

    private static void pairSum(int[] intArray, int target) {

        /*2,7,11,15*/
        String indexes = null;
        HashMap<Integer, Integer> indexVal = new HashMap<>();
        for (int i = 0; i < intArray.length; i++) {
            int diff = target - intArray[i];
            if (indexVal.containsKey(diff)) {
                indexes = "first: " + indexVal.get(diff) + " second:" + i;
                break;
            }
            indexVal.put(intArray[i], i);
        }
        System.out.println(indexes);
    }


    private static boolean containsDuplicate(int k, int[] intArray) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : intArray) {
            if (map.containsKey(num) && isIndexInRange(i, map.get(num), k)) {
                return true;
            }
            map.put(num, i);
            i++;
        }
        return false;

    }


    private static boolean isIndexInRange(int curr_index, int map_index, int k) {
        int x = Math.abs(curr_index - map_index);
        return x <= k ? true : false;
    }

    private static int mySolutionMaximumInArray(int[] intArray) {
        if (intArray.length == 1) {
            return intArray[0];
        } else {
            int maxSoFar = -1;
            for (int i = 0; i < intArray.length; i++) {
                System.out.println("index: " + i);
                if (intArray[i] > maxSoFar)
                    maxSoFar = intArray[i];
            }
            return maxSoFar;
        }
    }

    private static boolean mySolutionSortCheck(boolean isAscending, int[] arr) {
        boolean isSorted = true;
        if (arr.length == 0) {
            return false;
        } else {
            if (isAscending) {
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i - 1] > arr[i])
                        isSorted = false;
                }
            } else {
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i - 1] < arr[i])
                        isSorted = false;
                }
            }
        }
        return isSorted;
    }

    private static void gfgUsingCollection(int[] intArray) {
        Collections.reverse(Arrays.asList(intArray));
        System.out.println(Arrays.asList(intArray));
    }
   /* private static void gfgSolutionWithBetterLogic(int[] intArray) {
        int n= intArray.length;
        int t;*/
    /*For input: 12,-7,-8,4,-1,-6,
     * i will be > 0,1,2,3,4,5
     * n will be > 5,4,3,2,1,0
     * If we keep subtracting  i from n inside loop we  will get the n's sequence
     * run the loop by half of the size and remove the start&end variable
     *
     *
     *  */

      /*  for (int i = 0; i < n / 2; i++) {
            t = intArray[i];
            intArray[i] = intArray[n - i - 1];
            intArray[n - i - 1] = t;
        }
        for (int val : intArray){
            System.out.print(val+",");
        }
    }*/

    /*static void fun(int x)
    {

        if(x > 0)
        {
            System.out.println("Current x = "+ x);
            fun(--x);
            System.out.println(x + " ");
            fun(--x);
        }
    }*/

    private static void mySolutionReverseArray(int[] intArray) {
        int start = 0;
        int end = intArray.length - 1;
        for (int i = 0; i < end; i++) {
            if (start == end) {
                break;
            } else {
                try {
                    intArray[start] = intArray[start] * intArray[end];
//                     tem = a * b
//                    b = a / b
//                    tem = a/b
                    intArray[end] = intArray[start] / intArray[end];
                    intArray[start] = intArray[start] / intArray[end];

                } catch (ArithmeticException e) {
                    /*int temp = intArray[start];
                    intArray[start]=intArray[end];
                    intArray[end]= temp;*/
                }

                System.out.println("start> " + start + " end>" + end);
                start++;
                end--;
            }
        }
        for (int val : intArray) {
            System.out.print(val + ",");
        }
        /*Quick sort */
    }

}