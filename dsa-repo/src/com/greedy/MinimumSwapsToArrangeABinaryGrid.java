package com.greedy;

import java.util.Arrays;

/*
1536. Minimum Swaps to Arrange a Binary Grid

Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.

A grid is said to be valid if all the cells above the main diagonal are zeros.

Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.

The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).



Example 1:
Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
Output: 3

TC : o(n^2)
SC: o(n)
 */
public class MinimumSwapsToArrangeABinaryGrid {

    public static void main(String[] args) {
        System.out.println(new MinimumSwapsToArrangeABinaryGrid().minSwaps(
                new int[][]{
                        {0,0,1},
                        {1,1,0},
                        {1,0,0}
                }
        ));
    }
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] pos = new int[n];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 1) {
                    pos[i] = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = -1;
            for (int j = i; j < n; ++j) {
                if (pos[j] <= i) {
                    ans += j - i;
                    k = j;
                    break;
                }
            }
            if (k >= 0) {
                for (int j = k; j > i; --j) {
                    int temp = pos[j];
                    pos[j] = pos[j - 1];
                    pos[j - 1] = temp;
                }
            } else {
                return -1;
            }
        }
        return ans;
    }
}
