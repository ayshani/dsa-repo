package com.stack;

import java.util.Stack;

/*
907. Sum of Subarray Minimums

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
Since the answer may be large, return the answer modulo 109 + 7.

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

TC : o(n)
SC : o(n)
 */
public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] ar = new int[]{11,81,94,43,3};
        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(ar));
    }
    public int sumSubarrayMins(int[] arr) {
        int ans = 0;
        // monotonic stack
        Stack<Integer> st = new Stack<>();
        long mod = (long)1000000007;
        st.push(-1);
        for (int i= 0; i < arr.length+1; i++){
            int currVal = (i<arr.length)? arr[i] : 0;
            while(st.peek() !=-1 && currVal<arr[st.peek()]){
                int index = st.pop();
                int j = st.peek();
                int left = index - j;
                int right = i - index;
                long add = (left * right * (long)arr[index]) % mod;
                ans += add ;
                ans %= mod;
            }

            st.push(i);
        }
        return ans;
    }
}
