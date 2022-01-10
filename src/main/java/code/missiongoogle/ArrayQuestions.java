package code.missiongoogle;


import java.util.Arrays;
import java.util.Collections;

public class ArrayQuestions {
    public static void main(String[] args) {
        int [] intArray= new int[]{5, 23, 28, 2, 40};
        String [] stringArray = new String[]{"Sumit","Gaddar","Bhulan","Ramu"};

        /*Array-Traversal*/
        //mySolutionReverseArray(intArray);
        //gfgSolutionWithBetterLogic(intArray);
        //gfgUsingCollection(intArray);

        /*Array Sort Check*/
        //System.out.println(mySolutionSortCheck(false,intArray));
        //TODO: check with recursive method(GFG solution)

        /*Find Maximum in array*/
        System.out.println(String.valueOf(mySolutionMaximumInArray(intArray)));
        
    }

    private static int mySolutionMaximumInArray(int[] intArray) {
        if(intArray.length!=0 && intArray.length==1){
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
            int curr;
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
                    int temp = intArray[start];
                    intArray[start]=intArray[end];
                    intArray[end]= temp;
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
