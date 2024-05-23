package com.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
2597. The Number of Beautiful Subsets

You are given an array nums of positive integers and a positive integer k.

A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.

Return the number of non-empty beautiful subsets of the array nums.

A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums.
Two subsets are different if and only if the chosen indices to delete are different.



Example 1:

Input: nums = [2,4,6], k = 2
Output: 4
Explanation: The beautiful subsets of the array nums are: [2], [4], [6], [2, 6].
It can be proved that there are only 4 beautiful subsets in the array [2,4,6].


TC : o(2^n)
SC: o(n)
 */
public class TheNumberOfBeautifulSubsets {

    public static void main(String[] args) {
        System.out.println(new TheNumberOfBeautifulSubsets().beautifulSubsets(
                new int[]{2,4,6}, 2
        ));
    }
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        Arrays.sort(nums);
        return util(nums, 0,frequencyMap, k)-1;
    }

    private int util(int[] nums, int index, Map<Integer,Integer> frequencyMap, int k){
        // Base case: Return 1 for a subset of size 1
        if(index==nums.length){
            return 1;
        }

        // count subsets when nums[i] is not taken
        int totalCount = util(nums, index+1, frequencyMap, k);
        // check if nums[i] can be taken
        if(!frequencyMap.containsKey(nums[index]-k)){
            frequencyMap.put(nums[index], frequencyMap.getOrDefault(nums[index],0)+1);

            totalCount += util(nums, index+1, frequencyMap, k);
            // backtrack
            frequencyMap.put(nums[index], frequencyMap.getOrDefault(nums[index],0)-1);
            if(frequencyMap.get(nums[index])==0){
                frequencyMap.remove(nums[index]);
            }
        }
        return totalCount;
    }
}
