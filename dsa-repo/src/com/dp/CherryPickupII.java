package com.dp;
/*
1463. Cherry Pickup II

You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number
of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.


Example 1:
Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.

TC : o(m*n*n)
SC: o(m*n*n)
 */
public class CherryPickupII {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {3,1,1},
                {2,5,1},
                {1,5,5},
                {2,1,1}
        };
        System.out.println(new CherryPickupII().cherryPickup(grid));
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp= new Integer[m][n][n];
        return util(grid, m,n, 0, 0, n-1, dp);
    }

    private int util(int[][] grid, int m, int n, int r, int c1, int c2, Integer[][][] dp){
        if(r==m)
            return 0;
        if(dp[r][c1][c2]!= null){
            return dp[r][c1][c2];
        }

        int ans =0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nc1 = c1+ i, nc2 = c2 + j;
                if(nc1>=0 && nc1<n && nc2>=0 && nc2<n){
                    ans = Math.max(ans, util(grid, m,n, r+1, nc1, nc2, dp));
                }
            }
        }
        int cherries = c1==c2? grid[r][c1] : grid[r][c1]+ grid[r][c2];
        return dp[r][c1][c2] = ans + cherries;
    }
}
