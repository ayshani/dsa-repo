package com.gametheory;
/*
Stair Game
There is a staircase consisting of n stairs, numbered 1,2,…,n. Initially, each stair has some number of balls.

There are two players who move alternately. On each move, a player chooses a stair k where k≠1 and it has at least one ball. Then, the player moves any number of balls from stair k to stair k−1. The player who moves last wins the game.

Your task is to find out who wins the game when both players play optimally.

Return "first" if First player is the winner or "second" if Second player is the winner without quotes.

Note that if there are no possible moves at all, the second player wins.

Constraints:

1<= n <= 10^5

0<= balls[i] <= 10^9



Example:

Input

n = 4
balls= {1, 1, 1, 1}
Output

second

 */
public class StairGame {

    public static void main(String[] args) {
        int[] balls = new int[]{1,1,1,1};
        System.out.println(new StairGame().solve(4,balls));
    }
    String solve(int n, int[] balls){
        int xr=0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                xr^=balls[i];
            }
        }
        if(xr>0)
        {
            return "first";
        }
        else{
            return "second";
        }
    }
}
