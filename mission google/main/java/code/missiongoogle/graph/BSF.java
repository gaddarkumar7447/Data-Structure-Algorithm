package code.missiongoogle.graph;

import java.util.*;

public class BSF {
    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean []visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            for (int i : adj.get(node)) {
                if (!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            arrayLists.add(new ArrayList<>());
        }
        arrayLists.get(0).add(1);
        arrayLists.get(0).add(2);
        arrayLists.get(0).add(3);
        arrayLists.get(2).add(4);
        arrayLists.get(1).add(9);
        System.out.println(bfsOfGraph(4, arrayLists));
    }
}
