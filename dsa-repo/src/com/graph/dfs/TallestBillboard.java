package com.graph.dfs;

import com.dp.TallestBillboardDP;

import java.util.HashMap;
import java.util.Map;

/*
956. Tallest Billboard
You are installing a billboard and want it to have the largest height. The billboard will have two steel
supports, one on each side. Each steel support must be an equal height.

You are given a collection of rods that can be welded together. For example, if you have rods of lengths
1, 2, and 3, you can weld them together to make a support of length 6.

Return the largest possible height of your billboard installation. If you cannot support the billboard, return 0.

Example 1:

Input: rods = [1,2,3,6]
Output: 6
Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.

TC : o(3^n)
SC: o(N * max different absolute difference)
 */
public class TallestBillboard {


    public static void main(String[] args) {
        int[] rods = new int[]{1,2,3,6};
        System.out.println(new TallestBillboardDP().tallestBillboard(rods));
    }

    public int tallestBillboard(int[] rods) {
        return help(rods, 0, 0, 0, new HashMap());
    }

    private int help(int[] rods, int i, int s1, int s2, Map<String, Integer> dp) {
        if (i == rods.length)
            return s1 == s2 ? s1 : -1;

        String dpKey = i + " " + Math.abs(s1 - s2);

        if (dp.containsKey(dpKey))
            return dp.get(dpKey) == -1 ? -1 : Math.max(s1, s2) + dp.get(dpKey);

        int lBeam = help(rods, i + 1, s1 + rods[i], s2, dp);
        int rBeam = help(rods, i + 1, s1, s2 + rods[i], dp);
        int discard = help(rods, i + 1, s1, s2, dp);
        int ans = Math.max(discard, Math.max(lBeam, rBeam));

        dp.put(dpKey, ans == -1 ? -1 : ans - Math.max(s1, s2));

        return ans;
    }
}
