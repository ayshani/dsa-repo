package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
354. Russian Doll Envelopes

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi]
represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope
are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.



Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

TC : o(nlogn)
SC : o(n)
 */
public class RussianDollEnvelopes {

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{
                {5,4},{6,4},{6,7},{2,3}
        };

        System.out.println(new RussianDollEnvelopes().maxEnvelopes(envelopes));
    }


    public int maxEnvelopes(int[][] envelopes) {
        List<Integer> list = new ArrayList<>();

        /*sort envelopes by width (envelopes[i][0]), then we only need to consider height
        //if two envelopes have same width, sort them by descending order
        //because [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting,
        //otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
        //but we actually do not want to count them as valid russian doll envelopes*/
        Arrays.sort(envelopes, (a, b) -> a[0]==b[0] ? b[1]-a[1] : a[0] -b[0]);

        //KEY POINTS: after sorting them by width with increasing order,
        // we need to find Longest Increasing Subsequence
        //by traversing height of each envelope, then we get the final result
        //store height of each increasing subsequence with different length
        /*eg: 3, 5, 1, 8, 2, 12
         * 1
         * 1, 2
         * 3, 5, 8
         * 3, 5, 8, 12
         * list = {1, 2, 8, 12}
         */
        //we do not care about what elements are in each subsequence, we only care about
        //heights of them, because every time we only compare with their heights to decide
        //which subsequence could we add new item and update the entire structure
        for (int i = 0; i < envelopes.length; i++) {
            int val = envelopes[i][1];
            if (list.isEmpty()) {
                list.add(val);
                continue;
            }
            int left = 0, right = list.size() - 1;
            while (right - left > 1) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) >= val) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (val <= list.get(left)) {
                list.set(left, val);
            } else if (val <= list.get(right)) {
                list.set(right, val);
            } else {
                list.add(val);
            }
        }
        return list.size();
    }
}
