package com.dp;
/*
1981. Minimize the Difference Between Target and Chosen Elements

You are given an m x n integer matrix mat and an integer target.

Choose one integer from each row in the matrix such that the absolute difference between target
and the sum of the chosen elements is minimized.
Return the minimum absolute difference.
The absolute difference between two numbers a and b is the absolute value of a - b.

Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
Output: 0
Explanation: One possible choice is to:
- Choose 1 from the first row.
- Choose 5 from the second row.
- Choose 7 from the third row.
The sum of the chosen elements is 13, which equals the target, so the absolute difference is 0.

TC : o(n*k)
SC : o(n*5001)
 */
public class MinimizeTheDifferenceBetweenTargetAndChosenElements {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };

        System.out.println(new MinimizeTheDifferenceBetweenTargetAndChosenElements().minimizeTheDifference(mat,13));
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        Integer[][] dp = new Integer[mat.length][5001];
        return minDifference(mat, 0,target,0,dp);
    }

    private int minDifference(int[][] mat, int index, int target, int val, Integer[][] dp){
        if(index== mat.length){
            return Math.abs(val-target);
        }

        if(null != dp[index][val])
            return dp[index][val];

        int res = Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            res = Math.min(res, minDifference(mat,index+1,target,val+mat[index][i], dp));
        }

        return dp[index][val] = res;
    }
}
