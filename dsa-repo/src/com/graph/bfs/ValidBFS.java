package com.graph.bfs;

import java.util.*;
// https://codeforces.com/contest/1037/submission/119607886

/*
Valid Bfs

The BFS algorithm is defined as follows.

Consider an undirected graph with vertices numbered from 1 to n. Initialize q as a new queue containing only
vertex 1, mark the vertex 1 as used.

Extract a vertex v from the head of the queue q.
Print the index of vertex v.

Iterate in arbitrary order through all such vertices u that u is a neighbor of v and is not marked yet as used.
Mark the vertex u as used and insert it into the tail of the queue q.

If the queue is not empty, continue from step 2.
Otherwise finish.
Since the order of choosing neighbors of each vertex can vary, it turns out that there may be multiple sequences
which BFS can print.
In this problem you are given an array  sequence corresponds to some valid BFS traversal of the given tree
starting from vertex 1. The tree is an undirected graph, such that there is exactly one simple path between
any two vertices.

The tree is given as an array of edges where edges[i] = [ui, vi] is a bidirectional edge between node ui and node vi .

Return true if the sequence is valid bfs traversal of the given tree otherwise false.

Constraints:

1≤ n ≤10^5

0<= edges.length <= n-1

1≤ ai ≤n

1<= ui, vi <=n



Expected time Complexity:  O ( nlogn )
 */
public class ValidBFS {

    public static void main(String[] args) {
        int[] seq = new int[]{0,3,2,1,4,5};
        int[][] edges = new int[][]{
                {0,1},{0,2},{0,3},{1,4},{4,5}
        };

        System.out.println(new ValidBFS().validBFS(6,seq,edges));
    }
    boolean validBFS(int n, int[] sequence, int[][] edges){
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        int[] order = new int[n];
        for(int i=0;i<sequence.length;i++){
            order[sequence[i]]=i;
        }

        print(adjList);
        for(int i=0;i<adjList.length;i++) {
            Collections.sort(adjList[i], Comparator.comparingInt(a -> order[(int) a]));
        }
        print(adjList);

        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = 1;
        int count =0;
        int[] seq = new int[n];
        while(!q.isEmpty()){
            int current = q.poll();
            seq[current] = count++;
            for(int neighbour : adjList[current]){
                if(visited[neighbour]!=1){
                    q.offer(neighbour);
                    visited[neighbour] = 1;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(order[i] != seq[i])
                return false;
        }

        return true;
    }


    private void print(ArrayList<Integer>[] adjList) {
        System.out.println("Print Adjacency List ------->");
        Arrays.stream(adjList).forEach(element -> {element.stream().forEach(value -> System.out.print(value+" "));
                                                    System.out.println();});
    }
}
