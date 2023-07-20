package com.gametheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Ada Pawns

Ada is playing pawn chess with Suzumo.

Pawn chess is played on a longboard with N squares in one row. Initially, some of the squares contain pawns.
You are given a string board with length N describing the initial board from left to right. An empty square and
a square containing pawn are denoted by the characters  '.' and 'P' respectively.

Note that the colors of the squares and pawns do not matter in this game, but otherwise, the standard chess rules
apply:

no two pawns can occupy the same square at the same time

a pawn cannot jump over another pawn (they are no knights!), i.e. if there is a pawn at square i, then it can only
be moved to square i−2 if squares i−1 and i−2 are empty

pawns cannot move outside of the board (outs are forbidden)

The players alternate turns; as usual, Ada plays first. In each turn, the current player must choose a pawn and move
it either one or two squares to the left of its current position. The player that cannot make a move loses.

Can Ada always beat Suzumo? Remember that Ada is a chess grandmaster, so she always plays optimally.

Return "Yes" if Ada wins the game otherwise "No".

Constraints:

1<= N <= 10^5

board[i]='.' or 'P'



Example:

Input

board= "..P.P"
Output

Yes
Explanation:

Ada can move the first pawn two squares to the left; the board after this move looks like:

P...P

and now, Suzumo can only move the second pawn. If he moves it one square to the left, Ada will move it two squares
to the left on her next move, and if he moves it two squares to the left, Ada will move it one square to the left,
so the board after Ada's next move will look like:

PP...

and Suzumo cannot make any move here.
TC  : o(n)
SC: o(n)
 */
public class AdaPawns {

    public static void main(String[] args) {
        System.out.println(new AdaPawns().solve("..P.P"));
    }
    String  solve( String  board){
        int n=board.length(),last=-1;
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(board.charAt(i)=='P')
            {
                // max position a pawn can shift to left side i-1/i-2
                temp.add(i-last-1);
                last=i;
            }
        }
        int xor_sum=0;
        Collections.reverse(temp);
        for(int i=0;i<temp.size();i+=2)
        {
            // as it is 2 position max which can be shifted, so we can do %3.
            xor_sum^=(temp.get(i)%3);
        }
        if(xor_sum==1)
        {
            return "Yes";
        }
        else{
            return "No";
        }
    }
}
