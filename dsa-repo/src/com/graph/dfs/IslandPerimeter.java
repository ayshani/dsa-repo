package com.graph.dfs;
/*
463. Island Perimeter

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents
water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell
is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter
of the island.

Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

TC : o(m*n)
SC: o(m*n)
 */
public class IslandPerimeter {
    int count;

    public static void main(String[] args) {
        System.out.println(new IslandPerimeter().islandPerimeter(
                new int[][]{
                        {0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}
                }
        ));
    }
    int[] dir = new int[]{0,1,0,-1,0};
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i,j,m,n,grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int m , int n, int[][] grid){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0)
        {
            count++;
            return;
        }
        if(grid[i][j]==-1)
            return;
        grid[i][j]=-1;
        for(int d=0;d<4;d++){
            int x = i+dir[d];
            int y = j+dir[d+1];
            dfs(x,y,m,n,grid);
        }
    }

}
