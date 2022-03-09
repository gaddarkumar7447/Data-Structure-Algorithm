package code.missiongoogle;

import java.util.Scanner;

public class YoungPhysicist {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i <nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
//                    return new int []{i,j};
                    System.out.print(i+","+j);
                }
            }
        }
        return null;
    }


    /*public static int[] nums(int[] inArray, int target){
        for (int i = 0; i < inArray.length; i++) {

            for (int j = 0; j < inArray.length; j++) {
                if (inArray[i] + inArray[j]== target){
                    return new int []{i,j};
                }

            }
//            return new IllegalArgumentException("No found");

        }*/
        /*throw new IllegalArgumentException("No found");*/
//        throw new IllegalArgumentException("N");
//    }
    public static boolean isBlanced(int a[][], int n){
        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i][j];
            }
            if (sum != 0)
            {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] nums= new int[]{5,10,17,20,43};
        int target = 37;
        /*twoSum(nums,target);*/
        int t, p;
        p = sc.nextInt();
        t = sc.nextInt();
        Character[] as = new Character[p];
//        as = sc.next().charAt();
        for (int i = 0; i < t; i++) {
            for (int j = 0; as[j] != '\0'; j++) {
                    if (as[j] == 'B' && as[j+1] == 'G'){
                        as[j] = 'G';
                        as[j+1] = 'B';
                        j++;
                    }
            }
        }
        System.out.print("%s"+as);


        /*Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[6][6];
        int r,c;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1 ; j < 6; j++) {
                if (matrix[i][j] == 1){
                    r = Math.abs(3-i);
                    c = Math.abs(3-j);
                    System.out.println(r+c);
                }
            }

        }*/
        /*int n = sc.nextInt();
        int  sum = 0, flag = 0;
        int a[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
              a[i][j] = sc.nextInt();
            }
        }

        if (isBlanced(a,n)){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }*/
    }
}
