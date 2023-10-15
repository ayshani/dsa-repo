package com.dp.knapsack;

import java.util.Arrays;

/*
1269. Number of Ways to Stay in the Same Place After Some Steps

You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left,
 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the
 array at any time).

Given two integers steps and arrLen, return the number of ways such that your pointer is still at index 0 after
exactly steps steps. Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: steps = 3, arrLen = 2
Output: 4
Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
Right, Left, Stay
Stay, Right, Left
Right, Stay, Left
Stay, Stay, Stay

TC : o(n * min(m,n))
SC : o(n * min(m,n))
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    int[][] memo;
    int MOD = (int) 1e9 + 7;
    int arrLen;

    public static void main(String[] args) {
        System.out.println(new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps().numWays(3,2));
    }

    public int dp(int curr, int remain) {
        if (remain == 0) {
            if (curr == 0) {
                return 1;
            }

            return 0;
        }

        if (memo[curr][remain] != -1) {
            return memo[curr][remain];
        }

        int ans = dp(curr, remain - 1);
        if (curr > 0) {
            ans = (ans + dp(curr - 1, remain - 1)) % MOD;
        }

        if (curr < arrLen - 1) {
            ans = (ans + dp(curr + 1, remain - 1)) % MOD;
        }

        memo[curr][remain] = ans;
        return ans;
    }

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        this.arrLen = arrLen;
        memo = new int[arrLen][steps + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, steps);
    }
}
