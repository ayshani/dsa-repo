package com.graph.bfs;

import java.util.*;

/*
815. Bus Routes

You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence
1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target.
You can travel between bus stops by buses only.

Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.



Example 1:

Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.

Explanation:
The first part loop on routes and record stop to routes mapping in to_route.
The second part is general bfs. Take a stop from queue and find all connected route.
The hashset seen record all visited stops and we won't check a stop for twice.
We can also use a hashset to record all visited routes, or just clear a route after visit

TC: o(n)
SC: o(n)
 */
public class BusRoutes {

    public static void main(String[] args) {
        int src = 1, target = 6, routes[][] =  new int[][]{{1,2,7},{3,6,7}};
        System.out.println(new BusRoutes().numBusesToDestination(routes,src,target));
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // make a grah which is :
        // route -> bus_i, bus_j
        for(int i=0;i<routes.length;i++){
            for(int route : routes[i]){
                graph.computeIfAbsent(route, value -> new ArrayList<>()).add(i);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{source, 0});
        Set<Integer> seenStop = new HashSet<>();
        seenStop.add(source);
        boolean[] seenRoutes = new boolean[n];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int stop = cur[0], bus = cur[1];

            if(stop==target)
                return bus;
            // iterate for all buses for this stop

            for(int nextBus : graph.get(stop)){
                // incase we have already seen that route for that bus, continue
                if(seenRoutes[nextBus])
                    continue;
                // get all route for this particular bus
                for(int route : routes[nextBus]){
                    // incase we havn't visited tha stop we add it to q to explore
                    if(!seenStop.contains(route)){
                        seenStop.add(route);
                        q.offer(new int[]{route, bus+1});
                    }
                }
                // once we have visited all routes for the bus, mark this route true
                seenRoutes[nextBus] = true;
            }
        }
        return -1;
    }
}
