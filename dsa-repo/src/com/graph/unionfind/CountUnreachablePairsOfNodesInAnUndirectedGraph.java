package com.graph.unionfind;

import java.util.HashMap;
import java.util.Map;

/*
2316. Count Unreachable Pairs of Nodes in an Undirected Graph

You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1.
You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected
edge connecting nodes ai and bi.

Return the number of pairs of different nodes that are unreachable from each other.

Example 1:
Input: n = 3, edges = [[0,1],[0,2],[1,2]]
Output: 0
Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.


TC : o(n*alpha(n))
SC: o(n)
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1},{0,2},{1,2}
        };
        System.out.println(new CountUnreachablePairsOfNodesInAnUndirectedGraph().countPairs(3, edges));
    }
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for(int[] edge : edges){
            uf.union(edge[0],edge[1]);
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int parent = uf.find(i);
            map.put(parent, map.getOrDefault(parent,0)+1);
        }
        long total =0;
        for(int count : map.values()){
            total+= count*1l*(n-count);
            n-=count;
        }

        return total;
    }
}
