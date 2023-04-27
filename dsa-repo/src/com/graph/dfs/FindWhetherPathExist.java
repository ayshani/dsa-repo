package com.graph.dfs;
/*
Find whether path exist
https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1

Given a grid of size n*n filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left.
The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall.
Note: There are only a single source and a single destination.

TC: o(m*n)
SC: o(1)
 */
public class FindWhetherPathExist {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {3,0,3,0,0},{3,0,0,0,3}
            ,{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}
        };
        System.out.println(new FindWhetherPathExist().is_Possible(grid));
    }
    int[] dir = new int[]{0,1,0,-1,0};
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return dfs(grid, i,j, m, n);
                }
            }
        }
        return false;
    }

    private boolean dfs(int[][] grid, int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=m || grid[i][j]==0)
            return false;
        if(grid[i][j]==2)
            return true;
        grid[i][j]=0;
        for(int d=0;d<3;d++){
            int x = i+dir[d], y =j+dir[d+1];
            if(dfs(grid, x,y,m,n))
                return true;
        }
        return false;
    }
}
