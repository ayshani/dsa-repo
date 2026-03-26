package com.prefixsum;
/*
3546. Equal Sum Grid Partition I

You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:

Each of the two resulting sections formed by the cut is non-empty.
The sum of the elements in both sections is equal.
Return true if such a partition exists; otherwise return false.



Example 1:

Input: grid = [[1,4],[2,3]]

Output: true

Explanation:
A horizontal cut between row 0 and row 1 results in two non-empty sections, each with a sum of 5.
Thus, the answer is true.

TC : o(mn)
SC: o(mn)
 */
public class EqualSumGridPartitionI {

    public static void main(String[] args) {
        System.out.println(new EqualSumGridPartitionI().canPartitionGrid(
                new int[][]{{1,4},{2,3}}
        ));
    }
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] sum = new long[m + 1][n + 1];
        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] =
                        sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + grid[i][j];
                total += grid[i][j];
            }
        }
        for (int i = 0; i < m - 1; i++) {
            if (total == sum[i + 1][n] * 2) {
                return true;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (total == sum[m][i + 1] * 2) {
                return true;
            }
        }
        return false;
    }
}
