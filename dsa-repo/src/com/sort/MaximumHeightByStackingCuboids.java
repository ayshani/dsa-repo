package com.sort;

import java.util.Arrays;
import java.util.Comparator;

/*
1691. Maximum Height by Stacking Cuboids
Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed).
Choose a subset of cuboids and place them on each other.

You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj.
You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.

Return the maximum height of the stacked cuboids.

Example 1:
Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
Output: 190
Explanation:
Cuboid 1 is placed on the bottom with the 53x37 side facing down with height 95.
Cuboid 0 is placed next with the 45x20 side facing down with height 50.
Cuboid 2 is placed next with the 23x12 side facing down with height 45.
The total height is 95 + 50 + 45 = 190.

Intuition
There is something midleading here, you need to understand the differnece.
If the question is:
"You can place cuboid i on cuboid j if width[i] <= width[j] and length[i] <= length[j]"
that's will be difficult.

But it's
"You can place cuboid i on cuboid j if width[i] <= width[j] and length[i] <= length[j] and height[i] <= height[j]"
That's much easier.


Explanation
You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.
So for each cuboid, we sort its length in three dimension.

You can place cuboid i on cuboid j,
we have
width[i] <= width[j] and length[i] <= length[j] and height[i] <= height[j].

This condition will hold, after we sort each cuboid length,
that is,
small[i] <= small[j] and mid[i] <= mid[j] and big[i] <= big[j].

We apply a brute for doulbe for loop,
to compare each pair of cuboids,
check if they satifify the condition samll[i] <= small[j] and mid[i] <= mid[j] and big[i] <= big[j]
If so, we can place cuboid i on cuboid j.

You may concern whether area[i] <= area[j].
Don't worry, we always put the big[i] as the height,
the area (width,length) = (small[i], mid[j]),
and we have checked samll[i] <= small[j] && mid[i] <= mid[j].


Complexity
Time O(n^2)
Space O(n)
 */
public class MaximumHeightByStackingCuboids {

    public static void main(String[] args) {
        int[][] cube = new int[][]{
                {50,45,20},{95,37,53},{45,23,12}
        };
        System.out.println(new MaximumHeightByStackingCuboids().maxHeight(cube));
    }
    public int maxHeight(int[][] cuboids) {
        for(int[] cube: cuboids){
            Arrays.sort(cube);
        }

        Arrays.sort(cuboids, (a, b) -> {
            if(a[0]!=b[0])
                return b[0]-a[0];
            if(a[1]!=b[1])
                return b[1]-a[1];
            return b[2]-a[2];
        });

        int n = cuboids.length, res =0;
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            dp[i] = cuboids[i][2];
            for(int j=0;j<i;j++){
                if(cuboids[j][0]>=cuboids[i][0] && cuboids[j][1]>=cuboids[i][1] && cuboids[j][2]>=cuboids[i][2]){
                    dp[i] = Math.max(dp[i], dp[j]+cuboids[i][2]);
                }
            }
            res = Math.max(dp[i],res);
        }

        return res;
    }
}
