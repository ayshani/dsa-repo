package com.graph.dfs;
/*
1568. Minimum Number of Days to Disconnect Island

You are given an m x n binary grid grid where 1 represents land and 0 represents water. An island is a maximal
4-directionally (horizontal or vertical) connected group of 1's.

The grid is said to be connected if we have exactly one island, otherwise is said disconnected.

In one day, we are allowed to change any single land cell (1) into a water cell (0).

Return the minimum number of days to disconnect the grid.

Example 1:

Input: grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]

Output: 2
Explanation: We need at least 2 days to get a disconnected grid.
Change land grid[1][1] and grid[0][2] to water and get 2 disconnected island.

TC : o(n^4)
SC: o(n^2)
 */
public class MinimumNumberOfDaysToDisconnectIsland {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfDaysToDisconnectIsland().minDays(
                new int[][]{
                        {0,1,1,0},{0,1,1,0},{0,0,0,0}
                }
        ));
    }
    public int minDays(int[][] grid) {
        if(noOfIsland(grid) != 1){
            return 0;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(noOfIsland(grid) != 1){
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private int noOfIsland(int [][]grid){
        int ans = 0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    ans ++;
                    dfs(visited, grid,i,j);
                }
            }
        }
        return ans;
    }

    private void dfs(boolean [][]visited, int [][]grid,int i, int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || visited[i][j] || grid[i][j] == 0){
            return ;
        }
        visited[i][j] = true;
        dfs(visited, grid, i-1, j);
        dfs(visited, grid, i+1, j);
        dfs(visited, grid, i, j-1);
        dfs(visited, grid, i, j+1);
    }
}
