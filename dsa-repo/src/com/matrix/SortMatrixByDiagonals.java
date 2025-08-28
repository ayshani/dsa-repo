package com.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
3446. Sort Matrix by Diagonals

You are given an n x n square matrix of integers grid. Return the matrix such that:

The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
The diagonals in the top-right triangle are sorted in non-decreasing order.


Example 1:

Input: grid = [[1,7,3],[9,8,2],[4,5,6]]

Output: [[8,2,3],[9,6,7],[4,5,1]]

Explanation:
The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:

[1, 8, 6] becomes [8, 6, 1].
[9, 5] and [4] remain unchanged.
The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:

[7, 2] becomes [2, 7].
[3] remains unchanged.

TC : o(n^2 * logn)
SC: o(n)
 */
public class SortMatrixByDiagonals {

    public static void main(String[] args) {
        int[][] res = new SortMatrixByDiagonals().sortMatrix(
                new int[][]{
                        {1,7,3},
                        {9,8,2},
                        {4,5,6}
                }
        );
        int n = res.length;
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j] +" ");
            }
            System.out.println();
        }
    }
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for(int i=0;i<n;i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;i+j<n; j++){
                tmp.add(grid[i+j][j]);
            }
            tmp.sort(Collections.reverseOrder());
            for (int j = 0; i + j < n; j++) {
                grid[i + j][j] = tmp.get(j);
            }
        }

        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("-----");
        for (int j = 1; j < n; j++) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; j + i < n; i++) {
                tmp.add(grid[i][j + i]);
            }
            Collections.sort(tmp);
            for (int i = 0; j + i < n; i++) {
                grid[i][j + i] = tmp.get(i);
            }
        }

        return grid;
    }
}
