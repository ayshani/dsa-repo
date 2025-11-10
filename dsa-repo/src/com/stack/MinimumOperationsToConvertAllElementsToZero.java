package com.stack;

import java.util.ArrayList;
import java.util.List;

/*
3542. Minimum Operations to Convert All Elements to Zero

You are given an array nums of size n, consisting of non-negative integers. Your task is to apply some (possibly zero) operations on the array so that all elements become 0.

In one operation, you can select a subarray [i, j] (where 0 <= i <= j < n) and set all occurrences of the minimum non-negative integer in that subarray to 0.

Return the minimum number of operations required to make all elements in the array 0.



Example 1:

Input: nums = [0,2]

Output: 1

Explanation:

Select the subarray [1,1] (which is [2]), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in [0,0].
Thus, the minimum number of operations required is 1.

TC : o(n)
SC: o(1)

Intuition
Through observation, we can establish the following rules:

Rule 1: Setting several identical minimum values to 0 simultaneously can reduce the number of operations.
Rule 2: If smaller numbers exist between two identical numbers, those numbers cannot be turned into 0 together.

For each element a:

1. If the top element of the stack is greater than a, then according to Rule 2, the top element cannot be operated
on together with subsequent elements, so it needs to be popped from the stack.
2. If a is 0, we skip it since no operation is needed.
3. If the stack is empty or the top element is less than a, it means we need a new operation to cover a, so we push
it onto the stack and increment the operation count by one.
 */
public class MinimumOperationsToConvertAllElementsToZero {

    public static void main(String[] args) {
        System.out.println(new MinimumOperationsToConvertAllElementsToZero().minOperations(new int[]{0,2}));
    }
    public int minOperations(int[] nums) {
        List<Integer> st = new ArrayList<>();
        int res =0;
        for(int a : nums){
            while(!st.isEmpty() && st.get(st.size() -1) > a){
                st.remove(st.size()-1);
            }

            if(a==0){
                continue;
            }

            if(st.isEmpty() || st.get(st.size()-1)< a){
                res++;
                st.add(a);
            }
        }
        return res;
    }
}
