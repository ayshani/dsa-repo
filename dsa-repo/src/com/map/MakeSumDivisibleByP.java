package com.map;

import java.util.HashMap;
import java.util.Map;

/*
1590. Make Sum Divisible by P

Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the
remaining elements is divisible by p. It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

A subarray is defined as a contiguous block of elements in the array.



Example 1:

Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4],
and the sum of the remaining elements is 6, which is divisible by 6.

TC : o(n)
SC: o(n)
 */
public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        System.out.println(new MakeSumDivisibleByP().minSubarray(
                new int[]{3,1,4,2}, 6
        ));
    }
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        int target=0;
        for(int num : nums)
            target = (target+num)%p;

        if(target==0)
            return 0;
        int sum=0, minLength=n;

        for(int i=0;i<n;i++){
            sum=(sum+nums[i])%p;

            if(mp.containsKey((sum-target+p) % p))
                minLength = Math.min(minLength,i - mp.get((sum-target+p)% p));

            mp.put(sum,i);
        }
        return minLength< n? minLength: -1;
    }
}
