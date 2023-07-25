package com.gametheory;

import java.util.Arrays;

/*
Alice And Bob Silly Game
https://www.hackerrank.com/challenges/alice-and-bobs-silly-game/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
Alice and Bob invented the following silly game:

The game starts with an integer, , that's used to build a  of  distinct integers in the inclusive range from  to
(i.e., ).
Alice always plays first, and the two players move in alternating turns.
During each move, the current player chooses a prime number, , from . The player then removes  and all of its
 multiples from .
The first player to be unable to make a move loses the game.
Alice and Bob play  games. Given the value of  for each game, print the name of the game's winner on a new line.
 If Alice wins, print Alice; otherwise, print Bob.

Note: Each player always plays optimally, meaning they will not make a move that causes them to lose the game
if some better, winning move exists.

Input Format

The first line contains an integer, , denoting the number of games Alice and Bob play.
Each line  of the  subsequent lines contains a single integer, , describing a game.

Constraints

Subtasks

 for  of the maximum score
Output Format

For each game, print the name of the winner on a new line. If Alice wins, print Alice; otherwise, print Bob.

Sample Input 0

3
1
2
5
Sample Output 0

Bob
Alice
Alice
 */
public class AliceAndBobSillyGame {

    public static void main(String[] args) {
        System.out.println(AliceAndBobSillyGame.sillyGame(5));
    }
    public static String sillyGame(int n) {
        // Write your code here
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for(int i=2;i*i<=n;i++){
            if(!prime[i])
                continue;
            for(int j= i*i;j<=n;j+=i){
                prime[j]= false;
            }
        }
        int count =0;
        for(int i=1;i<=n;i++){
            if(prime[i])
                count++;
        }
        if(n==1 || count%2==0 )
            return "Bob";
        return "Alice";
    }
}
