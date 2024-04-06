package com.graph.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
310. Minimum Height Trees

A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words,
any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges
where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree,
you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h.
Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

Example 1:
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.

TC : o(n)
SC: o(n)
 */
public class MinimumHeightTrees {

    public static void main(String[] args) {
        int n = 4, edges[][] = new int[][]{{1,0},{1,2},{1,3}};
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(n,edges));
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return List.of(0);
        }
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for(int[] edge : edges){
            int u =edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.offer(i);
            }
        }
        System.out.println(q);
        while(n>2){
            int size = q.size();
            n -= size;
            while(size-->0){
                int cur = q.poll();
                for( int neighbour : graph.get(cur)){
                    degree[neighbour]--;
                    if(degree[neighbour]==1){
                        q.offer(neighbour);
                    }
                }
            }
        }
        System.out.println(q);
        return new ArrayList<>(q);
    }
}
