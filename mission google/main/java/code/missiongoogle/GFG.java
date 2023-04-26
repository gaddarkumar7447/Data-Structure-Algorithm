package code.missiongoogle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

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
        int max = 0;
        int[] arr = new int[weights.size()];
        int index = 0;
        for (int i : weights) {
            arr[index++] = i;
        }
        Arrays.sort(arr);
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int i : arr) {
            hashMap1.put(i, hashMap1.getOrDefault(i, 0) + 1);
        }
        if (hashMap1.containsValue(1)) return -1;
        return hashMap1.size();
    }

    public static int[] reverseSpiral(int R, int C, int[][] matrix) {
        int[] nums = new int[matrix.length * matrix[0].length];
        int left = 0, right = matrix.length - 1, high = 0, low = matrix[0].length - 1, dir = 0;
        int index = 0;
        while (left <= right && high <= low) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    nums[index++] = matrix[high][i];
                }
                dir = 1;
                high++;
            } else if (dir == 1) {
                for (int i = high; i <= low; i++) {
                    nums[index++] = matrix[i][right];
                }
                right--;
                dir = 2;
            } else if (dir == 2) {
                for (int i = left; i >= right; i--) {
                    nums[index++] = matrix[low][i];
                }
                low--;
                dir = 3;
            } else {
                for (int i = low; i >= high; i--) {
                    nums[index++] = matrix[i][left];
                }
                left++;
                dir = 0;
            }
        }
        Arrays.sort(nums);
        return nums;
    }

    public static List<Integer> spiralMatrixOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int[] nums = new int[matrix.length * matrix[0].length];
        int index = 0;
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
        for (int i : list) {
            nums[index++] = i;
        }
        System.out.println("Ram " + Arrays.toString(nums));
        return list;
    }

    public static int[] twoOddNum(int arr[], int N) {
        TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
        for (int i : arr) {
            tm.put(i, tm.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[2];
        int index = 0;
        for (int i : tm.keySet()) {
            if (tm.get(i) % 2 != 0) {
                ans[index++] = i;
            }
        }
        return ans;
    }

    public int minDifference(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < sum + 1; i++)
            t[0][i] = false;
        for (int i = 0; i < n + 1; i++)
            t[i][0] = true;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        int mn = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (t[n][i]) {
                mn = Math.min(mn, sum - (2 * i));
            }
        }
        return mn;
    }

    public static boolean halvesAreAlike(String s) {
        String str = s.toLowerCase();
        char[] num1 = new char[str.length() / 2];
        char[] num2 = new char[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            num1[i] = str.charAt(i);
        }
        int j = 0;
        for (int i = str.length() / 2; i < str.length(); i++) {
            num2[j++] = str.charAt(i);
        }
        int count1 = 0;
        for (char a : num1) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') count1++;
        }
        int count2 = 0;
        for (char a : num2) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') count2++;
        }
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
        return count1 == count2;
    }

    public static boolean checkAlike(String str) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char a : "aeiouAEIOU".toCharArray()) {
            hashSet.add(a);
        }
        int count = 0;
        for (int i = 0; i < str.length() / 2; i++) {
            if (hashSet.contains(str.charAt(i))) count++;
            if (hashSet.contains(str.charAt(str.length() - 1 - i))) count--;
        }
        return count == 0;
    }

    public static int maxDistance(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int a = 0, b = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                a = i;
            }
            if (min > arr[i]) {
                min = arr[i];
                b = i;
            }
        }
        System.out.println(a + "+" + b);
        return Math.abs(max - min + (a - b));
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length == 0) {
            return true;
        }
        HashMap<Integer, List<Integer>> edgeList = new HashMap<>();
        //since using i to represent people i in dislikes[][] instead of i-1
        int[] color = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();

        //construct edgelist
        for (int i = 1; i <= N; i++) {
            edgeList.put(i, new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            edgeList.get(dislike[0]).add(dislike[1]);
            edgeList.get(dislike[1]).add(dislike[0]);
        }

        //since using i to represent people i in dislikes[][] instead of i-1
        for (int index = 1; index <= N; index++) {
            if (color[index] == 0) {
                q.add(index);
                color[index] = 1;

                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int i = 0; i < size; i++) {
                        int person = q.poll();
                        int nextColor = color[person] == 1 ? 2 : 1;
                        List<Integer> dislikePeople = edgeList.get(person);
                        for (int j = 0; j < dislikePeople.size(); j++) {
                            int dislikePerson = dislikePeople.get(j);
                            if (color[dislikePerson] == color[person]) {
                                return false;
                            }
                            if (color[dislikePerson] == 0) {
                                color[dislikePerson] = nextColor;
                                q.add(dislikePerson);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static int closetTarget(String[] words, String target, int startIndex) {
        int forword = 0;
        int backword = 0;

        for (int i = startIndex; i < words.length; i++) {
            if (words[i] == target) {
                forword++;
                i = (i + 1) % words.length;
            }
        }
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i] == target) {
                backword++;
                i = (i - 1) % words.length;
            }
        }

        return Math.min(backword, forword);
    }

    public static int minStoneSum(int[] piles, int k) {
        Arrays.sort(piles);
        int n = piles.length - 1;
        while (k > 0) {
            if (piles[n] % 2 != 0) {
                piles[n] = (int) Math.floor(piles[n] / 2) + 1;
            } else {
                piles[n] = (int) Math.floor(piles[n] / 2);
            }
            n--;
            k--;
        }
        System.out.println(Arrays.toString(piles));
        int sum = 0;
        for (int i : piles) {
            sum += i;
        }
        return sum;
    }

    public static String largestNumber(int[] nums) {
        StringBuilder str = new StringBuilder();
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum == 0) return "0";
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                checkGreater(nums, nums[i], nums[j], i, j);
            }
        }
        for (int i : nums) {
            str.append(i);
        }
        return str.toString();
    }

    private static void checkGreater(int[] nums, int i, int j, int f, int s) {
        long max = Long.parseLong(String.valueOf(i) + j);
        long min = Long.parseLong(String.valueOf(j) + i);
        if (min > max) {
            int tem = nums[f];
            nums[f] = nums[s];
            nums[s] = tem;
        }
    }

    public static boolean detectCapitalUse(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            boolean isUpper = Character.isUpperCase(word.charAt(1));
            for (int i = 2; i < word.length(); i++) {
                boolean currentState = Character.isUpperCase(word.charAt(i));
                if (isUpper != currentState) return false;
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }

    public static int minDeletionSize(String[] strs) {
        int cont = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    cont++;
                    break;
                }
            }
        }
        return cont;
    }

    public static long makeSimilar(int[] nums, int[] target) {
        if (Arrays.equals(nums, target)) return 0;
        long ans = 0;
        List<Integer> evenNum = new ArrayList<>();
        List<Integer> oddNum = new ArrayList<>();
        List<Integer> evenTarNum = new ArrayList<>();
        List<Integer> oddTarNum = new ArrayList<>();

        for (int i : nums) {
            if (i % 2 == 0) {
                evenNum.add(i);
            } else {
                oddNum.add(i);
            }
        }
        for (int i : target) {
            if (i % 2 == 0) {
                evenTarNum.add(i);
            } else {
                oddTarNum.add(i);
            }
        }
        for (int i = 0; i < oddNum.size(); i++) {
            ans += Math.abs(oddTarNum.get(i) - oddNum.get(i)) / 2;
        }
        for (int i = 0; i < evenNum.size(); i++) {
            ans += Math.abs(evenNum.get(i) - evenTarNum.get(i)) / 2;
        }
        return ans / 2;
    }

    public static long makeSimilar1(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        List<Integer> even1 = getEven(nums, true);
        List<Integer> odd1 = getEven(nums, false);
        List<Integer> even2 = getEven(target, true);
        List<Integer> odd2 = getEven(target, false);
        long diff = 0;
        for (int i = 0; i < even1.size(); i++) {
            if (even1.get(i) > even2.get(i)) {
                diff += even1.get(i) - even2.get(i);
            }
        }
        for (int i = 0; i < odd1.size(); i++) {
            if (odd1.get(i) > odd2.get(i)) {
                diff += odd1.get(i) - odd2.get(i);
            }
        }
        return diff / 2;
    }

    private static List<Integer> getEven(int[] nums, boolean flag) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            if (flag) {
                if (n % 2 == 0) {
                    list.add(n);
                }
            } else {
                if (n % 2 != 0) {
                    list.add(n);
                }
            }
        }
        return list;
    }

    public static int toggle(int n, int[] arr) {
        int start = 0, end = 0, log_start = 0, log_end = 0, log_length = 0;
        while (end > arr.length) {
            if (end - start + 1 > log_length) {
                log_start = start;
                log_end = end;
                log_length = end - start + 1;
            } else {
                start = end + 1;
                end += 1;
            }
        }
        for (int i = log_start; i < log_end; i++) {
            arr[i] = 1 - arr[i];
        }
        return arr.length - log_length;

    }

    public static int toggle1(int n, int[] arr) {
        int start = 0, curr = 0, max = 0, count = 0;
        while (curr < arr.length) {
            if (arr[curr] == 1) {
                count++;
                max = Math.max(max, count);
                curr++;
            } else {
                while (curr < arr.length && arr[curr] == 0) {
                    count++;
                    curr++;
                    max = Math.max(max, count);
                }
                start = curr;
                while (curr < arr.length && arr[curr] == 1) {
                    count++;
                    curr++;
                    max = Math.max(max, count);
                }
                curr = start;
                count = 0;
            }
        }
        return max;
    }

    static int maximumpoints(int[][] arr, int n, int x, int y) {
        int maxPoint = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int width = Math.abs(arr[i][0] - arr[j][0]);
                int height = Math.abs(arr[i][1] - arr[j][1]);
                if (width <= x && height <= y) {
                    int count = 0;
                    for (int k = 0; k < n; k++) {
                        if (arr[k][0] >= Math.min(arr[i][0], arr[j][0]) && arr[k][0] <= Math.max(arr[i][0], arr[j][0]) &&
                                arr[k][1] >= Math.min(arr[i][1], arr[j][1]) && arr[k][1] <= Math.max(arr[i][1], arr[j][1])) {
                            count++;
                        }
                    }
                    maxPoint = Math.max(maxPoint, count);
                }
            }
        }
        return maxPoint;
    }

    static long findGoodPairs(int a[], int n, int k) {
        // Code your solution here.
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(a[i])) {
                mp.put(a[i], new ArrayList<>());
            }
            mp.get(a[i]).add(i);
        }
        long ans = 0;
        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            List<Integer> indices = entry.getValue();
            for (int i = 0; i < indices.size(); i++) {
                for (int j = i + 1; j < indices.size(); j++) {
                    if (indices.get(j) - indices.get(i) >= k) {
                        ans += indices.size() - j;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);
        for (int cost : costs) {
            if (coins >= cost && coins != 0) {
                count++;
                coins -= cost;
            }
        }
        return count;
    }

    public static int countDigits(int num) {
        if (num >= 1 && num <= 9) return 1;
        int count = 0;
        int nums = num;
        while (num != 0) {
            int rem = num % 10;
            if (nums % rem == 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int pos = 0, sum = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                total += sum;
                sum = 0;
                pos = i + 1;
            }
        }
        total += sum;
        if (total >= 0) return pos;
        return -1;
    }

    public static String categorizeBox(int length, int width, int height, int mass) {
        int vol = (length * width) * height;
        boolean bulky = length >= 1e4 || width >= 1e4 || height >= 1e4 || mass >= 1e4 || vol >= 1e9;
        boolean heavy = mass >= 100;
        if (bulky && heavy) {
            return "Both";
        } else if (bulky) {
            return "Bulky";
        } else if (heavy) {
            return "Heavy";
        } else
            return "Neither";
    }

    public static long maxKelements(int[] nums, int k) {
        /*long score = 0;
        int l = k;
        int count = 0;
        for(int i = 0; i < l; i++){
            if (count == k) break;
            if(nums[i] >= k){
                score += nums[i];
                nums[i] = (int) Math.ceil( (double) nums[i] / 3);
                i -= 1;
                count++;
            }else {
                l += 1;
            }
        }
        return score;*/
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ans = 0;
        for (int e : nums) {
            pq.add(e);
        }
        System.out.println(pq);
        /*for (int i = 0; i < k; i++) {
            double curr = pq.remove();
            ans += curr;
            System.out.println(curr);
            pq.add((int) Math.ceil(curr / 3));
        }*/

        return ans;
    }

    static long countPairs(int n, int[] arr, int k) {
        long ans = 0;
        int[] a = new int[k];
        System.out.println(Arrays.toString(a));
        for (int i : arr) {
            a[i % k]++;
        }
        for (int i = 0; i < k; i++) {
            ans = ans + ((long) a[i] * (a[i] - 1)) / 2;
        }

        return ans;
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

    public static int maxPoints(int[][] nums) {
        int len = nums.length;
        if (len <= 2) return len;
        int max = 2;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int total = 2;
                for (int k = 0; k < len; k++) {
                    if (k != i && k != j) {
                        int pointA = (nums[j][1] - nums[i][1]) * (nums[i][0] - nums[k][0]);
                        int pointB = (nums[i][1] - nums[k][1]) * (nums[j][0] - nums[i][0]);
                        if (pointA == pointB) {
                            total++;
                        }
                    }
                }
                max = Math.max(total, max);
            }
        }
        return max;
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

        /*int store = 0;
        int count = 0;
        for (int i : arr) {
            if (count == 0) store = i;
            if (i == store) count += 1;
            else count -= 1;
        }
        return store;*/
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i : arr) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        int value = 0;
        System.out.println(hash);
        for (Map.Entry<Integer, Integer> i : hash.entrySet()) {
            if (i.getValue() > max) {
                value = i.getKey();
                max = i.getValue();
            }
        }
        return value;
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }

    public static int maximumPopulation(int[][] logs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = 1;
        for (int[] arr : logs) {
            for (int j = arr[0]; j < arr[1]; j++) {
                if (map.get(j) == null) {
                    map.put(j, 1);
                } else {
                    int y = map.get(j) + 1;
                    max = Math.max(max, y);
                    map.put(j, map.get(j) + 1);
                }
            }
        }
        int result = 0;
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public static int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;

    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        /*HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsValue(val)){
                j++;
            }
            else {
                hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0)+ 1);
            }
        }
        System.out.println(hashMap);
        return j;*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static String ticTacToe(int[][] moves) {
        int len = moves.length;
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {// A
                board[moves[i][0]][moves[i][1]] = 'X';
            } else {// B
                board[moves[i][0]][moves[i][1]] = '0';
            }
        }
        System.out.println(Arrays.deepToString(board));
        return checkBoard(board);
    }

    private static String checkBoard(char[][] board) {
        // Check all row
        for (int i = 0; i < board.length; i++) {
            int countA = 0;
            int countB = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'X') {
                    countA++;
                } else if (board[i][j] == '0') {
                    countB++;
                }
            }
            if (countA == 3) return "A";
            if (countB == 3) return "B";
        }

        // Check all Column
        for (int i = 0; i < board.length; i++) {
            int countA = 0;
            int countB = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 'X') {
                    countA++;
                } else if (board[j][i] == '0') {
                    countB++;
                }
            }
            if (countA == 3) return "A";
            if (countB == 3) return "B";
        }

        // Check diagonal
        if (board[0][0] == '0' && board[1][1] == '0' && board[2][2] == '0') return "B";
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') return "A";

        if (board[2][0] == '0' && board[1][1] == '0' && board[0][2] == '0') return "B";
        if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') return "A";

        // Draw
        int c = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'X' || board[i][j] == '0') c++;
            }
        }
        if (c != 9) return "Pending";
        return "Draw";
    }

    public static boolean validMountainArray(int[] nums) {
        if (nums.length < 3) return false;
        int max = 0;
        for (int i : nums) {
            if (max < i) {
                max = i;
            }
        }
        if (max == nums[nums.length - 1]) return false;
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                i++;
                break;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        if (i < 2) return false;
        for (; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        char[] c = words[0].toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (isContains(c[i], words)) {
                list.add(String.valueOf(c[i]));
            }
        }
        return list;

    }


    public static boolean isContains(char c, String[] words) {
        for (int i = 1; i < words.length; i++) {
            if (!words[i].contains(String.valueOf(c))) return false;
            else words[i] = words[i].replaceFirst(String.valueOf(c), "@");
        }
        return true;
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int start = 1, ans = 0;
        while (start <= arr.length) {
            for (int i = 0; i <= arr.length - start; i++) {
                for (int j = i; j < i + start; j++) {
                    ans += arr[j];
                }
            }
            start += 2;
        }
        return ans;
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int[] arr = new int[nums.length];
        boolean[] bool = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                arr[i] = putArray(i, nums, bool);
            } else {
                arr[i] = putArrayA(i, nums, bool);
            }
        }
        return arr;
    }

    public static int putArray(int i, int[] nums, boolean[] bool) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0 && !bool[j]) {
                bool[j] = true;
                return nums[j];
            }
        }
        return 0;
    }

    public static int putArrayA(int i, int[] nums, boolean[] bool) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 != 0 && !bool[j]) {
                bool[j] = true;
                return nums[j];
            }
        }
        return 0;
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

    public static int[][] insertValueOfMiddle(int[][] intervals, int[] newIntervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] in : intervals) {
            if (in[1] < newIntervals[0]) {
                list.add(in);
            } else if (newIntervals[1] < in[0]) {
                list.add(newIntervals);
                newIntervals = in;
            } else {
                newIntervals[0] = Math.min(newIntervals[0], in[0]);
                newIntervals[1] = Math.max(newIntervals[1], in[1]);
            }
        }
        list.add(newIntervals);
        return list.toArray(new int[list.size()][]);
    }

    public static int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 0) return 0;
        int res = kadenAlgo(nums);
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            y += nums[i];
            nums[i] *= -1;
        }
        int z = kadenAlgo(nums);
        if (res + z == 0) return res;
        return Math.max(res, y + z);
    }

    private static int kadenAlgo(int[] nums) {
        int sum = nums[0], answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) sum = nums[i];
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum = 0;
        int rem = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if (hashMap.containsKey(rem)) {
                ans += hashMap.get(rem);
                hashMap.put(rem, hashMap.get(rem) + 1);
            } else {
                hashMap.put(rem, 1);
            }

        }
        return ans;
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> add = new ArrayList<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    add.add(nums[i]);
                }
            }
        }
        return list;
    }

    public static int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        int[] count = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            count[trust[i][0]]--;
            count[trust[i][1]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == n - 1) return i;
        }
        return -1;
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcd(str1.length(), str2.length());
        return str2.substring(0, gcd);
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private static void permutation(String prefix, String str, List<String> result) {
        int n = str.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), result);
            }
        }
    }

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        separateDigits1(nums, list);
        int i = 0;
        int[] num = new int[list.size()];
        for (int l : list) {
            num[i++] = l;
        }
        return num;
    }

    public void separateDigits1(int[] nums, List<Integer> answer) {
        for (int num : nums) {
            char[] digits = String.valueOf(num).toCharArray();
            for (char digit : digits) {
                answer.add(digit - '0');
            }
        }
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0;
        int ct = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = false;
            for (int x : banned) {
                if (x == i) flag = true;
            }
            if (flag) continue;
            if (sum <= maxSum) {
                sum += i;
                ct++;
            }
            if (sum > maxSum) ct--;
            break;
        }
        return ct;
    }

    public static boolean isPossibleToCutPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] marked = new boolean[m][n];
        marked[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                marked[i][j] = grid[i][j] == 1 ? ((i > 0 ? marked[i - 1][j] : false) || (j > 0 ? marked[i][j - 1] : false))
                        : false;
            }
        }
        if (!marked[m - 1][n - 1]) return true;
        return false;
    }

    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        Arrays.sort(prizePositions);
        int[] after = new int[n];
        int[] maxafter = new int[n];
        for (int i = 0; i < n; i++) {
            int ind = BinarySearch.floorIndex(prizePositions, prizePositions[i] + k);
            after[i] = ind - i + 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            maxafter[i] = Math.max(after[i], (i < n - 1 ? maxafter[i + 1] : 0));
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int ind = BinarySearch.floorIndex(prizePositions, prizePositions[i] + k) + 1;
            ans = Math.max(ans, after[i] + (ind < n ? maxafter[ind] : 0));
        }
        return ans;
    }

    static class BinarySearch {
        static int ceilIndex(int arr[], int x) {
            int low = 0;
            int high = arr.length - 1;
            int ind = -1;
            boolean xmatched = false;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > x) {
                    if (!xmatched)
                        ind = mid;
                    high = mid - 1;
                } else if (arr[mid] == x) {
                    ind = mid;
                    low = mid + 1;
                    xmatched = true;
                } else {
                    low = mid + 1;
                }
            }
            return ind;
        }

        static int floorIndex(int[] arr, int x) {
            int low = 0;
            int high = arr.length - 1;
            int ind = -1;
            boolean xmatched = false;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] < x) {
                    if (!xmatched)
                        ind = mid;
                    low = mid + 1;
                } else if (arr[mid] == x) {
                    ind = mid;
                    low = mid + 1;
                    xmatched = true;
                } else {
                    high = mid - 1;
                }
            }
            return ind;
        }
    }

    public static boolean isDisconnect(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int start = 0, end = m * n - 1;
        int[] parent = new int[m * n];
        for (int i = 0; i < m * n; i++) parent[i] = i;

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                int cur = i * n + j;
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    int next = cur + n;
                    int p1 = findParent(parent, cur), p2 = findParent(parent, next);
                    if (p1 != p2) {
                        parent[p1] = p2;
                        cnt--;
                    }
                }
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    int next = cur + 1;
                    int p1 = findParent(parent, cur), p2 = findParent(parent, next);
                    if (p1 != p2) {
                        parent[p1] = p2;
                        cnt--;
                    }
                }
                cnt++;
            }
        }
        int pStart = findParent(parent, start), pEnd = findParent(parent, end);
        if (pStart == pEnd) return false;
        return cnt >= 3 || (cnt == 2 && (grid[0][0] == 0 || grid[m - 1][n - 1] == 0));
    }

    private static int findParent(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = findParent(parent, parent[i]);
    }

    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        long diffNeeded = Math.abs(sum - goal);
        if (diffNeeded % limit == 0) {
            return (int) (diffNeeded / limit);
        } else {
            return (int) diffNeeded / limit + 1;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Integer>[] red = new ArrayList[n];
        ArrayList<Integer>[] blue = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }
        for (int[] edge : redEdges) {
            red[edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blue[edge[0]].add(edge[1]);
        }
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int color = cur[1];
            ArrayList<Integer> adj = color == 0 ? red[node] : blue[node];
            for (int next : adj) {
                if (res[next] > res[node] + 1) {
                    res[next] = res[node] + 1;
                    q.offer(new int[]{next, 1 - color});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }

    public static long findTheArrayConcVal(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += Integer.parseInt(nums[i] + String.valueOf(nums[nums.length - i - 1]));
        }
        return sum;
    }

    long ans = 0;
    int s;

    private int dfs(int i, int prev, List<List<Integer>> graph) {
        int people = 1;
        for (int x : graph.get(i)) {
            if (x == prev) continue;
            people += dfs(x, i, graph);
        }
        if (i != 0) ans += (people + s - 1) / s;
        return people;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList<>();
        s = seats;
        for (int i = 0; i < roads.length + 1; i++) graph.add(new ArrayList<>());
        for (int[] r : roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        dfs(0, 0, graph);
        return ans;
    }

    public static int minMaxDifference(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        char value1 = chars[0];
        char value2 = chars[0];
        for (char aChar : chars) {
            if (aChar != '9') {
                value1 = aChar;
                break;
            }
        }
        char[] max = new char[chars.length];
        char[] min = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == value1) max[i] = '9';
            else max[i] = chars[i];

            if (chars[i] == value2) min[i] = '0';
            else min[i] = chars[i];
        }
        String maxValue = new String(max);
        String minValue = new String(min);

        return Integer.parseInt(maxValue) - Integer.parseInt(minValue);
    }

    private static int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num % 2 == 0 ? num : num * 2);
        }
        int minDev = Integer.MAX_VALUE;
        while (true) {
            int max = set.last();
            int min = set.first();
            minDev = Math.min(minDev, max - min);
            if (max % 2 == 0) {
                set.remove(max);
                set.add(max / 2);
            } else {
                break;
            }
        }
        return minDev;
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] mat = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) mat[i][0] = i;
        for (int j = 0; j <= n; j++) mat[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1];
                } else {
                    mat[i][j] = 1 + Math.min(Math.min(mat[i - 1][j],
                            mat[i][j - 1]), mat[i - 1][j - 1]);
                }
            }
        }
        return mat[m][n];
    }

    public static int[] divisibilityArray(String word, int m) {
        int[] nums = new int[word.length()];
        int rem = 0;
        for (int i = 0; i < word.length(); i++) {
            int digit = word.charAt(i) - '0';
            rem = (rem * 10 + digit) % m;
            if (rem == 0) {
                nums[i] = 1;
            }
        }
        return nums;
    }

    public static int alternateDigitSum(int n) {
        int sum = 0;
        int digit = n;
        int inc = 1;
        while (digit != 0) {
            int rem = digit % 10;
            if (inc % 2 != 0 || sum == 0) {
                sum += rem;
                inc++;
            } else {
                sum -= rem;
            }
            digit /= 10;
            inc++;
        }
        return sum;
    }


    public static int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        System.out.println(hashMap);
        List<Integer> list = new ArrayList<>(hashMap.keySet());
        System.out.println(list);
        Collections.sort(list, (a, b) -> (hashMap.get(b) - hashMap.get(a)));

        for (int i = 0; i < k; i++) {
            arr[i] = list.get(i);
        }

        System.out.println(list);

        return arr;
    }

    public static String count(char chars, int num) {
        return String.valueOf(chars).repeat(num);
    }

    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        Arrays.sort(ranks);
        long left = 0, right = (long) 1e18;
        while (left < right) {
            long mid = (left + right) / 2;
            long total_cars = 0;
            for (int r : ranks) {
                long num_cars = mid / ((long) r * r);
                total_cars += num_cars;
                if (total_cars >= cars) {
                    break;
                }
            }
            if (total_cars >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findNumbers(int[] nums) {
        int max = 0;
        for (int num : nums) {
            int length = String.valueOf(num).length();
            if (length % 2 == 0) {
                max++;
            }
        }
        return max;
    }

    public static int smallestNumber(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        int smallest = Integer.MAX_VALUE;
        for (int num : set1) {
            if (set2.contains(num)) {
                smallest = Math.min(smallest, num);
            }
        }
        if (smallest == Integer.MAX_VALUE) {
            for (int num : set2) {
                if (set1.contains(num)) {
                    smallest = Math.min(smallest, num);
                }
            }
        }
        return smallest;
    }

    public static int minimizeArrayValue(int[] nums) {
        int[] arr = nums;
        int ans = 0;
        int pos = 0;
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (nums[i] > maxNumber) {
                maxNumber = nums[i];
                pos = i;
            }
        }

        if (pos == 0) {
            return nums[pos];
        }
        nums[pos] = nums[pos] - 1;
        nums[pos - 1] = nums[pos - 1] + 1;

        System.out.println(Arrays.toString(nums));
        return minimizeArrayValue(nums);
    }

    public static int findTheLongestBalancedSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); ) {
            int z = 0, o = 0;
            while (i < s.length() && s.charAt(i) == '0') {
                z++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == '1' && z > o) {
                o++;
                i++;
                max = Math.max(max, o * 2);
            }
            while (i < s.length() && s.charAt(i) == '1') i++;
        }
        return max;
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i : pushed){
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void GetWalletApi() throws Exception{
        String userId = "c919a907-7da0-4987-86b6-a3334e163cc3";
        String url = "http://ec2-3-110-216-86.ap-south-1.compute.amazonaws.com:8080/d11/v1/user/get-wallet-data?userId=" + userId;

        URL apiUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) apiUrl.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("API request failed with HTTP status code: " + status);
        }
    }
    public static List<Boolean> kidsWithCandies(int[] nums, int num) {
        List<Boolean> list = new ArrayList<>();
        int max = Arrays.stream(nums).max().getAsInt();
        for(int i : nums){
            if (i + num >= max){
                list.add(true);
            }else {
                list.add(false);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String userId = uuid.toString();
        System.out.println(userId);


        //System.out.println(validateStackSequences(pushed, popped));
       /* int []nums = {3,7,1,6,11,10};
        int []n = new int[2];
        int max = Arrays.stream(nums).max().getAsInt();
        System.out.println(max);*/
        //System.out.println(minimizeArrayValue(nums));
        // System.out.println(count('A',3));
        //System.out.println(findTheArrayConcVal(nums));

        /*String str = "my name, is gaddar: kumar? chaudhary ? I & from West champaran! bihar";
        String name = str.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        if (!name.equals(new StringBuilder(name).reverse().toString())) {
            System.out.println("true");
        }*/

    }
}
