package code.missiongoogle.algorithms;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
//import static java.lang.System.out;
import java.util.*;

class DynamicProgramming {
/* ---------------------------------------------------------------------------------------- */
    public static int fibo(String str, int num){
        System.out.println(str + num);
        if (num == 1 || num == 0) return num;
        return fibo("A   "+str,num-1) + fibo("B   "+str,num-2);
    }

    public static int TopDown(int []arr,int num){
        if (num < 2) return num;
        if (arr[num] == 0)
            return arr[num] = TopDown(arr,num-1) + TopDown(arr,num-2);
        return arr[num];
    }

    public static int downTop(int num){
        int []arr = new int[num + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= num; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[num];
    }

    public static int stair(int num){
        int a = 0, b = 1, c;
        for (int i = 2; i <= num; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return b;
    }

/*--------------------------------------------------------------------------*/

    public static int treeStair(int num){
        int []arr = new int[num +1];
        if (num == 0 || num == 1) return 1;
        if (num == 2) return  2;
        if (arr[num] == 0){
            arr[num] = treeStair(num-1) + treeStair(num-2) + treeStair(num-3);
        }
        return arr[num];
    }

    public static int bottomStair(int num){
        int []arr = new int[num + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2]= 2;
        for (int i = 3; i <= num ; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        return arr[num];
    }

    public static int TopStair(int num){
        int a= 1, b = 1, c = 2, d;
        for (int i = 3; i <=num ; i++) {
            d = a+b+c;
            a = b;
            b = c;
            c= d;
        }
        return c;
    }
    public void show(){
        System.out.println(this);;
    }
    public static int matrixManipulation(int []matrix,int i, int j){
        if (i==j) return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int count = matrixManipulation(matrix,i,k) + matrixManipulation(matrix,k+1,j) + matrix[i-1] * matrix[k] * matrix[j];
            if (count < min)
                min = count;
        }
        return min;
    }
    /*--------------Minimum number of jump to nth stair------------ */

    public static int minimumStair(int num){
        if (num == 0) return 0;
        if (num == 1 || num == 2 || num == 3) return 1;
        int a = Math.min(Math.min(minimumStair(num-1),minimumStair(num-2)),minimumStair(num-3));
        return 1 + a;
    }

    public static int minimumDown(int num){
        int a = 0, b = 1, c = 1, d;
        for (int i = 3; i <= num; i++) {
            d = 1 + Math.min(Math.min(a,b),c);
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
    public static int stepDown(int []arr, int num){
        if (num == 0 ) return 0;
        if (num == 1 || num ==2 || num == 3) return 1;
        return 1 + Math.min(Math.min(stepDown(arr, num-1),stepDown(arr, num-2)),stepDown(arr, num-3));
    }
    public static int stepUp(int num){
        int []arr = new int[num + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= num; i++) {
            arr[i] = 1 + Math.min(Math.min(arr[i-1], arr[i-2]),arr[i-3]);
        }
        return arr[num];
    }

    public static int lcs(String s1, String s2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcs(s1, s2, n - 1, m - 1);
        }

        return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }

    public static int lcsTopDown(String s1, String s2, int n, int m, Integer[][] arr) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(arr[n][m] == null) {
            if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
                arr[n][m] = 1 + lcsTopDown(s1, s2, n - 1, m - 1, arr);
            } else {
                arr[n][m] = Math.max(lcsTopDown(s1, s2, n - 1, m, arr), lcsTopDown(s1, s2, n, m - 1, arr));
            }
        }

        return arr[n][m];
    }

    public static int lcsBottomUp(String s1, String s2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        int[][] arr = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        return arr[n][m];
    }
    public static int longestPalindromeSubSequence(String str , int start, int end, int [][]dp){
        if (start > end) return 0;
        if (start == end) return 1;
        if (dp[start][end] == 0){
            if (str.charAt(start) == str.charAt(end)){
                dp[start][end] = 2 + longestPalindromeSubSequence(str, start + 1, end - 1, dp);
            }
            else {
                dp[start][end] = Math.max(longestPalindromeSubSequence(str, start + 1, end, dp), longestPalindromeSubSequence(str, start, end -1, dp));
            }
        }
        return dp[start][end];
    }

    public static int longestPalindromeSubseq(String s) {
        return lcs(s, s.length());
    }
    public static int lcs(String s, int n){
        int [][]dp = new int [n][n];
        for(int i = n - 2; i >= 0 ; i--){
            for(int j = i + 1; j < n; j++){
                if(s.charAt(i + 1) == s.charAt(j - 1)){
                    dp[i][j] = 2 + dp[i + 1][j -1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n-1];
    }
    public static List<List<Integer>> permute(int []nums){
        List<List<Integer>> list = new ArrayList<>();
        canPermute(nums,list, 0);
        return list;
    }
    private static void canPermute(int []nums,List<List<Integer>> list, int index) {
        if (nums.length == index){
            list.add(toList(nums));
        }else {
            for (int i = index; i < nums.length; i++) {
                swap(i, index,  nums);
                canPermute(nums, list, index + 1);
                swap(i,index, nums);
            }
        }
    }
    private static void swap(int i, int index, int[] nums) {
        int tem = nums[i];
        nums[i] = nums[index];
        nums[index] = tem;
    }

    public static List<Integer> toList(int []nums){
        List<Integer> l = new ArrayList<>();
        for (int i : nums){
            l.add(i);
        }
        return l;
    }

    public static void main(String[] args) {
        int []nums = new int[5];
        System.out.println(TopDown(nums,4));
        /*Set<List<Integer>> set = new HashSet<>();
        set.add(Collections.singletonList(54));
        int []nums = {1,2,3};
        System.out.println(permute(nums));*/

        /*String str = "bbbab";
        int [][]dp = new int[str.length()][str.length()];
        System.out.println(longestPalindromeSubseq(str));*/

        /*String s1 = "abcde";
        String s2 = "ace";
        System.out.println(lcs(s1, s2, s1.length(), s2.length()));*/

        /*Integer[][] arr = new Integer[s1.length() + 1][s2.length() + 1];
        System.out.println(DynamicProgramming.lcsTopDown(s1, s2, s1.length(), s2.length(), arr));
        System.out.println(lcsBottomUp(s1, s2, s1.length(), s2.length()));*/


        /*int num = 7;
        System.out.println(minimumDown(7));*/
        //System.out.println(stepDown(arr,num));

//        System.out.println(minimumDown(40));



        /*int []matrix = {5,4,6,2,7};
        out.println(matrixManipulation(matrix,1,matrix.length-1));*/
        /*DynamicProgramming a = new DynamicProgramming();
        out.println(a);
        a.show();*/
//        b.show();
//        out.println(TopStair(5));
//        out.println(fibo("T ",5));
//        Scanner sc = new Scanner(System.in);
        // 0 1 1 2 3 5 8 13 21
        /*int n = 5;

        int []arr = new int[n+1];
        out.println(TopDown(arr,n));*/

    }
}