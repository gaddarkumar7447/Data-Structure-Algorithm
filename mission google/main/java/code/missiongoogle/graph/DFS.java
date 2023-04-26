package code.missiongoogle.graph;
import java.util.ArrayList;

public class DFS {
    public static void dfs(int node, boolean []visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list){
        visited[node] = true;
        list.add(node);
        for (Integer i : adj.get(node)){
            if (!visited[i]){
                dfs(i, visited, adj, list);
            }
        }
    }

    public static ArrayList<Integer> dfsGraph(int v, ArrayList<ArrayList<Integer>> adj){
        boolean []visited = new boolean[v + 1];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, visited, adj, list);
        return list;
    }

    // DFS practices

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            lists.add(new ArrayList<>());
        }
        lists.get(0).add(1);
        lists.get(0).add(2);
        lists.get(0).add(4);
        lists.get(4).add(3);

        System.out.println(dfsGraph(5, lists));

    }
}
