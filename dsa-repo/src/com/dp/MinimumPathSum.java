package com.dp;
/*
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
        1 3 1
        1 5 1
        4 2 1
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Logic
-------
The idea is to sum up the first row and first column as there is no way to reach to that point other
than to go right or down respectively. For the rest of the grid[i][j] (for all i >1 and j >1)
find the minimum of the grid-left (j-1) and grid-top (i-1) value and add to the current grid value.
At the end, the minimum path sum would be the bottom last value in the grid.

TC : o(m*n)
SC : o(1)

 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i=1;i<n;i++){
            grid[0][i]+= grid[0][i-1];
        }
        for(int i=1;i<m;i++){
            grid[i][0]+= grid[i-1][0];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }

        return grid[m-1][n-1];
    }
}

