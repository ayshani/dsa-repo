package com.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Mother Vertex

Given a Directed Graph, find a Mother Vertex in the Graph (if present).
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.

TC : o(V+E)
SC: o(V)
 */
public class MotherVertex {

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> edges =  new ArrayList<>();

        for(int i=0;i<V;i++){
            edges.add(new ArrayList<>());
        }
        edges.get(0).add(2);
        edges.get(0).add(3);
        edges.get(1).add(0);
        edges.get(2).add(1);
        edges.get(3).add(4);
        System.out.println(new MotherVertex().findMotherVertex(V,edges));
    }
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, List<List<Integer>> adj)
    {
        // Code here
        boolean[] visited = new boolean[V];
        int motherVertex =0;
        for(int i=0; i<V;i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                motherVertex = i;
            }
        }

        boolean[] check = new boolean[V];
        dfs(motherVertex, adj,check);

        for(int i=0;i<V;i++){
            if(!check[i]){
                return -1;
            }
        }
        return motherVertex;
    }

    private void dfs(int src, List<List<Integer>>adj, boolean[] visited){
        visited[src] = true;

        for(int neighbour : adj.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited);
            }
        }
    }
}
