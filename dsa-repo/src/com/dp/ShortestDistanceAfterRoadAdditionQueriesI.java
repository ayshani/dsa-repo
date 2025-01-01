package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
3243. Shortest Distance After Road Addition Queries I

You are given an integer n and a 2D integer array queries.

There are n cities numbered from 0 to n - 1. Initially, there is a unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.

queries[i] = [ui, vi] represents the addition of a new unidirectional road from city ui to city vi. After each query, you need to find the length of the shortest path from city 0 to city n - 1.

Return an array answer where for each i in the range [0, queries.length - 1], answer[i] is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries.



Example 1:

Input: n = 5, queries = [[2,4],[0,2],[0,4]]

Output: [3,2,1]

Explanation:

After the addition of the road from 2 to 4, the length of the shortest path from 0 to 4 is 3.
After the addition of the road from 0 to 2, the length of the shortest path from 0 to 4 is 2.
After the addition of the road from 0 to 4, the length of the shortest path from 0 to 4 is 1.

TC : O(q×(n+q)).
SC : O(q×(n+q)).
 */
public class ShortestDistanceAfterRoadAdditionQueriesI {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShortestDistanceAfterRoadAdditionQueriesI()
                .shortestDistanceAfterQueries(5, new int[][]{{2,4},{0,2},{0,4}})));
    }
    // Recursive function to find the minimum distance from the current node to
    // the destination node (n-1)
    private int findMinDistance(
            List<List<Integer>> adjList,
            int n,
            int currentNode,
            int[] dp
    ) {
        // We've reached the destination node
        if (currentNode == n - 1) return 0;

        // If this node has already been computed, return the stored value
        if (dp[currentNode] != -1) return dp[currentNode];

        int minDistance = n;

        for (int neighbor : adjList.get(currentNode)) {
            // Recursively find the minimum distance from the neighbor to the destination
            minDistance = Math.min(
                    minDistance,
                    findMinDistance(adjList, n, neighbor, dp) + 1
            );
        }

        // Store the computed minimum distance in the dp array and return it
        return dp[currentNode] = minDistance;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1; // DP array to store minimum distances from each node
        }
        List<List<Integer>> adjList = new ArrayList<>(n);

        // Initialize the graph with edges between consecutive nodes
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>()); // Create a new list for each node
        }
        for (int i = 0; i < n - 1; i++) {
            adjList.get(i).add(i + 1);
        }

        List<Integer> answer = new ArrayList<>();

        // Process each query to add new edges
        for (int[] road : queries) {
            int u = road[0];
            int v = road[1];

            // Add the directed edge from u to v
            adjList.get(u).add(v);

            // Find the minimum distance from the starting node (0) to the destination (n-1)
            answer.add(findMinDistance(adjList, n, 0, dp));

            // Clear and reset the dp array
            for (int i = 0; i < n; i++) {
                dp[i] = -1;
            }
        }

        // Convert List<Integer> to int[] before returning
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result; // Return the results for each query
    }

}
