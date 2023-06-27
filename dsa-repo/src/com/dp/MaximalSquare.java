package com.dp;
/*
221. Maximal Square

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],
                ["1","0","1","1","1"],
                ["1","1","1","1","1"],
                ["1","0","0","1","0"]]
Output: 4

TC : o(m*n)
SC: o(m*n)
 */
public class MaximalSquare {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix== null || matrix.length==0 || matrix.length==0)
            return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max =0;
        for(int i=0;i<m;i++){
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            max = Math.max(max, dp[i][0]);
        }
        for(int i=0;i<n;i++){
            dp[0][i] = Character.getNumericValue(matrix[0][i]);
            max = Math.max(max, dp[0][i]);
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    int minCount = Math.min(dp[i-1][j],
                            Math.min(dp[i-1][j-1],dp[i][j-1]));
                    dp[i][j] = minCount +1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
