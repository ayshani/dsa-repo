package com.greedy;

import java.util.Arrays;

/*
1509. Minimum Difference Between Largest and Smallest Value in Three Moves

You are given an integer array nums.

In one move, you can choose one element of nums and change it to any value.

Return the minimum difference between the largest and smallest value of nums after performing at most three moves.



Example 1:

Input: nums = [5,3,2,4]
Output: 0
Explanation: We can make at most 3 moves.
In the first move, change 2 to 3. nums becomes [5,3,3,4].
In the second move, change 4 to 3. nums becomes [5,3,3,3].
In the third move, change 5 to 3. nums becomes [3,3,3,3].
After performing 3 moves, the difference between the minimum and maximum is 3 - 3 = 0.

TC : o(nlogn)
SC: o(logn)
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public static void main(String[] args) {
        System.out.println(new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves().minDifference(
                new int[]{5,3,2,4}
        ));
    }
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n<=4){
            return 0;
        }

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        /*
        There can be total 4 scenario for removal
        Removing the three largest elements.
        Removing the two largest and one smallest elements.
        Removing one largest and two smallest elements.
        Removing the three smallest elements.
         */
        for(int left =0, right = n-4; left<4; left++, right++){
            minDiff = Math.min(minDiff, nums[right] - nums[left]);
        }
        return minDiff;
    }
}
