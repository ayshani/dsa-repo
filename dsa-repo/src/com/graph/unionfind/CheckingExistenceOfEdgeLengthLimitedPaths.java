package com.graph.unionfind;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
1697. Checking Existence of Edge Length Limited Paths

An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi] denotes an edge
between nodes ui and vi with distance disi. Note that there may be multiple edges between two nodes.

Given an array queries, where queries[j] = [pj, qj, limitj], your task is to determine for each queries[j] whether
there is a path between pj and qj such that each edge on the path has a distance strictly less than limitj .

Return a boolean array answer, where answer.length == queries.length and the jth value of answer is true if there
is a path for queries[j] is true, and false otherwise.

Example 1:
Input: n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
Output: [false,true]
Explanation: The above figure shows the given graph. Note that there are two overlapping edges between 0 and 1 with
distances 2 and 16.
For the first query, between 0 and 1 there is no path where each distance is less than 2, thus we return false for
this query.
For the second query, there is a path (0 -> 1 -> 2) of two edges with distances less than 5, thus we return true for
this query.

TC : o(n)
SC: o(n)
 */
public class CheckingExistenceOfEdgeLengthLimitedPaths {

    public static void main(String[] args) {
        int[][] d = new int[][]{
                {0,1,2},{1,2,4},{2,0,8},{1,0,16}
        };

        int[][] q = new int[][]{
                {0,1,2},{0,2,5}
        };
        boolean[] res = new CheckingExistenceOfEdgeLengthLimitedPaths().distanceLimitedPathsExist(3,d,q);
        for(boolean b : res){
            System.out.print(b+" ");
        }

    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        Arrays.sort(edgeList, (a, b)-> a[2]-b[2]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> queries[a][2] -queries[b][2]
        );
        for(int i=0;i<queries.length;i++){
            pq.offer(i);
        }

        int currentEdge =0;
        UnionFind uf = new UnionFind(n);
        while(!pq.isEmpty()){
            int queryIndex = pq.poll();

            while(currentEdge<edgeList.length && edgeList[currentEdge][2]< queries[queryIndex][2] ){
                uf.union(edgeList[currentEdge][0], edgeList[currentEdge][1]);
                currentEdge++;
            }

            result[queryIndex] = uf.isConnected(queries[queryIndex][0], queries[queryIndex][1]);
        }

        return result;
    }
}
