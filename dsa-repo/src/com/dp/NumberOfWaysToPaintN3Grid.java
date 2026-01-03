package com.dp;
/*
1411. Number of Ways to Paint N × 3 Grid


You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors: Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).

Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 109 + 7.



Example 1:
Input: n = 1
Output: 12
Explanation: There are 12 possible way to paint the grid as shown.

TC : o(n)
SC: o(1)

 */
public class NumberOfWaysToPaintN3Grid {

    public static void main(String[] args) {
        System.out.println(new NumberOfWaysToPaintN3Grid().numOfWays(1));
    }
    public int numOfWays(int n) {
        long a121 = 6, a123 = 6, b121, b123, mod = (long)1e9 + 7;
        for (int i = 1; i < n; ++i) {
            b121 = a121 * 3 + a123 * 2;
            b123 = a121 * 2 + a123 * 2;
            a121 = b121 % mod;
            a123 = b123 % mod;
        }
        return (int)((a121 + a123) % mod);
    }
}
