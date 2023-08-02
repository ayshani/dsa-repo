package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
46. Permutations

Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

TC : o(n*n!)
SC : o(n)
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new Permutations().permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,new ArrayList<Integer>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums,ArrayList<Integer> aux,  List<List<Integer>> result){
        if(aux.size()== nums.length){
            result.add(new ArrayList<>(aux));
            return;
        }

        for(int i= 0;i<nums.length;i++){
            if(!aux.contains(nums[i])){
                aux.add(nums[i]);
                backtrack(index+1, nums,aux,result);
                aux.remove(aux.size()-1);
            }
        }
    }
}
