package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2218. Maximum Value of K Coins From Piles

There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.

In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.

Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom,
and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly
k coins optimally.

Example 1:
Input: piles = [[1,100,3],[7,8,9]], k = 2
Output: 101
Explanation:
The above diagram shows the different ways we can choose k coins.
The maximum total we can obtain is 101.

Intuition
Top down dynamic programming.
Also noticed that some people already get accepted, a dp program.


Explanation
dp[i,k] means picking k elements from pile[i] to pile[n-1].
We can pick 0,1,2,3... elements from the current pile[i] one by one.
It asks for the maximum total value of coins we can have,
so we need to return max of all the options.


Complexity
Time O(nm)
Space O(nk)
where m = sum(piles[i].length) <= 2000

 */
public class MaximumValueOfKCoinsFromPiles {

    public static void main(String[] args) {
        List<List<Integer>> piles = new ArrayList<>();
        piles.add(new ArrayList<>());
        piles.add(new ArrayList<>());
        piles.get(0).addAll(Arrays.asList(1,100,3));
        piles.get(1).addAll(Arrays.asList(7,8,9));

        System.out.println(new MaximumValueOfKCoinsFromPiles().maxValueOfCoins(piles,2));
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] memo = new Integer[piles.size() + 1][k + 1];

        return dp(piles, memo, 0, k);
    }
    public int dp(List<List<Integer>> piles, Integer[][] memo, int i, int k) {
        if (k == 0 || i == piles.size()) return 0;
        if (memo[i][k] != null) return memo[i][k];

        int res = dp(piles, memo, i + 1, k);
        int cur = 0;

        for (int j = 0; j < Math.min(piles.get(i).size(), k); ++j) {
            cur += piles.get(i).get(j);
            res = Math.max(res, cur + dp(piles, memo, i + 1, k - j - 1));
        }
        return memo[i][k] = res;
    }
}
