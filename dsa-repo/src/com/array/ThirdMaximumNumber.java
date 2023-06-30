package com.array;
/*
414. Third Maximum Number

Given an integer array nums, return the third distinct maximum number in this array.
If the third maximum does not exist, return the maximum number.



Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

TC : o(n)
SC : o(n)
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        System.out.println(new ThirdMaximumNumber().thirdMax(nums));
    }
    public int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;
        for(Integer num : nums){
            if(num.equals(max1) ||num.equals(max2) ||num.equals(max3) )
                continue;
            if(max1== null || num>max1){
                max3 = max2;
                max2= max1;
                max1 = num;
            } else if(max2== null || num>max2){
                max3 = max2;
                max2= num;
            } else if(max3== null || num>max3){
                max3 = num;
            }
        }
        return max3== null ? max1 : max3;
    }
}
