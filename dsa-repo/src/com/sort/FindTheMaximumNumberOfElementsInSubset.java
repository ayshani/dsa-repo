package com.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
3020. Find the Maximum Number of Elements in Subset

You are given an array of positive integers nums.

You need to select a
subset
 of nums which satisfies the following condition:

You can place the selected elements in a 0-indexed array such that it follows the pattern:
 [x, x2, x4, ..., xk/2, xk, xk/2, ..., x4, x2, x] (Note that k can be be any non-negative power of 2).
 For example, [2, 4, 16, 4, 2] and [3, 9, 3] follow the pattern while [2, 4, 8, 4, 2] does not.
Return the maximum number of elements in a subset that satisfies these conditions.



Example 1:

Input: nums = [5,4,1,2,2]
Output: 3
Explanation: We can select the subset {4,2,2}, which can be placed in the array as [2,4,2] which follows
the pattern and 22 == 4. Hence the answer is 3.

TC : o(nlogn)
SC: o(n)
 */
public class FindTheMaximumNumberOfElementsInSubset {

    public static void main(String[] args) {
        System.out.println(new FindTheMaximumNumberOfElementsInSubset().maximumLength(
                new int[]{5,4,1,2,2}
        ));
    }
    public int maximumLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        Arrays.sort(nums);

        int maximun = map.containsKey(1)? map.get(1)%2==0 ? map.get(1)-1 : map.get(1) : 1;

        for(int num : nums){
            int count =0, val = num;
            while(map.containsKey(val) && map.get(val)>=2 && val !=1){
                count += 2;
                val *= val;
            }
            if(map.containsKey(val))
                count++;
            else{
                count--;
            }
            maximun = Math.max(maximun, count);
        }
        return maximun;
    }
}
