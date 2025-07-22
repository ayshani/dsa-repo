package com.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/*
1695. Maximum Erasure Value

You are given an array of positive integers nums and want to erase a subarray containing unique elements.
The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal
to a[l],a[l+1],...,a[r] for some (l,r).

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].

TC : o(n)
SC: o(n)
 */
public class MaximumErasureValue {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,4,5,6};
        System.out.println(new MaximumErasureValue().maximumUniqueSubarray(nums));
    }
    public int maximumUniqueSubarray(int[] nums) {
        int start =0, end =0, n = nums.length, sum =0, ans =-1;
        Set<Integer> set = new HashSet<>();
        for(end =0;end<n;end++){
            // If the window has duplicate elements then shrink the window from the left
            if(set.contains(nums[end])){
                while(set.contains(nums[end])){
                    sum-= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
            }

            // Expand the window from the right
            set.add(nums[end]);
            sum+= nums[end];
            // Calculate the max window sum
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
