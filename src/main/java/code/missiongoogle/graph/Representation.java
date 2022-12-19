package code.missiongoogle.graph;

import java.util.ArrayList;

public class Representation {
    public static void main(String[] args) {
        int m = 3, n = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);

        // Undirected Graph
        // adj.get(u).add(v);
        // adj.get(v).add(u);

        // Directed Graph
        // adj.get(u).add(v);

        adj.get(2).add(3);
        adj.get(3).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(10);
        System.out.println(adj);


        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++){
                System.out.println(adj.get(i).get(j));
            }
        }*/
    }
}
