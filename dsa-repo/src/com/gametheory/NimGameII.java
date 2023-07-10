package com.gametheory;
/*
Nim Game II

There are n heaps of sticks and two players who move alternately. On each move, a player chooses a non-empty
heap and removes 1, 2, or 3 sticks. The player who removes the last stick wins the game.

Your task is to find out who wins if both players play optimally.

Return "first" if first player is the winner or "second" if second player is the winner without quotes.

Constraints:

1<= n <= 10^5

1<= heaps[i] <= 10^9

Example:

Input

n = 4
heaps = [5, 7, 2, 5]
Output

first
 */
public class NimGameII {

    public static void main(String[] args) {
        int[] heaps = new int[]{5,7,2,5};
        System.out.println(new NimGameII().solve(4,heaps));
    }
    String solve(int n, int[] heaps){
        for(int i=0;i<n;i++){
            heaps[i]%=4;
        }

        int xor =0;
        for(int i=0;i<heaps.length;i++){
            xor ^= heaps[i];
        }

        if(xor!=0)
            return "first";
        return "second";
    }
}
