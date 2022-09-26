package com.graph.representation;

import java.util.ArrayList;
import java.util.List;

/*
1615. Maximal Network Rank

There is an infrastructure of n cities with some number of roads connecting these cities.
Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

The network rank of two different cities is defined as the total number of directly connected
roads to either city. If a road is directly connected to both cities, it is only counted once.

The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.

Example 1:
Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
                    0 - 1 - 2
                     \  |
                        3
Output: 4
Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1.
The road between 0 and 1 is only counted once.

Logic
--------
build undirected adjacency graph
iterate over every vertex
    iterate over every other vertex
        Add both vertices adjacency size and subtract common edge between them if they are
        directly connected as common edge will be counted twice
        take the maximum from all pair

TC : o(n^2)
SC : o(n)
 */
public class MaximalNetworkRank {

    public static void main(String[] args) {
        int n = 5;
        int[][] roads = new int[][]{
                {0,1},{0,3},{1,2},{1,3},{2,3},{2,4}
        };
        System.out.println(new MaximalNetworkRank().maximalNetworkRank(n,roads));
    }
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : roads){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res =0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                res= Math.max(res,graph.get(i).size() + graph.get(j).size() - (graph.get(i).contains(j)? 1:0));
            }
        }

        return res;
    }
}
