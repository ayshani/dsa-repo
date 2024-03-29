package com.slidingwindow;

import java.util.Arrays;

/*
2962. Count Subarrays Where Max Element Appears at Least K Times

You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.



Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3],
[3,2,3,3], [2,3,3] and [3,3].

TC : o(n)
SC: o(1)

 */
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    public static void main(String[] args) {
        System.out.println(new CountSubarraysWhereMaxElementAppearsAtLeastKTimes()
                .countSubarrays(new int[]{1,3,2,3,3}, 2));
    }
    public long countSubarrays(int[] nums, int k) {
        long ans =0;
        int maxElement = Arrays.stream(nums).max().getAsInt();
        for(int start=0, end =0, count=0; end<nums.length;end++){
            if(nums[end]==maxElement){
                count++;
            }

            while(k==count){
                if(nums[start]==maxElement){
                    count--;
                }

                start++;
            }
            // start will be incremented in above loop to signify the index
            // which is the max position it can displace from initial position
            // so that k count of max Elemnt remains in this sliding window.
            // i.e. By adding start to the answer, we ensure that we account for
            //all valid subarrays ending at the current index end
            ans += start;
        }
        return ans;
    }
}
