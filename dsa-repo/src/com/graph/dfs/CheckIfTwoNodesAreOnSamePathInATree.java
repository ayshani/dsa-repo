package com.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/*
Check if two nodes are on same path in a tree
https://www.geeksforgeeks.org/check-if-two-nodes-are-on-same-path-in-a-tree/

Given a tree (not necessarily a binary tree) and a number of queries such that every query takes two nodes of
the tree as parameters. For every query pair, find if two nodes are on the same path from the root to the bottom.

inp:
1,2,3,4,5,null,6,null,null,7
Explanation
-----------
It is obvious that the Depth First Search technique is to be used to solve the above problem,
the main problem is how to respond to multiple queries fast. Here our graph is a tree which may have
any number of children. Now DFS in a tree, if started from root node, proceeds in a depth search manner
i.e. Suppose root has three children and those children have only one child with them so if DFS is started
then it first visits the first child of root node then will go deep to the child of that node.
The situation with a small tree can be shown as follows:

The order of visiting the nodes will be – 1 2 5 3 6 4 7 .
Thus, other children nodes are visited later until completely one child is successfully visited till depth.
To simplify this if we assume that we have a watch in our hand, and we start walking from the root in DFS manner.

Intime – When we visit the node for the first time
Outtime- If we again visit the node later but there are no children unvisited we call it outtime,

Note: Any node in its sub-tree will always have intime < its children (or children of children) because it is always visited first before children (due to DFS) and will have outtime > all nodes in its sub-tree because before noting the outtime it waits for all of its children to be marked visited.

For any two nodes u, v if they are in the same path then,

Intime[v] < Intime[u] and Outtime[v] > Outtime[u]
                 OR
Intime[u] < Intime[v] and Outtime[u ]> Outtime[v]
If a given pair of nodes follows any of the two conditions, then they are on the same root to the leaf path.
Else not on the same path (If two nodes are on different paths it means that no one is in the subtree of each other).
Time Complexity – O(n) for preprocessing and O(1) per query.
 */
public class CheckIfTwoNodesAreOnSamePathInATree {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1,2},{1,3},{3,6},{2,4},{2,5},{5,7},{5,8},{5,9}
        };
        GFG obj = new GFG(10,edges);
        if (obj.query(1, 5))
            System.out.print("Yes\n" );
        else
            System.out.print("No\n");

        if (obj.query(2, 9))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");

        if (obj.query(2, 6))
            System.out.print("Yes\n" );
        else
            System.out.print("No\n");

    }

}

class GFG{
    int n ;

    // To store start and end time of all vertices
    // during DFS.
    int[] inTime, outTime;

    // To keep track of visited vertices in DFS
    boolean[] visited;
    int timer;
    List<List<Integer>> graph;
    public  GFG(int n, int[][] edges){
        this.n = n;
        this.inTime = new int[n];
        this.outTime =new int[n];
        this.visited = new boolean[n];
        timer =0;
        buildGraph(edges);
    }

    private void buildGraph(int[][] edges) {
        graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }

        dfs(graph,1);
    }

    // Does DFS of given graph and fills arrays
    // intime[] and outtime[]. These arrays are used
    // to answer given queries.
    private void dfs(List<List<Integer>> graph, int src) {

        visited[src] =true;
        // Increment the timer as you enter
        // the recursion for src
        ++timer;
        // Upgrade the in time for the vertex
        inTime[src] =timer;
        for(int next : graph.get(src)){
            if(!visited[next])
                dfs(graph,next);
        }
        // Increment the timer as you exit the
        // recursion for v
        ++timer;
        // Upgrade the outtime for that node
        outTime[src] =timer;
    }

    // Returns true if 'u' and 'v' lie on
    // same root to leaf path else false.
    public boolean query(int u, int v){
        return (inTime[u]<inTime[v]&& outTime[u]>outTime[v]) || (inTime[u]>inTime[v]&& outTime[u]<outTime[v]);
    }
}
