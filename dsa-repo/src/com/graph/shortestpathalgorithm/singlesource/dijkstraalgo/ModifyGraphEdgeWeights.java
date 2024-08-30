package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.Arrays;

/*
2699. Modify Graph Edge Weights

You are given an undirected weighted connected graph containing n nodes labeled from 0 to n - 1, and an integer
array edges where edges[i] = [ai, bi, wi] indicates that there is an edge between nodes ai and bi with weight wi.

Some edges have a weight of -1 (wi = -1), while others have a positive weight (wi > 0).

Your task is to modify all edges with a weight of -1 by assigning them positive integer values in the range
[1, 2 * 109] so that the shortest distance between the nodes source and destination becomes equal to an integer
target. If there are multiple modifications that make the shortest distance between source and destination equal
to target, any of them will be considered correct.

Return an array containing all edges (even unmodified ones) in any order if it is possible to make the shortest
distance from source to destination equal to target, or an empty array if it's impossible.

Note: You are not allowed to modify the weights of edges with initial positive weights.

Example 1:
Input: n = 5, edges = [[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]], source = 0, destination = 1, target = 5
Output: [[4,1,1],[2,0,1],[0,3,3],[4,3,1]]
Explanation: The graph above shows a possible modification to the edges, making the distance from 0 to 1 equal to 5.


TC : o(E*V*v)
SC: o(V*V)
 */
public class ModifyGraphEdgeWeights {

    public static void main(String[] args) {
        int[][] res = new ModifyGraphEdgeWeights().modifiedGraphEdges(
                5, new int[][]{{4,1,-1},{2,0,-1},{0,3,-1},{4,3,-1}}, 0,1,5
        );
        Arrays.stream(res).forEach(e-> System.out.println(Arrays.toString(e)));
    }
    private static final int INF = (int) 2e9;

    public int[][] modifiedGraphEdges(
            int n,
            int[][] edges,
            int source,
            int destination,
            int target
    ) {
        // Step 1: Compute the initial shortest distance from source to destination
        long currentShortestDistance = runDijkstra(
                edges,
                n,
                source,
                destination
        );

        // If the current shortest distance is less than the target, return an empty result
        if (currentShortestDistance < target) return new int[0][0];

        boolean matchesTarget = (currentShortestDistance == target);

        // Step 2: Iterate through each edge to adjust its weight if necessary
        for (int[] edge : edges) {
            // Skip edges that already have a positive weight
            if (edge[2] > 0) continue;

            // Set edge weight to a large value if current distance matches target, else set to 1
            edge[2] = matchesTarget ? INF : 1;

            // Step 3: If current shortest distance does not match target
            if (!matchesTarget) {
                // Compute the new shortest distance with the updated edge weight
                long newDistance = runDijkstra(edges, n, source, destination);
                // If the new distance is within the target range, update edge weight to match target
                if (newDistance <= target) {
                    matchesTarget = true;
                    edge[2] += target - newDistance;
                }
            }
        }

        // Return modified edges if the target distance is achieved, otherwise return an empty result
        return matchesTarget ? edges : new int[0][0];
    }

    // Dijkstra's algorithm to find the shortest path distance
    private long runDijkstra(
            int[][] edges,
            int n,
            int source,
            int destination
    ) {
        // Step 1: Initialize adjacency matrix and distance arrays
        long[][] adjMatrix = new long[n][n];
        long[] minDistance = new long[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(minDistance, INF);
        for (long[] row : adjMatrix) {
            Arrays.fill(row, INF);
        }

        // Set the distance to the source node as 0
        minDistance[source] = 0;

        // Step 2: Fill the adjacency matrix with edge weights
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                adjMatrix[edge[0]][edge[1]] = edge[2];
                adjMatrix[edge[1]][edge[0]] = edge[2];
            }
        }

        // Step 3: Perform Dijkstra's algorithm
        for (int i = 0; i < n; ++i) {
            // Find the nearest unvisited node
            int nearestUnvisitedNode = -1;
            for (int j = 0; j < n; ++j) {
                if (
                        !visited[j] &&
                                (nearestUnvisitedNode == -1 ||
                                        minDistance[j] < minDistance[nearestUnvisitedNode])
                ) {
                    nearestUnvisitedNode = j;
                }
            }
            // Mark the nearest node as visited
            visited[nearestUnvisitedNode] = true;

            // Update the minimum distance for each adjacent node
            for (int v = 0; v < n; ++v) {
                minDistance[v] = Math.min(
                        minDistance[v],
                        minDistance[nearestUnvisitedNode] +
                                adjMatrix[nearestUnvisitedNode][v]
                );
            }
        }

        // Return the shortest distance to the destination node
        return minDistance[destination];
    }
}
