package com.graph.representation;

import com.array.BattleshipsInABoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1791. Find Center of Star Graph

There is an undirected star graph consisting of n nodes labeled from 1 to n.
A star graph is a graph where there is one center node and exactly n - 1 edges that connect
the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge
between the nodes ui and vi. Return the center of the given star graph.

Example 1:
Input: edges = [[1,2],[2,3],[4,2]]
            4
            |
            2
           / \
          1   3
Output: 2
Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.

TC : o(E+V)
SC : o(V)
 */
public class FindCenterOfStarGraph {

    public static void main(String[] args){
        int[][] edges = new int[][]{
                {1,2},{2,3},{4,2}
        };

        System.out.println(new FindCenterOfStarGraph().findCenter(edges));
        System.out.println(new FindCenterOfStarGraph().findCenterV2(edges));
    }
    public int findCenter(int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges){
            graph.putIfAbsent(edge[0],new ArrayList<Integer>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1],new ArrayList<Integer>());
            graph.get(edge[1]).add(edge[0]);
        }

        for(Map.Entry<Integer,List<Integer>> entry : graph.entrySet()){
            if(entry.getValue().size()== graph.size()-1)
                return entry.getKey();
        }

        return 0;
    }

    /*
    As the input is the star graph then one vertx should be present in all edges.
    So, we need to check only two edges to find out the common vertex

    TC : o(1)
    SC: o(1)
     */
    public int findCenterV2(int[][] edges) {
        int[] first = edges[0], sec = edges[1];
        return (first[0]== sec[0] || first[0] == sec[1]) ? first[0] : first[1];
    }

}
