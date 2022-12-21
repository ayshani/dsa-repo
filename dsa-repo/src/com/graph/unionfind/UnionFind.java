package com.graph.unionfind;

public class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i=0;i<size;i++){
            parent[i] =i;
        }
    }

    public int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int xSet = find(x), ySet = find(y);

        if(xSet==ySet)
            return;
        else if(rank[xSet]>rank[ySet]){
            parent[ySet] = xSet;
        } else if(rank[xSet]<rank[ySet]){
            parent[xSet] = ySet;
        } else{
            parent[ySet] = xSet;
            rank[xSet]++;
        }
    }
}
