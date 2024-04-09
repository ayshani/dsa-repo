package com.graph.mst.krushkal;
/*
https://www.scaler.com/topics/data-structures/kruskal-algorithm/

KrusKal Algorithm
------------------
Kruskal's algorithm is a greedy algorithm in graph theory that is used to find the Minimum
spanning tree (A subgraph of a graph G(V,E) which is a tree and includes all the vertices of the given graph
such that the sum of the weight of the edges is minimum) of a given connected, weighted, undirected graph.

In case, the graph is not connected, on applying Kruskal's algorithm we can find the MST of each connected component.

Algorithm
-------------
1. Sort all edges in ascending order of weight.
2. loop over every edge and check if vertices connecting that edge if we consider doesnt make a cycle.
3. Incase it doesn't make a cycle , do union of both vertices and go for next edge and so on.

Complexity Analysis
--------
Time Complexity -
Sorting of E edges costs us O(E∗log(E)) time.
For each edge, we are using the Union-Find algorithm which costs us O(E∗α(V)) time.
As discussed in DSU, for practical values of i.e. V≤10^80

 we can write
O(E∗α(V)) as O(E) because O(α(V)) ≃ O(1).
Hence, the overall time complexity is O(E∗log(E)+E) ≃ O(E∗log(E))
Space Complexity - We are using a List/Vector to store the
E edges of the given graph so the space complexity is O(E).
*/

import java.util.Arrays;

public class KrusKalAlgorithm {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1,7},{0,2,8},{1,2,3},{1,4,6},{2,3,3},{2,4,4},{3,4,2},{3,5,2},{4,5,2}
        };
        System.out.println(new KrusKalAlgorithm().getMinimumCostFromKrusKalAlgorithm(edges,6));
    }
    public int getMinimumCostFromKrusKalAlgorithm(int[][] edges, int n){

        int minCost =0;

        Arrays.sort(edges,(a,b)-> a[2]-b[2]);
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            int u=edge[0], v = edge[1], cost = edge[2];
            int parentU = uf.find(u), parentV = uf.find(v);
            if(parentU!=parentV){
                minCost+= cost;
                uf.union(parentU,parentV);
            }
        }
        return minCost;
    }

}

class UnionFind{
    int[] parent, rank, weight;
    int count;
    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        weight = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        count=0;
    }

    public int find(int x){
        if(x==parent[x])
            return x;
        parent[x] =  find(parent[x]);
        return parent[x];
    }

    // find parent withing strictly less than limit
    // incase its not possible to get, we return the x itself.
    // not doing any path compression
    public int find(int x, int limit){
        if(x==parent[x]|| weight[x]>=limit)
            return x;
        return find(parent[x], limit);
    }

    public void union(int x, int y){
        int parentX = find(x), parentY = find(y);

        if(parentX==parentY)
            return;
        count++;
        if(rank[parentX]>rank[parentY]){
            parent[parentY]= parentX;
        } else if(rank[parentX]<rank[parentY]) {
            parent[parentX]= parentY;
        } else {
            parent[parentY]= parentX;
            rank[parentX]++;
        }
    }

    // we are finding actual parent of the node and doing union of both of them
    public void union(int x, int y, int limit, int imax){
        // sending imax as we don't care amy any limit when we are finding parent.
        // its only finding parent irrespective of the limit.
        int parentX = find(x,imax), parentY = find(y,imax);
        if(parentX ==parentY)
            return;
        if(rank[parentY]<rank[parentX]){
            parent[parentY] = parentX;
            weight[parentY] = limit;
        } else if(rank[parentY]>rank[parentX]){
            parent[parentX] = parentY;
            weight[parentX] = limit;
        } else{
            parent[parentY] = parentX;
            weight[parentY] = limit;
            rank[parentX]++;
        }
    }

    public void reset(int x) {
        parent[x]=x;
    }
}
