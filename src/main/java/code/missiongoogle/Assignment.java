package code.missiongoogle;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public  class Assignment {
    /*Assignment 2*/
    /*1.*/private static void primeOrNot(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the  number :");
        int num = sc.nextInt();
        if (num == 0 || num == 1) System.out.println("Not prime number");
        boolean flag = false;
        for (int i = 2; i <= num/2; i++){
            if (num % i == 0){
                flag = true;
                break;
            }
        }
        if (flag) System.out.println("Not prime");
        else System.out.println("Prime");
    }

    /*2.*/private static void nthFibonacciNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        int a = 0, b = 1;
        int c = 0;
        for (int i = 2; i < num; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        System.out.println(num+"nth fibonacci series : "+c);
    }
    /*3.*/private static void reverse(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        int reverse = 0;
        while (num != 0){
            int rem = num % 10;
            reverse = reverse * 10 + rem;
            num /= 10;
        }
        System.out.println(reverse);
    }
    /*4.*/ private static void allPrimeNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        boolean flag = false;
        for (int i = 2; i < num; i++){
            if (checkPrime(i)){
                System.out.print(i+" ");
            }
        }
    }

    private static boolean checkPrime(int num){
        if (num == 0 || num == 1) System.out.println("Not prime number");
        boolean flag = false;
        for (int i = 2; i <= num/2; i++){
            if (num % i == 0){
                flag = true;
                break;
            }
        }
        return !flag;
    }

    /*5.*/private static void allFibonacciLessNum(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            if (fibo(i) < num) System.out.print(fibo(i)+" ");
        }
    }
    private static int fibo(int num){
        if (num == 0 || num == 1) return num;
        else return fibo(num - 1) + fibo(num - 2);
    }
    /*6.*/ private static void sumOfOddEven(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        int evenSum = 0, oddSum = 0;
        while (num != 0){
            int rem = num % 10;
            if (rem % 2 == 0){
                evenSum += rem;
            }else {
                oddSum += rem;
            }
            num /= 10;
        }
        System.out.println("Sum of even number: "+evenSum);
        System.out.println("Sum of odd number: "+oddSum);
    }
    /*7.*/ private static void pattern1(){
        int num = 4;
        int count = 1;
        for (int i = 0; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (j > 0 && j <= i){
                    System.out.print(count++ +" ");
                }
            }
            System.out.println();
        }
    }

    /*8.*/ private static void patten2(){

    }


    public static void main(String[] args) {
        System.out.println("Gaddar Kumar chaudhary");
    }
}
