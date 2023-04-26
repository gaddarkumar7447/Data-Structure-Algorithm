package code.missiongoogle.graph;

import java.util.*;

public class GPractices {
    // BFS problem with the examples
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i : rooms.get(0)) {
            queue.add(i);
            visited[i] = true;
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j : rooms.get(i)) {
                if (!visited[j]) {
                    visited[j] = true;
                    queue.add(i);
                }
            }
        }
        for (boolean i : visited) {
            if (!i) {
                return false;
            }
        }
        return true;
    }

    // DFS Problem with the examples
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] mat = new int[image.length][image.length];
        return mat;
    }

    public static int findCircleNumber(int[][] mat) {
        boolean[] visited = new boolean[mat.length];
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            if (!visited[i]) {
                dfs1(mat, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs1(int[][] mat, boolean[] visited, int i) {
        for (int j = 0; j < mat.length; j++) {
            if (mat[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs1(mat, visited, j);
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i) {
        for (int j : adj.get(i)) {
            if (adj.get(i).get(j) == 1 && !visited[j]) {
                dfs(adj, visited, j);
            }
        }
    }

    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph.length == 0 || graph[0].length == 0)
            return res;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs11(graph, res, list, 0);

        return res;
    }

    public static void dfs11(int[][] graph, List<List<Integer>> res, List<Integer> list, int pos) {
        if (pos == graph.length - 1) {
            res.add(new ArrayList<>(list));
        } else {
            for (int d : graph[pos]) {
                list.add(d);
                dfs11(graph, res, list, d);
                list.remove(list.size() - 1);
            }
        }
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<Integer>(0));
        }
        System.out.println(map);
        boolean[] visited = new boolean[n];
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        return dfs(map, visited, hasApple, 0);
    }

    private static int dfs(List<List<Integer>> map, boolean[] visited, List<Boolean> hasApple, int index) {
        int result = 0;
        visited[index] = true;

        for (int i : map.get(index)) {
            if (!visited[i]) {
                result += dfs(map, visited, hasApple, i);
            }
        }
        if (index == 0) {
            return result;
        }
        return result += (hasApple.get(index) || result > 0) ? 2 : 0;
    }

    /*int []nums;
    List<List<Integer>> list;
    Set<Integer> visited;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        nums = new int[n];
        list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int []i : edges) {
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        visited = new HashSet<>();
        dfsCall(0, labels);
        return nums;
    }

    private int[] dfsCall(int node, String labels) {
        visited.add(node);
        int []count = new int[26];
        for (int i : list.get(node)){
            if (!visited.contains(i)){
                int []adjCount = dfsCall(i, labels);
                for (int j = 0; j < 26; j++){
                    count[j] += adjCount[j];
                }
            }
        }
        char ch = labels.charAt(node);
        count[ch - 'a']++;
        nums[node] = count[ch - 'a'];
        return count;
    }*/

    int[] result;
    List<List<Integer>> adj;
    boolean[] visited;

    //This function takes in the number of nodes in a tree, the edges that connect the nodes and the labels of the nodes
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        //Creating an adjacency list to store the edges
        adj = new ArrayList<>(n);
        result = new int[n];
        //initializing the adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        //populating the adjacency list with the edges
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        //keep track of visited nodes
        visited = new boolean[n];
        //calling the dfs function to count the subtrees starting from the root node
        dfs(0, labels);
        return result;
    }

    //dfs function to traverse the tree and count the subtrees
    int[] dfs(int node, String labels) {
        visited[node] = true;
        int[] count = new int[26];
        //visiting all the neighbours of the current node
        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                int[] adjCount = dfs(nbr, labels);
                //updating the count array with the count of the subtrees of the neighbours
                for (int i = 0; i < 26; i++) {
                    count[i] += adjCount[i];
                }
            }
        }
        //incrementing the count of the current node label
        char ch = labels.charAt(node);
        count[ch - 'a']++;
        //storing the count of the subtrees of the current node
        result[node] = count[ch - 'a'];
        return count;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        System.out.println(minTime(7, edges, new ArrayList<Boolean>()));
    }

}
