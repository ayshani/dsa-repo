package com.graph.dfs;

import java.util.*;

/*
834. Sum of Distances in Tree

There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi]
indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances
between the ith node in the tree and all other nodes.

Example 1:
Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.

Complexity Analysis

Time Complexity: O(N), where NNN is the number of nodes in the graph.

Space Complexity: O(N).
 */
public class SumOfDistancesInTree {

    List<Set<Integer>> adjList;
    int[] ans, count;
    int N;

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{
                {0,1},{0,2},{2,3},{2,4},{2,5}
        };
        int[] res = new SumOfDistancesInTree().sumOfDistancesInTree(n,edges);
        Arrays.stream(res).forEach(e -> System.out.print(e+" "));
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new HashSet<Integer>());
        }

        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        ans = new int[n];
        count = new int[n];
        Arrays.fill(count,1);
        rootDfs(0,-1);
        childDfs(0,-1);
        return ans;
    }

    /*
    Root the tree. For each node, consider the subtree S
    node of that node plus all descendants. Let count[node] be the number of nodes in SnodeS_{\text{node}}S
    node, and stsum[node] ("subtree sum") be the sum of the distances from node to the nodes in SnodeS_{\text{node}}S
    node.

    We can calculate count and stsum using a post-order traversal, where on exiting some node, the count and stsum of all descendants of this node is correct, and we now calculate count[node] += count[child] and stsum[node] += stsum[child] + count[child].

    This will give us the right answer for the root: ans[root] = stsum[root].
    */
    private void rootDfs(int node, int parent){
        for(int child : adjList.get(node)){
            if(child!=parent){
                rootDfs(child,node);
                count[node]+=count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    /*
    if we have a node parent and it's child child, then these are neighboring nodes,
    and so ans [child] = ans[parent] - count[child] + (N - count[child]). This is because
    there are count[child] nodes that are 1 easier to get to from child than parent,
    and N-count[child] nodes that are 1 harder to get to from child than parent.
    */
    private void childDfs(int node, int parent){
        for(int child : adjList.get(node)){
            if(child!=parent){
                ans[child] = ans[node] - count[child] + (N - count[child]);
                childDfs(child,node);
            }
        }
    }
}
