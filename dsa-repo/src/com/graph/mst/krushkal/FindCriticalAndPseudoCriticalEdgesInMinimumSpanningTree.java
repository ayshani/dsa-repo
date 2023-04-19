package com.graph.mst.krushkal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree

Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where
edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi. A minimum
spanning tree (MST) is a subset of the graph's edges that connects all vertices without cycles and with the
minimum possible total edge weight.

Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). An MST edge
whose deletion from the graph would cause the MST weight to increase is called a critical edge. On the other hand,
a pseudo-critical edge is that which can appear in some MSTs but not all.

Note that you can return the indices of the edges in any order.

Example 1:
Input: n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
Output: [[0,1],[2,3,4,5]]
Explanation: The figure above describes the graph.
Notice that the two edges 0 and 1 appear in all MSTs, therefore they are critical edges,
so we return them in the first list of the output.
The edges 2, 3, 4, and 5 are only part of some MSTs, therefore they are considered pseudo-critical edges.
We add them to the second list of the output.



TC : o(E*ElogE)
SC: o(N*3)
 */
public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1,1},{1,2,1},{0,2,1},{2,3,4},{3,4,2},{3,5,2},{4,5,2}
        };
        System.out.println(new FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree()
                .findCriticalAndPseudoCriticalEdges(6,edges));
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // have a copy of Original edges
        int originalEdges[][] = new int[edges.length][3];
        for(int i = 0; i < edges.length; i++) {
            originalEdges[i][0] = edges[i][0];
            originalEdges[i][1] = edges[i][1];
            originalEdges[i][2] = edges[i][2];
        }
        // sort in ascending order of weight
        Arrays.sort(edges, (a, b) -> a[2]-b[2]);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();
        // get original MST cost
        int originalMinCost = mst(n, edges, null,null);
        System.out.println(originalMinCost);

        for(int i=0;i<originalEdges.length;i++){
            // get MST cost by including ith edge
            int includeCost = mst(n,edges,originalEdges[i],null);
            // get MST cost by excluding ith edge
            int excludeCost = mst(n,edges,null,originalEdges[i]);
            // if excluding ith edge increase MSt cost, that means that edge is the critical edge
            if(excludeCost> originalMinCost)
                criticalEdges.add(i);
            // incase there is no change in MST cost after including the edge
            // that means it is a pseudo-critical edge i.e. if we remove it, there as alternate path
            // with same weight which can lead to MST cost
            else if(includeCost == originalMinCost){
                pseudoCriticalEdges.add(i);
            }
        }
        list.add(criticalEdges);
        list.add(pseudoCriticalEdges);
        return list;
    }

    private int mst(int n, int[][] edges, int[] include, int[] exclude){
        int minCost=0;
        UnionFind uf = new UnionFind(n);
        // if include is not null do the union and update the minCost
        if(null != include){
            uf.union(uf.find(include[0]),uf.find(include[1]));
            minCost+=include[2];
        }
        // do normal kruskal but skip include and exclude
        for(int[] edge : edges){
            if(include != null && include[0] == edge[0] && include[1] == edge[1] && include[2] == edge[2])
                continue;
            if(exclude != null && exclude[0] == edge[0] && exclude[1] == edge[1] && exclude[2] == edge[2])
                continue;
            int u= edge[0], v = edge[1], w = edge[2];
            int parentU = uf.find(u), parentV = uf.find(v);
            if(parentU!=parentV){
                uf.union(parentU,parentV);
                minCost+=w;
            }
        }

        return uf.count == n-1 ? minCost: Integer.MAX_VALUE;
    }
}
