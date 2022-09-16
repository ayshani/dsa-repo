package com.dp;
/*
1770. Maximum Score from Performing Multiplication Operations

You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m.
The arrays are 1-indexed.

You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Remove x from the array nums.
Return the maximum score after performing m operations.



Example 1:

Input: nums = [1,2,3], multipliers = [3,2,1]
Output: 14
Explanation: An optimal solution is as follows:
- Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
- Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
- Choose from the end, [1], adding 1 * 1 = 1 to the score.
The total score is 9 + 4 + 1 = 14.


Logic
------
we have two options

Select Left: Number of operations will advance by one. And, so does the left pointer.
Thus, we will multiply mulitpliers[op] and nums[left] (since we have selected from left), and add this product
to (optimal) result of state dp[op+1][left+1].

Select Right: Then also the number of operations will advance by one. Then, we will multiply mulitpliers[op]
with nums[n-1-(op-left)] (since we have selected from right), and add this product to (optimal) result of
state dp[op+1][left] (Now, left will not increment since number has not been chosen from left).

TC : o(m^2)
SC : o(m^2)
 */
public class MaximumScoreFromPerformingMultiplicationOperations {
    public static void main(String[] args) {
        int[] nums = new int[]{-5,-3,-3,-2,7,1}, multipliers = new int[]{-10,-5,3,4,6};

        System.out.println(new MaximumScoreFromPerformingMultiplicationOperations().maximumScore(nums,multipliers));
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[][] dp = new int[m+1][m+1];

        for(int op = m-1;op>=0;op--){
            for(int left = op; left>=0;left--){
                dp[op][left] = Math.max(multipliers[op]*nums[left] + dp[op+1][left+1],
                        multipliers[op]*nums[n-1-(op-left)] + dp[op+1][left]);
            }
        }

        return dp[0][0];
    }
}
