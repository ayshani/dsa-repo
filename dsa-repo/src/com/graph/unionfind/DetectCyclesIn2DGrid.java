package com.graph.unionfind;

import java.util.Arrays;

/*
1559. Detect Cycles in 2D Grid

Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same
value in grid.

A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can
move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same
value of the current cell.

Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1)
is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.

Return true if any cycle of the same value exists in grid, otherwise, return false.



Example 1:
Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
Output: true

TC : o(mn* a(mn))
SC: o(mn)
 */
public class DetectCyclesIn2DGrid {
    public static void main(String[] args) {
        System.out.println(new DetectCyclesIn2DGrid().containsCycle(
                new char[][]{
                        {'a','a','a','a'},
                        {'a','b','b','a',},
                        {'a','b','b','a',},
                        {'a','a','a','a',}
                }
        ));
    }
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        CycleUnionFind uf = new CycleUnionFind(m*n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                /*
                Since the Union-Find structure is one-dimensional while grid is two-dimensional,
                we map each position (i,j) to a one-dimensional index using i×n+j:

                The position above (i,j) maps to (i−1)×n+j.
                The position to the left of (i,j) maps to i×n+j−1.
                 */
                if(i > 0 && grid[i][j] == grid[i-1][j] ){
                    if(!uf.findAndUnite(i*n+j, (i-1)*n+j)){
                        return true;
                    }
                }
                if(j>0 && grid[i][j] == grid[i][j-1]){
                    if(!uf.findAndUnite(i*n+j, i*n+j-1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class CycleUnionFind {
    int[] parent, size;
    int n, setCount;

    public CycleUnionFind(int n){
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);
        this.n = n;
        setCount =n;
    }

    public int findSet(int x){
        return parent[x] == x ? x : (parent[x] = findSet(parent[x]));
    }

    public void unite(int x, int y){
        if(size[x] < size[y]){
            int temp = x;
            x = y;
            y = temp;
        }

        parent[y] = x;
        size[x] += size[y];
        --setCount;
    }

    public boolean findAndUnite(int x, int y){
        int parentX = findSet(x);
        int parentY = findSet(y);
        if(parentX != parentY){
            unite(parentX, parentY);
            return true;
        }
        return false;
    }
}