package com.dp;

import java.util.HashMap;
import java.util.Map;

/*
740. Delete and Earn

You are given an integer array nums. You want to maximize the number of points you get by performing the following
operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal
to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.



Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.

TC : o(n)
SC: o(n)
 */
public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2};
        System.out.println(new DeleteAndEarn().deleteAndEarn(nums));
    }
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int max=0,n = nums.length;
        for(int num : nums){
            max = Math.max(max,num);
            mp.put(num, mp.getOrDefault(num,0)+num);
        }

        int[] dp = new int[max+1];
        dp[1]= mp.getOrDefault(1,0);

        for(int i=2;i<dp.length;i++){
            int gain = mp.getOrDefault(i,0);
            dp[i] = Math.max(dp[i-1],dp[i-2]+gain);
        }

        return dp[max];
    }
}
