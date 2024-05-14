package com.graph.dfs;
/*
1219. Path with Maximum Gold

In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that
cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.


Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.

Let n be the number of rows in the grid, m be the number of columns, and g be the number of gold cells.
TC : o(m*n*4^g)
SC: o(4^g)
 */
public class PathWithMaximumGold {

    public static void main(String[] args) {
        System.out.println(new PathWithMaximumGold().getMaximumGold(
                new int[][]{
                        {0,6,0},
                        {5,8,7},
                        {0,9,0}
                }
        ));
    }
    int[] direction = new int[]{0,1,0,-1,0};

    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int maxGold =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxGold = Math.max(maxGold, dfs(grid, i,j, m,n));
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0){
            return 0;
        }

        int originalValue = grid[i][j], maxGold =0;
        grid[i][j] = 0;

        for(int d =0;d<4; d++){
            maxGold = Math.max(maxGold, dfs(grid, i+direction[d], j+ direction[d+1], m,n));
        }
        grid[i][j] = originalValue;
        return maxGold + originalValue;
    }
}
