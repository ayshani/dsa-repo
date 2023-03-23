package com.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/*
1319. Number of Operations to Make Network Connected

There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network
where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any
other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly
connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected.
If it is not possible, return -1.

Example 1:
Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.

TC: o(n)
SC: o(n)
 */
public class NumberOfOperationsToMakeNetworkConnected {

    public static void main(String[] args) {
        int[][] connections = new int[][]{
                {0,1},{0,2},{1,2}
        };
        System.out.println(new NumberOfOperationsToMakeNetworkConnected().makeConnected(4,connections));
    }
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        if(connections.length<n-1)
            return -1;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length; i++){
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }
        int numberOfComponents= 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                numberOfComponents++;
                dfs(graph, i, visited);
            }
        }
        return numberOfComponents-1;
    }

    private void dfs(List<List<Integer>> graph, int source, boolean[] visited){
        if(visited[source])
            return ;
        visited[source] =true;

        for(int neighbour : graph.get(source)){
            dfs(graph, neighbour, visited);
        }
    }

}
