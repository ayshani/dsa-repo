package com.graph.bridgesandarticulationpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Articulation Point - I
https://practice.geeksforgeeks.org/problems/articulation-point-1/
https://www.youtube.com/watch?v=j1QDfU21iZk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=56
Doc -https://takeuforward.org/data-structure/articulation-point-in-graph-g-56/

Given an undirected connected graph with V vertices and adjacency list adj.
You are required to find all the vertices removing which (and edges through it) disconnects the graph
into 2 or more components.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

Your Task:
You don't need to read or print anything. Your task is to complete the function articulationPoints() which takes V and adj as input parameters and returns a list containing all the vertices removing which turn the graph into two or more disconnected components in sorted order. If there are no such vertices then returns a list containing -1.


Point
------
To find out the bridges in the bridge problem, we checked inside the DFS, if there exists any alternative
path from the adjacent node to the current node.
But here we cannot do so as in this case, we are trying to remove the current node along with all the edges
linked to it. For that reason, here we will check if there exists any path from the adjacent node to the
previous node of the current node. In addition to that, we must ensure that the current node we are trying to
remove must not be the starting node.

The check conditions for this case will change like the following:
if(low[it] > tin[node])  converts to if(low[it] >= tin[node] && parent  != -1)

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
 */
public class ArticulationPointI {

    int timer =1;

    public static void main(String[] args) {
        List<List<Integer>> connections =  new ArrayList<>();
        connections.add(List.of(0,1));
        connections.add(List.of(1,4));
        connections.add(List.of(2,4));
        connections.add(List.of(3,4));
        connections.add(List.of(2,3));

        System.out.println(new ArticulationPointI().articulationPoints(5, connections));
    }

    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V, List<List<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        int[] visited = new int[V];
        int[] inTime = new int[V];
        int[] low = new int[V];
        int[] isAP = new int[V];

        for(int i=0;i<V;i++){
            if(visited[i]==0)
                dfs(i, -1, adj, visited, inTime, low, isAP);
        }

        for(int i=0;i<V;i++){
            if(isAP[i]==1)
                result.add(i);
        }

        if(result.size()==0)
            result.add(-1);
        return result;
    }

    private void dfs(int currentNode, int parent, List<List<Integer>> adj, int[] visited,
                     int[] inTime, int[] low, int[] isAP){
        visited[currentNode] = 1;
        inTime[currentNode] =timer;
        low[currentNode] = timer;
        timer++;
        int children =0;
        for(int next : adj.get(currentNode)){
            if(next==parent)
                continue;
            if(visited[next]==0){
                dfs(next, currentNode, adj, visited, inTime, low, isAP);
                low[currentNode] = Math.min(low[currentNode], low[next]);

                if(low[next]>= inTime[currentNode] && parent !=-1)
                    isAP[currentNode] =1;
                children++;
            } else{
                low[currentNode] = Math.min(low[currentNode], inTime[next]);
            }
        }

        if(children>1 && parent==-1){
            isAP[currentNode] =1;
        }
    }
}
