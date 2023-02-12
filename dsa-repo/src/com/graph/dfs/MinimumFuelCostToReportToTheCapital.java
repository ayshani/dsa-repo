package com.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
2477. Minimum Fuel Cost to Report to the Capital

There is a tree (i.e., a connected, undirected graph with no cycles) structure country network consisting
of n cities numbered from 0 to n - 1 and exactly n - 1 roads. The capital city is city 0.
You are given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional
road connecting cities ai and bi.

There is a meeting for the representatives of each city. The meeting is in the capital city.

There is a car in each city. You are given an integer seats that indicates the number of seats in each car.

A representative can use the car in their city to travel or change the car and ride with another representative.
The cost of traveling between two cities is one liter of fuel.

Return the minimum number of liters of fuel to reach the capital city.



Example 1:
Input: roads = [[0,1],[0,2],[0,3]], seats = 5
Output: 3
Explanation:
- Representative1 goes directly to the capital with 1 liter of fuel.
- Representative2 goes directly to the capital with 1 liter of fuel.
- Representative3 goes directly to the capital with 1 liter of fuel.
It costs 3 liters of fuel at minimum.
It can be proven that 3 is the minimum number of liters of fuel needed.

Algorithm
Create an adjacency list where adj[X] contains all the neighbors of node X.
Create an integer fuel that stores the minimum amount of fuel needed to move all representatives to node 0.
Begin the DFS traversal:
-We use the dfs function to perform the traversal. For each call, pass node, parent, adj and seats as the parameters.
It returns the number of representatives in the subtree of the node. We start with node 0. We also keep track
of the parent node of the current node so that we don’t visit the node’s parent as it has already been visited.
-Initalize an integer representatives to store the number of representatives in the subtree of node.
We initialize it to 1 because the node itself has one representative.
-Iterate over all the children of the node (nodes that share an edge) and check if any child is equal to the parent.
If the child is equal to the parent, we will not visit it again.
-If the child is not equal to the parent, recursively call the dfs function with the node as child and the parent
as node. Add the count of representatives (returned by this call) in the subtree of child to representatives.
-After iterating over all the children, we have the required number of representatives.
To move all of these representatives to the parent node, we would require ceil(representatives / seats) cars
and an equal amount of fuel. We perform fuel += ceil(representatives / seats). We ignore node 0 because it
does not have a parent.
Return fuel.


Complexity Analysis
Here nnn is the number of nodes.

Time complexity: O(n)

The dfs function visits each node once, which takes O(n) time in total. Because we have n - 1 undirected edges,
each edge can only be iterated twice (by nodes at the end), resulting in O(n) operations total while visiting all nodes.
We also need O(n) time to initialize the adjacency list.
Space complexity: O(n).

Building the adjacency list takes O(n) space.
The recursion call stack used by dfs can have no more than nnn elements in the worst-case scenario.
It would take up O(n) space in that case.

 */
public class MinimumFuelCostToReportToTheCapital {

    long fuel;

    public static void main(String[] args) {
        int[][] roads = new int[][]{{0,1},{0,2},{0,3}};
        System.out.println(new MinimumFuelCostToReportToTheCapital().minimumFuelCost(roads,5));
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] r : roads){
            adj.computeIfAbsent(r[0], value -> new ArrayList<>()).add(r[1]);
            adj.computeIfAbsent(r[1], value -> new ArrayList<>()).add(r[0]);
        }
        fuel =0;
        dfs(adj, 0,-1,seats);
        return fuel;
    }

    private int dfs(Map<Integer, List<Integer>> adj, int node, int parent, int seats){

        // The node itself has one representative.
        int representative =1;
        if(!adj.containsKey(node))
            return representative;

        for(int child : adj.get(node)){
            if(child != parent){
                representative += dfs(adj, child, node, seats);
            }
        }
        // Count the fuel it takes to move to the parent node.
        // Root node does not have any parent so we ignore it.
        if(node!=0){
            fuel += Math.ceil((double)representative/seats);
        }
        return representative;
    }
}
