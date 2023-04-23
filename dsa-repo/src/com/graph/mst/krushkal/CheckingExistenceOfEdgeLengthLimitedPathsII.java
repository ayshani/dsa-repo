package com.graph.mst.krushkal;

import java.util.Arrays;

/*
1724. Checking Existence of Edge Length Limited Paths II

An undirected graph of n nodes is defined by edgeList, where edgeList[i] = [ui, vi, disi]
denotes an edge between nodes ui and vi with distance disi. Note that there may be multiple edges between two nodes,
and the graph may not be connected.

Implement the DistanceLimitedPathsExist class:

DistanceLimitedPathsExist(int n, int[][] edgeList) Initializes the class with an undirected graph.
boolean query(int p, int q, int limit) Returns true if there exists a path from p to q such that each edge on the
    path has a distance strictly less than limit, and otherwise false.

Example 1:
Input
["DistanceLimitedPathsExist", "query", "query", "query", "query"]
[[6, [[0, 2, 4], [0, 3, 2], [1, 2, 3], [2, 3, 1], [4, 5, 5]]], [2, 3, 2], [1, 3, 3], [2, 0, 3], [0, 5, 6]]
Output
[null, true, false, true, false]

Explanation
DistanceLimitedPathsExist distanceLimitedPathsExist = new DistanceLimitedPathsExist(6, [[0, 2, 4], [0, 3, 2], [1, 2, 3], [2, 3, 1], [4, 5, 5]]);
distanceLimitedPathsExist.query(2, 3, 2); // return true. There is an edge from 2 to 3 of distance 1, which is less than 2.
distanceLimitedPathsExist.query(1, 3, 3); // return false. There is no way to go from 1 to 3 with distances strictly less than 3.
distanceLimitedPathsExist.query(2, 0, 3); // return true. There is a way to go from 2 to 0 with distance < 3: travel from 2 to 3 to 0.
distanceLimitedPathsExist.query(0, 5, 6); // return false. There are no paths from 0 to 5.

Explanation----
We build a tree by Union-Find with no path compression.
And each time we query, we find the parents as long as the edge weight is smaller than limit.

TC: o(nlogn)
SC: o(n)
 */
public class CheckingExistenceOfEdgeLengthLimitedPathsII {

    public static void main(String[] args) {
        DistanceLimitedPathsExist distanceLimitedPathsExist = new DistanceLimitedPathsExist(6,
                new int[][]{{0, 2, 4}, {0, 3, 2}, {1, 2, 3}, {2, 3, 1}, {4, 5, 5}});

        // return true. There is an edge from 2 to 3 of distance 1, which is less than 2.
        System.out.println(distanceLimitedPathsExist.query(2, 3, 2));

        // return false. There is no way to go from 1 to 3 with distances strictly less than 3.
        System.out.println(distanceLimitedPathsExist.query(1, 3, 3));

        // return true. There is a way to go from 2 to 0 with distance < 3: travel from 2 to 3 to 0.
        System.out.println(distanceLimitedPathsExist.query(2, 0, 3));

        // return false. There are no paths from 0 to 5.
        System.out.println(distanceLimitedPathsExist.query(0, 5, 6));
    }

}

class DistanceLimitedPathsExist {

    UnionFind uf;
    final int imax = Integer.MAX_VALUE;
    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        uf = new UnionFind(n);
        // sorting in ascending order
        Arrays.sort(edgeList, (a, b) -> a[2]-b[2]);

        // as we start from smallest weight, so technically, we are making the edge[0]
        // of smallest weighted edge as the parent of the component and so does the weight
        // in UnionFind gets calculated.
        for(int[] edge : edgeList){
            uf.union(edge[0], edge[1], edge[2],imax);
        }
    }

    // here we find the parent within limit
    public boolean query(int p, int q, int limit) {
        return uf.find(p,limit)==uf.find(q,limit);
    }
}
