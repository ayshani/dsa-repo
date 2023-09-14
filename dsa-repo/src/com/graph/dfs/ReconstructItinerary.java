package com.graph.dfs;

import java.util.*;

/*
332. Reconstruct Itinerary

You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival
airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are
multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single
string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

Example 1:
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]

TC : o(n)
SC: o(n)
 */
public class ReconstructItinerary {
    LinkedList<String> result;
    Map<String, LinkedList<String>> adj;

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC","LHR"));
        tickets.add(Arrays.asList("JFK","MUC"));
        tickets.add(Arrays.asList("SFO","SJC"));
        tickets.add(Arrays.asList("LHR","SFO"));

        System.out.println(new ReconstructItinerary().findItinerary(tickets));
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String src = ticket.get(0), dest = ticket.get(1);
            adj.computeIfAbsent(src, value -> new LinkedList<>()).add(dest);
        }

        adj.forEach((key, value)-> Collections.sort(value));

        dfs("JFK");
        return result;
    }

    public void dfs(String start){
        if(adj.containsKey(start)) {
            for (String next : adj.get(start)) {
                dfs(next);
            }
        }
        result.addFirst(start);
    }
}
