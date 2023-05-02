package com.graph.sssp.bellmanford;

import java.util.Arrays;

/*
Bellman Ford Algorithm
https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
https://courses.csail.mit.edu/6.006/fall11/lectures/lecture17.pdf

Given a graph and a source vertex src in the graph, find the shortest paths from src to all vertices in the given
graph. The graph may contain negative weight edges.

We have discussed Dijkstra’s algorithm for this problem. Dijkstra’s algorithm is a Greedy algorithm and the
time complexity is O((V+E)LogV) (with the use of the Fibonacci heap). Dijkstra doesn’t work for Graphs with negative
weights, Bellman-Ford works for such graphs. Bellman-Ford is also simpler than Dijkstra and suites well for
distributed systems. But time complexity of Bellman-Ford is O(V * E), which is more than Dijkstra.

Time Complexity:  O(V * E), where V is the number of vertices in the graph and E is the number of edges in the graph
Auxiliary Space: O(E)

Notes:

Negative weights are found in various applications of graphs. For example, instead of paying the cost for a path,
we may get some advantage if we follow the path.
Bellman-Ford works better (better than Dijkstra’s) for distributed systems. Unlike Dijkstra’s where we need to
find the minimum value of all vertices, in Bellman-Ford, edges are considered one by one.
Bellman-Ford does not work with an undirected graph with negative edges as it will be declared as a negative cycle.
 */
public class BellmanFordAlgorithm {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{
                {1,0,5},{1,2,-2},{1,4,6},{2,3,3}
        };

        new BellmanFordAlgorithm().bellmanFord(n,edges,1);
    }
    public void bellmanFord(int n, int[][] edges, int source)
    {
        //code here

        int[] distance = new int[n];
        int[] parent = new int[n];
        // Step 1: Initialize distances from src to all
        // other vertices as INFINITE
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] =0;
        parent[source] =-1;
        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for(int i=0;i<n-1;i++){
            for(int j=0;j<edges.length;j++){
                int src = edges[j][0], dest = edges[j][1], weight = edges[j][2];
                if( distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]){
                    distance[dest] = distance[src] + weight;
                    parent[dest] = src;
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
                System.out.println("Graph contains negative weight cycle");
                isNegativeWeightCyclePresent =true;
                break;
            }
        }
        if(!isNegativeWeightCyclePresent)
            print(distance,n, source, parent);
    }

    private void print(int[] distance, int n, int src, int[] parent) {
        System.out.println("Vertex Distance from Source : "+src);
        for(int i=0;i<n;i++){
            System.out.println(i +" -- distance :: "+ distance[i] +", parent :: " + parent[i]);
        }
    }
}
