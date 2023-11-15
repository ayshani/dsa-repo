package com.sort.countingSort;
/*
1846. Maximum Element After Decreasing and Rearranging

You are given an array of positive integers arr. Perform some operations (possibly none) on arr so that it satisfies
these conditions:

The value of the first element in arr must be 1.
The absolute difference between any 2 adjacent elements must be less than or equal to 1. In other words,
abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed). abs(x) is the absolute value of x.
There are 2 types of operations that you can perform any number of times:

Decrease the value of any element of arr to a smaller positive integer.
Rearrange the elements of arr to be in any order.
Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.



Example 1:

Input: arr = [2,2,1,2,1]
Output: 2
Explanation:
We can satisfy the conditions by rearranging arr so it becomes [1,2,2,2,1].
The largest element in arr is 2.

TC : o(n)
SC: o(n)
 */
public class MaximumElementAfterDecreasingAndRearranging {

    public static void main(String[] args) {
        System.out.println(new MaximumElementAfterDecreasingAndRearranging().
                maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,}));
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] count = new int[n+1];
        for(int num : arr){
            count[Math.min(num, n)]++;
        }

        int ans =1;
        for(int num =2; num<=n;num++){
            ans =  Math.min(ans + count[num], num);
        }
        return ans;
    }
}
