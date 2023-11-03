package com.array;

import java.util.ArrayList;
import java.util.List;

/*
229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]

TC : o(n)
SC: o(1)

https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
 */
public class MajorityElementII {

    public static void main(String[] args) {
        System.out.println(new MajorityElementII().majorityElement(new int[]{2,1,3,4,1,5,6,1}));
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        if(nums.length==1){
            res.add(nums[0]);
            return res;
        }
        int candidate1 = nums[0], candidate2 = nums[1], count1 =0, count2 =0;
        for(int val : nums){
            if(val == candidate1)
                count1++;
            else if(val == candidate2)
                count2++;
            else if(count1==0){
                candidate1 = val;
                count1++;
            }
            else if(count2==0){
                candidate2 = val;
                count2++;
            } else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int val : nums){
            if(val == candidate1)
                count1++;
            else if(val == candidate2)
                count2++;
        }
        if(count1>nums.length/3)
            res.add(candidate1);
        if(count2>nums.length/3)
            res.add(candidate2);
        return res;
    }
}
