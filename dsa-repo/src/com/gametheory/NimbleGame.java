package com.gametheory;

import java.util.Arrays;
import java.util.List;

/*
Nimble Game

Two people are playing Nimble! The rules of the game are:

The game is played on a line of n squares, indexed from 0 to n-1. Each square i (where 0<=i<n) contains ci coins.
For example:
    0  1     2      3       4
    - 1 1  2 2 2    -  4 4 4 4 4 4

The players move in alternating turns. During each move, the current player must remove exactly 1 coin from square
i and move it to square j if and only if 0<=j<i.
The game ends when all coins are in square 0 and nobody can make a move. The first player to have no available move
loses the game.

Given the value of n and the number of coins in each square, determine whether the person who wins the game is
the first or second person to move. Assume both players move optimally.

Input Format

The first line contains an integer, T, denoting the number of test cases.
Each of the 2T  subsequent lines defines a test case. Each test case is described over the following two lines:

An integer,n  , denoting the number of squares.
 n space-separated integers,c0,c1,c2,c3,... , where each ci describes the number of coins at square i.

Output Format

For each test case, print the name of the winner on a new line (i.e., either  or ).

Sample Input

2
5
0 2 3 0 6
4
0 0 0 0
Sample Output

First
Second
 */
public class NimbleGame {

    public static void main(String[] args) {
        System.out.println(NimbleGame.nimbleGame(Arrays.asList(0,2,3,0,6)));
    }

    public static String nimbleGame(List<Integer> s) {
        // Write your code here
        int nimSum =0;
        for(int i=0;i<s.size();i++){
            int x = s.get(i)%2;
            if(x!=0)
                nimSum ^= i;
        }
        if(nimSum!=0)
            return "First";
        return "Second";
    }
}
