package com.sort;

import java.util.ArrayList;
import java.util.List;

/*
1840. Maximum Building Height

You want to build n new buildings in a city. The new buildings will be built in a line and are labeled from 1 to n.

However, there are city restrictions on the heights of the new buildings:

The height of each building must be a non-negative integer.
The height of the first building must be 0.
The height difference between any two adjacent buildings cannot exceed 1.
Additionally, there are city restrictions on the maximum height of specific buildings. These restrictions are given as a 2D integer array restrictions where restrictions[i] = [idi, maxHeighti] indicates that building idi must have a height less than or equal to maxHeighti.

It is guaranteed that each building will appear at most once in restrictions, and building 1 will not be in restrictions.

Return the maximum possible height of the tallest building.



Example 1:


Input: n = 5, restrictions = [[2,1],[4,1]]
Output: 2
Explanation: The green area in the image indicates the maximum allowed height for each building.
We can build the buildings with heights [0,1,2,1,2], and the tallest building has a height of 2.
Example 2:


Input: n = 6, restrictions = []
Output: 5
Explanation: The green area in the image indicates the maximum allowed height for each building.
We can build the buildings with heights [0,1,2,3,4,5], and the tallest building has a height of 5.
TC : o(nlogn)
SC : o(n)
 */
public class MaximumBuildingHeight {

    public static void main(String[] args) {
        System.out.println(new MaximumBuildingHeight().maxBuilding(6, new int[][]{}));
    }
    public int maxBuilding(int n, int[][] restrictions) {
        // Convert the constraints to a list for manipulation
        List<int[]> r = new ArrayList<>();
        for (int[] res : restrictions) {
            r.add(new int[] { res[0], res[1] });
        }

        // Add restriction (1, 0)
        r.add(new int[] { 1, 0 });
        // Sort by position
        r.sort((a, b) -> Integer.compare(a[0], b[0]));
        // Add restriction (n, n-1)
        if (r.get(r.size() - 1)[0] != n) {
            r.add(new int[] { n, n - 1 });
        }

        int m = r.size();

        // Pass restrictions from left to right
        for (int i = 1; i < m; ++i) {
            int dist = r.get(i)[0] - r.get(i - 1)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i - 1)[1] + dist);
        }

        // Pass restrictions from right to left
        for (int i = m - 2; i >= 0; --i) {
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i + 1)[1] + dist);
        }

        int ans = 0;
        for (int i = 0; i < m - 1; ++i) {
            // Calculate the maximum height of the buildings between r[i][0] and r[i][1]
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            int best = (dist + r.get(i)[1] + r.get(i + 1)[1]) / 2;
            ans = Math.max(ans, best);
        }

        return ans;
    }
}
