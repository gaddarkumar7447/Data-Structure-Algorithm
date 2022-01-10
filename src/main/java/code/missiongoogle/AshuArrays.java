package code.missiongoogle;

public class AshuArrays {

    public static void reverseArray(int[] a) {
        int i;
        for (i = 0; i < a.length / 2; i++) {
            /*X,Y
             * x= x*y;
             * y=x/y
             * x=x/y
             *
             *
             * */
            a[i] = a[i] * a[a.length - i - 1];
            a[a.length - i - 1] = a[i] / a[a.length - i - 1];
            a[i] = a[i] / a[a.length - i - 1];
        }


        for (int val : a) {
            System.out.print(val + ",");
        }
    }


    public static void sortCheck(int[] a) {
        System.out.println(sortedInAsendingOrder(a));
        System.out.println(sortedInDesendingOrder(a));


    }

    private static String sortedInDesendingOrder(int[] a) {
        boolean isSorted=true;
        for (int i=1;i<a.length;i++){
            if(a[i-1]<a[i])
                isSorted=false;
        }
        return isSorted? "Sorted in desending order": "Not sorted in desending order";
    }

    private static String sortedInAsendingOrder(int[] a) {
        boolean isSorted=true;
        for (int i=1;i<a.length;i++){
            if(a[i-1]>a[i])
                isSorted=false;
        }
        return isSorted? "Sorted in asending order": "Not sorted in asending order";
    }
}
