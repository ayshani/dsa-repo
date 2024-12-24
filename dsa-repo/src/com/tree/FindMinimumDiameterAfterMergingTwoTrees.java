package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
3203. Find Minimum Diameter After Merging Two Trees

There exist two undirected trees with n and m nodes, numbered from 0 to n - 1 and from 0 to m - 1, respectively. You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.

You must connect one node from the first tree with another node from the second tree with an edge.

Return the minimum possible diameter of the resulting tree.

The diameter of a tree is the length of the longest path between any two nodes in the tree.



Example 1:
Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]

TC : o(m+n)
SC: o(m+n)
 */
public class FindMinimumDiameterAfterMergingTwoTrees {

    public static void main(String[] args) {
        System.out.println(new FindMinimumDiameterAfterMergingTwoTrees().minimumDiameterAfterMerge(
                new int[][]{{0,1},{0,2},{0,3}}, new int[][]{{0,1}}
        ));
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Calculate the number of nodes for each tree (number of edges + 1)
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build adjacency lists for both trees
        List<List<Integer>> adjList1 = buildAdjList(n, edges1);
        List<List<Integer>> adjList2 = buildAdjList(m, edges2);

        // Calculate the diameter of both trees
        int diameter1 = findDiameter(n, adjList1);
        int diameter2 = findDiameter(m, adjList2);

        // Calculate the longest path that spans across both trees
        int combinedDiameter =
                (int) Math.ceil(diameter1 / 2.0) +
                        (int) Math.ceil(diameter2 / 2.0) +
                        1;

        // Return the maximum of the three possibilities
        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }

    // Function to build an adjacency list from an edge list
    private List<List<Integer>> buildAdjList(int size, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    // Function to find the diameter of a tree
    private int findDiameter(int n, List<List<Integer>> adjList) {
        Queue<Integer> leavesQueue = new LinkedList<>();
        int[] degrees = new int[n];

        // Initialize the degree of each node and add leaves (nodes with degree 1) to the queue
        for (int node = 0; node < n; node++) {
            degrees[node] = adjList.get(node).size();
            if (degrees[node] == 1) {
                leavesQueue.offer(node);
            }
        }

        int remainingNodes = n;
        int leavesLayersRemoved = 0;

        // Process the leaves until there are 2 or fewer nodes remaining
        while (remainingNodes > 2) {
            int size = leavesQueue.size();
            remainingNodes -= size;
            leavesLayersRemoved++;

            // Remove the leaves from the queue and update the degrees of their neighbors
            for (int i = 0; i < size; i++) {
                int currentNode = leavesQueue.poll();

                // Process the neighbors of the current leaf
                for (int neighbor : adjList.get(currentNode)) {
                    degrees[neighbor]--;
                    if (degrees[neighbor] == 1) {
                        leavesQueue.offer(neighbor);
                    }
                }
            }
        }

        // If exactly two nodes remain, return the diameter as twice the number of layers of leaves removed + 1
        if (remainingNodes == 2) return 2 * leavesLayersRemoved + 1;

        return 2 * leavesLayersRemoved;
    }
}
