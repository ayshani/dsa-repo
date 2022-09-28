package com.graph.dfs;
/*
695. Max Area of Island

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected
4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
                [0,0,0,0,0,0,0,1,1,1,0,0,0],
                [0,1,1,0,1,0,0,0,0,0,0,0,0],
                [0,1,0,0,1,1,0,0,1,0,1,0,0],
                [0,1,0,0,1,1,0,0,1,1,1,0,0],
                [0,0,0,0,0,0,0,0,0,0,1,0,0],
                [0,0,0,0,0,0,0,1,1,1,0,0,0],
                [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

TC : o(m*n)
SC : o(m*n)
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0}
        };

        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea=0;
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(grid[i][j]== 1 && !visited[i][j]){
                   maxArea =  Math.max(maxArea, dfs(grid,visited, i,j,m,n));
               }
           }
        }

        return maxArea;
    }

    private int dfs(int[][] grid , boolean[][] visited, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || grid[i][j]!=1)
            return 0;

        visited[i][j]= true;

        return 1+ dfs(grid,visited,i+1,j,m,n)+
                dfs(grid,visited,i-1,j,m,n)+
                dfs(grid,visited,i,j+1,m,n)+
                dfs(grid,visited,i,j-1,m,n);

    }
}
