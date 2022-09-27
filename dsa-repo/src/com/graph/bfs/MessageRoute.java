package com.graph.bfs;

import java.util.*;

/*
Message Route

There is a network of n computers, each computer is numbered 1 to n.

The computer network is given as an array of edges where edges[i] = [ui, vi]
is a bidirectional edge that connects computer ui and computer vi .

Your task is to find if Alice can send a message to Bob, if it is possible,
return minimum number of computers on such a route and if it is not possible than return -1.

Alice's Computer is 1 and Bob's computer is  n.

Constraints:

2≤ n ≤10^5
1<= edges.length <= 2*10^5
1<= ui, vi <=n

Expected Time Complexity:  O (n + edges.length)
 */
public class MessageRoute {

    public static void main(String[] args) {
        int n=5;
        int[][] edges = new int[][]{
                {0,2},{0,1},{1,3},{2,4}
        };

        System.out.println(new MessageRoute().messageRoute(n,edges));
    }
    int messageRoute(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] e: edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int source = 0, dest = n-1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent,-1);
        visited[source]= true;
        parent[source] = source;
        dist[source] =0;

        while(!q.isEmpty()){
            int currentNode = q.poll();
            for(int v : graph.get(currentNode)){
                if(!visited[v]){
                    dist[v] = dist[currentNode] + 1;
                    parent[v] = currentNode;
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }

        return dist[dest];
    }
}
