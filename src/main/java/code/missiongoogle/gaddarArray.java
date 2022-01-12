package code.missiongoogle;

public class gaddarArray {
   public static boolean reversArray(int []a){
       boolean isSorted=true;
       int temp = a[0];

       for(int i=1;i<a.length-1;i++){
           if(temp<a[i]){
               isSorted=false;

           }
       }
       return  isSorted;
   }
   public  static int [] pairSum(int [] inputArr, int target){
       for (int i = 0; i < inputArr.length; i++) {
           for (int j = i + 1; j < inputArr.length; j++) {
               if (inputArr[i] + inputArr[j] == target){
                   System.out.printf("(%d, %d)\n",inputArr[i],inputArr[j]);
               }
           }
       }
    return inputArr;
   }

    public  static int maxElement(int [] inputArr){
       int max = inputArr[0];

        for (int i = 1; i < inputArr.length; i++) {

            if (max > inputArr[i]){
                max = inputArr[i];
                System.out.println(inputArr[i]);
            }
        }
        return max;
    }


    public  static int minElement(int [] inputArr){
        int min = inputArr[0];
        for (int i = 1; i < inputArr.length; i++) {

            if (min < inputArr[i]){
                min = inputArr[i];
                System.out.println(inputArr[i]);

            }
        }

        return min;
    }

    public int peekElement(int [] arr, int n){
        for (int i = 1; i < arr.length; i++) {

        }
       return 0;
    }
}
