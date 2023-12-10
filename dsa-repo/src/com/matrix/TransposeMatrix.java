package com.matrix;

import java.util.Arrays;

/*
867. Transpose Matrix

Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

TC : o(m*n)
SC: o(m*n)
 */
public class TransposeMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new TransposeMatrix().transpose(
                new int[][]{
                        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                }
        )));
    }
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] b = new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                b[j][i] = matrix[i][j];
            }
        }
        return b;
    }
}
