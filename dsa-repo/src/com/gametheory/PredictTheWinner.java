package com.gametheory;
/*
486. Predict the Winner

You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0.
At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or
nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score.
The game ends when there are no more elements in the array.

Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the
winner, and you should also return true. You may assume that both players are playing optimally.

Constraints:

1 <= nums.length <= 20

0 <= nums[i] <= 10^7

Example:

Input: nums = [1,5,2]
Output: false

Explanation: Initially, player 1 can choose between 1 and 2.
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1
will be left with 1 (or 2).
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the winner and you need to return false.

Explanation
-------------
We can define a recursive function maxDiff(left, right) that takes the starting and ending indices left and right
of the list as input to maximize the current score difference between the two players.

At each step, we simulate the current player selecting a number from the list and then call the function
recursively to determine the optimal move for the next player. We update the score difference based on the
player's move, and then return the maximum score difference that the first player can achieve.

when it is the green player's turn for the subarray nums[left ~ right], his maximum score difference is denoted by
maxDiff(left, right). He has two choices: nums[left] and nums[right].

If he chooses nums[left] and increases the score difference by nums[left], then the next move will be made by
the red player on the remaining array nums[left + 1 ~ right], and maxDiff(left + 1, right) represents the max
score difference that the red player could lead the green player by.

However, this subproblem maxDiff(left + 1, right) is from the perspective of the red player, and the positive
gain for the red player is exactly the negative gain for the green player. Therefore, in our formula for counting
the current score gain of green player, the impact factor of the red player's gain is -1.

Therefore, by picking nums[left], the green player's maximum score difference is nums[left]
minus maxDiff(left + 1, right). Likewise, by picking nums[right], his maximum score difference
is nums[right] minus maxDiff(left, right - 1).

The green player shall pick the larger one of the two, that is:

maxDiff(left, right) = max(nums[left] - maxDiff(left + 1, right), nums[right] - maxDiff(left, right - 1)).
We can recursively solve the problem until we reach the base case left = right, where the game ends after
the last player picks the final number and the maximum score difference he can make is nums[left].
 */
public class PredictTheWinner {

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,233,7};
        System.out.println(new PredictTheWinner().PredictTheWinnerV1(nums));
        System.out.println(new PredictTheWinner().PredictTheWinnerV2(nums));
    }
    boolean PredictTheWinnerV1(int[] nums) {
        int n = nums.length;
        return maxScoreDifference(0,n-1,nums)>=0;
    }

    // TC : o(2^n) as we have always two choices to pick
    // SC : o(n)
    private int maxScoreDifference(int start, int end, int[] nums){
        if(start==end){
            return nums[start];
        }
        return Math.max(nums[start] - maxScoreDifference(start+1,end,nums),
                nums[end] - maxScoreDifference(start,end-1,nums));
    }

    // TC : o(n^2)
    // SC : o(n^2)
    boolean PredictTheWinnerV2(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];

        return maxDiff(0,n-1,nums, dp)>=0;
    }

    private int maxDiff(int start, int end, int[] nums,Integer[][] dp ){

        if(start==end){
            return nums[start];
        }

        if(dp[start][end]!=null)
            return dp[start][end];

        int scoreByStart = nums[start] - maxDiff(start+1,end,nums,dp);
        int scoreByEnd = nums[end] - maxDiff(start,end-1,nums,dp);
        int maxDifference = Math.max(scoreByStart,scoreByEnd);
        return dp[start][end]= maxDifference;
    }

}
