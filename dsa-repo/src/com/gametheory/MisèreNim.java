package com.gametheory;

import java.util.Arrays;
import java.util.List;

/*
Misère Nim

Two people are playing game of Misère Nim. The basic rules for this game are as follows:

The game starts with  piles of stones indexed from 0 to n-1 . Each pile i (where ) 0<i<n has si stones.
The players move in alternating turns. During each move, the current player must remove one or more stones from a
single pile.
The player who removes the last stone loses the game.
Given the value of n and the number of stones in each pile, determine whether the person who wins the game is the
first or second person to move. If the first player to move wins, print First on a new line; otherwise, print Second.
Assume both players move optimally.

Example
s = [1,1,1]
In this case, player 1 picks a pile, player 2 picks a pile and player 1 has to choose the last pile. Player 2 wins so
return Second.

s=[2,1,2]
There is no permutation of optimal moves where player 2 wins. For example, player 1 chooses the first pile. If player
2 chooses 1 from another pile, player 1 will choose the pile with 2 left. If player 2 chooses a pile of 2, player 1
chooses 1 from the remaining pile leaving the last stone for player 2. Return First.

Function Description

Complete the misereNim function in the editor below.

misereNim has the following parameters:

int s[n]: the number of stones in each pile
Returns

string: either First or Second
Input Format

The first line contains an integer, T, the number of test cases.
Each test case is described over two lines:

An integer, n, the number of piles.
 space-separated integers,s[i] , that describe the number of stones at pile .


Sample Input

STDIN   Function
-----   --------
2       T = 2
2       s[] size n = 2
1 1     s = [1, 1]
3       s[] size n = 3
2 1 3   s = [2, 1, 3]
Sample Output

First
Second
 */
public class MisèreNim {

    public static void main(String[] args) {
        System.out.println(MisèreNim.misereNim(Arrays.asList(2,1,2)));
    }
    public static String misereNim(List<Integer> s) {
        // Write your code here
        int nimSum =0, count =0;;
        for(int i=0;i<s.size();i++){
            nimSum^=s.get(i);
            if(s.get(i)==1)
                count++;
        }
        if(count==s.size()){
            if(count%2==0){
                return "First";
            } else{
                return "Second";
            }
        }
        if(nimSum!=0)
            return "First";
        return "Second";

    }
}
