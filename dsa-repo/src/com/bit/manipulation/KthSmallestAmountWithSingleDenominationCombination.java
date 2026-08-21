package com.bit.manipulation;

import java.util.Arrays;

/*
3116. Kth Smallest Amount With Single Denomination Combination

You are given an integer array coins representing coins of different denominations and an integer k.

You have an infinite number of coins of each denomination. However, you are not allowed to combine coins of
different denominations.

Return the kth smallest amount that can be made using these coins.



Example 1:

Input: coins = [3,6,9], k = 3

Output: 9

Explanation: The given coins can make the following amounts:
Coin 3 produces multiples of 3: 3, 6, 9, 12, 15, etc.
Coin 6 produces multiples of 6: 6, 12, 18, 24, etc.
Coin 9 produces multiples of 9: 9, 18, 27, 36, etc.
All of the coins combined produce: 3, 6, 9, 12, 15, etc.

TC : o(2^n ×(nlog(max{coins})+log(k×min{coins})))
SC : o(2^n)
 */
public class KthSmallestAmountWithSingleDenominationCombination {

    public static void main(String[] args) {
        System.out.println(new KthSmallestAmountWithSingleDenominationCombination()
                .findKthSmallest(new int[]{3,6,9},3));
    }
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        int n = coins.length;
        int m = 1 << n;

        long l = k;
        long r = (long) coins[0] * k + 1;

        int[] bitCount = new int[m];
        long[] lcm = new long[m];

        for (int mask = 1; mask < m; mask++) {
            long curLcm = 1;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    long g = gcd(curLcm, coins[i]);
                    long tmp = curLcm / g;

                    if (tmp <= r / coins[i]) {
                        curLcm = tmp * coins[i];
                    } else {
                        curLcm = r + 1;
                        break;
                    }
                    bitCount[mask]++;
                }
            }
            lcm[mask] = curLcm;
        }

        while (l < r) {
            long x = l + (r - l) / 2;
            if (count(x, m, lcm, bitCount) >= k) {
                r = x;
            } else {
                l = x + 1;
            }
        }
        return l;
    }

    private long count(long x, int m, long[] lcm, int[] bitCount) {
        long res = 0;
        for (int mask = 1; mask < m; mask++) {
            if (lcm[mask] > x) continue;

            if ((bitCount[mask] & 1) == 1) {
                res += x / lcm[mask];
            } else {
                res -= x / lcm[mask];
            }
        }
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
