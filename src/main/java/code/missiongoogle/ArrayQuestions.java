package code.missiongoogle;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArrayQuestions {
    public static void main(String[] args) {
        int [] intArray= new int[]{2,7,11,15};
        String [] stringArray = new String[]{"Sumit","Gaddar","Bhulan","Ramu"};

        /*Array-Traversal*/
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
        pairSum(intArray,9);









    }

    private static void pairSum(int[] intArray,int target) {
        /*2,7,11,15*/
        String indexes=null;
        HashMap<Integer, Integer> indexVal = new HashMap<>();
        for(int i=0;i<intArray.length;i++){
            int diff = target-intArray[i];
            if(indexVal.containsKey(diff)){
                indexes="first: "+indexVal.get(diff)+" second:"+i;
                break;
            }
            indexVal.put(intArray[i],i);
        }
        System.out.println(indexes);



    }


    private static boolean containsDuplicate(int k, int[] intArray) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for(int num : intArray) {
            if(map.containsKey(num) && isIndexInRange(i, map.get(num), k)) {
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
        if(intArray.length == 1){
           return intArray[0];
        }else {
            int maxSoFar=-1;
            for(int i=0;i<intArray.length;i++){
                System.out.println("index: "+i);
                if(intArray[i]>maxSoFar)
                    maxSoFar=intArray[i];
            }
            return maxSoFar;
        }
    }

    private static boolean mySolutionSortCheck(boolean isAscending,int [] arr) {
        boolean isSorted=true;
        if(arr.length==0){
            return false;
        }else {
            if(isAscending){
                for (int i=1;i<arr.length;i++){
                    if(arr[i-1]>arr[i])
                        isSorted=false;
                }
            }else {
                for (int i=1;i<arr.length;i++){
                    if(arr[i-1]<arr[i])
                        isSorted=false;
                }
            }
        }
        return isSorted;


    }

    private static void gfgUsingCollection(int[] intArray) {
        Collections.reverse(Arrays.asList(intArray));
        System.out.println(Arrays.asList(intArray));



    }

    private static void gfgSolutionWithBetterLogic(int[] intArray) {
        int n= intArray.length;
        int t;
        /*For input: 12,-7,-8,4,-1,-6,
        * i will be > 0,1,2,3,4,5
        * n will be > 5,4,3,2,1,0
        * If we keep subtracting  i from n inside loop we  will get the n's sequence
        * run the loop by half of the size and remove the start&end variable
        *
        *
        *  */

        for (int i = 0; i < n / 2; i++) {
            t = intArray[i];
            intArray[i] = intArray[n - i - 1];
            intArray[n - i - 1] = t;
        }
        for (int val : intArray){
            System.out.print(val+",");
        }
    }

    private static void mySolutionReverseArray(int[] intArray) {
        int start=0;
        int end = intArray.length-1;
        for(int i =0; i<end;i++){
            if(start==end){
                break;
            }else {
                try{
                    intArray[start]=intArray[start]*intArray[end];
                    intArray[end]= intArray[start]/intArray[end];
                    intArray[start]= intArray[start]/intArray[end];

                }catch (ArithmeticException e){
                    /*int temp = intArray[start];
                    intArray[start]=intArray[end];
                    intArray[end]= temp;*/
                }

                System.out.println("start> "+start+" end>"+end);
                start++;
                end--;
            }
        }
        for (int val : intArray){
            System.out.print(val+",");
        }
    }


}
