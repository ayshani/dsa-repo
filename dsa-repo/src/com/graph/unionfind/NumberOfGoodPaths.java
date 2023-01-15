package com.graph.unionfind;

import java.util.*;

/*
2421. Number of Good Paths

There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n
nodes numbered from 0 to n - 1 and exactly n - 1 edges.

You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node.
You are also given a 2D integer array edges where edges[i] = [ai, bi]
denotes that there exists an undirected edge connecting nodes ai and bi.

A good path is a simple path that satisfies the following conditions:

The starting node and the ending node have the same value.
All nodes between the starting node and the ending node have values less than or equal to the starting
node (i.e. the starting node's value should be the maximum value along the path).
Return the number of distinct good paths.

Note that a path and its reverse are counted as the same path. For example, 0 -> 1 is considered to
be the same as 1 -> 0. A single node is also considered as a valid path.

Example 1:
Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
Output: 6
Explanation: There are 5 good paths consisting of a single node.
There is 1 additional good path: 1 -> 0 -> 2 -> 4.
(The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.)
Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0].

Complexity Analysis
------------------------
Here, n is the number of nodes.

Time complexity: O(n⋅log(n))

For T operations, the amortized time complexity of the union-find algorithm (using path compression with union by rank)
is O(alpha(T)). Here, alpha(T) is the inverse Ackermann function that grows so slowly,
that it doesn't exceed 4 for all reasonable T (approximately T < 10^{600}.
You can read more about the complexity of union-find here. Because the function grows so slowly,
we consider it to be O(1). We iterate over each edge once from the larger value node to the smaller one,
or if the neighbours (nodes that share an edge) have equal value, we iterate that edge twice, which is also linear.
To iterate over n−1 edges, we have to perform O(n) operations which needs O(n) time.
We also need a map valuesToNodes having sorted keys.
Each operation in such a data structure comes with a log factor. We push all the n nodes into the map and
iterate over all of them, which further adds O(n⋅log(n))) time.
The group map has unsorted keys, and each of its operation takes O(1) time on average.
We need O(n) time to iterate through all of the nodes to find the set size using it.
Additionally, we need O(n) time each to initialize the adj, parent and rank arrays.

Space complexity: O(n)

We require O(n) space each for the adj, parent and rank arrays.
We also require O(n) space for the valuesToNodes and the group maps.
 */
public class NumberOfGoodPaths {

    public static void main(String[] args) {
        int[] vals = new int[]{1,3,2,1,3};
        int[][] edges = new int[][]{
                {0,1},{0,2},{2,3},{2,4}
        };
        System.out.println(new NumberOfGoodPaths().numberOfGoodPaths(vals,edges));
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int n = vals.length;
        // Mapping from value to all the nodes having the same value in sorted order of
        // values.
        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i);
        }

        UnionFind dsu = new UnionFind(n);
        int goodPaths = 0;

        // Iterate over all the nodes with the same value in sorted order, starting from
        // the lowest value.
        for (int value : valuesToNodes.keySet()) {
            // For every node in nodes, combine the sets of the node and its neighbors into
            // one set.
            for (int node : valuesToNodes.get(value)) {
                if (!adj.containsKey(node))
                    continue;
                for (int neighbor : adj.get(node)) {
                    // Only choose neighbors with a smaller value, as there is no point in
                    // traversing to other neighbors.
                    if (vals[node] >= vals[neighbor]) {
                        dsu.union(node, neighbor);
                    }
                }
            }
            // Map to compute the number of nodes under observation (with the same values)
            // in each of the sets.
            Map<Integer, Integer> group = new HashMap<>();
            // Iterate over all the nodes. Get the set of each node and increase the count
            // of the set by 1.
            for (int u : valuesToNodes.get(value)) {
                group.put(dsu.find(u), group.getOrDefault(dsu.find(u), 0) + 1);
            }
            // For each set of "size", add size * (size + 1) / 2 to the number of goodPaths.
            for (int key : group.keySet()) {
                int size = group.get(key);
                goodPaths += size * (size + 1) / 2;
            }
        }
        return goodPaths;
    }
}
