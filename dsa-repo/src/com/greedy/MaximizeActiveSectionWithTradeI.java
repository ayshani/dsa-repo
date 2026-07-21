package com.greedy;

import java.util.ArrayList;
import java.util.List;

/*
3499. Maximize Active Section with Trade I

You are given a binary string s of length n, where:

'1' represents an active section.
'0' represents an inactive section.
You can perform at most one trade to maximize the number of active sections in s. In a trade, you:

Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
Return the maximum number of active sections in s after making the optimal trade.

Note: Treat s as if it is augmented with a '1' at both ends, forming t = '1' + s + '1'. The augmented '1's do not
contribute to the final count.



Example 1:

Input: s = "01"

Output: 1

Explanation:

Because there is no block of '1's surrounded by '0's, no valid trade is possible. The maximum number of active
sections is 1.

TC : o(n)
SC: o(k)
 */
public class MaximizeActiveSectionWithTradeI {

    public static void main(String[] args) {
        System.out.println(new MaximizeActiveSectionWithTradeI().maxActiveSectionsAfterTrade("01"));
    }
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt1++;
        }

        List<Integer> zeroBlocks = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) == s.charAt(start)) {
                i++;
            }
            if (s.charAt(start) == '0') {
                zeroBlocks.add(i - start);
            }
        }

        int m = zeroBlocks.size();
        if (m < 2) {
            return cnt1;
        }
        int bestGain = 0; // Optimal Increment
        for (int j = 0; j < m - 1; j++) {
            bestGain = Math.max(
                    bestGain,
                    zeroBlocks.get(j) + zeroBlocks.get(j + 1)
            );
        }

        return cnt1 + bestGain;
    }
}
