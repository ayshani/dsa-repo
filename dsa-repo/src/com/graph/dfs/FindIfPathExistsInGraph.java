package com.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/*
1971. Find if Path Exists in Graph

There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
The edges in the graph are represented as a 2D integer array edges, where each
edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source
to destination, or false otherwise.

Example 1:Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

TC : o(m+n)
SC : o(m+n)
 */
public class FindIfPathExistsInGraph {

    public static void main(String[] args) {
        int n = 6, source = 0, destination = 5;
        int[][] edges = new int[][]{
                {0,1},{0,2},{3,5},{5,4},{4,3}
        };

        System.out.println(new FindIfPathExistsInGraph().validPath(n,edges,source,destination));
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];


        if(dfs(adjList,source,destination,visited))
            return true;
        return false;
    }

    private boolean dfs(List<List<Integer>> adjList, int source, int destination, boolean[] visited){
        if(source == destination)
            return true;

        if(!visited[source]) {
            visited[source] = true;
            for(int i=0;i<adjList.get(source).size();i++){
                if(dfs(adjList,adjList.get(source).get(i),destination, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
