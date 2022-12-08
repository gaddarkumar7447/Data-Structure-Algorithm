package code.missiongoogle.dsa;

public class Recursion {
    /*static int fun1(int x, int y)
    {
        if (x == 0)
            return y;
        else
            return fun1(x - 1, x + y);
    }*/

    /*static int fun1(int n)
    {
        if (n == 1)
            return 0;
        else
            return 1 + fun1(n / 2);
    }*/

   /* static void fun2(int n)
    {
        if(n == 0)
            return;

        fun2(n/2);
        System.out.print(" "+n%2);
    }*/

   /* static void fun1(int n)
    {
        int i = 0;
        if (n > 1)
            fun1(n - 1);
        for (i = 0; i < n; i++)
            System.out.print(" * ");
    }
*/

    public static void print(int num){
        if (num == 0){
            return;
        }
        System.out.println("%d "+num%2);
        print(num/2);

    }

   static String fun2(String  str)

    {

        String s1=null;
        for(int i = str.length()-1; i > 0; i-- ){
            s1+=str.charAt(i);
        }

        return str;
    }
        /*if (n <= 0) return;
        if (n > 1000) return;

        System.out.print(String.format("%d ", n));
        fun2(2 * n);
        System.out.print(String.format("%d ", n));*/

        /*if(i ==str.length()){
            return "";
        }else{
            return fun2(str,i+1)+ str.charAt(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(fun2("",0));
    }*/
}
