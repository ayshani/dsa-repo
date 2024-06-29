package com.graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
2192. All Ancestors of a Node in a Directed Acyclic Graph

You are given a positive integer n representing the number of nodes of a Directed Acyclic Graph (DAG). The nodes
are numbered from 0 to n - 1 (inclusive).

You are also given a 2D integer array edges, where edges[i] = [fromi, toi] denotes that there is a unidirectional
edge from fromi to toi in the graph.

Return a list answer, where answer[i] is the list of ancestors of the ith node, sorted in ascending order.
A node u is an ancestor of another node v if u can reach v via a set of edges.



Example 1:
Input: n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
Output: [[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
Explanation:
The above diagram represents the input graph.
- Nodes 0, 1, and 2 do not have any ancestors.
- Node 3 has two ancestors 0 and 1.
- Node 4 has two ancestors 0 and 2.
- Node 5 has three ancestors 0, 1, and 3.
- Node 6 has five ancestors 0, 1, 2, 3, and 4.
- Node 7 has four ancestors 0, 1, 2, and 3.

TC : o(n^2)
SC: o(n)
 */
public class AllAncestorsOfANodeInADirectedAcyclicGraph {

    public static void main(String[] args) {
        System.out.println(new AllAncestorsOfANodeInADirectedAcyclicGraph().getAncestors(
                8, new int[][]{
                        {0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}
                }
        ));
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[1]).add(edge[0]);
        }
        List<List<Integer>> ancestorsList = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> ancestors = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            dfs(graph, i, visited);
            for(int node =0; node<n; node++){
                if(node==i)
                    continue;
                if(visited.contains(node)){
                    ancestors.add(node);
                }
            }
            ancestorsList.add(ancestors);
        }

        return ancestorsList;
    }

    private void dfs(List<List<Integer>> graph, int start, Set<Integer> visited){
        visited.add(start);
        for(int parent : graph.get(start)){
            if(!visited.contains(parent)){
                dfs(graph, parent, visited);
            }
        }
    }
}
