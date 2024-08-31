package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
1514. Path with Maximum Probability

You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b]
is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and
return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer
by at most 1e-5.

Example 1:
Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2
        and the other has 0.5 * 0.5 = 0.25.

TC : o(m+nlogn)
SC: o(m+n)
 */
public class PathWithMaximumProbability {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1},{1,2},{0,2}
        };
        double[] prob = new double[]{0.5,0.5,0.2};

        System.out.println(new PathWithMaximumProbability().maxProbability(3,edges,prob,0,2));
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<ProbPair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(new ProbPair(edges[i][1],succProb[i]));
            graph.get(edges[i][1]).add(new ProbPair(edges[i][0],succProb[i]));
        }

        boolean[] visited = new boolean[n];
        double[] probability = new double[n];
        Arrays.fill(probability,0);
        probability[start] =1d;

        // sort with descending order of probability
        PriorityQueue<ProbPair> pq = new PriorityQueue<>((a, b)->
        {
            if(b.prob>a.prob)
                return 1;
            return -1;
        });

        pq.offer(new ProbPair(start,1));

        while(!pq.isEmpty()){
            ProbPair cur = pq.poll();
            //System.out.println(cur.prob);
            if(cur.node==end)
                return probability[end];

            if(visited[cur.node])
                continue;

            visited[cur.node] =true;

            for(ProbPair neighbour : graph.get(cur.node)){
                int next = neighbour.node;
                double nextProbability = neighbour.prob;
                // if next is not visited and probability of current node with nextProbability
                // is greater than the present probability of next node, then update
                if(!visited[next] && probability[cur.node]*nextProbability> probability[next]){
                    probability[next] = probability[cur.node]*nextProbability;
                    pq.offer(new ProbPair(next,probability[next]));
                }
            }
        }

        return 0d;
    }
}

class ProbPair{
    int node;
    double prob;
    public ProbPair(int n, double p ){
        this.node = n;
        this.prob = p;
    }
}
