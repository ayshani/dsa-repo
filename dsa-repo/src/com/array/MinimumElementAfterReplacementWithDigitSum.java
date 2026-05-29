package com.array;
/*
3300. Minimum Element After Replacement With Digit Sum

You are given an integer array nums.

You replace each element in nums with the sum of its digits.

Return the minimum element in nums after all replacements.



Example 1:

Input: nums = [10,12,13,14]

Output: 1

Explanation:

nums becomes [1, 3, 4, 5] after all replacements, with minimum element 1.

TC : o(n*digit)
SC: o(1)
 */
public class MinimumElementAfterReplacementWithDigitSum {

    public static void main(String[] args) {
        System.out.println(new MinimumElementAfterReplacementWithDigitSum().minElement(new int[]{10,12,13,14}));
    }
    public int minElement(int[] nums) {
        int ans = 37;
        for(int num : nums){
            int dig =0;
            while(num>0){
                dig += num%10;
                num /=10;
            }
            ans = Math.min(ans, dig);
        }
        return ans;
    }
}
