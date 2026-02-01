package com.array;
/*
3010. Divide an Array Into Subarrays With Minimum Cost I

You are given an array of integers nums of length n.

The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.

You need to divide nums into 3 disjoint contiguous subarrays.

Return the minimum possible sum of the cost of these subarrays.



Example 1:

Input: nums = [1,2,3,12]
Output: 6
Explanation: The best possible way to form 3 subarrays is: [1], [2], and [3,12] at a total cost of 1 + 2 + 3 = 6.
The other possible ways to form 3 subarrays are:
- [1], [2,3], and [12] at a total cost of 1 + 2 + 12 = 15.
- [1,2], [3], and [12] at a total cost of 1 + 3 + 12 = 16.
TC : o(n)
SC: o(1)
 */
public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    public static void main(String[] args) {
        System.out.println(new DivideAnArrayIntoSubarraysWithMinimumCostI().minimumCost(new int[]{1,2,3,12}));
    }
    public int minimumCost(int[] nums) {
        int sum = nums[0], min1 = Integer.MAX_VALUE, min2= Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            } else if( nums[i] < min2){
                min2 = nums[i];
            }
        }
        return sum + min1+min2;
    }
}
