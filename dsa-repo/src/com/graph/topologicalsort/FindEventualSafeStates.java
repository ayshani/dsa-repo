package com.graph.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
802. Find Eventual Safe States

There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a
0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is
an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting
from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

Example 1:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.


TC :Here, n is the number of nodes and m is number of edges in the graph.

Time complexity: O(m+n)

Initializing the adj list takes O(m) time as we go through all the edges. The indegree array take O(n) time.
Initializing the int safe array also takes O(n) time.
Each queue operation takes O(1) time, and a single node will be pushed once, leading to O(n) operations for n nodes.
We iterate over the neighbors of each node that is popped out of the queue iterating over all the edges once.
Since there are total of m edges, it would take O(m) time to iterate over the edges.
Iterating over all the nodes and pushing only safe nodes into safeNodes also takes O(n) time.
Space complexity: O(m+n)

The adj arrays takes O(m) space. The indegree array takes O(n) space.
The safe array also takes O(n) space.
The queue can have no more than n elements in the worst-case scenario.
It would take up O(n) space in that case.
 */
public class FindEventualSafeStates {

    public static void main(String[] args) {
        int[][] g = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};

        System.out.println(new FindEventualSafeStates().eventualSafeNodes(g));
    }
    public List<Integer> eventualSafeNodes(int[][] g) {
        int n = g.length;
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int node : g[i]){
                graph.get(node).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] safeState = new int[n];
        while(!q.isEmpty()){
            int cur = q.poll();
            safeState[cur]=1;
            for(int neighbour : graph.get(cur)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                    q.offer(neighbour);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safeState[i]==1){
                result.add(i);
            }
        }
        return result;
    }
}
