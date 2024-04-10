package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
882. Reachable Nodes In Subdivided Graph

You are given an undirected graph (the "original graph") with n nodes labeled from 0 to n - 1. You decide to subdivide
each edge in the graph into a chain of nodes, with the number of new nodes varying between each edge.

The graph is given as a 2D array of edges where edges[i] = [ui, vi, cnti] indicates that there is an edge between
nodes ui and vi in the original graph, and cnti is the total number of new nodes that you will subdivide the edge into.
 Note that cnti == 0 means you will not subdivide the edge.

To subdivide the edge [ui, vi], replace it with (cnti + 1) new edges and cnti new nodes.
The new nodes are x1, x2, ..., xcnti, and
the new edges are [ui, x1], [x1, x2], [x2, x3], ..., [xcnti-1, xcnti], [xcnti, vi].

In this new graph, you want to know how many nodes are reachable from the node 0, where a node is reachable if
the distance is maxMoves or less.

Given the original graph and maxMoves, return the number of nodes that are reachable from node 0 in the new graph.

Example 1:
Input: edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
Output: 13
Explanation: The edge subdivisions are shown in the image above.
The nodes that are reachable are highlighted in yellow.

TC : o(ElogV) + o(E)
SC: o(n*2)
 */
public class ReachableNodesInSubdividedGraph {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1,10},{0,2,1},{1,2,2}
        };
        System.out.println(new ReachableNodesInSubdividedGraph().reachableNodes(edges,6,3));
    }
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<int[]>());
        }

        for(int[] edge : edges){
            int u =edge[0], v= edge[1], w = edge[2];
            graph.get(u).add(new int[]{v,w+1});
            graph.get(v).add(new int[]{u,w+1});
        }

        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] =0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[]{0,0});
        // this is a count to get how many nodes acn be visited uder said condition
        int total =0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]])
                continue;
            // incase if the distance is less than the maxMoves,
            //we are counting this node in
            if(distance[cur[0]]<=maxMoves)
                total++;
            visited[cur[0]] =true;
            for(int[] neighbour : graph.get(cur[0])){
                int next = neighbour[0], nextWeight = neighbour[1];
                if(!visited[next] && distance[next] > distance[cur[0]]+nextWeight){
                    distance[next] = distance[cur[0]]+nextWeight;
                    pq.offer(new int[]{next,distance[next]});
                }
            }
        }

        // we will iterate over every edge and each edge consists of src, dest, and weight
        // As we have already gone through dijkstra, we know what is the min distance that is required from 0 to
        // reach that src/dest.
        // so, we can check how much we can traverse under maxMoves condition
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], count = edge[2];
            int temp =0;
            // incase maxMoves is more than distance[u],
            // we take what is max we can reach from u but it doesnt be
            // greater than count of that edge as here count is the number of
            // new node which can be formed. Hence (maxMoves-distance[u])
            // can't outrun count
            if(distance[u]<maxMoves){
                temp+= Math.min(maxMoves-distance[u], count);
            }
            // similar for v node also
            if(distance[v]<maxMoves){
                temp+= Math.min(maxMoves-distance[v], count);
            }

            // Now, as we are calculating edge wise, so, we may run into situation where temp is more than actual
            // count i.e. if same new nodes are getting considered more than one time and that can happen
            // in case for e.g.:
            // 0---2 edge  with count =1
            // here distance[0] =0, distance[2] =2
            // so, Min(maxMoves-distance[0] =6, count =1) ==> 1
            // and Min(maxMoves-distance[2] =4, count =1) ==> 1
            // here we can considering same new node twice. So, to stop
            // considering same new node twice, we take min(temp and count)
            total += Math.min(temp,count);
        }

        return total;
    }
}
/*
w =10
maxMove - dist[0]
6 -0 =6 -> temp1

maxMove - dist[1]
6 - 5 =1-> temp2


6 -0 =6,w =1
6 -2 =4,w =1
temp =2,w= 1*/

