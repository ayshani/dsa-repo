package com.gametheory;
/*
Game of Bullets

Isa challenged Gaitonde for a game, he placed n piles of bullets, with each pile containing Ai(A1,A2….An) bullets each, and defined the following rule for the game: In each turn, a player can choose only one pile and remove any number of bullets (at least one) from that pile. The player who cannot make a move loses the game.

Gaitonde accepts the challenge and says that he will go first. Chef wants to know who will win if they both play optimally.

Note: Gaitonde will make the first move every time.

Return "Gaitonde" if he wins the game or "Isa" if  Isa is the winner without quotes.

Constraints:

1<= n <= 10^5

1<= Ai <= 10^6



Example:

Input

n = 2
A= [1, 1]
Output

Isa
Explanation:

Gaitonde starts the game by removing 1 bullet from any of the piles, and then Isa removes the only bullet in
the other pile. Now Gaitonde is left without a valid move and hence Isa wins the game.

TC : o(n)
SC: o(1)
 */
public class GameOfBullets {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,9};
        System.out.println(new GameOfBullets().solve(nums.length,nums));
    }
    String solve(int n, int[] A)
    {
        int nimSum =0;
        for(int i=0;i<A.length;i++){
            nimSum ^= A[i];
        }
        if(nimSum==0)
            return "Isa";
        return "Gaitonde";
    }
}
