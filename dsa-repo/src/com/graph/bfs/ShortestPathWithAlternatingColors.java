package com.graph.bfs;

import java.util.*;

/*
1129. Shortest Path with Alternating Colors

You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1.
Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

You are given two arrays redEdges and blueEdges where:

redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to
node x such that the edge colors alternate along the path, or -1 if such a path does not exist.



Example 1:

Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
Output: [0,1,-1]

Algorithm
------------
Create an adjacency list adj that contains a list of pairs of integers such that adj[node]
contains the neighbors of node in the form (neighbor, color) where neighbor is the neighbor of
node and color denotes the edge color that connects node and neighbor. We use the number 0 for red
and the number 1 for blue.
Create a answer array with the value -1 where answer[i] is the answer for the ithi^{th}i
th
  node.
Create a 2D visit array in which visit[node][color] indicates whether node has yet been visited using an edge of color.
Create a queue of triplets. It will save three integers per triplet: a) the current node, b) the steps
taken to visit the node, and c) the color of the previous edge used. The node 0 has 0 steps and no specific
color of visit, we can use -1 as the color. We also set visit[0][0] and visit[0][1] to true because visiting
node 0 again is pointless.
While the queue is not empty:
Remove the first element out of the queue to obtain [node, steps, prevColor].
Loop through all (neighbor, color) pairs in adj[node]. If a neighbor has not yet been visited with a color
edge and color != prevColor, we visit neighbor with the color edge by pushing [neighbor, steps + 1, color]
in the queue. If this is neighbor's first visit, i.e., answer[neighbor] == -1, we set answer[neighbor] = steps + 1.
Return answer.

Complexity Analysis
--------------------
Here nnn is the number of nodes and eee is the total number of blue and red edges.

Time complexity: O(n+e).

The complexity would be similar to the standard BFS algorithm since we’re iterating at most twice over each node.
Each queue operation in the BFS algorithm takes O(1) time, and a single node can only be pushed onto the queue twice,
leading to O(n) operations for nnn nodes. We iterate over all the neighbors of each node that is popped
out of the queue, so for an undirected edge, a given edge could be iterated at most twice, resulting in O(e)
 operations total for all the nodes. As a result, the total time required is O(n+e).
Space complexity: O(n+e).

Building the adjacency list takes O(e) space.
The BFS queue takes O(n) because each vertex is added at most twice in the form of triplet of integers.
The other visit and answers arrays take O(n) space.
 */
public class ShortestPathWithAlternatingColors {

    public static void main(String[] args) {
        int[][] red = new int[][]{{0,1},{1,2}}, blue = new int[][]{};

        int[] res = new ShortestPathWithAlternatingColors().shortestAlternatingPaths(3,red,blue);
        Arrays.stream(res).forEach(e -> System.out.print(e +" "));
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();

        for(int[] e : redEdges){
            adj.computeIfAbsent(e[0], value -> new ArrayList<List<Integer>>()).
                    add(Arrays.asList(e[1],0));
        }
        for(int[] e : blueEdges){
            adj.computeIfAbsent(e[0], value -> new ArrayList<List<Integer>>()).
                    add(Arrays.asList(e[1],1));
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // Start with node 0, with number of steps as 0 and undefined color -1.
        q.offer(new int[]{0,0,-1});
        visited[0][0]= true;
        visited[0][1] = true;
        ans[0]=0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curNode = cur[0], curSteps = cur[1], curColor = cur[2];

            if(!adj.containsKey(curNode))
                continue;

            for(List<Integer> neighbour : adj.get(curNode)){
                int neighbourNode = neighbour.get(0);
                int neighbourColor = neighbour.get(1);
                if(!visited[neighbourNode][neighbourColor] && neighbourColor!= curColor){
                    if(ans[neighbourNode]== -1){
                        ans[neighbourNode] = curSteps+1;
                    }
                    visited[neighbourNode][neighbourColor] = true;
                    q.offer(new int[]{neighbourNode , curSteps +1, neighbourColor});
                }
            }
        }
        return ans;
    }
}
