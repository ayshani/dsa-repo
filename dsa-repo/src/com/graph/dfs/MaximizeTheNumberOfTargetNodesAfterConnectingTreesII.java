package com.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
3373. Maximize the Number of Target Nodes After Connecting Trees II

There exist two undirected trees with n and m nodes, labeled from [0, n - 1] and [0, m - 1], respectively.

You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.

Node u is target to node v if the number of edges on the path from u to v is even. Note that a node is always target to itself.

Return an array of n integers answer, where answer[i] is the maximum possible number of nodes that are target to node i of the first tree if you had to connect one node from the first tree to another node in the second tree.

Note that queries are independent from each other. That is, for every query you will remove the added edge before proceeding to the next query.



Example 1:

Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]

Output: [8,7,7,8,8]

Explanation:

For i = 0, connect node 0 from the first tree to node 0 from the second tree.
For i = 1, connect node 1 from the first tree to node 4 from the second tree.
For i = 2, connect node 2 from the first tree to node 7 from the second tree.
For i = 3, connect node 3 from the first tree to node 0 from the second tree.
For i = 4, connect node 4 from the first tree to node 4 from the second tree.

TC : o(n+m)
SC: o(n+m)
 */
public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaximizeTheNumberOfTargetNodesAfterConnectingTreesII().maxTargetNodes(
            new int[][]{{0,1},{0,2},{2,3},{2,4}}, new int[][]{{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}}
        )));
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] color1 = new int[n];
        int[] color2 = new int[m];
        int[] count1 = build(edges1, color1);
        int[] count2 = build(edges2, color2);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[color1[i]] + Math.max(count2[0], count2[1]);
        }
        return res;
    }

    private int[] build(int[][] edges, int[] color) {
        int n = edges.length + 1;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int res = dfs(0, -1, 0, children, color);
        return new int[] { res, n - res };
    }

    private int dfs(
            int node,
            int parent,
            int depth,
            List<List<Integer>> children,
            int[] color
    ) {
        int res = 1 - (depth % 2);
        color[node] = depth % 2;
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, depth + 1, children, color);
        }
        return res;
    }
}
