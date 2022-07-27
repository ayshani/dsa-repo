package com.array;

import java.util.ArrayList;
import java.util.List;

/*
 * 2089. Find Target Indices After Sorting Array
 *
 * You are given a 0-indexed integer array nums and a target element target.
 * A target index is an index i such that nums[i] == target.
 * Return a list of the target indices of nums after sorting nums in non-decreasing order.
 * If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 *
 * Example 1:
 * Input: nums = [1,2,5,2,3], target = 2
 * Output: [1,2]
 * Explanation: After sorting, nums is [1,2,2,3,5].
 * The indices where nums[i] == 2 are 1 and 2.
 *
 * Logic
 * -------------
 * Idea is to have two counter -
 * one for less than target
 * another equal to target
 * once we get the count of less than target, the iterate over count of equal
 * add the index
 *
 * TC : o(n)
 * SC : o(1)
 */
public class FindTargetIndicesAfterSortingArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[] {1,2,5,2,3};
        int target = 2;
        FindTargetIndicesAfterSortingArray obj = new FindTargetIndicesAfterSortingArray();
        System.out.println(obj.targetIndices(nums, target));

    }

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();

        int count =0, lessThan =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<target)
                lessThan++;
            else if(nums[i]==target)
                count++;
        }

        while(count>0){
            res.add(lessThan++);
            count--;
        }

        return res;
    }

}
