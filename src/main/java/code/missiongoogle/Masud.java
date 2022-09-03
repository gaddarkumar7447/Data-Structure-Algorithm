package code.missiongoogle;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

class Masud {


    public static void main(String[] args)  {
        var a = 10;
        int []nums = {5,1,12,-5,8,4,9};
        for (int i = 0; i < nums.length; i++){
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]){
                    index = j;
                    // -5
                    /*int tem = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tem;*/
                }
            }
            int tem = nums[index];
            nums[index] = nums[i];
            nums[i] = tem;;
        }
        System.out.println(Arrays.toString(nums));
        //
        /*Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        while(a-- > 0){
            int in = sc.nextInt();
            for (int i = 0; i < in; i++) {
                set.add(sc.nextInt());
            }

            if (in % 2 == 0){
                System.out.println("YES");
                continue;
            }

            if(set.size() % 2 == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }*/
    }

        /*int [] arr = {5,1,2,9,6,7,4};
        // insertion sort
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            //while (j >= 0 && arr[j] > key)
            while (  j  >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));*/
        /*int []arr = {5,4,5,6,7,5};
        int []newArr = new int[20];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]){
                    flag = 1;
                    break;
                }
            }

            if (flag == 0){
                newArr[index++] = arr[i];
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.print(" "+newArr[i]);
        }*/
}
