package code.missiongoogle;

import java.util.Scanner;
import static java.lang.System.out;

public class KnapSack {

    public static void main(String[] args) {

       /*Scanner sc=new Scanner(System.in);
        int object,m;
        System.out.println("Enter the Total Objects");
        object=sc.nextInt();
        int weight[]=new int[object];
        int profit[]=new int[object];
        for(int i=0;i<object;i++)
        {
            System.out.println("Enter the Profit");
            profit[i]=sc.nextInt();
            System.out.println("Enter the weight");
            weight[i]=sc.nextInt();
        }
        System.out.println("Enter the Knapsack capacity");
        m=sc.nextInt();
        double p_w[] = new double[object];
        for(int i=0;i<object;i++)
        {
            p_w[i]=(double)profit[i]/(double)weight[i];
        }
        System.out.println("");
        System.out.println("-------------------");
        System.out.println("-----Data-Set------");
        System.out.print("-------------------");
        System.out.println("");
        System.out.print("Objects");
        for(int i=1;i<=object;i++)
        {
            System.out.print(i+"    ");
        }
        System.out.println();
        System.out.print("Profit ");
        for(int i=0;i<object;i++)
        {
            System.out.print(profit[i]+"    ");
        }
        System.out.println();
        System.out.print("Weight ");
        for(int i=0;i<object;i++)
        {
            System.out.print(weight[i]+"    ");
        }
        System.out.println();
        System.out.print("P/W    ");
        for(int i=0;i<object;i++)
        {
            System.out.print(p_w[i]+"  ");
        }

        for(int i=0;i<object-1;i++)
        {
            for(int j=i+1;j<object;j++)
            {
                if(p_w[i]<p_w[j])
                {
                    double temp=p_w[j];
                    p_w[j]=p_w[i];
                    p_w[i]=temp;

                    int temp1=profit[j];
                    profit[j]=profit[i];
                    profit[i]=temp1;

                    int temp2=weight[j];
                    weight[j]=weight[i];
                    weight[i]=temp2;
                }
            }
        }
        System.out.println("");
        System.out.println("-------------------");
        System.out.println("--After Arranging--");
        System.out.print("-------------------");
        System.out.println("");
        System.out.print("Objects");
        for(int i=1;i<=object;i++)
        {
            System.out.print(i+"    ");
        }
        System.out.println();
        System.out.print("Profit ");
        for(int i=0;i<object;i++)
        {
            System.out.print(profit[i]+"    ");
        }
        System.out.println();
        System.out.print("Weight ");
        for(int i=0;i<object;i++)
        {
            System.out.print(weight[i]+"    ");
        }
        System.out.println();
        System.out.print("P/W    ");
        for(int i=0;i<object;i++)
        {
            System.out.print(p_w[i]+"  ");
        }
        int k=0;
        double sum=0;
        System.out.println();
        while(m > 0)
        {
            if(weight[k] < m)
            {
                sum += 1 * profit[k];
                m = m - weight[k];
            }
            else
            {
                double x4 = m * profit[k];
                double x5 = weight[k];
                double x6 = x4/x5;
                sum = sum + x6;
                m = 0;
            }
            k++;
        }
        System.out.println("Final Profit is="+sum);*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the object: ");
        int object = sc.nextInt();
        int []obj = new int[object];
        int []pro = new int[object];
        int []wet = new int[object];
        double []pro_wet =new double[object];
        for (int i = 0; i < object; i++) {
            System.out.println("Enter profit: ");
            pro[i] = sc.nextInt();
            System.out.println("Enter the weight:");
            wet[i] = sc.nextInt();
        }
        for (int i = 0; i < object; i++) {
            pro_wet[i] = (double) pro[i]/ (double) wet[i];
        }
        System.out.println("\t\t\tData");
        System.out.println("-------------------------------");
        System.out.print("Profit- ");
        for (int i = 0; i < object; i++) {
            System.out.print("  "+pro[i]);
        }
        System.out.println();
        System.out.print("Weight- ");
        for (int i = 0; i < object; i++) {
            System.out.print("  "+wet[i]);
        }
        System.out.println();
        System.out.print("Pro/wet: ");
        for (int i = 0; i < object; i++) {
            System.out.print(" "+pro_wet[i]);
        }
        System.out.println();
        System.out.println("\t\tArranging order");
        System.out.println("-----------------------------");
        for (int i = 0; i < object; i++) {
            for (int j = i+1; j < object-1; j++) {
                if (pro_wet[i]<pro_wet[j]){
                    double tem = pro_wet[i];
                    pro_wet[i] = pro_wet[j];
                    pro_wet[j] = tem;

                    int tem1 = pro[i];
                    pro[i] = pro[j];
                    pro[j] = tem1;

                    int tem2 = wet[i];
                    wet[i] = wet[j];
                    wet[j] = tem2;
                }
            }
        }
        System.out.print("Profit: ");
        for (int i = 0; i < object; i++) {
            System.out.print(" "+pro[i]);
        }
        System.out.println();
        System.out.print("Weight: ");
        for (int i = 0; i < object; i++) {
            System.out.print(" "+wet[i]);

        }
        System.out.println();
        System.out.print("Pro/Wet: ");
        for (int i = 0; i < object; i++) {
            System.out.print(" "+pro_wet[i]);
        }
        System.out.println();
        System.out.println("Enter the capacity: ");
        int cap = sc.nextInt();
        int k = 0;
        double sum = 0;
        while(cap > 0){
            if (wet[k] < cap){
                sum +=  pro[k];
                cap = cap- wet[k];
            }
            else {
                sum += (double) (cap * pro[k])/wet[k];
                cap = 0;
            }
            k++;
        }
        System.out.println(sum);
    }
}
