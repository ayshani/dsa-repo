package com.tree;

import java.util.*;

/*
2872. Maximum Number of K-Divisible Components

There is an undirected tree with n nodes labeled from 0 to n - 1. You are given the integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

You are also given a 0-indexed integer array values of length n, where values[i] is the value associated with the ith node, and an integer k.

A valid split of the tree is obtained by removing any set of edges, possibly empty, from the tree such that the resulting components all have values that are divisible by k, where the value of a connected component is the sum of the values of its nodes.

Return the maximum number of components in any valid split.



Example 1:
Input: n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
Output: 2
Explanation: We remove the edge connecting node 1 with 2. The resulting split is valid because:
- The value of the component containing nodes 1 and 3 is values[1] + values[3] = 12.
- The value of the component containing nodes 0, 2, and 4 is values[0] + values[2] + values[4] = 6.
It can be shown that no other valid split has more than 2 connected components.

TC : o(m+n)
SC: o(n)
 */
public class MaximumNumberOfKDivisibleComponents {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfKDivisibleComponents().maxKDivisibleComponents(
                5, new int[][]{{0,2},{1,2},{1,3},{2,4}}, new int[]{1,8,1,4,4}, 6
        ));
    }
    public int maxKDivisibleComponents(
            int n,
            int[][] edges,
            int[] values,
            int k
    ) {
        // Base case: if there are less than 2 nodes, return 1
        if (n < 2) return 1;

        int componentCount = 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        // Step 1: Build the graph
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            graph.computeIfAbsent(node1, key -> new HashSet<>()).add(node2);
            graph.computeIfAbsent(node2, key -> new HashSet<>()).add(node1);
        }

        // Convert values to long to prevent overflow
        long[] longValues = new long[values.length];
        for (int i = 0; i < values.length; i++) {
            longValues[i] = values[i];
        }

        // Step 2: Initialize the BFS queue with leaf nodes (nodes with only one connection)
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                queue.add(entry.getKey());
            }
        }

        // Step 3: Process nodes in BFS order
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            // Find the neighbor node
            int neighborNode = -1;
            if (
                    graph.get(currentNode) != null &&
                            !graph.get(currentNode).isEmpty()
            ) {
                neighborNode = graph.get(currentNode).iterator().next();
            }

            if (neighborNode >= 0) {
                // Remove the edge between current and neighbor
                graph.get(neighborNode).remove(currentNode);
                graph.get(currentNode).remove(neighborNode);
            }

            // Check divisibility of the current node's value
            if (longValues[currentNode] % k == 0) {
                componentCount++;
            } else if (neighborNode >= 0) {
                // Add current node's value to the neighbor
                longValues[neighborNode] += longValues[currentNode];
            }

            // If the neighbor becomes a leaf node, add it to the queue
            if (
                    neighborNode >= 0 &&
                            graph.get(neighborNode) != null &&
                            graph.get(neighborNode).size() == 1
            ) {
                queue.add(neighborNode);
            }
        }

        return componentCount;
    }
}
