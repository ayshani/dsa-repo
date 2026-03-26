package com.matrix;

import com.prefixsum.EqualSumGridPartitionI;

import java.util.HashSet;
import java.util.Set;

/*
3548. Equal Sum Grid Partition II

You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:

Each of the two resulting sections formed by the cut is non-empty.
The sum of elements in both sections is equal, or can be made equal by discounting at most one single cell in total (from either section).
If a cell is discounted, the rest of the section must remain connected.
Return true if such a partition exists; otherwise, return false.

Note: A section is connected if every cell in it can be reached from any other cell by moving up, down, left, or right through other cells in the section.



Example 1:

Input: grid = [[1,4],[2,3]]

Output: true

Explanation:

A horizontal cut after the first row gives sums 1 + 4 = 5 and 2 + 3 = 5, which are equal. Thus, the answer is true.

TC : o(mn)
SC: o(mn)
Explanation : https://leetcode.com/problems/equal-sum-grid-partition-ii/editorial/?envType=daily-question&envId=2026-03-26#approach-rotation-matrix--hash-table--enumeration-of-the-upper-matrix-sum

 */
public class EqualSumGridPartitionII {

    public static void main(String[] args) {
        System.out.println(new EqualSumGridPartitionII().canPartitionGrid(
                new int[][]{{1,4},{2,3}}
        ));
    }
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        for (int k = 0; k < 4; k++) {
            Set<Long> exist = new HashSet<>();
            exist.add(0L);
            long sum = 0;
            m = grid.length;
            n = grid[0].length;
            if (m < 2) {
                grid = rotation(grid);
                continue;
            }
            if (n == 1) {
                for (int i = 0; i < m - 1; i++) {
                    sum += grid[i][0];
                    long tag = sum * 2 - total;
                    if (tag == 0 || tag == grid[0][0] || tag == grid[i][0]) {
                        return true;
                    }
                }
                grid = rotation(grid);
                continue;
            }
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    exist.add((long) grid[i][j]);
                    sum += grid[i][j];
                }
                long tag = sum * 2 - total;
                if (i == 0) {
                    if (
                            tag == 0 || tag == grid[0][0] || tag == grid[0][n - 1]
                    ) {
                        return true;
                    }
                    continue;
                }
                if (exist.contains(tag)) {
                    return true;
                }
            }
            grid = rotation(grid);
        }
        return false;
    }

    public int[][] rotation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][m - 1 - i] = grid[i][j];
            }
        }
        return tmp;
    }
}
