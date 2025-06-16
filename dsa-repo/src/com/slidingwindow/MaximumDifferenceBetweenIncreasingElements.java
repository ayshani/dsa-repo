package com.slidingwindow;
/*
2016. Maximum Difference Between Increasing Elements

Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].

Return the maximum difference. If no such i and j exists, return -1.



Example 1:

Input: nums = [7,1,5,4]
Output: 4
Explanation:
The maximum difference occurs with i = 1 and j = 2, nums[j] - nums[i] = 5 - 1 = 4.
Note that with i = 1 and j = 0, the difference nums[j] - nums[i] = 7 - 1 = 6, but i > j, so it is not valid.

TC : o(n)
SC: o(1)
 */
public class MaximumDifferenceBetweenIncreasingElements {

    public static void main(String[] args) {
        System.out.println(new MaximumDifferenceBetweenIncreasingElements().maximumDifference(
                new int[]{7,1,5,4}
        ));
    }
    public int maximumDifference(int[] nums) {
        int n= nums.length, ans = -1, premin = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]>premin){
                ans = Math.max(ans, nums[i]- premin);
            } else{
                premin = nums[i];
            }
        }
        return ans;
    }
}
