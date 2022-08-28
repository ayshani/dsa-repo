package com.prefixsum;
/*
1013. Partition Array Into Three Parts With Equal Sum

Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i + 1 < j with
(arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] ==
arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

Example 1:

Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

TC : o(n)
SC : o(1)
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;

        //calculate overall sum
        for(int num : arr){
            sum+= num;
        }

        //check if it's divisible by 3
        if(sum%3!=0){
            return false;
        }

        //exact sum of each segment
        sum/=3;

        int prefixSum =0, numSegment =0;

        for(int i=0;i<arr.length;i++){
            prefixSum+= arr[i];

            //check if we can form a segment
            if(prefixSum== sum && numSegment<=2){
                numSegment++;
                prefixSum=0;
            }
        }

        // once we get 3 segments then there shouldn't be any more segments
        // available in the array with the same sum
        return numSegment==3 && prefixSum==0;
    }

}
