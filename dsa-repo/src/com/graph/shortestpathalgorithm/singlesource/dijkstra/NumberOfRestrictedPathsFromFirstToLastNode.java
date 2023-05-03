package com.graph.shortestpathalgorithm.singlesource.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
1786. Number of Restricted Paths From First to Last Node

There is an undirected weighted connected graph. You are given a positive integer n which denotes that the graph
has n nodes labeled from 1 to n, and an array edges where each edges[i] = [ui, vi, weighti] denotes that there
is an edge between nodes ui and vi with weight equal to weighti.

A path from node start to node end is a sequence of nodes [z0, z1, z2, ..., zk] such that z0 = start and
zk = end and there is an edge between zi and zi+1 where 0 <= i <= k-1.

The distance of a path is the sum of the weights on the edges of the path. Let distanceToLastNode(x) denote the
shortest distance of a path between node n and node x. A restricted path is a path that also satisfies that
distanceToLastNode(zi) > distanceToLastNode(zi+1) where 0 <= i <= k-1.

Return the number of restricted paths from node 1 to node n. Since that number may be too large,
return it modulo 109 + 7.

Example 1:
Input: n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
Output: 3
Explanation: Each circle contains the node number in black and its distanceToLastNode value in blue.
The three restricted paths are:
1) 1 --> 2 --> 5
2) 1 --> 2 --> 3 --> 5
3) 1 --> 3 --> 5


Idea
-----------
We use Dijkstra to calculate shortest distance paths from last node n to any other nodes x,
the result is distanceToLastNode(x), where x in 1..n. Complexity: O(E * logV) = O(M logN),
where M is number of edges, N is number of nodes.
In the restricted path, [z0, z1, z2, ..., zk], node zi always stand before node z(i+1)
because distanceToLastNode(zi) > distanceToLastNode(zi+1), mean while dfs do calculate number of paths,
a current node never comeback to visited nodes, so we don't need to use visited array to check visited nodes.
Then our dfs(src) function only depends on one param src, we can use memory cache to cache precomputed results
of dfs function, so the time complexity can be deduced to be O(E).
Complexity:

Time: O(M * logN), where M is number of edges, N is number of nodes.
Space: O(M + N)
 */
public class NumberOfRestrictedPathsFromFirstToLastNode {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}
        };

        System.out.println(new NumberOfRestrictedPathsFromFirstToLastNode().countRestrictedPaths(5,edges));
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<DPair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(new DPair(edge[1],edge[2]));
            graph.get(edge[1]).add(new DPair(edge[0],edge[2]));
        }

        int[] distance = dijkstra(n, graph);

        return dfs(1,n, graph, distance, new Integer[n+1]);
    }

    private int[] dijkstra(int n, List<List<DPair>> graph){
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[n] =0;
        boolean[] visited = new boolean[n+1];
        PriorityQueue<DPair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.offer(new DPair(n,0));

        while(!pq.isEmpty()){
            DPair current = pq.poll();

            int node = current.destination, weight = current.weight;

            if(visited[node])
                continue;
            visited[node]= true;
            for(DPair neighbour : graph.get(node)){
                int neighbourNode = neighbour.destination, neighbourweight = neighbour.weight;
                if(!visited[neighbourNode] &&
                        distance[neighbourNode] > distance[node] + neighbourweight){
                    distance[neighbourNode] = distance[node] + neighbourweight;
                    pq.offer(new DPair(neighbourNode, distance[neighbourNode]));
                }
            }
        }

        return distance;
    }

    private int dfs(int source, int destination, List<List<DPair>> graph, int[] distance, Integer[] memo){

        if(memo[source]!=null)
            return memo[source];
        if(source==destination)
            return 1;
        int ans =0;
        for(DPair neighbour :  graph.get(source)){
            if(distance[source]> distance[neighbour.destination]){
                ans  =
                        (ans + dfs(neighbour.destination, destination, graph,distance,memo))%
                                1000000007;
            }
        }
        return memo[source] = ans;
    }
}



class DPair{
    public int destination, weight;
    public DPair(int d, int w){
        this.destination = d;
        this.weight = w;
    }
}
