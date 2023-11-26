package com.greedy;

import java.util.Arrays;

/*
1727. Largest Submatrix With Rearrangements

You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in
any order.

Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering
the columns optimally.

Example 1:
Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
Output: 4
Explanation: You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 4.

TC : o(m*n*logn)
SC: o(n)
 */
public class LargestSubmatrixWithRearrangements {

    public static void main(String[] args) {
        System.out.println(new LargestSubmatrixWithRearrangements()
                .largestSubmatrix(new int[][]{
                        {0,0,1},{1,1,1},{1,0,1}
                }));

    }
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }

            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for (int i = 0; i < n; i++) {
                /*
                Note that in Java, we can't conveniently sort int[] in descending order, so we sort it in ascending
                order and consider the base to the right of each column instead. For each column i, every column to
                its right has a height greater than or equal to the current height. Thus, we can treat the number of
                columns n - i as the base to form a submatrix with the current height.
                */
                ans = Math.max(ans, currRow[i] * (n-i));
            }
        }

        return ans;
    }
}
