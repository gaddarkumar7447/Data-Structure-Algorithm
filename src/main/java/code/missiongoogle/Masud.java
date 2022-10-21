package code.missiongoogle;


import java.util.*;

/*class Shape11{
    int x, y;
    public void getXY(){
        System.out.println("Enter the len and bre");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
    }
    public void showXY(){
        System.out.println("X: "+x + "Y: "+y);
    }
}
class Rect11 extends Shape11{
    int len, bre;
    @Override
    public void getXY() {
        super.getXY();
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        bre = sc.nextInt();
    }

    @Override
    public void showXY() {
        super.showXY();
        System.out.println("Area of the rectangle: "+len * bre);
    }
}


abstract class Dia{
    abstract void cal();
    abstract void dis();
}
class R extends Dia{
    int l, b;
    @Override
    void cal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and breath: ");
        l = sc.nextInt();
        b = sc.nextInt();
    }

    @Override
    void dis() {
        System.out.println("Area of Rectangle: "+l * b);
    }
}

class Tria extends Dia{
    int l, b, h;
    @Override
    void cal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and breath and heght ");
        l = sc.nextInt();
        b = sc.nextInt();
        h = sc.nextInt();
    }

    @Override
    void dis() {
        System.out.println("Area of Triangle: "+l * b * h);
    }
}*/
class Masud {

    /*static Node head;
        static class Node{
            int data;
            Node next;
            Node(int data){
                this.data = data;
                this.next = null;
            }
        }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
            Node last = new Node(data);
            if (head == null){
                head = last;
                return;
            }
            Node curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = last;
    }

    public void  deleteFirst(){
            if (head == null){
                System.out.println("list is empty");
                return;
            }
            head = head.next;
    }

    public void DeleteKey(int data){
        Node key = new Node(data);
        if (head == null){
            System.out.println("Head is already null");
            return;
        }
        Node cur = head;
        while (cur.next == key)
        {
            if (cur != key)
                System.out.println("This number is not present in the list");
            else
                cur = head.next;
        }

    }

    public void display(){
            Node cur = head;
            while (cur != null){
                System.out.print(" "+cur.data);
                cur = cur.next;
            }
        System.out.print(" -> Null");
    }

    *//*
    * Masud node = new Masud();
            node.addFirst(30);
            node.addLast(9000);
            node.addFirst(50);
            node.addFirst(40);
            node.addLast(1000);
            node.addLast(7000);
            node.DeleteKey(7000);
            node.display();*//*
     */
    public static void main(String[] args) {
        /*Comparator in java*/
        /*int[][] twoDim = {{1, 2}, {3, 7}, {8, 9}, {4, 2}, {5, 3}};
        Arrays.sort(twoDim, (a1, a2) -> a2[0] - a1[0]);
        System.out.println(Arrays.deepToString(twoDim));*/
        ArrayList student = new ArrayList<>();
        student.add(new Student(2, 14, "Gaddar"));
        student.add(new Student(5, 10, "Karan"));
        student.add(new Student(1, 17, "Ravi"));
        student.add(new Student(9, 18, "Sudan"));
        student.add(new Student(4, 11, "Kudan"));
        student.add(new Student(8, 15, "Madan"));

        Collections.sort(student, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.rollNumber - o2.rollNumber;
            }
        });

        for (Object o : student) {
            Student student1 = (Student) o;
            System.out.println(student1.age + " " + student1.rollNumber + " " + student1.name);
        }

    }
}

       /* int []nums = {12, 31, 25, 8, 32, 17, 40, 42};
        merge1(nums, 0, nums.length - 1);
        int []a = new int[3];
        a = Arrays.copyOfRange(nums,0,3);

        System.out.println(Arrays.toString(nums));*/

        /*
        * int n1 = (mid - l + 1);
        int n2 = (h - mid);

        int i , j, k;
        // 12 <= 31
        int []L = new int[n1];
        int []R = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = arr[l+i];
        }

        for (j = 0; j < n2; j++) {
            R[j] = arr[mid + j + 1];
        }

        i = 0; j = 0; k = l;

        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                arr[k++] = L[i++];
            }
            else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1){
            arr[k++] = L[i++];
        }

        while (j < n2){
            arr[k++] = R[j++];
        }
    }

    public static void  merge1(int []arr, int l,int h){
        if (l < h){
            int mid = (l+h) / 2;
            merge1(arr,l,mid);
            merge1(arr,mid+1,h);
            mergeSort(arr,l,mid,h);
        }
    }*/











/*
* // start = 0
    // end = 6
    public static int partition (int a[], int start, int end)
    {
        // pivote = 9
        int pivot = a[end]; // pivot element

        // i = 1
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++)
        {
            // j = 2
            // If current element is smaller than the pivot
            // a[3] = 12 < 9
            if (a[j] < pivot)
            {
                // {5,1,12,-5,8,4,9}
                i++; // increment index of smaller element
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i+1];
        a[i+1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    public static void quick(int a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */
   /* {
            // start = 0
            // end = 6
            if (start < end)
        {
        int p = partition(a, start, end); //p is the partitioning index
        quick(a, start, p - 1);
        quick(a, p + 1, end);
        }
        }

public static void printArr(int a[], int n)
        {
        int i;
        for (i = 0; i < n; i++){
        System.out.print(" "+a[i]);
        }

        }*/

/*
*  /*for (int i = 0; i < nums.length; i++){
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]){
                    index = j;
                    // -5
                    *//*int tem = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tem;*//*
                }
            }
            int tem = nums[index];
            nums[index] = nums[i];
            nums[i] = tem;;
        }
        System.out.println(Arrays.toString(nums));*/
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

/*
* /*int [] arr = {5,1,2,9,6,7,4};
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
