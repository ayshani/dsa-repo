package com.matrix;
/*
1572. Matrix Diagonal Sum

Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all
the elements on the secondary diagonal that are not part of the primary diagonal.

Example 1:
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.


TC ; o(n)
SC : o(1)
 */
public class MatrixDiagonalSum {

    public static void main(String[] args) {
        int[][] amt = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(new MatrixDiagonalSum().diagonalSum(amt));
    }
    public int diagonalSum(int[][] mat) {
        int sum =0;
        int n = mat.length;
        for(int i=0;i<n;i++){
            sum+= mat[i][i];  // Primary diagonals are row = column!
            sum+= mat[n-1-i][i]; // Secondary diagonals are row + column = n-1!
        }
        // if n is a odd number, that mean we have added the center element twice!
        return n%2==0 ? sum : sum - mat[n/2][n/2];
    }
}
