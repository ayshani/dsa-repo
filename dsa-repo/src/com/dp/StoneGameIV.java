package com.dp;
/*
1510. Stone Game IV

Alice and Bob take turns playing a game, with Alice starting first.

Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing any
non-zero square number of stones in the pile.

Also, if a player cannot make a move, he/she loses the game.

Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both
players play optimally.

Example 3:

Input: n = 4
Output: true
Explanation: n is already a perfect square, Alice can win with one move, removing 4 stones (4 -> 0).

TC : o(n* root(n))
SC: o(n)
 */
public class StoneGameIV {

    public static void main(String[] args) {
        System.out.println(new StoneGameIV().winnerSquareGame(6));
    }
    public boolean winnerSquareGame(int n) {
        // Intuition: bottom-up fill, dp[i] true if some square move leads to a losing state for the opponent
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                System.out.println("i: "+ i + " j: "+ j + " (i - j * j): "
                        + (i - j * j) + " dp[i - j * j]: "+ dp[i - j * j]);
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
