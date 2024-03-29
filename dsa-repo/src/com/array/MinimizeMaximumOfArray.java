package com.array;
/*
2439. Minimize Maximum of Array

You are given a 0-indexed array nums comprising of n non-negative integers.

In one operation, you must:

Choose an integer i such that 1 <= i < n and nums[i] > 0.
Decrease nums[i] by 1.
Increase nums[i - 1] by 1.
Return the minimum possible value of the maximum integer of nums after performing any number of operations.



Example 1:

Input: nums = [3,7,1,6]
Output: 5
Explanation:
One set of optimal operations is as follows:
1. Choose i = 1, and nums becomes [4,6,1,6].
2. Choose i = 3, and nums becomes [4,6,2,5].
3. Choose i = 1, and nums becomes [5,5,2,5].
The maximum integer of nums is 5. It can be shown that the maximum number cannot be less than 5.
Therefore, we return 5.

TC : o(n)
SC: o(1)
 */
public class MinimizeMaximumOfArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3,7,1,6};
        System.out.println(new MinimizeMaximumOfArray().minimizeArrayValue(nums));
    }
    public int minimizeArrayValue(int[] nums) {
        long sum =0, maxSum =0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            /*
            ( sum + i ) / i + 1 , because we need max value after average like (3+2+3) / 3 = 2.666
            int convert it to 2 but we need 3 for our solution as we have to find max value in the array
            so if we add no of terms in sum i.e.: (3+2+3)+3(number of terms) / 3 the average comes 3.666
            when int is    applied it become 3
            */
            maxSum = Math.max(maxSum, (sum+i)/(i+1));
        }

        return (int)maxSum;
    }
}
