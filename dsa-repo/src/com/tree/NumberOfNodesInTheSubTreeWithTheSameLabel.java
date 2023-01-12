package com.tree;

import java.util.*;

/*
1519. Number of Nodes in the Sub-Tree With the Same Label

You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered
from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label
which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).

The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes
ai and bi in the tree.

Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have
the same label as node i.

A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.

Example 1:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
Output: [2,1,1,1,1,1,1]
Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well,
thus the answer is 2. Notice that any node is part of its sub-tree.
Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have
different labels than node 1, the answer is just 1 (the node itself).

Algorithm
------------
Create an adjacency list where adj[X] contains all the neighbors of node X.
Initialize an array ans, storing the answer of each node. Initialize it with 0 for every node.
Start a DFS traversal.
We use a dfs function to perform the traversal.
    For each call, pass node, parent, adj, labels and ans as the parameters.
    It returns an array which stores the count of each label in the node's subtree.
    We start with node 0.
    We also keep track of the parent node of the current node so that we don’t visit
        the node’s parent as it has already been visited.
Initialize an array nodeCounts to store the count of each label in the node's subtree.
    Initialize it with 0 except for the node label, which should be 1.
Iterate over all the children of the node (nodes that share an edge) and
    check if any child is equal to the parent. If the child is equal to the parent, we will not visit it again.
If the child is not equal to the parent, recursively call the dfs function with the node as child
    and the parent as node. Store the count of all labels in its subtree in childCounts.
Add childCounts to nodeCounts.
After looping through all the children, set the ans[node] to ans[node] = nodeCounts[labels[node]].
Return nodeCounts.
Return ans.

Complexity Analysis
-----------------
Here, n is the number of nodes.

Time complexity: O(26 * n) = O(n)

Each node is visited by the dfs function once, which takes O(n) time in total.
We also iterate over the edges of every node once (since we don't visit a node more than once,
we don't iterate its edges more than once), which adds O(n) time since we have n−1 edges.
For each child of a node, we also add the counts of each label in the child's subtree to the node,
which comes with a 26 factor. Since there are n−1 edges, there are n−1 children.
So, we would take up O(26∗n) time to perform all these operations.
Additionally, we need O(n) time to initialize the adjacency list and the ans array.
Space complexity: O(26∗n)=O(n)

The recursion call stack used by dfs can have no more than nnn elements in the worst-case scenario.
Storing each element comes with a 26 factor because we create an array nodeCounts of size 26 for each node.
So, we would take up O(26∗n) space in the worst case.
We also need O(n) memory for the adjacency list and the ans array.
 */
public class NumberOfNodesInTheSubTreeWithTheSameLabel {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = new int[][]{
                {0,1},{0,2},{1,4},{1,5},{2,3},{2,6}
        };
        String labels = "abaedcd";
        int[] res = new NumberOfNodesInTheSubTreeWithTheSameLabel().countSubTrees(n,edges,labels);
        Arrays.stream(res).forEach(e -> System.out.print(e+" "));
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges){
            adj.computeIfAbsent(edge[0], value -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], value -> new ArrayList<>()).add(edge[0]);
        }

        int[] ans = new int[n];
        char[] label = labels.toCharArray();
        dfs(0,-1,adj,label,ans);
        return ans;
    }

    private int[] dfs(int node, int parent, Map<Integer,List<Integer>> adj, char[] label, int[] ans) {
        int[] nodeCounts = new int[26];
        nodeCounts[label[node] - 'a' ] = 1;

        if(!adj.containsKey(node)){
            return nodeCounts;
        }

        for(int child : adj.get(node)){
            if(child==parent)
                continue;
            int[] childCounts = dfs(child,node,adj,label,ans);

            for(int i=0;i<26;i++){
                nodeCounts[i]+= childCounts[i];
            }
        }

        ans[node] = nodeCounts[label[node]-'a'];

        return nodeCounts;
    }
}
