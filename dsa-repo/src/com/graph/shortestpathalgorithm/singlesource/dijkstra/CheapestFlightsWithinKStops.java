package com.graph.shortestpathalgorithm.singlesource.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
787. Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array flights where
flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
If there is no such route, return -1.

Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

TC : o(n^k)
SC: o(n)
 */
public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int[][] flights = new int[][]{
                {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}
        };
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(4,flights,0,3,1));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] flight :  flights){
            int from = flight[0], to = flight[1], price = flight[2];
            graph.get(from).add(new int[]{to,price});
            //graph.get(to).add(new int[]{from,price});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1]-b[1]);
        // to,price,stops
        pq.offer(new int[]{src,0,0});

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src]=0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int to = cur[0], price = cur[1], steps = cur[2];
            if( steps>stops[to] || steps>k+1 )
                continue;
            stops[to] = steps;
            if(to==dst)
                return price;
            for(int[] neighbour : graph.get(to)){
                pq.offer(new int[]{neighbour[0], neighbour[1]+price, steps+1});
            }
        }
        return -1;
    }
}
