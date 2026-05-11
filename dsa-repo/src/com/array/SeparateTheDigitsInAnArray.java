package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
2553. Separate the Digits in an Array

Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums after separating them in the same order they appear in nums.

To separate the digits of an integer is to get all the digits it has in the same order.

For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].


Example 1:

Input: nums = [13,25,83,77]
Output: [1,3,2,5,8,3,7,7]
Explanation:
- The separation of 13 is [1,3].
- The separation of 25 is [2,5].
- The separation of 83 is [8,3].
- The separation of 77 is [7,7].
answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.

TC : o(mlogn)
SC: o(n)
 */
public class SeparateTheDigitsInAnArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SeparateTheDigitsInAnArray().separateDigits(new int[]{13, 25, 83, 77})));
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i= nums.length-1; i>=0;i--){
            int x = nums[i];
            while(x >0 ){
                res.add(x%10);
                x/= 10;
            }
        }
        Collections.reverse(res);
        int[] result = new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
