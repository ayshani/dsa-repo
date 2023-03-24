package com.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/*
1466. Reorder Routes to Make All Paths Lead to the City Zero

There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between
two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads
in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.


Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum
number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).


Algo
-----
Based on the problem description, we have a tree, and node zero is the root.

However, the direction can point either from a parent to a child (positive), or from a child to its parent (negative).
To solve the problem, we traverse the tree and count edges that are directed from a parent to a child. Direction of
those edges need to be changed to arrive at zero node.

In the code below, I am using the adjacency list, and the sign indicates the direction.
If the index is positive - the direction is from a parent to a child and we need to change it (change += (to > 0)).

Note that we cannot detect the direction for zero (-0 == 0), but it does not matter as we start our traversal from zero.
TC: o(n)
SC: o(n)
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public static void main(String[] args) {
        int[][] con = new int[][]{
                {0,1},{1,3},{2,3},{4,0},{4,5}
        };
        System.out.println(new ReorderRoutesToMakeAllPathsLeadToTheCityZero().minReorder(6, con));
    }
    int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (var to : al.get(from))
            if (!visited[Math.abs(to)]) {
                System.out.println(from +" "+ to + " "+ change);
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
                System.out.println(from +" "+ to + " "+ change);
            }
        System.out.println("return change "+ change);
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            al.add(new ArrayList<>());
        for (var c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        return dfs(al, new boolean[n], 0);
    }
}
