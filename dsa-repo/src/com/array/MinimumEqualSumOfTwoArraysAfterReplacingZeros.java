package com.array;
/*
2918. Minimum Equal Sum of Two Arrays After Replacing Zeros

You are given two arrays nums1 and nums2 consisting of positive integers.

You have to replace all the 0's in both arrays with strictly positive integers such that the sum of elements
of both arrays becomes equal.

Return the minimum equal sum you can obtain, or -1 if it is impossible.



Example 1:

Input: nums1 = [3,2,0,1,0], nums2 = [6,5,0]
Output: 12
Explanation: We can replace 0's in the following way:
- Replace the two 0's in nums1 with the values 2 and 4. The resulting array is nums1 = [3,2,2,1,4].
- Replace the 0 in nums2 with the value 1. The resulting array is nums2 = [6,5,1].
Both arrays have an equal sum of 12. It can be shown that it is the minimum sum we can obtain.
 */
public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {

    public static void main(String[] args) {
        System.out.println(new MinimumEqualSumOfTwoArraysAfterReplacingZeros().minSum(
                new int[]{20,0,18,11,0,0,0,0,0,0,17,28,0,11,10,0,0,15,29},
                new int[]{16,9,25,16,1,9,20,28,8,0,1,0,1,27}));

        /*System.out.println(new MinimumEqualSumOfTwoArraysAfterReplacingZeros().minSum(
                new int[]{8,13,15,18,0,18,0,0,5,20,12,27,3,14,22,0},
                new int[]{29,1,6,0,10,24,27,17,14,13,2,19,2,11}
        ));*/
    }
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 =0, sum2 =0, count1 =0, count2 =0;
        int m = nums1.length, n = nums2.length;
        for(int i=0;i<m;i++){
            sum1 += nums1[i];
            if(nums1[i]==0)
                count1++;
        }

        for(int i=0;i<n;i++){
            sum2 += nums2[i];
            if(nums2[i]==0)
                count2++;
        }

        if(sum1>sum2){
            long totalSum1 = count1 + sum1;
            long dif = Math.abs(totalSum1 - sum2);
            if(count2==0 ||  dif< count2)
                return -1;
            return totalSum1;
        } else if( sum1<sum2){
            long totalSum2 = count2 + sum2;
            long dif = Math.abs(totalSum2 - sum1);
            if(count1==0 ||  dif< count1)
                return -1;
            return totalSum2;
        } else{
            if(count1==0 && count2 ==0)
                return sum1;
            else if(count1==0 || count2 ==0)
                return -1;
            else if(count1==count2)
                return sum1 + count1;
            else
                return Math.max(count1, count2) + sum1;
        }

    }
}
