package com.graph.stronglyconnectedcomponents.bridgesandarticulationpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
finding bridges in a graph.
 https://www.youtube.com/watch?v=qrAub5z8FeA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=55
 bridges are those edges which when deleted, can divide the graph into two or more components.
 this uses Tarjan Algorithm.
 doc - https://cp-algorithms.com/graph/bridge-searching.html#algorithm
       https://www.geeksforgeeks.org/bridge-in-a-graph/


 Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.

Time Complexity: O(V+2E), where V = no. of vertices, E = no. of edges. It is because the algorithm is just a
simple DFS traversal.

Space Complexity: O(V+2E) + O(3V), where V = no. of vertices, E = no. of edges. O(V+2E) to store the graph in
an adjacency list and O(3V) for the three arrays i.e. tin, low, and vis, each of size V.

 */
public class FindAllBridges {

    int timer =1;

    public static void main(String[] args) {
        List<List<Integer>> edges =  new ArrayList<>();
        edges.add(Arrays.asList(0,1));
        edges.add(Arrays.asList(1,2));
        edges.add(Arrays.asList(2,0));
        edges.add(Arrays.asList(1,3));

        System.out.println(new FindAllBridges().findAllBridges(4,edges));
    }
    public List<List<Integer>> findAllBridges(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();

        // build graph
        buildGraph(n, connections, graph);

        int[] visited = new int[n];
        // time when we first time visit the node
        int[] inTime = new int[n];
        // lowest time which can be reched from a particular node
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,graph,visited,inTime, low, bridges);

        return bridges;

    }

    private void dfs(int currentNode, int parent,List<List<Integer>> graph, int[] visited, int[] inTime, int[] low,
                     List<List<Integer>> bridges) {
        visited[currentNode] = 1;
        inTime[currentNode] = timer;
        low[currentNode] = timer;
        timer++;

        for(int next : graph.get(currentNode)){
            // if we get next node as parent, we dont consider this
            // as we are going to consider parent->next edge elimination.
            // so there is no need to consider this. we need to check if we can go
            // to ancestor above the parent.
            if(next==parent)
                continue;
            // if this is first time we are visiting a neighbour
            if(visited[next]==0){
                // do the dfs
                dfs(next, currentNode,graph, visited, inTime, low, bridges);
                // once dfs is completed, we take the min low of neighbour and it own self
                low[currentNode] =  Math.min(low[next], low[currentNode]);
                // incase the lowest reach time is greater than current node's inTime
                // that means we can't reach from neighbour to this current node if this current->next
                // edge is removed
                if(low[next] > inTime[currentNode] ){
                    bridges.add(Arrays.asList(currentNode, next));
                }
            } else{
                // if we have already visited then we just update our low values
                // as it can never be a bridge  but we can update our lowest time from this
                // current node
                low[currentNode] =  Math.min(inTime[next], low[currentNode]);
            }
        }

    }

    private void buildGraph(int n, List<List<Integer>> edges, List<List<Integer>> graph){
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.size();i++){
            int u = edges.get(i).get(0), v = edges.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
}
