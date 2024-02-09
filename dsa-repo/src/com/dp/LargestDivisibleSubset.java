package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
368. Largest Divisible Subset

Given a set of distinct positive integers nums, return the largest subset answer such that every pair
(answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.



Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]

TC : o(n^2)
SC: o(n)
 */
public class LargestDivisibleSubset {


    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset().
                largestDivisibleSubset(new int[]{1,2,4,8,10,3,5,12,15,21}));
    }
    // this is an variation of LIS( longest Increasing sequence)
    // Sort the array
    // find LIS for divisible elements
    // construct the subset
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length, max =0, index =-1;

        int[] count = new int[n], previous = new int[n];
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            count[i] =1;
            previous[i] = -1;
            for(int j= i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    if(count[j]+1 >count[i]){
                        count[i] = count[j] +1;
                        previous[i] = j;
                    }
                }
            }
            if(count[i] > max){
                max = count[i];
                index =i;
            }
        }

        while(index!=-1){
            result.add(nums[index]);
            index = previous[index];
        }

        return result;
    }

}
