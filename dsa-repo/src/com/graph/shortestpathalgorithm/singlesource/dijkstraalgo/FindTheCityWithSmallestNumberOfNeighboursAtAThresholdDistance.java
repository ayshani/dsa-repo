package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance

There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti]
represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is
at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

Example 1:
Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph.
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2]
City 1 -> [City 0, City 2, City 3]
City 2 -> [City 0, City 1, City 3]
City 3 -> [City 1, City 2]
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it
has the greatest number.

TC: O(VElogV)
SC: o(n^2)
 */
public class FindTheCityWithSmallestNumberOfNeighboursAtAThresholdDistance {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1,3},{1,2,1},{1,3,4},{2,3,1}
        };

        System.out.println(new FindTheCityWithSmallestNumberOfNeighboursAtAThresholdDistance()
                .findTheCity(4,edges,4));
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // build the graph
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u =edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }

        int[][] distance = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
            distance[i][i] =0;
        }

        // run dijkstra for every node and make that node as the src and
        // find out the min distance[] from that src to rest of the nodes
        for(int i=0;i<n;i++){
            dijkstra(graph, distance[i], i, n);
        }

        int minCity = -1, minCount =n;

        // once we get the minDistance for every round, we cn check which
        // node gives the min neighbour count within a threshold
        for(int i=0;i<n;i++){
            int currentCount=0;
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                if(distance[i][j]<=distanceThreshold)
                    currentCount++;
            }
            if(minCount>=currentCount){
                minCount = currentCount;
                minCity = i;
            }
        }

        return minCity;
    }

    private void dijkstra(List<List<int[]>> graph, int[] dist, int src, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{src,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]])
                continue;
            visited[cur[0]] = true;

            for(int[] neighbour : graph.get(cur[0])){
                int next = neighbour[0], nextWeight = neighbour[1];
                if(!visited[next] && dist[cur[0]] + nextWeight<dist[next] ){
                    dist[next] = dist[cur[0]] + nextWeight;
                    pq.offer(new int[]{next,dist[next]});
                }
            }
        }
    }
}
