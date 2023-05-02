package com.graph.stronglyconnectedcomponents.tarjanalgorithm;

import java.util.*;

/*
Tarjan Algorithm
https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/

DFS search produces a DFS tree/forest
Strongly Connected Components form subtrees of the DFS tree.
If we can find the head of such subtrees, we can print/store all the nodes in that subtree (including the head)
    and that will be one SCC.
There is no back edge from one SCC to another (There can be cross edges, but cross edges will not be used while
    processing the graph).

To find the head of an SCC, we calculate the disc and low array (as done for articulation point, bridge, and
biconnected component). As discussed in the previous posts, low[u] indicates the earliest visited vertex
(the vertex with minimum discovery time) that can be reached from a subtree rooted with u.
A node u is head if disc[u] = low[u]

Time Complexity:
The above algorithm mainly calls DFS, DFS takes O(V+E) for a graph represented using an adjacency list.
Auxiliary Space: O(V)
 */
public class TarjanAlgorithm {

    int timer =0;

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);

        System.out.println(new TarjanAlgorithm().tarjans(V,adj));
    }
    public List<List<Integer>> tarjans(int V, List<List<Integer>> adj)
    {
        // code here
        List<List<Integer>> result = new ArrayList<>();

        int[] low = new int[V], discovery = new int[V];
        Arrays.fill(low,-1);
        Arrays.fill(discovery,-1);
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(discovery[i]==-1){
                dfs(i,adj,visited, low,discovery,stack,result);
            }
        }

        Collections.sort(result,(a, b) -> a.get(0)-b.get(0));
        return result;
    }

    private void dfs(int cur, List<List<Integer>> adj, boolean[] visited, int[] low,
                     int[] discovery, Stack<Integer> stack,List<List<Integer>> result){
        low[cur] =timer;
        discovery[cur] = timer;
        timer++;
        visited[cur] = true;
        stack.push(cur);

        for(int next : adj.get(cur)){
            if(discovery[next]==-1){
                dfs(next,adj,visited,low,discovery,stack, result);
                low[cur] = Math.min(low[cur], low[next]);
            } else if(visited[next]){
                low[cur] = Math.min(low[cur], discovery[next]);
            }
        }
        if(low[cur] == discovery[cur]){
            ArrayList<Integer> temp = new ArrayList<>();
            while(stack.peek() != cur){
                visited[stack.peek()] = false;
                temp.add(stack.pop());
            }
            visited[stack.peek()] = false;
            temp.add(stack.pop());
            Collections.sort(temp);
            result.add(temp);
        }
    }
}
