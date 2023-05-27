package com.dp;
/*
1406. Stone Game III


Alice and Bob continue their games with piles of stones. There are several stones arranged in a row, and each
stone has an associated value which is an integer given in the array stoneValue.

Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2, or 3 stones
from the first remaining stones in the row.

The score of each player is the sum of the values of the stones taken. The score of each player is 0 initially.

The objective of the game is to end with the highest score, and the winner is the player with the highest score and
there could be a tie. The game continues until all the stones have been taken.

Assume Alice and Bob play optimally.

Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.



Example 1:

Input: values = [1,2,3,7]
Output: "Bob"
Explanation: Alice will always lose. Her best move will be to take three piles and the score become 6. Now the
score of Bob is 7 and Bob wins.


 */
public class StoneGameIII {

    public static void main(String[] args) {
        int[] stones = new int[]{1,2,3,7};
        StoneGameIII obj = new StoneGameIII();
        System.out.println(obj.stoneGameIIIV1(stones));
        System.out.println(obj.stoneGameIIIV2(stones));
    }

    /*
    Solution 1: Minimax Solution

Let's Alice be a maxPlayer and Bob be a minPlayer. On each turn, we need to maximize score of the maxPlayer and minimize score of the minPlayer.
After all, we will check the final score. If score>0 Alice wins, score<0 Bob wins else they tie.
More about detail Minimax: https://en.wikipedia.org/wiki/Minimax.
Complexity:

Time & Space: O(n)
     */
    public String stoneGameIIIV1(int[] stoneValue) {
        int score = minimax(stoneValue, 0,1,new Integer[stoneValue.length][2]);
        if(score<0)
            return "Bob";
        else if(score>0)
            return "Alice";
        return "Tie";
    }

    public int minimax(int[] stoneValue, int i, int maxPlayer, Integer[][] dp){
        if(i>=stoneValue.length)
            return 0;
        if(dp[i][maxPlayer]!=null)
            return dp[i][maxPlayer];

        int ans = maxPlayer== 1? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int score =0;

        for(int j=i;j<Math.min(i+3,stoneValue.length);j++){
            if(maxPlayer == 1){
                score +=stoneValue[j];
                ans = Math.max(ans, score + minimax(stoneValue,j+1,0,dp));
            } else{
                score -=stoneValue[j];
                ans = Math.min(ans, score + minimax(stoneValue,j+1,1,dp));
            }
        }

        return dp[i][maxPlayer] = ans;
    }

    /*
    Solution 2: Bottom up DP

Let dp[i] denote the maximum difference in the score of the current player against the opponent in the ith turn.
There are 3 options for the current player to choose:
Take A[i], diff1 = take - dp[i+1]
Take A[i] + A[i+1], diff2 = take - dp[i+2]
Take A[i] + A[i+1] + A[i+2], diff3 = take - dp[i+3]
We want to maximize difference in the score of the current player against the opponent, so dp[i] = max(diff1, diff2, diff3)

Complexity:

Time & Space: O(n)
     */
    public String stoneGameIIIV2(int[] stoneValue) {
        int n = stoneValue.length;

        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int take =0;
            dp[i] = Integer.MIN_VALUE;
            for(int j=i;j<Math.min(i+3,n);j++){
                take += stoneValue[j];
                dp[i] = Math.max(dp[i], take - dp[j+1]);
            }
        }

        int difference = dp[0];
        if(difference>0)
            return "Alice";
        else if(difference<0)
            return "Bob";
        else
            return "Tie";
    }
}
