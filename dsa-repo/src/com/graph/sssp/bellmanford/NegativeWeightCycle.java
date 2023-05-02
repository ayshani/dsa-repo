package com.graph.sssp.bellmanford;

import java.util.Arrays;

/*
Negative weight cycle

https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1
https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check
if it contains a negative weight cycle or not.
Note: edges[i] is defined as u, v and weight.

Example 1:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,-3}}
Output: 1
Explanation: The graph contains negative weight
cycle as 0->1->2->0 with weight -1,-2,-3.

Time Complexity:
O(V * E), where V is the number of vertices in the graph and E is the number of edges in the graph
Auxiliary Space:
O(E)
 */
public class NegativeWeightCycle {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{
                {1,0,5},{1,2,-2},{1,4,6},{2,3,3},{3,1,-4}
        };

        System.out.println(new NegativeWeightCycle().isNegativeWeightCycle(n,edges));
    }
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here

        int[] outDegree = new int[n];
        // we are using here BellmanFord Algorithm which requires one single source.
        // as in this problem, we are not provided with source, we can't just take one
        // random source. we nee dto choose one source which has connectivity to atleast
        // another vertex. Hecne, we are calculating outdegree of vertices.
        for(int[] edge : edges){
            outDegree[edge[0]]++;
        }
        int[] distance = new int[n];
        // Step 1: Initialize distances from src to all
        // other vertices as INFINITE
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Among all outdegree vertices, take any one.
        // and mark it as a source ie. make its distance as 0
        for(int i=0;i<n;i++){
            if(outDegree[i]!=0){
                distance[i] =0;
                break;
            }
        }


        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for(int i=0;i<n-1;i++){
            for(int j=0;j<edges.length;j++){
                int src = edges[j][0], dest = edges[j][1], weight = edges[j][2];
                if( distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]){
                    distance[dest] = distance[src] + weight;
                }
            }
        }

        // Step 3: check for negative-weight cycles. The
        // above step guarantees shortest distances if graph
        // doesn't contain negative weight cycle. If we get
        // a shorter path, then there is a cycle.
        boolean isNegativeWeightCyclePresent = false;
        for(int j=0;j<edges.length;j++){
            int src = edges[j][0], dest = edges[j][1], weight = edges[j][2];
            if( distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]){
                return 1;
            }
        }
        return 0;
    }
}
