package com.bit.manipulation;
/*
3133. Minimum Array End

You are given two integers n and x. You have to construct an array of positive integers nums of size n where for every 0 <= i < n - 1, nums[i + 1] is greater than nums[i], and the result of the bitwise AND operation between all elements of nums is x.

Return the minimum possible value of nums[n - 1].



Example 1:

Input: n = 3, x = 4

Output: 6

Explanation:

nums can be [4,5,6] and its last element is 6.

TC : o(n)
SC : o(1)
 */
public class MinimumArrayEnd {

    public static void main(String[] args) {
        System.out.println(new MinimumArrayEnd().minEnd(3,4));
    }
    public long minEnd(int n, int x) {
        long result = x;

        // Step 1: Iterate n-1 times (since we already initialized result with x)
        while (--n > 0) {
            // Step 2: Increment result and perform bitwise OR with x
            result = (result + 1) | x;
        }

        return result;
    }
}
