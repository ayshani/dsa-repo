package com.greedy;
/*
3736. Minimum Moves to Equal Array Elements III

You are given an integer array nums.

In one move, you may increase the value of any single element nums[i] by 1.

Return the minimum total number of moves required so that all elements in nums become equal.



Example 1:

Input: nums = [2,1,3]

Output: 3

Explanation:

To make all elements equal:

Increase nums[0] = 2 by 1 to make it 3.
Increase nums[1] = 1 by 1 to make it 2.
Increase nums[1] = 2 by 1 to make it 3.
Now, all elements of nums are equal to 3. The minimum total moves is 3.

TC : o(n)
SC: o(1)
 */
public class MinimumMovesToEqualArrayElementsIII {

    public static void main(String[] args) {
        System.out.println(new MinimumMovesToEqualArrayElementsIII().minMoves(new int[]{2,1,3}));
    }
    public int minMoves(int[] nums) {
        int mx = nums[0];
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int ans = 0;
        for (int x : nums) {
            ans += mx - x;
        }
        return ans;
    }
}
