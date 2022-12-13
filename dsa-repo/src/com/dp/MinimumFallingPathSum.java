package com.dp;

import java.util.Arrays;

/*
931. Minimum Falling Path Sum

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that
is either directly below or diagonally left/right. Specifically,
the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Example 1:
Input: matrix = [[2,1,3],
                 [6,5,4],
                 [7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
(1,5,7) , (1,4,8)

Explanation
--------
The minimum path to get to element A[i][j] is the minimum of A[i - 1][j - 1], A[i - 1][j] and A[i - 1][j + 1].
Starting from row 1, we add the minumum path to each element.
he smallest number in the last row is the miminum path sum.
Example:
[1, 2, 3]
[4, 5, 6] => [5, 6, 8]
[7, 8, 9] => [7, 8, 9] => [12, 13, 15]

TC : o(n^2)
SC : o(1)
 */
public class MinimumFallingPathSum {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println(new MinimumFallingPathSum().minFallingPathSum(nums));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        for(int i=1;i<m;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] += Math.min(matrix[i-1][j],
                        Math.min(matrix[i-1][Math.max(0,j-1)], matrix[i-1][Math.min(j+1,m-1)]));
            }
        }

        return Arrays.stream(matrix[m-1]).min().getAsInt();
    }
}
