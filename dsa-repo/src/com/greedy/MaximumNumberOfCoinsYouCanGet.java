package com.greedy;

import java.util.Arrays;

/*
1561. Maximum Number of Coins You Can Get

There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:

In each step, you will choose any 3 piles of coins (not necessarily consecutive).
Of your choice, Alice will pick the pile with the maximum number of coins.
You will pick the next pile with the maximum number of coins.
Your friend Bob will pick the last pile.
Repeat until there are no more piles of coins.
Given an array of integers piles where piles[i] is the number of coins in the ith pile.

Return the maximum number of coins that you can have.



Example 1:

Input: piles = [2,4,1,2,7,8]
Output: 9
Explanation: Choose the triplet (2, 7, 8), Alice Pick the pile with 8 coins, you the pile with 7 coins and Bob the
last one.
Choose the triplet (1, 2, 4), Alice Pick the pile with 4 coins, you the pile with 2 coins and Bob the last one.
The maximum number of coins which you can have are: 7 + 2 = 9.
On the other hand if we choose this arrangement (1, 2, 8), (2, 4, 7) you only get 2 + 4 = 6 coins which is not
optimal.

TC : o(nlogn)
SC: o(1)
 */
public class MaximumNumberOfCoinsYouCanGet {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfCoinsYouCanGet().maxCoins(new int[]{2,4,1,2,7,8}));
    }
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int me =0;
        for(int i=piles.length/3;i<piles.length;i+=2){
            me += piles[i];
        }
        return me;
    }
}
