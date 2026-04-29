package com.dp;
/*
3225. Maximum Score From Grid Operations

You are given a 2D matrix grid of size n x n. Initially, all cells of the grid are colored white. In one operation,
you can select any cell of indices (i, j), and color black all the cells of the jth column starting from the top row
down to the ith row.

The grid score is the sum of all grid[i][j] such that cell (i, j) is white and it has a horizontally adjacent black cell.

Return the maximum score that can be achieved after some number of operations.



Example 1:

Input: grid = [[0,0,0,0,0],[0,0,3,0,0],[0,1,0,0,0],[5,0,0,3,0],[0,0,0,0,2]]

Output: 11

Explanation:

In the first operation, we color all cells in column 1 down to row 3, and in the second operation, we color all
cells in column 4 down to the last row. The score of the resulting grid is grid[3][0] + grid[1][2] + grid[3][3]
which is equal to 11.

TC : o(n^3)
SC: o(n^3)
 */
public class MaximumScoreFromGridOperations {

    public static void main(String[] args) {
        System.out.println(new MaximumScoreFromGridOperations().maximumScore(
                new int[][]{
                        {0,0,0,0,0},
                        {0,0,3,0,0},
                        {0,1,0,0,0},
                        {5,0,0,3,0},
                        {0,0,0,0,2}
                }
        ));
    }
    public long maximumScore(int[][] grid) {
        int n = grid[0].length;
        if (n == 1) {
            return 0;
        }

        long[][][] dp = new long[n][n + 1][n + 1];
        long[][] prevMax = new long[n + 1][n + 1];
        long[][] prevSuffixMax = new long[n + 1][n + 1];
        long[][] colSum = new long[n][n + 1];

        for (int c = 0; c < n; c++) {
            for (int r = 1; r <= n; r++) {
                colSum[c][r] = colSum[c][r - 1] + grid[r - 1][c];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int currH = 0; currH <= n; currH++) {
                for (int prevH = 0; prevH <= n; prevH++) {
                    if (currH <= prevH) {
                        long extraScore = colSum[i][prevH] - colSum[i][currH];
                        dp[i][currH][prevH] = Math.max(
                                dp[i][currH][prevH],
                                prevSuffixMax[prevH][0] + extraScore
                        );
                    } else {
                        long extraScore =
                                colSum[i - 1][currH] - colSum[i - 1][prevH];
                        dp[i][currH][prevH] = Math.max(
                                dp[i][currH][prevH],
                                Math.max(
                                        prevSuffixMax[prevH][currH],
                                        prevMax[prevH][currH] + extraScore
                                )
                        );
                    }
                }
            }

            for (int currH = 0; currH <= n; currH++) {
                prevMax[currH][0] = dp[i][currH][0];
                for (int prevH = 1; prevH <= n; prevH++) {
                    long penalty = (prevH > currH)
                            ? (colSum[i][prevH] - colSum[i][currH])
                            : 0;
                    prevMax[currH][prevH] = Math.max(
                            prevMax[currH][prevH - 1],
                            dp[i][currH][prevH] - penalty
                    );
                }

                prevSuffixMax[currH][n] = dp[i][currH][n];
                for (int prevH = n - 1; prevH >= 0; prevH--) {
                    prevSuffixMax[currH][prevH] = Math.max(
                            prevSuffixMax[currH][prevH + 1],
                            dp[i][currH][prevH]
                    );
                }
            }
        }

        long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, Math.max(dp[n - 1][n][k], dp[n - 1][0][k]));
        }

        return ans;
    }
}
