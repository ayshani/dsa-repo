package com.slidingwindow;
/*643. Maximum Average Subarray I

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.



Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

TC : o(n)
SC: o(1)
 */
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(nums,4));
    }
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg =0, sum =0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        maxAvg = sum/k;
        for(int i=k;i<nums.length;i++){
            double curSum = sum - nums[i-k] + nums[i];
            double curAvg = curSum/k;
            if(curAvg>= maxAvg){
                maxAvg = curAvg;
            }
            sum = curSum;
        }

        return maxAvg;
    }
}
