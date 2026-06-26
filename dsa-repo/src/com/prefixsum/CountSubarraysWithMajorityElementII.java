package com.prefixsum;
/*
3739. Count Subarrays With Majority Element II

You are given an integer array nums and an integer target.

Return the number of subarrays of nums in which target is the majority element.

The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.



Example 1:

Input: nums = [1,2,2,3], target = 2

Output: 5

Explanation:

Valid subarrays with target = 2 as the majority element:

nums[1..1] = [2]
nums[2..2] = [2]
nums[1..2] = [2,2]
nums[0..2] = [1,2,2]
nums[1..3] = [2,2,3]
So there are 5 such subarrays.

TC : o(n)
SC: o(n)
 */
public class CountSubarraysWithMajorityElementII {

    public static void main(String[] args) {
        System.out.println(new CountSubarraysWithMajorityElementII().countMajoritySubarrays(
                new int[]{1,2,2,3}, 2
        ));
    }
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        // represents the occurrence count of prefix sums -n, -(n-1), ..., 0, 1, ..., n, with index offset by n.
        int[] pre = new int[n * 2 + 1];
        pre[n] = 1;
        int cnt = n;
        long ans = 0;
        long presum = 0;
        for(int i=0;i<n;++i){
            if(nums[i] == target){
                presum += pre[cnt];
                ++cnt;
                ++pre[cnt];
            } else{
                --cnt;
                presum -= pre[cnt];
                ++pre[cnt];
            }
            ans += presum;
        }
        return ans;
    }
}
