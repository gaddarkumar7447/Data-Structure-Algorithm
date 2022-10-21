package code.missiongoogle;

import java.awt.image.AreaAveragingScaleFilter;
import java.math.BigInteger;
import java.sql.Struct;
import java.sql.Time;
import java.util.*;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class GFG {
    private static ArrayList<Integer> duplicates(int[] arr) {
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

    /*https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1?page=1&sortBy=submissions*/
    /*Try to solve another way*/
    private static int minJumps(int[] arr) {
        if (arr.length == 1) return 0;
        if (arr[0] == 0) return -1;
        int des = 0;
        int pos = 0;
        int jump = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            des = Math.max(des, arr[i] + i);
            if (pos == i) {
                pos = des;
                jump++;
            }
            if (pos == i) return -1;
        }
        return jump;
    }

    private static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        /*int []first = new int[k];
        int []sec = new int[arr.size() - k];
        for (int i = 0; i < k; i++) {
            first[i] = arr.get(i);
        }
        int index = 0;
        for (int i = k; i < arr.size(); i++) {
            sec[index++] = arr.get(i);
        }
        for (int i = 0; i < first.length/2; i++) {
            int tem = first[i];
            first[i] = first[first.length - i - 1];
            first[first.length - i - 1] = tem;
        }
        for (int i = 0; i < sec.length/2; i++) {
            int tem1 = sec[i];
            sec[i] = sec[sec.length - i - 1];
            sec[sec.length - i - 1] = tem1;
        }

        System.out.println(Arrays.toString(first));
        System.out.println(Arrays.toString(sec));
        int [] fi = new int[arr.size()];
        System.arraycopy(first, 0, fi, 0, k);
        int ind = 0;
        for (int i = k; i < fi.length; i++) {
            fi[k] = sec[ind];
            ind++;
            k++;
        }
        System.out.println(Arrays.toString(fi));
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for(int i : fi){
            arrayList1.add(i);
        }
        System.out.println(arrayList1);*/
        for (int i = 0; i < n; i = i + k) {
            int l = i;
            int r = i + k - 1;
            if (r > n - 1) r = n - 1;
            while (l < r) {
                Collections.swap(arr, l, r);
                l++;
                r--;
            }
        }
    }

    private static void sortMethod(int[] arr) {
        Arrays.sort(arr);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum == s) {
                list.add(k + 1);
                list.add(i + 1);
                break;
            }
            if (sum > s) {
                i = k;
                k++;
                sum = 0;
            }
        }
        if (list.size() == 0) {
            list.add(-1);
        }
        return list;
    }

    public int minSum(int a[], int b[], int n) {
        int res = 0;
        int idx1 = 0, idx2 = 0;
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min1 > a[i]) {
                min1 = a[i];
                idx1 = i;
            }
        }
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min2 > b[i]) {
                min2 = b[i];
                idx2 = i;
            }
        }

        if (idx1 != idx2) {
            res = min1 + min2;
        } else {
            int min3 = Integer.MAX_VALUE;
            int min4 = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (min3 > a[i] && i != idx1) {
                    min3 = a[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if (min4 > b[i] && i != idx2) {
                    min4 = b[i];
                }
            }
            res = Math.min(min1 + min4, min2 + min3);
        }
        return res;
    }

    private static String replaceAll(String str, String oldW, String newW) {
        StringBuilder s = new StringBuilder();
        s.append(str.replaceAll(oldW, newW));
        return s.toString();
    }

    private static int maximizeSum(int[] arr, int n) {
        int max = 0;
        int i = n - 1;
        Stack<Integer> stk = new Stack<>();
        while (i >= 0) {
            if (stk.isEmpty() || stk.peek() == arr[i]) {
                stk.push(arr[i]);
            } else if (stk.peek() == arr[i] + 1) {
                max += stk.pop();
            } else stk.push(arr[i]);
            i--;
        }
        while (!stk.isEmpty()) {
            max += stk.pop();
        }
        return max;
    }

    /*https://practice.geeksforgeeks.org/problems/maximum-subset-xor/1?page=1&difficulty[]=2&curated[]=1&sortBy=submissions*/
    public static int maxSubarrayXOR(int arr[], int N) {
        if (N == 0) return 0;
        int num = 0;
        while (true) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                if (max < arr[i]) max = arr[i];
            }
            if (max == 0) return num;
            num = Math.max(num, num ^ max);
            for (int i = 0; i < N; i++) {
                arr[i] = Math.min(arr[i], arr[i] ^ max);
            }
        }
    }

    private String multiplyStrings(String s1, String s2) {
        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = n1.multiply(new BigInteger(s2));
        return String.valueOf(n2);
    }

    private static int isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (end >= start) {
            if (s.charAt(start) != s.charAt(end)) return 0;
            start++;
            end--;
        }
        return 1;
    }

    public boolean isValid(String s) {
        char ch[] = s.toCharArray();
        if (ch[s.length() - 1] == '.')
            return false;
        String[] arrOfStr = s.split("[.]");
        boolean check = true;
        int len = arrOfStr.length;
        len = len - 1;
        if (len != 3)
            return false;
        while (len >= 0 && check == true) {
            if (arrOfStr[len].length() == 0)
                return false;
            check = find(arrOfStr[len]);
            if (check == false)
                break;
            len--;
        }

        return check;
    }

    public boolean find(String s) {
        int x;
        x = Integer.parseInt(s);
        int len = s.length() - 1;
        if (len < 0)
            return false;
        if (len == 0)
            return true;
        int temp = (int) (x / (Math.pow(10, len)));
        if (temp == 0)
            return false;
        else {
            if (x >= 0 && x <= 255)
                return true;
            return false;
        }
    }

    private static String reverseWords(String s) {
        String[] str = s.split("\\.");
        if (str.length == 0) return s;
        StringBuilder str1 = new StringBuilder();
        for (int i = str.length - 1; i > 0; i--) {
            str1.append(str[i]).append(".");
            if (i == 1) {
                str1.append(str[0]);
            }
        }
        if (str.length == 1) str1.append(s);
        return str1.toString();
    }

    public static boolean isAnagram(String a, String b) {
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    int atoi(String str) {
        try {
            return Integer.parseInt(str);
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public static boolean isRotated(String str1, String str2) {
        String s1 = str1.substring(2) + str1.substring(0, 2);
        String s2 = str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2);
        return s1.equals(str2) || s2.equals(str2);
    }

    static boolean ispar(String s) {
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

    public static String reverseWord(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }

    int strstr(String s, String x) {
        int a = s.indexOf(x);
        return a;
    }

    private static boolean areIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        Map<Character, Character> set1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!set1.containsKey(str1.charAt(i)) && !set1.containsValue(str2.charAt(i)))
                set1.put(str1.charAt(i), str2.charAt(i));
            else if (!set1.containsKey(str1.charAt(i)))
                set1.put(str1.charAt(i), '0');
        }

        for (int i = 0; i < str1.length(); i++) {
            if (set1.get(str1.charAt(i)) != str2.charAt(i))
                return false;
        }
        return true;
    }

    private static long calcSum(int[] inpArr, int i, int j) {
        if (inpArr[i] < 0)
            return 0;
        long sum = 0;
        for (; i < j; i++) {
            sum += inpArr[i];
            if (sum < 0)
                return 0;
        }
        return sum;
    }

    private static long solve(int[] inpArr, int n) {
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                ans += calcSum(inpArr, i, j);
            }
        }
        return ans;
    }

    private static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i - 1);
                temp.add(i);
                results.add(temp);
            }
        }
        return results;
    }

    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ans = 1;
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > dep[j]) {
                j++;
            } else {
                ans++;
            }
        }
        return ans;

    }

    private static String FirstNonRepeating(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                chars[i + 1] = '#';
                i++;
            }
        }
        StringBuilder str = new StringBuilder();
        for (char a : chars) {
            str.append(a);
        }
        return str.toString();
    }

    public static int minIndexChar(String str, String patt) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (str.charAt(i) == str.charAt(j)) return j;
            }
        }
        return -1;
    }

    static String removeDups(String S) {
        String s = "";
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < S.length(); i++) {
            if (!set.contains(S.charAt(i)))
                s = s + S.charAt(i);
            set.add(S.charAt(i));
        }

        return s;
    }

    /*static {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
    }*/

    /*Wrong Solution that is make*/
    /*public static ArrayList<Integer> _findLeastGreater(int n, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if (cur < arr[j]) {
                    min = Math.min(cur, arr[j]);
                    list.add(min);
                    break;
                }else {
                    list.add(-1);
                    j = arr.length;
                }
            }
        }
        list.add(-1);
        return list;
    }

    private static int sorted(int num, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int []arr = new int[set.size()];
        int index = 0;
        for (int a : set){
            arr[index++] = a;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num){
                return arr[i + 1];
            }
        }
        return -1;
    }*/

    private static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = n - 1; i >= 0; i--) {
            int elem = arr[i];
            set.add(elem);
            if (set.higher(elem) == null) list.add(-1);
            else list.add(set.higher(elem));
        }
        Collections.reverse(list);
        return list;
    }

    private static void booleanMatrix(int matrix[][]) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] row = new int[r];
        int[] col = new int[c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            if (row[i] == 1)
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = 1;
                }
        }
        for (int i = 0; i < c; i++) {
            if (col[i] == 1)
                for (int j = 0; j < r; j++) {
                    matrix[j][i] = 1;
                }
        }

        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
        System.out.println(Arrays.deepToString(matrix));
    }

    private static long trappingWater(int[] arr, int n) {
        long sum = 0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
        }
        int max1 = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            max1 = Math.max(max1, arr[i]);
            right[i] = max1;
        }

        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(left[i], right[i]) - arr[i];
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return sum;
    }

    public static int minSwaps(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (copy[i] != nums[i]) count++;
        }
        return count / 2;
    }

    private static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] nums = new int[k];
        if (arr.length == 1) list.add(arr[0]);
        for (int i = 0; i < arr.length - k + 1; i++) {
            nums = Arrays.copyOfRange(arr, i, i + k);
            list.add(minArray(nums));
        }
        return list;
    }

    private static int minArray(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }

    private static ArrayList<Integer> downwardDiagonal(int n, int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int j = 0; j < matrix[0].length; j++) {
            int k = j;
            for (int i = 0; k >= 0; i++, k--) {
                ans.add(matrix[i][k]);
            }
        }
        for (int i = 1; i < n; i++) {
            int k = i;
            for (int j = n - 1; k < n; k++, j--) {
                ans.add(matrix[k][j]);
            }
        }
        return ans;
    }

    int getMinDiff(int[] arr, int n, int k) {
        int[] nums = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > k) {
                nums[index++] = arr[i] - k;
            } else {
                nums[index++] = arr[i] + k;
            }
        }
        Arrays.sort(nums);
        return nums[nums.length - 1] - nums[0];
    }

    public long toh(int num, int from, int top, int des) {
        if (num == 1) {
            System.out.printf("move disk %d from rod %d to rod %d", num, from, top);
            return num;
        }
        toh(num - 1, from, des, top);
        System.out.printf("move disk %d from rod %d to rod %d", num, from, top);
        toh(num - 1, des, top, from);
        return (int) Math.pow(2, num) - 1;
    }

    private static int getPairsCount(int[] arr, int n, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (map.containsKey(k - j)) {
                count += map.get(k - j);
            }
            if (map.containsKey(j)) {
                map.put(j, map.get(j + 1));
            } else map.put(j, 1);
        }

        return count;
    }

    public static int countSetBits(int n) {
        if (n <= 1) return n;
        double k = Math.floor(Math.log(n));
        return (int) (k * Math.pow(2, k - 1) + (n - Math.pow(2, k) + 1) + countSetBits((int) (n - Math.pow(2, k))));
    }

    public static int[] topK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println(map);
        int[] arr = new int[k];
        List<Integer> list = new ArrayList<>(map.keySet());
        System.out.println(list);
        list.sort((a, b) -> map.get(b) - map.get(a));
        System.out.println(list);
        for (int i = 0; i < k; i++) arr[i] = list.get(i);
        return arr;
    }


    private static void rearrange(long[] arr, int n) {
        int max = n - 1;
        int min = 0;
        long[] temp = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = temp[max];
                max--;
            } else {
                arr[i] = temp[min];
                min++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void merge(long[] arr1, long[] arr2, int n, int m) {
        /*long []arr = new long[arr1.length + arr2.length];
        int cont = arr1.length;
        int index = 0;
        for (long i : arr1){
            arr[index++] = i;
        }
        for (long i : arr2) {
            arr[cont++] = i;
        }
        System.out.println(Arrays.toString(arr));*/
        int decArr1 = n - 1;
        int incArr2 = 0;
        while (decArr1 >= 0 && incArr2 < m) {
            if (arr1[decArr1] > arr2[incArr2]) {
                long temp = arr1[decArr1];
                arr1[decArr1] = arr2[incArr2];
                arr2[incArr2] = temp;
                decArr1--;
                incArr2++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    private static long floorSqrt(long x) {
        /*return (long) Math.sqrt(x);*/
        long ans = 0;
        for (int i = 1; (long) i * i <= x; i++) {
            ans = i;
        }
        return ans;
    }

    private static int nCr(int n, int r) {
        /*return fact(n) / (fact(r) * (fact(n - r)));*/
        int mod = 1000000007;
        if (r > n) {
            return 0;
        } else if (r == n) {
            return 1;
        }
        int[][] dp = new int[n + 1][r + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < r + 1; j++) {
                if (i == j || j == 0 || i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % mod;
                }
            }
        }
        return dp[n][r];
    }

    private static int fact(int n) {
        if (n == 1) return 1;
        return n * fact(n - 1);
    }

    public int getSum(int X, int Y, int Z) {
        int mod = 1000000007;
        long[][][] exactsum = new long[X + 1][Y + 1][Z + 1];
        long[][][] exactnum = new long[X + 1][Y + 1][Z + 1];
        for (int i = 0; i <= X; i++) {
            for (int j = 0; j <= Y; j++) {
                for (int k = 0; k <= Z; k++) {
                    exactsum[i][j][k] = 0;
                    exactnum[i][j][k] = 0;
                }
            }
        }
        long ans = 0L;
        exactnum[0][0][0] = 1L;
        for (int i = 0; i <= X; ++i) {
            for (int j = 0; j <= Y; ++j) {
                for (int k = 0; k <= Z; ++k) {
                    if (i > 0) {
                        exactsum[i][j][k] += (exactsum[i - 1][j][k] * 10 + 4 * exactnum[i - 1][j][k]) % mod;
                        exactnum[i][j][k] += exactnum[i - 1][j][k] % mod;
                    }
                    if (j > 0) {
                        exactsum[i][j][k] += (exactsum[i][j - 1][k] * 10 + 5 * exactnum[i][j - 1][k]) % mod;
                        exactnum[i][j][k] += exactnum[i][j - 1][k] % mod;
                    }
                    if (k > 0) {
                        exactsum[i][j][k] += (exactsum[i][j][k - 1] * 10 + 6 * exactnum[i][j][k - 1]) % mod;
                        exactnum[i][j][k] += exactnum[i][j][k - 1] % mod;
                    }
                    ans += exactsum[i][j][k] % mod;
                    ans %= mod;
                }
            }
        }
        return (int) ans;
    }

    public static int getMinimumTrips(List<Integer> weights) {
        int count = 0;
        int max = 0 ;
        int []arr = new int[weights.size()];
        int index = 0;
        for (int i : weights){
            arr[index++] = i;
        }
        Arrays.sort(arr);
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int i : arr){
            hashMap1.put(i, hashMap1.getOrDefault(i, 0) + 1);
        }
        if (hashMap1.containsValue(1)) return -1;
        return hashMap1.size();
    }


    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(197));
        System.out.println(getMinimumTrips(list));
        /*int n = 2;
        long arr1[] = {10, 12};
        int m = 3;
        long arr2[] = {5, 18, 20};
        merge(arr1, arr2, n, m);*/
        /*int N = 9, K = 3;
        int[] nums = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(max_of_subarrays(nums, N, K));*/

        /*int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        int [][]matrix =   {{ 1, 0, 0},
                            { 1, 0, 0},
                            { 1, 0, 0},
                            { 0, 0, 0}};
        booleanMatrix(matrix);*/


        /*int arr[] = {900, 940, 950, 1100, 1500, 1800},
        dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, arr.length));*/
        /*Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int test = 1; test <= testcase; test++) {
            int n = sc.nextInt();
            int[] inpArr = new int[n];
            for (int i = 0; i < n; i++)
                inpArr[i] = sc.nextInt();
            long ans = solve(inpArr, n);
            System.out.println("Case #" + test + ": " + ans);
        }*/

        /*String S = "xxforxx xx for xx", oldW = "xx" ,newW = "Geeks";
        System.out.println(replaceAll(S,oldW, newW));*/
        /*ArrayList<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
         *//*reverseInGroups(arrayList, arrayList.size(), 3);*//*
        Collections.swap(arrayList, 0, 2);
        System.out.println(arrayList);*/
    }
}
