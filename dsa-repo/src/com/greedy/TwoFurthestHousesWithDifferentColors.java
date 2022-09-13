package com.greedy;
/*
2078. Two Furthest Houses With Different Colors

There are n houses evenly lined up on the street, and each house is beautifully painted.
You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.

Return the maximum distance between two houses with different colors.

The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.

Example 1:
Input: colors = [1,1,1,6,1,1,1]
Output: 3
Explanation: color 1 is blue, and color 6 is red.
The furthest two houses with different colors are house 0 and house 3.
House 0 has color 1, and house 3 has color 6. The distance between them is abs(0 - 3) = 3.
Note that houses 3 and 6 can also produce the optimal answer.

TC : o(n)
SC : o(1)
 */
public class TwoFurthestHousesWithDifferentColors {
    public static void main(String[] args) {
        int[] color = new int[]{1,8,3,8,3};
        System.out.println(new TwoFurthestHousesWithDifferentColors().maxDistance(color));
    }
    public int maxDistance(int[] colors) {
        int n = colors.length, start =0;
        int end = n-1;

        while(colors[0]==colors[end])
            end--;
        while(colors[start]==colors[n-1])
            start++;

        return Math.max(end, n-1-start);
    }
}
