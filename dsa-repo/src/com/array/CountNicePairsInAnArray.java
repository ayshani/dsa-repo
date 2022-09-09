package com.array;

import java.util.HashMap;
import java.util.Map;

/*
1814. Count Nice Pairs in an Array

You are given an array nums that consists of non-negative integers.
Let us define rev(x) as the reverse of the non-negative integer x.
For example, rev(123) = 321, and rev(120) = 21.
A pair of indices (i, j) is nice if it satisfies all of the following conditions:

0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.

Example 1:

Input: nums = [42,11,1,97]
Output: 2
Explanation: The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.

Explanation
A[i] + rev(A[j]) == A[j] + rev(A[i])
A[i] - rev(A[i]) == A[j] - rev(A[j])
B[i] = A[i] - rev(A[i])

Then it becomes an easy question that,
how many pairs in B with B[i] == B[j]


Complexity
Time O(nloga)
Space O(n)
 */
public class CountNicePairsInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{42,11,1,97};
        System.out.println(new CountNicePairsInAnArray().countNicePairs(nums));
    }
    public int countNicePairs(int[] nums) {
        int mod = 1000000007, count =0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rev =reverse(nums[i]);
            int prev = map.getOrDefault(nums[i]-rev,0);
            count = (count+prev)%mod;
            map.put(nums[i]-rev, prev+1);
        }
        return count;
    }

    private int reverse(int num){
        int rev =0;
        while(num>0){
            rev = rev*10 + (num%10);
            num/=10;
        }
        return rev;
    }
}
