package com.dp;

import java.util.Arrays;

/*
2435. Paths in Matrix Whose Sum Is Divisible by K

You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.

Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.



Example 1:


Input: grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
        5  2  4
        3  8  5
        8  7  2
Output: 2
Explanation: There are two paths where the sum of the elements on the path is divisible by k.
The first path highlighted in red has a sum of 5 + 2 + 4 + 5 + 2 = 18 which is divisible by 3.
The second path highlighted in blue has a sum of 5 + 3 + 0 + 5 + 2 = 15 which is divisible by 3.

TC : o(n^3)
SC : o(m*n*k)
 */
public class PathsInMatrixWhoseSumIsDivisibleByK {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {5,2,4},{3,0,5},{0,7,2}
        };

        System.out.println(new PathsInMatrixWhoseSumIsDivisibleByK().numberOfPaths(grid,3));
    }
    long mod = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        long[][][] dp = new long[m][n][k+1];

        for(long[][] d : dp){
            for(long[] rem : d){
                Arrays.fill(rem,-1L);
            }
        }

        return (int)recur(0,0,0, m,n,k, grid,dp);
    }

    private long recur(int i, int j, int remainder, int m, int n, int k, int[][] grid, long[][][] dp){
        if(i>=m || j>=n)
            return 0;

        if(i==m-1 && j==n-1){
            if((grid[i][j]+remainder)%k == 0)
                return 1;
            return 0;
        }

        if(dp[i][j][remainder]!=-1L)
            return dp[i][j][remainder];

        int nextRemainder = (remainder+grid[i][j])%k;
        long right = recur(i,j+1, nextRemainder, m,n,k,grid, dp);
        long down = recur(i+1,j, nextRemainder, m,n,k,grid, dp);
        return dp[i][j][remainder] = (right+down)%mod;
    }

}
