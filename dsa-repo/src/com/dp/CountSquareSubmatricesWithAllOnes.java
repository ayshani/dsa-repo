package com.dp;
/*
1277. Count Square Submatrices with All Ones

Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

TC : o(row*col)
SC: o(row*col)
 */
public class CountSquareSubmatricesWithAllOnes {

    public static void main(String[] args) {
        System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(
                new int[][]{
                        {0,1,1,1},
                        {1,1,1,1},
                        {0,1,1,1}
                }
        ));
    }
    public int countSquares(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int ans =0;
        for(int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]==1){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j], dp[i+1][j]), dp[i][j+1])+1;
                }
                ans += dp[i+1][j+1];
            }
        }

        return ans;
    }
}
