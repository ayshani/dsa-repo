package com.matrix;
/*
766. Toeplitz Matrix

Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
Example 1:
Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
        1 2 3 4
        5 1 2 3
        9 5 1 2
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

TC : o(m*n)
SC : o(1)
 */
public class ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4},{5,1,2,3},{9,5,1,2}
        };
        System.out.println(new ToeplitzMatrix().isToeplitzMatrix(matrix));
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                if(r>0 && c>0 && matrix[r-1][c-1]!=matrix[r][c]){
                    return false;
                }
            }
        }

        return true;
    }
}
