package com.dp;
/*
2770. Maximum Number of Jumps to Reach the Last Index

You are given a 0-indexed array nums of n integers and an integer target.

You are initially positioned at index 0. In one step, you can jump from index i to any index j such that:

0 <= i < j < n
-target <= nums[j] - nums[i] <= target
Return the maximum number of jumps you can make to reach index n - 1.

If there is no way to reach index n - 1, return -1.



Example 1:

Input: nums = [1,3,6,4,1,2], target = 2
Output: 3
Explanation: To go from index 0 to index n - 1 with the maximum number of jumps, you can perform the following
jumping sequence:
- Jump from index 0 to index 1.
- Jump from index 1 to index 3.
- Jump from index 3 to index 5.
It can be proven that there is no other jumping sequence that goes from 0 to n - 1 with more than 3 jumps. Hence,
the answer is 3.
Example 2:

Input: nums = [1,3,6,4,1,2], target = 3
Output: 5
Explanation: To go from index 0 to index n - 1 with the maximum number of jumps, you can perform the following
jumping sequence:
- Jump from index 0 to index 1.
- Jump from index 1 to index 2.
- Jump from index 2 to index 3.
- Jump from index 3 to index 4.
- Jump from index 4 to index 5.
It can be proven that there is no other jumping sequence that goes from 0 to n - 1 with more than 5 jumps. Hence,
the answer is 5.
Example 3:

Input: nums = [1,3,6,4,1,2], target = 0
Output: -1
Explanation: It can be proven that there is no jumping sequence that goes from 0 to n - 1. Hence, the answer is -1.


Constraints:

2 <= nums.length == n <= 1000
-109 <= nums[i] <= 109
0 <= target <= 2 * 109

TC : o(n^2)
SC : o(n)
 */
public class MaximumNumberOfJumpsToReachTheLastIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,4,1,2};
        System.out.println(new MaximumNumberOfJumpsToReachTheLastIndex().maximumJumps(nums,3));
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length, count =0;
        if(n==0)
            return -1;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(i==0 || dp[i]!=0){
                for(int j=i+1;j<n;j++){
                    int diff = Math.abs(nums[j]-nums[i]);
                    if(diff>=-target && diff <=target){
                        dp[j] = Math.max(dp[j], dp[i]+1);
                    }
                }
            }
        }
        return dp[n-1]==0 ? -1 : dp[n-1];
    }
}