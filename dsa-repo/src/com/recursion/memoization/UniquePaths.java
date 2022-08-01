package com.recursion.memoization;
/*
62. Unique Paths

There is a robot on an m x n grid. The robot is initially located at the top-left corner
(i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can
take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Logic
------
Use recursion with memoization technique. start from [m-1,n-1] co-ordinate upto 0.
in case, it goes outside of boundary, return 0.
in case we reach the goal, return 1.
If, we have already computed the result, return that.
Else compute by traversing [m-1,n] paths + [m,n-1] paths and storing them.

TC : o(mn)
SC : o(mn)
 */
public class UniquePaths  {

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3,2));
    }

    public int uniquePaths(int m, int n) {
        return util(m-1,n-1,new Integer[m][n]);
    }

    private int util(int m, int n, Integer[][] memo){
        if(m<0 || n<0)
            return 0;
        else if( m==0 && n==0)
            return 1;
        else if( memo[m][n]!=null)
            return memo[m][n];
        else{
            memo[m][n] =  util(m-1,n,memo) + util(m,n-1,memo);
            return memo[m][n];
        }
    }
}
