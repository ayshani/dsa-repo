package com.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
3372. Maximize the Number of Target Nodes After Connecting Trees I

There exist two undirected trees with n and m nodes, with distinct labels in ranges [0, n - 1] and [0, m - 1], respectively.

You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree. You are also given an integer k.

Node u is target to node v if the number of edges on the path from u to v is less than or equal to k. Note that a node is always target to itself.

Return an array of n integers answer, where answer[i] is the maximum possible number of nodes target to node i of the first tree if you have to connect one node from the first tree to another node in the second tree.

Note that queries are independent from each other. That is, for every query you will remove the added edge before proceeding to the next query.



Example 1:

Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2

Output: [9,7,9,8,8]

Explanation:

For i = 0, connect node 0 from the first tree to node 0 from the second tree.
For i = 1, connect node 1 from the first tree to node 0 from the second tree.
For i = 2, connect node 2 from the first tree to node 4 from the second tree.
For i = 3, connect node 3 from the first tree to node 4 from the second tree.
For i = 4, connect node 4 from the first tree to node 4 from the second tree.

TC : O(n^2+m^2)
SC: O(n+m)
 */
public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaximizeTheNumberOfTargetNodesAfterConnectingTreesI().maxTargetNodes(
                new int[][]{{0,1},{0,2},{2,3},{2,4}}, new int[][]{{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}}, 2
        )));
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] count1 = build(edges1, k);
        int[] count2 = build(edges2, k - 1);
        int maxCount2 = 0;
        for (int c : count2) {
            if (c > maxCount2) {
                maxCount2 = c;
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[i] + maxCount2;
        }
        return res;
    }

    private int[] build(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(i, -1, children, k);
        }
        return res;
    }

    private int dfs(int node, int parent, List<List<Integer>> children, int k) {
        if (k < 0) {
            return 0;
        }
        int res = 1;
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, children, k - 1);
        }
        return res;
    }
}
