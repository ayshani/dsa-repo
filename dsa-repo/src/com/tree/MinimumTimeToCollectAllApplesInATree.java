package com.tree;

import java.util.*;

/*
1443. Minimum Time to Collect All Apples in a Tree

Given an undirected tree consisting of n vertices numbered from 0 to n-1,
which has some apples in their vertices. You spend 1 second to walk over one edge of the tree.
Return the minimum time in seconds you have to spend to collect all apples in the tree,
starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges,
where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi.
Additionally, there is a boolean array hasApple, where hasApple[i] = true means
that vertex i has an apple; otherwise, it does not have any apple.

Example 1:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8
Explanation: The figure above represents the given tree where red vertices have an apple.
One optimal path to collect all apples is shown by the green arrows.

TC : o(n)
SC : o(n)
 */
public class MinimumTimeToCollectAllApplesInATree {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = new int[][]{
                {0,1},{0,2},{1,4},{1,5},{2,3},{2,6}
        };

        List<Boolean> hasApples = Arrays.asList(false,false,true,false,true,true,false);

        System.out.println(new MinimumTimeToCollectAllApplesInATree().minTime(n,edges,hasApples));
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges){
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        return dfs(0,-1,adj,hasApple);
    }

    private int dfs(int node, int parent, Map<Integer,List<Integer>> adj, List<Boolean> hasApple)   {
        if(!adj.containsKey(node))
            return 0;

        int totalTime =0;
        for(int child : adj.get(node)){
            if(child==parent)
                continue;

            int childTime = dfs(child,node,adj,hasApple);

            if(childTime>0 || hasApple.get(child)){
                totalTime+= childTime+2;
            }
        }

        return totalTime;
    }
}
