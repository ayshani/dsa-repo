package com.gametheory;

import java.util.HashMap;
import java.util.Map;

/*
A chessboard game
https://www.hackerrank.com/challenges/a-chessboard-game-1/problem?isFullScreen=true

Two players are playing a game on a 15X15 chessboard. The rules of the game are as follows:

The game starts with a single coin located at some x,y coordinates. The coordinates of the upper left cell are (1,1), and
of the lower right cell are (15,15).

In each move, a player must move the coin from cell  to one of the following locations:

Note: The coin must remain inside the confines of the board.

Beginning with player 1, the players alternate turns. The first player who is unable to make a move loses the game.
Given the initial coordinates of the players' coins, assuming optimal play, determine which player will win the game.

Function Description

Complete the chessboardGame function in the editor below. It should return a string, either First or Second.

chessboardGame has the following parameter(s):

x: an integer that represents the starting column position
y: an integer that represents the starting row position
Input Format

The first line contains an integer , the number of test cases.
Each of the next  lines contains  space-separated integers  and .

Constraints

Output Format

On a new line for each test case, print  if the first player is the winner. Otherwise, print .

Sample Input

3
5 2
5 3
8 8
Sample Output

Second
First
First
Explanation

In the first case, player1 starts at the red square and can move to any of the blue squares. Regardless of which
one is chosen, the player 2 can move to one of the green squares to win the game.

image

In the second case, player 1 starts at the red square and can move to any of the blue squares or the purple one.
Moving to the purple one limits player 2 to the yellow square. From the yellow square, player 1 moves to the green
square and wins.

image

Language
Java 8
More
293031323334353637383940414243444546474849505152
        ans &= solve(x-1,y-2);
        ans = !ans;
        map.put(s, ans);
        return ans;
    }
}

class Pair{
    int x,y;
    public Pair(int x, int y){

Line: 43 Col: 18

Test against custom input
Wrong Answer :(

2/2 test cases failed


Sample Test case 0

Sample Test case 1
Compiler Message
Wrong Answer
Input (stdin)
3
5 2
5 3
8 8
Your Output (stdout)
First
First
First
Expected Output
Second
First
First

TC : o(n)
SC: o(n)
 */
public class AChessboardGame {

    public static void main(String[] args) {
        System.out.println(new AChessboardGame().chessboardGame(8,8));
    }
    public  String chessboardGame(int x, int y) {
        // Write your code here
        if(solve(x,y))
            return "First";
        return "Second";
    }
    static boolean[][] map = new boolean[16][16];
    private static boolean solve(int x, int y){
        if(x<1 || x>15 ||y<1 || y>15)
            return true;
        //String s = "x "+y;
        Pair p =  new Pair(x,y);
        if(map[x][y])
            return map[x][y];
        boolean ans = true;
        ans &= solve(x-2,y+1);
        ans &= solve(x-2,y-1);
        ans &= solve(x+1,y-2);
        ans &= solve(x-1,y-2);
        ans = !ans;
        map[x][y]= ans;
        return ans;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
