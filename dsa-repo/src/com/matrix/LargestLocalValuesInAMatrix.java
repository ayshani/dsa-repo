package com.matrix;

import java.util.Arrays;

/*
2373. Largest Local Values in a Matrix

You are given an n x n integer matrix grid.

Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:

maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.

Return the generated matrix.

Example 1:
Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
Output: [[9,9],[8,6]]
Explanation: The diagram above shows the original matrix and the generated matrix.
Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.

TC : o(n*n*3*3) = o(n*n)
SC: o(1)
 */
public class LargestLocalValuesInAMatrix {

    public static void main(String[] args) {
        int[][] inp = new int[][]{
                {9,9,8,1},
                {5,6,2,6},
                {8,2,6,4},
                {6,2,2,2}
        };
        int[][] res = new LargestLocalValuesInAMatrix().largestLocal(inp);
        Arrays.stream(res).forEach(e -> System.out.println(Arrays.toString(e)));
    }
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];

        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                // for each cell, iterate over 3x3 and get the max
                int max = 0;
                for(int k= i;k<i+3;k++){
                    for(int l = j; l<j+3; l++){
                        max = Math.max(max, grid[k][l]);
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }
}
