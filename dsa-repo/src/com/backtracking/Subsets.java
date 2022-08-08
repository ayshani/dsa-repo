package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
78. Subsets

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Logic
------
add in one local list and add the list in global one. backtrack then start from second onwards.

TC : o(n*2^n)
SC : o(n)
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new Subsets().subsets(nums));
    }
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums,0,cur);

        return result;
    }

    private void backtrack(int[] nums, int s, List<Integer> cur){

        // if(cur.size()>0){
        result.add(new ArrayList<>(cur));
        //}

        for(int i=s;i<nums.length;i++){
            cur.add(nums[i]);
            backtrack(nums,i+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}
