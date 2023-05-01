package com.graph.stronglyconnectedcomponents.kosarajualgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Kosaraju Algorithm
----------------------
https://ide.geeksforgeeks.org/c3InL3WPWX
Doc - https://www.geeksforgeeks.org/strongly-connected-components/
this algorithm is used ofr finding out what are the strongly connected components are there in a graph.

A directed graph is strongly connected if there is a path between all pairs of vertices.
A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph.


This algorithm is DFS based.
1. Create an empty stack ‘S’ and do DFS traversal of a graph. In DFS traversal, after calling recursive
DFS for adjacent vertices of a vertex, push the vertex to stack.
2. Reverse directions of all arcs to obtain the transpose graph.
One by one pop a vertex from S while S is not empty. Let the popped vertex be ‘v’. Take v as source and do DFS
(call DFSUtil(v)). The DFS starting from v prints strongly connected component of v.

Time Complexity:
The above algorithm calls DFS, finds reverse of the graph and again calls DFS. DFS takes O(V+E) for a
graph represented using adjacency list. Reversing a graph also takes O(V+E) time. For reversing the graph,
we simple traverse all adjacency lists.

Space Complexity:
O(V) as we are using a stack to store the vertices.

Applications:
SCC algorithms can be used as a first step in many graph algorithms that work only on strongly connected graph.
In social networks, a group of people are generally strongly connected (For example, students of a class or any
other common place). Many people in these groups generally like some common pages or play common games. The SCC
algorithms can be used to find such groups and suggest the commonly liked pages or games to the people in the group
who have not yet liked commonly liked a page or played a game.


 */
public class KosarajuAlgorithm {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1},{1,2},{2,3},{3,0},{3,4},{4,5},{5,4}
        };
        System.out.println(new KosarajuAlgorithm().getStronglyConnectedComponents(6,edges));
    }
    public List<List<Integer>> getStronglyConnectedComponents(int n, int[][] edges){
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        // build the graph with direction
        buildGraph(n, edges, graph);

        // do the topological sort with stack
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfsWithStack(i,graph,visited, stack);
            }
        }

        // make the graph transpose i.e. reverse the edge
        List<List<Integer>> transposeGraph = new ArrayList<>();
        transposeGraph(n, transposeGraph, edges);

        // with the popping order of stack, do the dfs so that we can get
        // the strongly connected components
        Arrays.fill(visited,false);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(!visited[cur]){
                List<Integer> aux = new ArrayList<>();
                dfs(cur,transposeGraph,visited,aux);
                result.add(aux);
            }
        }
        return result;
    }

    private void dfs(int cur, List<List<Integer>> transposeGraph, boolean[] visited, List<Integer> aux) {
        visited[cur] = true;
        aux.add(cur);
        for(int next : transposeGraph.get(cur)){
            if(!visited[next]){
                dfs(next,transposeGraph,visited,aux);
            }
        }
    }

    private void transposeGraph(int n, List<List<Integer>> graph, int[][] edges) {
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[1]).add(edge[0]);
        }
    }

    private void dfsWithStack(int i, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[i] =true;
        for(int next : graph.get(i)){
            if(!visited[next]){
                dfsWithStack(next,graph,visited,stack);
            }
        }
        stack.push(i);
    }

    private void buildGraph(int n, int[][] edges, List<List<Integer>> graph) {
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }
    }

}
