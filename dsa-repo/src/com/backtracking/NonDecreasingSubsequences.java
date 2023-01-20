package com.backtracking;

import java.util.*;

/*
491. Non-decreasing Subsequences

Given an integer array nums,
return all the different possible non-decreasing subsequences of the given array with at least two elements.
You may return the answer in any order.



Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

TC : o(2^n * n)
an array of n elements genertae 2^n sequences and we need to add this having n vindividual elements in list.
SC : o(2^n * n)
The answer contains O(2^n) sequences, each having a length of O(n).
If we do not count the answer as part of the space complexity, then the space complexity is O(n) for
the recursion call stack and space needed to build each sequence.
 */
public class NonDecreasingSubsequences {
    public static void main(String[] args) {
        int[] nums = new int[]{4,6,7,7};
        System.out.println(new NonDecreasingSubsequences().findSubsequences(nums));
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new LinkedList<>(), result);

        return result;
    }

    private void helper(int[] nums, int start, LinkedList<Integer> currentList, List<List<Integer>> result){
        if(currentList.size() >1){
            result.add(new LinkedList<Integer>(currentList));
        }

        Set<Integer> set = new HashSet<>();
        for(int i=start; i<nums.length;i++){
            if(set.contains(nums[i]))
                continue;
            if(currentList.size()== 0 || currentList.peekLast()<=nums[i]){
                set.add(nums[i]);
                currentList.add(nums[i]);
                helper(nums, i+1, currentList, result);
                currentList.remove(currentList.size()-1);
            }

        }
    }
}
