package com.graph.representation;

import java.util.*;

/*
2508. Add Edges to Make Degrees of All Nodes Even

There is an undirected graph consisting of n nodes numbered from 1 to n. You are given the integer n and a 2D
array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi.
The graph can be disconnected.

You can add at most two additional edges (possibly none) to this graph so that there are no repeated
edges and no self-loops.

Return true if it is possible to make the degree of each node in the graph even, otherwise return false.

The degree of a node is the number of edges connected to it.

Example 1:
Input: n = 5, edges = [[1,2],[2,3],[3,4],[4,2],[1,4],[2,5]]
Output: true
Explanation: The above diagram shows a valid way of adding an edge.
Every node in the resulting graph is connected to an even number of edges.

TC : o(edges)
SC: o(edges)
 */
public class AddEdgesToMakeDegreesOfAllNodesEven {

    Map<Integer, Set<Integer>> adj;

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1,2));
        edges.add(Arrays.asList(2,3));
        edges.add(Arrays.asList(3,4));
        edges.add(Arrays.asList(4,2));
        edges.add(Arrays.asList(1,4));
        edges.add(Arrays.asList(2,5));

        System.out.println(new AddEdgesToMakeDegreesOfAllNodesEven().isPossible(5,edges));
    }

    public boolean isPossible(int n, List<List<Integer>> edges) {
        adj = new HashMap<>();
        // Initialise adjacency List
        for(int i=0;i<=n;i++){
            adj.put(i,new HashSet<Integer>());
        }

        // add the mapping in adjacency list
        for(List<Integer> edge : edges){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        //get Odd degree node list
        List<Integer> oddList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(adj.get(i).size()%2!=0)
                oddList.add(i);
        }

        //check if there exist any odd degree node
        if(oddList.size()==0)
            return true;

        // handle count(odd degree node) =2
        if(oddList.size()==2){
            /*
            There are two cases:
            1. both odd degree nodes are connected
            2. both odd degree are not connected
            */

            int a = oddList.get(0);
            int b = oddList.get(1);
            for(int i=1;i<=n;i++){
                if(!isConnected(a,i) && !isConnected(b,i)){
                    return true;
                }
            }
        }

        // handle count(odd degree node) =4
        if(oddList.size()==4){
            /*
            There are four cases:
            In case if we have 4 odds a,b,c,d
            option1: We can link (a,b) and (c,d)
            option2: We can link (a,c) and (b,d)
            option3: We can link (a,d) and (b,c)
            otherwise return false.
            */
            int a = oddList.get(0);
            int b = oddList.get(1);
            int c = oddList.get(2);
            int d = oddList.get(3);
            if((!isConnected(a,b) && !isConnected(c,d))||
                    (!isConnected(a,c) && !isConnected(b,d)) ||
                    (!isConnected(a,d) && !isConnected(b,c)))
                return true;
        }

        return false;
    }

    private boolean isConnected(int a , int b){
        return adj.get(a).contains(b);
    }
}
