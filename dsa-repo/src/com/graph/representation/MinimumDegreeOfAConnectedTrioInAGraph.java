package com.graph.representation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
1761. Minimum Degree of a Connected Trio in a Graph

You are given an undirected graph. You are given an integer n which is the number of nodes in the graph
and an array edges, where each edges[i] = [ui, vi] indicates that there is an undirected edge between ui and vi.

A connected trio is a set of three nodes where there is an edge between every pair of them.
The degree of a connected trio is the number of edges where one endpoint is in the trio, and the other is not.

Return the minimum degree of a connected trio in the graph, or -1 if the graph has no connected trios.

Example 1:
Input: n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
                4 - 1 - 2 - 5
                    | /
                    3 - 6
Output: 3
Explanation: There is exactly one trio, which is [1,2,3]. The edges that form its degree are bolded in the figure above.

Logic
------
For each pair, check if they have a common neighbor and calculate their degree.
Important optimizations:

t1 > t2 > t3, so we do not check the same triplet twice.
- For that, we can use a directed adjacency list (or matrix).
- In this case, we need to store counts for each node separately.
Use adjacency list with a set to quickly check for the common neighbor.

TC  : o(n^3)
 */
public class MinimumDegreeOfAConnectedTrioInAGraph {

    public static void main(String[] args) {
        int n = 7, e[][] = new int[][]{{1,3},{4,1},{4,3},{2,5},{5,6},{6,7},{7,5},{2,6}};
        System.out.println(new MinimumDegreeOfAConnectedTrioInAGraph().minTrioDegree(n,e));
    }
    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();   // node --> neighbors, only store smaller -> bigger to avoid duplicate
        int[] degree = new int[n+1];    // node 1 ~ n

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int from = Math.min(a, b);
            int to = Math.max(a, b);
            if (!map.containsKey(from)) {
                map.put(from, new HashSet<>());
            }
            map.get(from).add(to);
            degree[a]++;
            degree[b]++;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {      // it's sure that i < j < k
            Set<Integer> nexti = map.getOrDefault(i, new HashSet<>());
            for (int j : nexti) {
                Set<Integer> nextj = map.getOrDefault(j, new HashSet<>());
                for (int k : nextj) {
                    if (nexti.contains(k)) {    // find trio
                        int d = (degree[i] + degree[j] + degree[k]) - 6;     // 3 connected nodes has 3*2 degrees
                        min = Math.min(min, d);
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
