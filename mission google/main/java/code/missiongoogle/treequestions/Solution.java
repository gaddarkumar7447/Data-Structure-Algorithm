package code.missiongoogle.treequestions;

import java.util.*;

class Solution {
    public static int longestPath(int[] parent, String s) {
        final int n = parent.length;
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int i = 1; i < n; ++i)
            graph[parent[i]].add(i); //adding every vertex

        longestPathDownFrom(graph, 0, s);//calling the function for max path
        return ans;
    }

    private static int ans = 0;

    private static int longestPathDownFrom(List<Integer>[] graph, int u, final String s) {
        int max1 = 0;
        int max2 = 0;

        for (final int v : graph[u]) {
            final int res = longestPathDownFrom(graph, v, s);
            if (s.charAt(u) == s.charAt(v))//equal charcters skipped
                continue;
            if (res > max1) //finding path with different charcters
            {
                max2 = max1;
                max1 = res;
            } else if (res > max2) {
                max2 = res;
            }
        }

        ans = Math.max(ans, 1 + max1 + max2);//finding max from every path
        return 1 + max1;//return the maximum length of path
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2};
        String s = "abacbe";
        System.out.println(longestPath(parent, s));
    }
}
