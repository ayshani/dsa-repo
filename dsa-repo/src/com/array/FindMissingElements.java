package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
3731. Find Missing Elements

You are given an integer array nums consisting of unique integers.

Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.

The smallest and largest integers of the original range are still present in nums.

Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.



Example 1:

Input: nums = [1,4,2,5]

Output: [3]

Explanation:

The smallest integer is 1 and the largest is 5, so the full range should be [1,2,3,4,5]. Among these, only 3 is missing.

TC : o(nlogn)
SC: o(logn)
 */
public class FindMissingElements {
    public static void main(String[] args) {
        System.out.println(new FindMissingElements().findMissingElements(new int[]{1,4,2,5}));
    }
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int low = nums[0], high = nums[nums.length-1], i =0;
        List<Integer> missingElements = new ArrayList<>();
        while(low<high){
            if(low == nums[i]){
                low++;
                i++;
            } else{
                missingElements.add(low);
                low++;
            }
        }

        return missingElements;
    }
}
