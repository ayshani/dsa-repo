package com.heap.min;

import java.util.PriorityQueue;

/*
2342. Max Sum of a Pair With Equal Sum of Digits

You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.



Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.

TC : o(nlogn)
SC: o(n)
 */
public class MaxSumOfAPairWithEqualSumOfDigits {

    public static void main(String[] args) {
        System.out.println(new MaxSumOfAPairWithEqualSumOfDigits().maximumSum(new int[]{18,43,36,13,7}));
    }
    public int maximumSum(int[] nums) {
        PriorityQueue<Integer>[] pq = new PriorityQueue[82];
        for(int i=0;i<82;i++){
            pq[i]= new PriorityQueue<Integer>();
        }

        int maxPairSum = -1;
        for(int num : nums){
            int digitSum =  calculateDigitSum(num);
            pq[digitSum].add(num);
            if(pq[digitSum].size()>2){
                pq[digitSum].poll();
            }
        }

        // Traverse the vector to find the maximum pair sum for each group
        for (PriorityQueue<Integer> minHeap : pq) {
            if (minHeap.size() == 2) {
                int first = minHeap.poll();
                int second = minHeap.poll();
                maxPairSum = Math.max(maxPairSum, first + second);
            }
        }

        return maxPairSum;
    }

    private int calculateDigitSum(int num){
        int sum =0;
        while(num>0){
            sum += num%10;
            num /=10;
        }
        return sum;
    }
}
