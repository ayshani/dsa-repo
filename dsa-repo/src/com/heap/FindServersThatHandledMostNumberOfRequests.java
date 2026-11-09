package com.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/*
1606. Find Servers That Handled Most Number of Requests

You have k servers numbered from 0 to k-1 that are being used to handle multiple requests simultaneously.
Each server has infinite computational capacity but cannot handle more than one request at a time.
The requests are assigned to servers according to a specific algorithm:

The ith (0-indexed) request arrives.
If all servers are busy, the request is dropped (not handled at all).
If the (i % k)th server is available, assign the request to that server.
Otherwise, assign the request to the next available server (wrapping around the list of servers and starting
from 0 if necessary). For example, if the ith server is busy, try to assign the request to the (i+1)th server, then
the (i+2)th server, and so on.
You are given a strictly increasing array arrival of positive integers, where arrival[i] represents the arrival
time of the ith request, and another array load, where load[i] represents the load of the ith request
(the time it takes to complete). Your goal is to find the busiest server(s). A server is considered busiest
if it handled the most number of requests successfully among all the servers.

Return a list containing the IDs (0-indexed) of the busiest server(s). You may return the IDs in any order.



Example 1:


Input: k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]
Output: [1]
Explanation:
All of the servers start out available.
The first 3 requests are handled by the first 3 servers in order.
Request 3 comes in. Server 0 is busy, so it's assigned to the next available server, which is 1.
Request 4 comes in. It cannot be handled since all servers are busy, so it is dropped.
Servers 0 and 2 handled one request each, while server 1 handled two requests. Hence server 1 is the busiest server.

TC: o(k+nlogk)
SC: o(k+n)
 */
public class FindServersThatHandledMostNumberOfRequests {
    record Job(int at, int server) {}  // at: the time its server frees up

    public static void main(String[] args) {
        System.out.println(new FindServersThatHandledMostNumberOfRequests().busiestServers(
                3, new int[]{1,2,3,4,5}, new int[]{5,2,3,3,3}
        ));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<Integer> free = new PriorityQueue<>();  // each free server, keyed by its next turn
        for (int x = 0; x < k; x++) free.add(x);  // at request 0, server x's next turn is x
        PriorityQueue<Job> busy = new PriorityQueue<>(Comparator.comparingInt(Job::at));

        int[] handled = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek().at() <= arrival[i]) {  // done by the arrival
                int x = busy.poll().server();
                free.add(i + Math.floorMod(x - i, k));  // its first turn from i on
            }
            if (free.isEmpty()) continue;  // none free: the request is dropped
            int x = free.poll() % k;
            busy.add(new Job(arrival[i] + load[i], x));
            handled[x]++;
        }

        int most = Arrays.stream(handled).max().getAsInt();
        return IntStream.range(0, k).filter(x -> handled[x] == most).boxed().toList();
    }
}
