package com.dp;
/*
62. Unique Paths
Medium

10209

319

Add to List

Share
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take
to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Logic
--------
have one 2D array .
for first row and first column, it is always 1.
then next time onwards, add the left and top cell value.

TC : o(m*n)
SC : o(m*n)
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(4,4));
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0)
                    grid[i][j]=1;
                else{
                    grid[i][j] = grid[i-1][j]+ grid[i][j-1];
                }
            }
        }

        return grid[m-1][n-1];
    }
}
