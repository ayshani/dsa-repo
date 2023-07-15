package com.set;

import java.util.HashSet;
import java.util.Set;

/*

217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true

TC : o(n)
SC : o(n)
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }

        return false;
    }
}
