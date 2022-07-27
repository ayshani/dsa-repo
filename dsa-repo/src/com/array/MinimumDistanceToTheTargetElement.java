package com.array;
/*
 * 1848. Minimum Distance to the Target Element
 *
 * Given an integer array nums (0-indexed) and two integers target and start,
 * find an index i such that nums[i] == target and abs(i - start) is minimized.
 * Note that abs(x) is the absolute value of x.
 *
 * Return abs(i - start).
 * It is guaranteed that target exists in nums.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5], target = 5, start = 3
 * Output: 1
 * Explanation:
 * 	nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.
 *
 * TC : o(n)
 * SC : o(1)
 */
public class MinimumDistanceToTheTargetElement {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[] { 1,2,3,4,5};
        int target = 5, start = 3;
        MinimumDistanceToTheTargetElement obj = new MinimumDistanceToTheTargetElement();
        System.out.print(obj.getMinDistance(nums, target, start));
    }

    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance =Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
                minDistance = Math.min(minDistance, Math.abs(start-i));
        }

        return minDistance;
    }

}
