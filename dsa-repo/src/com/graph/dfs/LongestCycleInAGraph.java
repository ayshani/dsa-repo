package com.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/*
2360. Longest Cycle in a Graph

You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a
directed edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.

Example 1:
Input: edges = [3,3,4,2,3]
Output: 3
Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
The length of this cycle is 3, so 3 is returned.

TC: o(n)
SC: o(n)
 */
public class LongestCycleInAGraph {

    int longestCycle;


    public static void main(String[] args) {
        int[] edges= new int[]{3,3,4,2,3};
        System.out.println(new LongestCycleInAGraph().longestCycle(edges));
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        longestCycle=-1;
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            if(edges[i]!=-1)
                graph.get(edges[i]).add(i);
        }

        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0)
                dfs(graph, i,0, visited);
        }

        return longestCycle;
    }

    private void dfs(List<List<Integer>> graph, int i, int cycle, int[] visited){
        visited[i]= 1; //add current node under processing mode. [1 : under processing node]

        for(int neighbour : graph.get(i)){
            if(visited[neighbour]==0)//If unprocessed yet, [0 : unprocessed node]
                dfs(graph, neighbour, cycle+1, visited);
            else if(visited[neighbour]==1){
                //if current vertex[adj] which is adjacent of current node [vertex] is already in under processing mode,
                //It means we found a cycle.
                //1 is added to include the edge length [vertex ----> adj] : I'm NOT making the call for this edge.
                longestCycle = Math.max(longestCycle, cycle+1);
            }
        }
        visited[i]=2; //mark current node as processed node
    }
}
