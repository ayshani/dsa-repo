package com.prefixsum;

import java.util.HashMap;

/*
Maximum Size Subarray Sum Equals k

Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Logic
------
e.g.: 1  -1  5  -2  3   k = 3
      ------------ sum
      ----- sum'
          -------- k

      sum- sum' = k
     => sum-k = sum'

 As we iterate over the array, put the sum' in a hashMap as Key and index as value.
 then, we cna get (sum-k) in o(1) time.

TC : o(n)
SC : o(n)


 */
public class MaximumSizeSubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k =3;
        System.out.println(new MaximumSizeSubarraySumEqualsK().getMaxSizeSubarraySum(nums,k));
    }

    private int getMaxSizeSubarraySum(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int prefSum =0;
        int size =0;
        for(int i=0;i<nums.length;i++){
            prefSum+=nums[i];
            if(map.containsKey(prefSum - k)){
                size = Math.max(size, i-map.get(prefSum-k));
            }
            map.putIfAbsent(prefSum,i);
        }

        return size;
    }
}
