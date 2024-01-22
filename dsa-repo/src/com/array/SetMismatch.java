package com.array;

import java.util.HashSet;
import java.util.Set;

/*
645. Set Mismatch

You have a set of integers s, which originally contains all the numbers from 1 to n.
Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]

TC : o(n)
SC : o(n)
 */
public class SetMismatch {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,4};
        int[] res = new SetMismatch().findErrorNums(nums);

        System.out.println(res[0] + " "+ res[1]);
    }
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = (n*(n+1))/2;
        Set<Integer> set = new HashSet<>();
        int duplicate =0;
        int numSum =0;
        for(int num : nums){
            if(!set.add(num))
            {
                duplicate = num;
            }
            numSum+=num;
        }
        int result =0;
        if(duplicate!=0){
            result = sum-(numSum-duplicate);
        }
        return new int[]{duplicate,result};
    }

}
