package com.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
2642. Design Graph With Shortest Path Calculator

There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1. The edges of the graph are
initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti] meaning that there is an
edge from fromi to toi with the cost edgeCosti.

Implement the Graph class:

Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost]. It is guaranteed that
there is no edge between the two nodes before adding this one.
int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2. If no path exists,
return -1. The cost of a path is the sum of the costs of the edges in the path.


Example 1:
Input
["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
[[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
Output
[null, 6, -1, null, 6]

Explanation
Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
g.shortestPath(3, 2); // return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2
        with a total cost of 3 + 2 + 1 = 6.
g.shortestPath(0, 3); // return -1. There is no path from 0 to 3.
g.addEdge([1, 3, 4]); // We add an edge from node 1 to node 3, and we get the second diagram above.
g.shortestPath(0, 3); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.

Complexity Analysis
Let E be number of edges in the graph when the call to any method is made.
Let V be the number of vertices in the graph when the call to any method is made.
Let N be the maximum number of calls made to addEdge.
Let M be the maximum number of calls made to shortestPath.

Time complexity: O(N+M⋅(V+E⋅logV))

initialization: O(E+V). Initializing a list to the size of VVV costs O(V) and iterating over all the edges costs O(E)
addEdge: O(N). Appending an element to a list costs O(1), and when this operation is performed NNN times, it results
        in a linear time complexity of O(N).
shortestPath: O(M⋅(V+E⋅logV)). Initializing the seen list will incur a time complexity of O(V). The time complexity
        for Dijkstra's algorithm is O(E⋅logV). Calling shortestPath M times leads to a combined time complexity
        of O(M⋅(V+E⋅logV)).
Space complexity: O(E+V+N)

initialization: O(E+V). This is the cost to initialize the adjacency list.
addEdge: O(N). Adding an element in the adjacency list will incur a space complexity of O(1), and when this operation
         is performed N times, it results in a linear space complexity of O(N).
shortestPath: O(E+V). The seen list will incur a space complexity of O(V). The priority queue will will incur a space
         complexity of O(E).
 */
public class DesignGraphWithShortestPathCalculator {

    public static void main(String[] args) {
        Graph g = new Graph(4, new int[][]{{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});
        System.out.println(g.shortestPath(3, 2));
        System.out.println(g.shortestPath(0, 3));
        g.addEdge(new int[]{1, 3, 4});
        System.out.println(g.shortestPath(0, 3));
    }
}

class Graph {
    List<List<GraphPair>> adjList;
    public Graph(int n, int[][] edges) {
        adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adjList.get(e[0]).add(new GraphPair(e[1], e[2]));
        }
    }

    public void addEdge(int[] e) {
        adjList.get(e[0]).add(new GraphPair(e[1], e[2]));
    }

    public int shortestPath(int node1, int node2) {
        int n = adjList.size();
        var pq = new PriorityQueue<SourcePair>((a, b) -> a.cost-b.cost);
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[node1] = 0;
        pq.offer(new SourcePair(0,node1));
        while(!pq.isEmpty()){
            SourcePair cur = pq.poll();
            if(cur.cost > costs[cur.source]){
                continue;
            }
            if(cur.source == node2){
                return costs[node2];
            }
            for(var neighbour : adjList.get(cur.source)){
                int neighbourNode = neighbour.dest;
                int cost = neighbour.weight;
                int newCost = cost + cur.cost;
                if(newCost < costs[neighbourNode]){
                    costs[neighbourNode] = newCost;
                    pq.offer(new SourcePair(newCost, neighbourNode));
                }
            }
        }
        return -1;
    }
}

class GraphPair{
    int dest, weight;
    public GraphPair(int d, int v){
        this.dest = d;
        this.weight = v;
    }
}

class SourcePair{
    int source, cost;
    public SourcePair(int v, int d){
        this.source = d;
        this.cost = v;
    }
}
