package com.array;
/*
2256. Minimum Average Difference

You are given a 0-indexed integer array nums of length n.

The average difference of the index i is the absolute difference between the average of the
first i + 1 elements of nums and the average of the last n - i - 1 elements. Both averages should be rounded down
to the nearest integer.

Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.

Note:

The absolute difference of two numbers is the absolute value of their difference.
The average of n elements is the sum of the n elements divided (integer division) by n.
The average of 0 elements is considered to be 0.


Example 1:

Input: nums = [2,5,3,9,5,3]
Output: 3
Explanation:
- The average difference of index 0 is: |2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3.
- The average difference of index 1 is: |(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2.
- The average difference of index 2 is: |(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2.
- The average difference of index 3 is: |(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0.
- The average difference of index 4 is: |(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1.
- The average difference of index 5 is: |(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4.
The average difference of index 3 is the minimum average difference so return 3.

Algorithm
-------------
Initialize variables:

n, integer to store the number of elements in the array.
minAvgDiff, initialized with a large integer value, stores the minimum average difference.
totalSum, a variable to store the sum of all elements of the nums array.
currPrefixSum, a variable to store the sum of all elements till the current index of the nums array.
ans, integer to store the index where we found the minimum average difference.
Iterate on the nums array and calculate totalSum.

Iterate over each index of the nums array:

At each index i, we add the current element in currPrefixSum, to get the sum of all elements of the nums array
from index 0 to index i, and divide the sum by i + 1 to get the average of the left part of the array.

Similarly, we can get the sum of elements from index i + 1 to n - 1 after subtracting the left part's sum from
the total sum of the array, and then divide it by n - i - 1 to get the average of the right part of the array.

If the difference between the average of the left and right part of the array is smaller than minAvgDiff,
then store this difference in minAvgDiff and the current index i in ans.

Return ans.

TC : o(n)
SC : o(1)
 */
public class MinimumAverageDifference {

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,3,9,5,3};
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(nums));
    }
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int minAverageDifference = Integer.MAX_VALUE;
        long currentPrefixSum =0, totalSum =0;

        // Get total sum of array.
        for(int i=0;i<n;i++){
            totalSum+= nums[i];
        }

        for(int i=0;i<n;i++){
            currentPrefixSum+= nums[i];

            // Calculate average of left part of array, index 0 to i.
            long leftPartAverage = currentPrefixSum/(i+1);
            // Calculate average of right part of array, index i+1 to n-1.
            long rightPartAverage = (totalSum - currentPrefixSum);
            // If right part have 0 elements, then we don't divide by 0.
            if(i!=n-1){
                rightPartAverage/=(n-i-1);
            }

            int currentDifference = (int) Math.abs(leftPartAverage - rightPartAverage);

            // If current difference of averages is smaller,
            // then current index can be our answer.
            if(currentDifference < minAverageDifference){
                minAverageDifference = currentDifference;
                ans = i;
            }

        }

        return ans;

    }
}
