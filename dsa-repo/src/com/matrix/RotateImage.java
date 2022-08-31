package com.matrix;
/*
48. Rotate Image

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

1 2 3      7  4  1
4 5 6  ->  8  5  2
7 8 9      9  6  3

TC : o(n^2)
SC : o(1)
 */
public class RotateImage {


    public static void main(String[] args) {
        int[][] m = new int[][]{
                {7,4,1},{8,5,2},{9,6,3}
        };

        RotateImage obj = new RotateImage();
        obj.rotate(m);
        for(int i=0;i<m.length;i++){
            for(int j =0;j<m[0].length;j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for(int i=0;i<(n+1)/2 ;i++){
            for(int j=0;j<(n/2);j++){
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
