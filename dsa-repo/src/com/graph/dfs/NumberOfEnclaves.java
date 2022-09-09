package com.graph.dfs;
/*
1020. Number of Enclaves

You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally)
land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
        0  0  0  0
        1  0  1  0
        0  1  1  0
        0  0  0  0
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Time: O(m * n), space: O(m * n)

 */
public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}
        };

        System.out.println(new NumberOfEnclaves().numEnclaves(grid));
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i== m-1 || j==n-1) && (grid[i][j]==1))
                    dfs(grid, i,j,m,n);
            }
        }

        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    count++;
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0)
            return;

        grid[i][j]=0;
        dfs(grid,i,j-1,m,n);
        dfs(grid,i,j+1,m,n);
        dfs(grid,i+1,j,m,n);
        dfs(grid,i-1,j,m,n);
    }

}
