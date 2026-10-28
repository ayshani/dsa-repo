package com.dp;
/*
3882. Minimum XOR Path in a Grid

You are given a 2D integer array grid of size m * n.

You start at the top-left cell (0, 0) and want to reach the bottom-right cell (m - 1, n - 1).

At each step, you may move either right or down.

The cost of a path is defined as the bitwise XOR of all the values in the cells along that path,
including the start and end cells.

Return the minimum possible XOR value among all valid paths from (0, 0) to (m - 1, n - 1).



Example 1:

Input: grid = [[1,2],[3,4]]

Output: 6

Explanation:

There are two valid paths:

(0, 0) → (0, 1) → (1, 1) with XOR: 1 XOR 2 XOR 4 = 7
(0, 0) → (1, 0) → (1, 1) with XOR: 1 XOR 3 XOR 4 = 6
The minimum XOR value among all valid paths is 6.

TC : o(m*n*1024)
SC: o(n*1024)
 */
public class MinimumXORPathInAGrid {

    public static void main(String[] args) {
        System.out.println(new MinimumXORPathInAGrid().minCost(
                new int[][]{{1,2},{3,4}}
        ));
    }
    public int minCost(int[][] grid) {
        int n = grid[0].length;
        boolean[][] dp = new boolean[n][1024];
        dp[0][0] = true;

        for(int[] row: grid){
            for(int j=0;j<n;j++){
                boolean[] next = new boolean[1024];
                for(int x=0;x<1024;x++){
                    if(dp[j][x] || j>0 && dp[j-1][x]){
                        next[x^row[j]] = true;
                    }
                }
                dp[j] = next;
            }
        }
        int x=0;
        while(!dp[n-1][x]){
            x++;
        }
        return x;
    }
}
