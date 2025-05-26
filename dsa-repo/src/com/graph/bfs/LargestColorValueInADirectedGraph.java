package com.graph.bfs;

import java.util.*;

/*
1857. Largest Color Value in a Directed Graph

There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i] is a lowercase English letter representing the color of the
ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that
there is a directed edge from node aj to node bj.

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge
from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most
frequently occurring color along that path.

Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.



Example 1:
Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
Output: 3
Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).

TC: o(n*max_adjacency_size*26)
SC: o(n*26)
 */
public class LargestColorValueInADirectedGraph {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1},{0,2},{2,3},{3,4}
        };
        System.out.println(new LargestColorValueInADirectedGraph().largestPathValue("abaca", edges));
    }
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int n = colors.length();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            graph.put(i, new HashSet<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[][] count  = new int[n][26];
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int result =0, processed=0;

        while(!q.isEmpty()){
            int size= q.size();
            while(size-->0){
                int cur = q.poll();
                processed++;

                result = Math.max(result, ++count[cur][colors.charAt(cur)-'a']);

                for( int neighbour : graph.get(cur)){
                    for(int i=0;i<26;i++){
                        count[neighbour][i] = Math.max(count[neighbour][i], count[cur][i]);
                    }
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0){
                        q.offer(neighbour);
                    }
                }

            }
        }
        return processed==n ? result : -1;
    }
}
