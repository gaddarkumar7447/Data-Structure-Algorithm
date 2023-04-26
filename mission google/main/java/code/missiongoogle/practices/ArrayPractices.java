package code.missiongoogle.practices;

import java.util.Scanner;

public class ArrayPractices {
    /*public static int sortedArray(int []array, int lenght){
        if (lenght == 1 || lenght == 0){
            return  0;
        }
        for (int i = 0; i < lenght; i++) {
            if (array[i + 1] > array[i]){
                return  1;
            }
        }
        return 0;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Marge Array */
        System.out.print("Enter the number of element in the first array: ");
        int n1 = sc.nextInt();
        int []a1 =  new int[n1];

        System.out.println("Enter the element: ");
        for (int i = 0; i < n1; i++) {
            a1[i] = sc.nextInt();
        }

        System.out.print("Enter the number of element in the second array: ");
        int n2 = sc.nextInt();
        int []a2 =  new int[n2];
        System.out.println("Enter the element: ");
        for (int i = 0; i < n2; i++) {
            a2[i] = sc.nextInt();
        }
        int m = n1 + n2;
        int []a3 = new int[m];
        int index = 0;

        for (int i = 0; i < n1; i++) {
            a3[index] = a1[i];
            index++;
        }

        for (int i = 0; i < n2; i++) {
            a3[index] = a2[i];
            index++;
        }

        System.out.println("After marging array");
        for (int i = 0; i < m; i++) {
            System.out.print(" "+a3[i]);
        }
        /*System.out.print("Enter the number of element in the array: ");
        int n = sc.nextInt();
        int []a1 =  new int[n];
        System.out.println("Enter the element: ");
        for (int i = 0; i < n; i++) {
            a1[i] = sc.nextInt();
        }*/

        /*System.out.println("Array");
        for (int i = 0; i < a1.length; i++) {
            System.out.print(" "+a1[i]);
        }

        System.out.println("\nReverse Array: ");
        for (int i = a1.length-1; i >= 0; i--) {
            System.out.print(" "+a1[i]);
        }*/

        /*System.out.println("\n Ascending order");

        for (int i = 0; i < a1.length; i++) {
            for (int k = i+1; k < a1.length; k++) {
                if (a1[i] > a1[k]) {
                    temp = a1[i];
                    a1[i] = a1[k];
                    a1[k] = temp;

                }
            }
            System.out.print(" "+a1[i]);

        }*/


        /*System.out.println("\n Descending order");
        for (int i = 0; i < a1.length; i++) {
            for (int k = i+1; k < a1.length; k++) {
                if (a1[i] < a1[k]){
                    temp = a1[i];
                    a1[i] = a1[k];
                    a1[k] = temp;
                }
            }
            System.out.print(" "+a1[i]);
        }

        int sum = 0;
        for (int i = 0; i < a1.length; i++) {
            sum += a1[i];
        }
        System.out.printf("\nSum of array = %d\n",sum);
        System.out.printf("Mean = %.2f",(float)sum/n);*/
        /* 4,5,2,7,1,8,*/


        /*Find second large element in the array*/

        /*int large = a1[0], pos = 0,second_lerge = a1[1];
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] > large){
                large = a1[i];
                pos = i;
            }
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != large){
                if (a1[i] > second_lerge){
                    second_lerge = a1[i];
                }
            }
        }
        System.out.println("Second large "+second_lerge);*/

        /*Find duplicate element in the array*/

        /*int flag = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int k = i + 1; k < a1.length; k++) {
                if (a1[i] == a1[k] && i != k){
                    flag = 1;
                    System.out.printf("Duplicate number %d %d ",i+1,k+1);
                }
            }
        }
        if (flag == 0){
            System.out.println("Not duplicate number");
        }*/

        /* Insert array at any position */

        /*int []array = new int[20];
        System.out.println("Enter the number of element in the array: ");
        int e = sc.nextInt();
        System.out.println("Enter the element: ");
        for (int i = 0; i < e; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the position where data you have to be inserted: ");
        int pos = sc.nextInt();
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        for (int i = e - 1; i >= pos ; i--)
        {
            array[i + 1] = array[i];
            array[pos] = num;
            e = e + 1;
        }
        for (int i = 0; i < e; i++) {
            System.out.print(" "+array[i]);
        }*/
        /*int []array = new int[20];
        int asen = 1, des = 1, i;
        System.out.println("Enter the number of element in the array: ");
        int e = sc.nextInt();
        System.out.println("Enter the element: ");
        for ( i = 0; i < e; i++) {
            array[i] = sc.nextInt();
        }*/

        /*for (int i = 0; i < array.length; i++) {
            for (int j = i + 1 ; j < array.length; j++) {
                if (array[i] > array[j]){
                    flag = true;
                    break;
                }
                else
                    flag = false;
            }
        }*/
        /*i = 0;
        while (i < e-1){
            if (array[i] > array[i+1] ){
                asen = 0;
            }
            else
                des = 0;
        }
        if (asen == 1){
            System.out.println("Array sorted in ascending order");
        }
        else if (des == 1){
            System.out.println("Array sorted in descending order");

        }
        else
            System.out.println("Array is not sorted");*/

        /*Delete element in the given position*/
        /*int []array = new int[20];
        System.out.println("Enter the number of element in the array: ");
        int e = sc.nextInt();
        System.out.println("Enter the element: ");
        for (int i = 0; i < e; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the position where data you have to be inserted: ");
        int pos = sc.nextInt();

        for (int i = pos; i < e - 1 ; i++) {
                array[i] = array[i+1];
            e--;
        }
        System.out.println("After delete the position");
        for (int i = 0; i < e; i++) {
            System.out.println(array[i]);
        }*/
    }
}
