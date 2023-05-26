package com.dp;
/*
1140. Stone Game II

Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and
each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most
stones.

Alice and Bob take turns, with Alice starting first.  Initially, M = 1.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.
Then, we set M = max(M, X).

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.



Example 1:

Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again.
Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take all
three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger.


TC o(n^2)
SC : o(n^2)
 */
public class StoneGameII {

    public static void main(String[] args) {
        int[] piles = new int[]{2,7,9,4,4};
        System.out.println(new StoneGameII().stoneGameII(piles));
    }
    public int stoneGameII(int[] piles) {
        if(piles == null || piles.length==0)
            return 0;

        int n = piles.length;

        int[] sufffixSum = new int[n];
        sufffixSum[n-1] = piles[n-1];

        //the sum from piles[i] to the end
        for(int i=n-2;i>=0;i--){
            sufffixSum[i] = sufffixSum[i+1] + piles[i];
        }

        Integer[][] dp = new Integer[n][n];
        return util(piles, sufffixSum, dp, 0,1);
    }

    // helper method return the Alex max score from pile[i] for the given M
    private int util(int[] piles,int[] sufffixSum,  Integer[][] dp, int pile, int M){
        // base case
        if(pile== piles.length)
            return 0;

        // when the left number of piles is less then 2M, the player can get all of them
        if(2*M >= piles.length-pile){
            return sufffixSum[pile];
        }
        // already seen before
        if(dp[pile][M] != null)
            return dp[pile][M];

        //the min value the next player can get
        int minValue =Integer.MAX_VALUE;
        for(int x=1; x<=2*M;x++){
            minValue = Math.min(minValue, util(piles,sufffixSum, dp, pile+x, Math.max(M,x)));
        }
        // Alex max stones = all the left stones - the min stones Lee can get
        return dp[pile][M] = sufffixSum[pile] - minValue;
    }
}
