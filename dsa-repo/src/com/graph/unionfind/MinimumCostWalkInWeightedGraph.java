package com.graph.unionfind;

import java.util.Arrays;

/*
3108. Minimum Cost Walk in Weighted Graph

There is an undirected weighted graph with n vertices labeled from 0 to n - 1.

You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.

A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it. It's important to note that a walk may visit the same edge or vertex more than once.

The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.

You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk, the answer is -1.

Return the array answer, where answer[i] denotes the minimum cost of a walk for query i.



Example 1:

Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]]

Output: [1,-1]

Explanation:
To achieve the cost of 1 in the first query, we need to move on the following edges: 0->1 (weight 7), 1->2 (weight 1), 2->1 (weight 1), 1->3 (weight 7).

In the second query, there is no walk between nodes 3 and 4, so the answer is -1.

TC : o(n+q)
SC: o(n)
 */
public class MinimumCostWalkInWeightedGraph {

    int[] parent;
    int[] depth;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MinimumCostWalkInWeightedGraph().minimumCost(5,
                new int[][]{{0,1,7},{1,3,7},{1,2,1}}, new int[][]{{0,3},{3,4}})));
    }
    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        // Initialize the parent array with -1 as initially each node belongs to its own component
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = -1;

        depth = new int[n];

        // All values are initially set to the number with only 1s in its binary representation
        int[] componentCost = new int[n];
        for (int i = 0; i < n; i++) {
            componentCost[i] = Integer.MAX_VALUE;
        }

        // Construct the connected components of the graph
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        // Calculate the cost of each component by performing bitwise AND of all edge weights in it
        for (int[] edge : edges) {
            int root = find(edge[0]);
            componentCost[root] &= edge[2];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            // If the two nodes are in different connected components, return -1
            if (find(start) != find(end)) {
                answer[i] = -1;
            } else {
                // Find the root of the edge's component
                int root = find(start);
                // Return the precomputed cost of the component
                answer[i] = componentCost[root];
            }
        }
        return answer;
    }

    // Find function to return the root (representative) of a node's component
    private int find(int node) {
        // If the node is its own parent, it is the root of the component
        if (parent[node] == -1) return node;
        // Otherwise, recursively find the root and apply path compression
        return parent[node] = find(parent[node]);
    }

    // Union function to merge the components of two nodes
    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        // If the two nodes are already in the same component, do nothing
        if (root1 == root2) return;

        // Union by depth: ensure the root of the deeper tree becomes the parent
        if (depth[root1] < depth[root2]) {
            int temp = root1;
            root1 = root2;
            root2 = temp;
        }

        // Merge the two components by making root1 the parent of root2
        parent[root2] = root1;

        // If both components had the same depth, increase the depth of the new root
        if (depth[root1] == depth[root2]) {
            depth[root1]++;
        }
    }
}
