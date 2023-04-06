package com.graph.dfs;
/*
1254. Number of Closed Islands

Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected
group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

Example 1:

Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).

TC : o(n^2)
SC: o(max travel that one cell can do)
 */
public class NumberOfClosedIslands {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };

        System.out.println(new NumberOfClosedIslands().closedIsland(grid));
    }
    public int closedIsland(int[][] grid) {
        int count =0;

        int m = grid.length, n = grid[0].length;

        for(int i=0;i<m;i++){
            if(grid[i][0]==0){
                mark(grid,i,0,m,n);
            }
            if(grid[i][n-1]==0){
                mark(grid,i,n-1,m,n);
            }
        }

        for(int i=0;i<n;i++){
            if(grid[0][i]==0){
                mark(grid,0,i,m,n);
            }
            if(grid[m-1][i]==0){
                mark(grid,m-1,i,m,n);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    count++;
                    mark(grid,i,j,m,n);
                }
            }
        }
        return count;
    }

    private void mark(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==1){
            return ;
        }

        grid[i][j]=1;

        mark(grid,i+1,j,m,n);
        mark(grid,i-1,j,m,n);
        mark(grid,i,j+1,m,n);
        mark(grid,i,j-1,m,n);
    }
}
