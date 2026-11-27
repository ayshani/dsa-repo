package com.gametheory;
/*
3360. Stone Removal Game

Alice and Bob are playing a game where they take turns removing stones from a pile, with Alice going first.

Alice starts by removing exactly 10 stones on her first turn.
For each subsequent turn, each player removes exactly 1 fewer stone than the previous opponent.
The player who cannot make a move loses the game.

Given a positive integer n, return true if Alice wins the game and false otherwise.



Example 1:

Input: n = 12

Output: true

Explanation:

Alice removes 10 stones on her first turn, leaving 2 stones for Bob.
Bob cannot remove 9 stones, so Alice wins.
TC : o(1)
SC : o(1)
 */
public class StoneRemovalGame {

    public static void main(String[] args) {
        System.out.println(new StoneRemovalGame().canAliceWin(12));
    }
    public boolean canAliceWin(int n) {
        int take = 10,
                k = 0;
        while (n >= take) {
            n -= take;
            take--;
            k++;
        }
        return k % 2 == 1;
    }
}
