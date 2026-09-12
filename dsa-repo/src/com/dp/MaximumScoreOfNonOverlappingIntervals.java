package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
3414. Maximum Score of Non-overlapping Intervals

You are given a 2D integer array intervals, where intervals[i] = [li, ri, weighti]. Interval i starts at position
li and ends at ri, and has a weight of weighti. You can choose up to 4 non-overlapping intervals. The score of the
chosen intervals is defined as the total sum of their weights.

Return the lexicographically smallest array of at most 4 indices from intervals with maximum score, representing your
choice of non-overlapping intervals.

Two intervals are said to be non-overlapping if they do not share any points. In particular, intervals sharing a left
or right boundary are considered overlapping.



Example 1:

Input: intervals = [[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]

Output: [2,3]

Explanation:

You can choose the intervals with indices 2, and 3 with respective weights of 5, and 3.

TC : o(nlogn * nK^2)
SC: o(nk^2)
 */
public class MaximumScoreOfNonOverlappingIntervals {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaximumScoreOfNonOverlappingIntervals().maximumWeight(
                List.of(List.of(1,3,2), List.of(4,5,2), List.of(1,5,5), List.of(6,9,3), List.of(6,7,1), List.of(8,9,1))
        )));
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        // Sort by right endpoint.
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] indices = new List[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                indices[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            int l = arr[i][0],
                    weight = arr[i][2],
                    idx = arr[i][3];
            // Use binary search to find intervals whose right endpoints are smaller than l.
            int k = binarySearch(arr, i, l);

            for (int j = 1; j < 5; j++) {
                long s1 = dp[i][j];
                long s2 = dp[k][j - 1] + weight;
                if (s1 > s2) {
                    dp[i + 1][j] = dp[i][j];
                    indices[i + 1][j] = new ArrayList<>(indices[i][j]);
                    continue;
                }

                List<Integer> newIndex = new ArrayList<>(indices[k][j - 1]);
                newIndex.add(idx);
                Collections.sort(newIndex);
                if (s1 == s2 && compareLists(indices[i][j], newIndex) < 0) {
                    newIndex = new ArrayList<>(indices[i][j]);
                }
                dp[i + 1][j] = s2;
                indices[i + 1][j] = newIndex;
            }
        }

        List<Integer> result = indices[n][4];
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private int binarySearch(int[][] arr, int end, int target) {
        int left = 0,
                right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid][1] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int compareLists(List<Integer> a, List<Integer> b) {
        int minLen = Math.min(a.size(), b.size());
        for (int i = 0; i < minLen; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
        return Integer.compare(a.size(), b.size());
    }
}
