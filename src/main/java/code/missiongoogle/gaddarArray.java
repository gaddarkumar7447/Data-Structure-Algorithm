package code.missiongoogle;

import javax.naming.CompositeName;
import java.util.Hashtable;
import java.util.Iterator;

public class gaddarArray {

    public static void print(int num){
        if (num == 0){
            return;
        }
        System.out.println("%d "+num%2);
        print(num/2);
    }


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


    private static int main(int a, int b)
    {
        if (a + b == 0)
        {
            return 0;
        }
        return a + main(a - 1, b);
    }

    public static void main(String[] args) {

       /* int out = 15;
        for (int i = 4; i < 6; i++)
        {
            for (int j = 7; j >= 5; j--)
            {
                if (i == j)
                    break;
                if (i > j)
                {
                    System.out.println("in IF IJ"+ j+""+i);
                    out += main(i, j);
                }
                else
                {
                    System.out.println("in else IJ"+ j+""+i);
                    out += main(j, i);
                    *//*if(j==7&& i==5){
                        System.out.println("7,4 "+out);
                    }*//*
                }
            }
        }
        System.out.println("out = " + out);*/
//        print(12);


        Hashtable<Integer, String> ht = new Hashtable<>();
        ht.put(1,"Gaddar");
        ht.put(2,"Raja");
        ht.put(3,"Sumit");
        ht.put(4,"Ravi");
        ht.put(5,"Ramu");
        ht.put(6,"Bhulan");

//        String val = new String(ht.remove(1));

//        System.out.println(ht.get(1));
//        System.out.prSystem.out.println(ht.get(1));*/intln(ht.remove(1));
        /*System.out.println(val);*/


        for (Integer integer: ht.keySet()) {
            String va = new String(ht.get(integer));
            System.out.println(integer+" "+va+" ");
        }
    }
}
