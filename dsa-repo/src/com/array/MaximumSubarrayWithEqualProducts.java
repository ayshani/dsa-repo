package com.array;
/*
3411. Maximum Subarray With Equal Products

You are given an array of positive integers nums.

An array arr is called product equivalent if prod(arr) == lcm(arr) * gcd(arr), where:

prod(arr) is the product of all elements of arr.
gcd(arr) is the GCD of all elements of arr.
lcm(arr) is the LCM of all elements of arr.
Return the length of the longest product equivalent subarray of nums.



Example 1:

Input: nums = [1,2,1,2,1,1,1]

Output: 5

Explanation:

The longest product equivalent subarray is [1, 2, 1, 1, 1], where prod([1, 2, 1, 1, 1]) = 2, gcd([1, 2, 1, 1, 1]) = 1,
and lcm([1, 2, 1, 1, 1]) = 2.

TC : o(n^2 *logn)
SC: o(1)
 */
public class MaximumSubarrayWithEqualProducts {

    public static void main(String[] args) {
        System.out.println(new MaximumSubarrayWithEqualProducts().maxLength(new int[]{1,2,1,2,1,1,1}));
    }
    public int maxLength(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            long prodVal = nums[i];
            long gcdVal = nums[i];
            long lcmVal = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                prodVal = prodVal * nums[j];
                gcdVal = gcd(gcdVal, nums[j]);
                lcmVal = (lcmVal * nums[j]) / gcd(lcmVal, nums[j]);
                if (prodVal > gcdVal * lcmVal) {
                    break;
                }
                if (prodVal == gcdVal * lcmVal) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
