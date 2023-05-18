package com.graph.representation;

import java.util.ArrayList;
import java.util.List;

/*
1557. Minimum Number of Vertices to Reach All Nodes


Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where
edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.

Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a
unique solution exists.

Notice that you can return the vertices in any order.

Example 1:
Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
Output: [0,3]
Explanation: It's not possible to reach all the nodes from a single vertex.
From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output [0,3].

TC: o(E+V)
SC: o(V)
 */
public class MinimumNumberOfVerticesToReachAllNodes {

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0;i<5;i++){
            edges.add(new ArrayList<>());
        }
        edges.get(0).addAll(List.of(0,1));
        edges.get(1).addAll(List.of(0,2));
        edges.get(2).addAll(List.of(2,5));
        edges.get(3).addAll(List.of(3,4));
        edges.get(4).addAll(List.of(4,2));
        System.out.println(new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(6, edges));
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();

        int[] indegree = new int[n];

        for(List<Integer> edge : edges){
            indegree[edge.get(1)]++;
        }


        for(int i=0;i<n;i++){
            if(indegree[i]==0 ){
                result.add(i);
            }
        }
        return result;
    }
}
