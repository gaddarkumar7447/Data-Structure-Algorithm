package code.missiongoogle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.*;
import java.util.Locale;
import java.util.Scanner;

public class Graph {
    /*static LinkedList<Integer> []adj;
    public Graph(int v){
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int des){
        adj[source].add(des);
        adj[des].add(source);
    }

    // BFS algorithm
    public int bsf(int source, int des){
        boolean []vis = new boolean[adj.length];
        int []parent = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        parent[source] = -1;
        while(!q.isEmpty()){
            int cur = q.poll();
            if (cur == des) break;
            for(int neighbor: adj[cur]){
                if (!vis[neighbor]){
                    q.add(neighbor);
                    vis[neighbor] = true;
                    parent[neighbor] = cur;
                }
            }
        }

        int dis = 0;
        int cur = des;
        while (parent[cur] != -1){
            System.out.print(cur+" -> ");
            cur = parent[cur];
            dis++;
        }
        return dis;
    }

    static int v  = -1;
    static int e = -1;
    public static void floydAlgo(int [][]matrix){
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if(matrix[i][j] > matrix[i][k] + matrix[k][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        System.out.println("Matrix");
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }*/


    /*private static LinkedList<Integer> []adjLists;
    private static boolean []visited;

    public Graph(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    public static void addEdge(int src, int dest) {
        adjLists[src].add(dest);
        System.out.print(adjLists[src].add(dest)+" ");
    }*/

    // DFS algorithm
    /*public static void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();

        while(ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }*/

    /*public static void addAdM(int [][]mat, int src, int des){
        mat[src][des] = 1;
        mat[des][src] = 1;
    }
    public static void addAdL(List<List<Integer>> adj, int src, int des){
        adj.get(src).add(des);
        adj.get(des).add(src);
    }*/

    private  LinkedList<Integer> []adj;
    private  int vertex;
    private  Queue<Integer> queue;

    Graph(int v){
        this.vertex = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<>();
    }

    public void addEdge(int vertex, int edge){
        adj[vertex].add(edge);
    }

    public void BFS(int n){
         boolean []visited = new boolean[vertex];
         int a = 0;
         visited[n] = true;
         queue.add(n);
         while(queue.size() != 0){
             n = queue.poll();
             System.out.print(n+" ");

             for (int i = 0; i < adj[n].size(); i++) {
                 a = adj[n].get(i);
                 if (!visited[a]){
                     visited[a] = true;
                     queue.add(a);
                 }
             }
         }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,4);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(4,5);
        g.addEdge(3,5);
        g.addEdge(2,1);
        g.addEdge(5,4);
        g.addEdge(5,3);
        g.addEdge(1,0);
        g.addEdge(4,0);
        g.BFS(5);





        /*Queue<Integer> queue = new LinkedList<>();
        queue.add(546);
        queue.add(14);
        queue.add(45);
        queue.add(36);
        System.out.println(queue.peek());
        System.out.println(queue);*/

        /*Adjacency matrix*/
        /*int e = 4, v = 4;
        int [][]matrix = new int[v+1][e+1];
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[0][2] = 1;
        matrix[2][0] = 1;
        matrix[1][2] = 1;
        matrix[2][1] = 1;
        matrix[2][3] = 1;
        matrix[3][2] = 1;

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < e; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }*/

        /*Adjacency List*/

        /*int v = 3, e = 3;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= e; i++) {
            list.add(new ArrayList<>());
        }
        list.get(1).add(2);
        list.get(2).add(1);
        list.get(2).add(3);
        list.get(3).add(2);
        list.get(1).add(3);
        list.get(3).add(1);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)+" --> ");
            }
            System.out.println();
        }*/

        /*Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal");*/

        //g.DFS(2);

        /*Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int [][]matrix = new int[v][e];
        for (int i = 0; i < v; i++) {
            int vertex = sc.nextInt();
            int edge = sc.nextInt();
            int wet = sc.nextInt();
        }

        for (int i = 0; i < e; i++) {
            for (int j = 0; j < e; j++) {
                if (i == j) matrix[i][j] = 0;
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        floydAlgo(matrix);*/


        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edge: ");
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(v);
        System.out.println("Enter "+e+" edges");
        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();
            g.addEdge(source,dest);
        }

        System.out.println("Enter source and destination");
        int s = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(g.bsf(s,d));*/



        /*Graph a = new Graph();
        a.add();
        a.sub(10,5);
        System.out.println(a.mul());
        System.out.println(a.div(10,3));*/
        /*Mobile mobile = new Mobile();
        mobile.makeCall();
        mobile.sendMessage();
        mobile.takePicture();*/

       /* Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();*/

        /* Create custom Locale for India.
          I used the "IANA Language Subtag Registry" to find India's country code */
//        Locale indiaLocale = new Locale("en", "IN");

        /* Create NumberFormats using Locales */
       /* NumberFormat us     = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india  = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china  = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);*/

        /* Print output */
        /*System.out.println("US: "     + us.format(payment));
        System.out.println("India: "  + india.format(payment));
        System.out.println("China: "  + china.format(payment));
        System.out.println("France: " + france.format(payment));*/
        /*Scanner sc = new Scanner(System.in);
        double pay = sc.nextDouble();
        sc.close();
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        String us = n.format(pay);

        NumberFormat n1 = NumberFormat.getNumberInstance();
        String in = n1.format(pay);

        NumberFormat n2 = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String ch = n2.format(pay);

        NumberFormat n3 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = n3.format(pay);

        System.out.println("US: "+us);
        System.out.printf("India: Rs.%f",Integer.parseInt(in));
        System.out.println("China: "+ch);
        System.out.println("France: "+france);*/


    }


}
