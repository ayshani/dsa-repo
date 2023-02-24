package com.greedy;

import java.util.TreeSet;

/*
1675. Minimize Deviation in Array

You are given an array nums of n positive integers.

You can perform two types of operations on any element of the array any number of times:

If the element is even, divide it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the last element,
and the array will be [1,2,3,2].
If the element is odd, multiply it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the first element,
and the array will be [2,2,3,4].
The deviation of the array is the maximum difference between any two elements in the array.

Return the minimum deviation the array can have after performing some number of operations.



Example 1:

Input: nums = [1,2,3,4]
Output: 1
Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
TC : o(n)
SC: o(n)
 */
public class MinimizeDeviationInArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(new MinimizeDeviationInArray().minimumDeviation(nums));
    }
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums){
            set.add(num%2==0 ? num : num*2);
        }

        int minDeviation = Integer.MAX_VALUE;
        while(true){
            int min = set.first();
            int max = set.last();
            minDeviation = Math.min(minDeviation, max-min);
            if(max%2==0){
                set.remove(max);
                set.add(max/2);
            } else{
                break;
            }
        }
        return minDeviation;
    }
}
