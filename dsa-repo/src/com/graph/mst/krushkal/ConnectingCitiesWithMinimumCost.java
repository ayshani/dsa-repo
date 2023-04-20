package com.graph.mst.krushkal;

import java.util.Arrays;

/*
1135. Connecting Cities With Minimum Cost

There are n cities labeled from 1 to n. You are given the integer n and an array connections where
connections[i] = [xi, yi, costi] indicates that the cost of connecting city xi and city yi
(bidirectional connection) is costi.

Return the minimum cost to connect all the n cities such that there is at least one path between each pair
of cities. If it is impossible to connect all the n cities, return -1,

The cost is the sum of the connections' costs used.

Example 1:
Input: n = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: Choosing any 2 edges will connect all cities so we choose the minimum 2.


TC : o(ElogV)
SC: o(n)
 */
public class ConnectingCitiesWithMinimumCost {
    public static void main(String[] args) {
        int n = 3;
        int edges[][] = new int[][]{
                {1,2,5} ,{1,3,6},{2,3,1}
        };
        System.out.println(new ConnectingCitiesWithMinimumCost().minimumCost(n,edges));
    }
    public int minimumCost(int n, int[][] connections) {

        UnionFind uf = new UnionFind(n+1);
        Arrays.sort(connections, (a, b) -> a[2]-b[2]);
        int minCost =0;
        for(int[] edge : connections){
            int x = uf.find(edge[0]), y = uf.find(edge[1]);
            if(x!=y){
                uf.union(x,y);
                minCost += edge[2];
            }
        }
        return uf.count == n-1 ? minCost : -1;
    }
}
