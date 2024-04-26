package com.dp;
/*
1289. Minimum Falling Path Sum II

Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no
two elements chosen in adjacent rows are in the same column.

Example 1:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation:
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.

TC : o(n^3)
SC: o(n^2)
 */
public class MinimumFallingPathSumII {

    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSumII().minFallingPathSum(
                new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                }
        ));
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] memo = new int[n][n];

        // fill the last row
        for(int i=0;i<n;i++){
            memo[n-1][i] = grid[n-1][i];
        }

        // fill the rest of the row from n-2 to 0
        for(int row = n-2; row>=0; row--){
            for(int col = 0; col<n; col++){
                // get the min
                int nextMin = Integer.MAX_VALUE;
                for(int nextCol = 0; nextCol <n; nextCol++){
                    if(nextCol != col){
                        nextMin = Math.min(nextMin, memo[row+1][nextCol]);
                    }
                }

                memo[row][col] = grid[row][col] + nextMin;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int col =0; col<n;col++){
            ans = Math.min(ans, memo[0][col]);
        }
        return ans;
    }
}
