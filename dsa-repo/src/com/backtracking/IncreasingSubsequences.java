package com.backtracking;

import java.util.*;

/*
491. Increasing Subsequences

Given an integer array nums, return all the different possible increasing subsequences of
the given array with at least two elements. You may return the answer in any order.

The given array may contain duplicates, and two equal integers should also be considered a
special case of increasing sequence.

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]

Logic
-------------
traverse the whole array add it in one temp list  if the last element added in list is less than current one
and put it in global list if the size is more than 1.
then backtrack and start from second element.

TC : o(n* 2^n)
2^n is for all cobminations of the nums.
n is for copying the local list to a global list.

SC : o(n)

 */
public class IncreasingSubsequences {

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,7,7};
        System.out.println(new IncreasingSubsequences().findSubsequences(nums));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new LinkedList<>(), result);

        return result;
    }

    private void helper(int[] nums, int start, LinkedList<Integer> curList, List<List<Integer>> result){
        if(curList.size()>1)
        {
            result.add(new LinkedList<Integer>(curList));
        }
        Set<Integer> set = new HashSet<>();
        for(int i=start;i<nums.length;i++){
            if(set.contains(nums[i]))
                continue;
            if(curList.size()==0 || curList.peekLast()<=nums[i]){
                curList.add(nums[i]);
                set.add(nums[i]);
                helper(nums, i+1, curList,result);
                curList.remove(curList.size()-1);
            }
        }
    }
}
