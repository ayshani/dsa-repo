package com.array;

import java.util.ArrayList;
import java.util.List;

/*
448. Find All Numbers Disappeared in an Array

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers
in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

TC  : o(n)
SC: o(1)
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            // ideally, for every number in array, its position should be at i-1
            // as elements start from 1
            // if its not, then we ll swap with tha position
            int position = nums[i]-1;
            if(nums[i] != nums[position]){
                int temp = nums[i];
                nums[i] = nums[position];
                nums[position] = temp;
            } else{
                i++;
            }
        }

        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                res.add(i+1);
        }
        return res;
    }
}
