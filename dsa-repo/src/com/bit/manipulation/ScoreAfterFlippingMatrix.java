package com.bit.manipulation;
/*
861. Score After Flipping Matrix

You are given an m x n binary matrix grid.

A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score after making any number of moves (including zero moves).



Example 1:
Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

TC : o(m*n)
SC: o(1)
 */
public class ScoreAfterFlippingMatrix {

    public static void main(String[] args) {
        System.out.println(new ScoreAfterFlippingMatrix().matrixScore(
                new int[][]{
                        {0,0,1,1},
                        {1,0,1,0},
                        {1,1,0,0}
                }
        ));
    }
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Set score to summation of first column
        int score = (1 << (n - 1)) * m;

        // Loop over all other columns
        for (int j = 1; j < n; j++) {
            int countSameBits = 0;
            for (int i = 0; i < m; i++) {
                // Count elements matching first in row
                if (grid[i][j] == grid[i][0]) {
                    countSameBits++;
                }
            }

            // Calculate score based on the number of same bits in a column
            countSameBits = Math.max(countSameBits, m - countSameBits);
            // Calculate the score contribution for the current column
            int columnScore = (1 << (n - j - 1)) * countSameBits;
            // Add contribution to score
            score += columnScore;
        }
        return score;
    }
}
