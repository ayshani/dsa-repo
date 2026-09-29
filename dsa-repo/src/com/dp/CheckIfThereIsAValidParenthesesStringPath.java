package com.dp;
/*
2267. Check if There Is a Valid Parentheses String Path

A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
You are given an m x n matrix of parentheses grid. A valid parentheses string path in the grid is a path satisfying all of the following conditions:

The path starts from the upper left cell (0, 0).
The path ends at the bottom-right cell (m - 1, n - 1).
The path only ever moves down or right.
The resulting parentheses string formed by the path is valid.
Return true if there exists a valid parentheses string path in the grid. Otherwise, return false.



Example 1:
Input: grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
Output: true
Explanation: The above diagram shows two possible paths that form valid parentheses strings.
The first path shown results in the valid parentheses string "()(())".
The second path shown results in the valid parentheses string "((()))".
Note that there may be other valid parentheses string paths.

TC  : o(nm(m+n))
SC: o(nm(m+n))
 */
public class CheckIfThereIsAValidParenthesesStringPath {

    public static void main(String[] args) {
        System.out.println(new CheckIfThereIsAValidParenthesesStringPath().hasValidPath(
                new char[][]{
                        {'(','(','('},
                        {')','(',')'},
                        {'(','(',')'},
                        {'(','(',')'}
                }
        ));
    }
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int pathLen = n + m - 1;

        if (pathLen % 2 == 1) {
            return false;
        }
        if (grid[0][0] != '(' || grid[n - 1][m - 1] != ')') {
            return false;
        }

        boolean[][][] dp = new boolean[n][m][pathLen + 1];

        dp[0][0][1] = true;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int change = grid[i][j] == '(' ? 1 : -1;

                if (i > 0) {
                    for (int balance = 0; balance <= pathLen; ++balance) {
                        if (!dp[i - 1][j][balance]) {
                            continue;
                        }

                        int next = balance + change;

                        if (next >= 0) {
                            dp[i][j][next] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int balance = 0; balance <= pathLen; ++balance) {
                        if (!dp[i][j - 1][balance]) {
                            continue;
                        }

                        int next = balance + change;

                        if (next >= 0) {
                            dp[i][j][next] = true;
                        }
                    }
                }
            }
        }

        return dp[n - 1][m - 1][0];
    }
}
