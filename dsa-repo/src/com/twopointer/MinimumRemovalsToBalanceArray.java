package com.twopointer;

import java.util.Arrays;

/*
3634. Minimum Removals to Balance Array

You are given an integer array nums and an integer k.

An array is considered balanced if the value of its maximum element is at most k times the minimum element.

You may remove any number of elements from nums​​​​​​​ without making it empty.

Return the minimum number of elements to remove so that the remaining array is balanced.

Note: An array of size 1 is considered balanced as its maximum and minimum are equal, and the condition always holds true.



Example 1:

Input: nums = [2,1,5], k = 2

Output: 1

Explanation:

Remove nums[2] = 5 to get nums = [2, 1].
Now max = 2, min = 1 and max <= min * k as 2 <= 1 * 2. Thus, the answer is 1.

TC : o(nlogn)
SC: o(logn)
 */
public class MinimumRemovalsToBalanceArray {

    public static void main(String[] args) {
        System.out.println(new MinimumRemovalsToBalanceArray().minRemoval(
                new int[]{2,1,5}, 2
        ));
    }
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int ans =n, right =0;
        for(int left =0;left<n;left++){
            while(right<n && nums[right] <= (long) nums[left]*k){
                right++;
            }
            ans = Math.min(ans, n- (right-left));
        }
        return ans;
    }
}
