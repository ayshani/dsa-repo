package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
743. Network Delay Time

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed
edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a
signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

TC: o(ElogV)
SC: o(E)
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = new int[][]{
                {2,1,1},{2,3,1},{3,4,1}
        };
        System.out.println(new NetworkDelayTime().networkDelayTime(times,4,2));
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<int[]>());
        }

        for(int[] time : times){
            int u = time[0], v = time[1], w = time[2];
            graph.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1]-b[1]);
        pq.offer(new int[]{k,0});
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] =0;
        int curDistance =0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]])
                continue;
            visited[cur[0]]= true;
            curDistance = distance[cur[0]];
            n--;
            for(int[] neighbour : graph.get(cur[0])){
                int next = neighbour[0], nextWeight = neighbour[1];
                if(!visited[next] && distance[next]> distance[cur[0]]+nextWeight){
                    distance[next] = distance[cur[0]]+nextWeight;
                    pq.offer(new int[]{next,distance[next]});
                }
            }
        }
        return n==0? curDistance:-1;
    }
}
