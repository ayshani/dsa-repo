package com.graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
2924. Find Champion II

There are n teams numbered from 0 to n - 1 in a tournament; each team is also a node in a DAG.

You are given the integer n and a 0-indexed 2D integer array edges of length m representing the DAG, where edges[i] = [ui, vi] indicates that there is a directed edge from team ui to team vi in the graph.

A directed edge from a to b in the graph means that team a is stronger than team b and team b is weaker than team a.

Team a will be the champion of the tournament if there is no team b that is stronger than team a.

Return the team that will be the champion of the tournament if there is a unique champion, otherwise, return -1.

Notes

A cycle is a series of nodes a1, a2, ..., an, an+1 such that node a1 is the same node as node an+1, the nodes a1, a2, ..., an are distinct, and there is a directed edge from the node ai to node ai+1 for every i in the range [1, n].
A DAG is a directed graph that does not have any cycle.


Example 1:
Input: n = 3, edges = [[0,1],[1,2]]
Output: 0
Explanation: Team 1 is weaker than team 0. Team 2 is weaker than team 1. So the champion is team 0.

TC : o(n)
SC:: o(n)
 */
public class FindChampionII {

    public static void main(String[] args) {
        System.out.println(new FindChampionII().findChampion(3, new int[][]{{0,1},{1,2}}));
    }
    public int findChampion(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
        }

        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            dfs(graph, i, set);
            if(set.size()==n)
                return i;
        }
        return -1;
    }

    private void dfs(List<List<Integer>> graph, int source, Set<Integer> set){
        if(set.contains(source))
            return;
        set.add(source);
        for(int next : graph.get(source)){
            dfs(graph, next, set);
        }
    }
}
