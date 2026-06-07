package com.array;

import java.lang.reflect.AnnotatedType;
import java.util.Arrays;

/*
2574. Left and Right Sum Differences

You are given a 0-indexed integer array nums of size n.

Define two arrays leftSum and rightSum where:

leftSum[i] is the sum of elements to the left of the index i in the array nums.
If there is no such element, leftSum[i] = 0.
rightSum[i] is the sum of elements to the right of the index i in the array nums.
If there is no such element, rightSum[i] = 0.
Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.



Example 1:

Input: nums = [10,4,8,3]
Output: [15,1,11,22]
Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].


TC : o(n)
SC: o(n)
 */
public class LeftAndRightSumDifferences {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeftAndRightSumDifferences().leftRightDifference(new int[]{10,4,8,3})));
    }
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] res = new int[n], leftSum = new int[n], rightSum = new int[n];

        for(int i=1;i<n;i++){
            leftSum[i]=leftSum[i-1]+ nums[i-1];
        }

        for(int i= n-2;i>=0;i--){
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }

        for(int i=0;i<n;i++){

            res[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return res;
    }
}
