package com.dp.kadane;
/*
978. Longest Turbulent Subarray

Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.


Example 1:

Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]

Algorithm
----------
variant of kadane's algorithm, in which we need to find the longest wiggle subarray(pos,  neg, pos ...)
or (neg, pos, neg ...)

If the current element follow the previous pattern then, we just increment the current count otherwise,
reset the current counter.
And in every iteration, just take maximum of (maxCount, currentCount)

TC : o(n)
SC: o(1)
 */
public class LongestTurbulentSubarray {


    public static void main(String[] args) {
        int[] ar = new int[]{9,4,2,10,7,8,8,1,9};
        System.out.println(new LongestTurbulentSubarray().maxTurbulenceSize(ar));
    }
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n<=1)
            return 1;
        int diff = arr[1] - arr[0], max =2, cur =2;
        if(diff==0){
            max=1;
            cur =1;
        }

        for(int i=2;i<n;i++){
            if((diff>0 && arr[i]-arr[i-1]<0)|| (diff<0 && arr[i]-arr[i-1]>0)){
                diff = arr[i] - arr[i-1];
                cur++;
            } else{
                diff = arr[i] - arr[i-1];
                max = Math.max(max, cur);
                if(diff !=0)
                    cur =2;
                else
                    cur =1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
