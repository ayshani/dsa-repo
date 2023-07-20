package com.gametheory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Grundy's Game

There is a heap of n coins and two players who move alternately. On each move, a player chooses a heap and
divides it into two nonempty heaps that have a different number of coins. The player who makes the last move
wins the game.

Your task is to find out who wins if both players play optimally.

Return "first" if First player is the winner or "second" if second player is the winner without quotes.

Constraints:

1<= n <= 10^6



Example 1:

Input

n = 6
Output

first
Example 2:

Input

n = 7
Output

second
 */
public class GrundysGame {

    public static void main(String[] args) {
        System.out.println(new GrundysGame().solve(5));
    }
    String solve(int n){
        int limit = 2000;
        int[] dp = new int[limit];
        dp[0]= dp[1]= dp[2]=0;
        for(int i=3;i<limit;i++){
            List<Integer> list = new ArrayList<>();
            for(int j =1;j*2<i;j++){
                list.add(dp[j]^dp[i-j]);
            }
            dp[i] =  getMex(list);
        }
        if(n>=limit)
            return "First";
        if(dp[n]==0)
            return "Second";
        return "First";
    }

    private int getMex(List<Integer> list) {

        Set<Integer> set = new HashSet<>(list);
        for(int i=0;i<=1000001;i++){
            if(!set.contains(i))
                return i;
        }
        return -1;
    }
}
