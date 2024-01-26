package com.dp;
/*
576. Out of Boundary Paths

There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid
crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball
out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

Example 1:

Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6

TC : o(m*n*maxMove)
SC : o(m*n*maxMove)
 */
public class OutOfBoundaryPaths {

    public static void main(String[] args) {
        System.out.println(new OutOfBoundaryPaths().findPaths(2,2,2,0,0));
    }
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] memo = new Integer[m][n][maxMove+1];

        return util(m,n, maxMove, startRow, startColumn,memo);
    }

    private int util(int m, int n, int maxMove, int startRow, int startColumn, Integer[][][] memo){
        if(startRow<0 || startRow>=m || startColumn<0 || startColumn>=n)
            return 1;

        if(maxMove==0)
            return 0;

        if(memo[startRow][startColumn][maxMove]!=null)
            return memo[startRow][startColumn][maxMove];

        memo[startRow][startColumn][maxMove] = ((util(m,n,maxMove-1,startRow+1, startColumn, memo) + util(m,n,maxMove-1,startRow-1, startColumn, memo)) % mod +
                ( util(m,n,maxMove-1,startRow, startColumn+1, memo)   + util(m,n,maxMove-1,startRow, startColumn-1, memo))%mod)% mod;
        return memo[startRow][startColumn][maxMove];
    }
}
