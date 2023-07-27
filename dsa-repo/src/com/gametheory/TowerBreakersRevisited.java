package com.gametheory;

import java.util.Arrays;
import java.util.List;

/*
Tower Breakers

https://www.hackerrank.com/challenges/tower-breakers-revisited-1/problem?isFullScreen=true

Two players (numbered  and ) are playing a game of Tower Breakers! The rules of the game are as follows:

Player  always moves first, and both players always move optimally.
Initially there are  towers of various heights.
The players move in alternating turns. In each turn, a player can choose a tower of height  and reduce its height to , where  and  evenly divides .
If the current player is unable to make any move, they lose the game.
Given the value of  and the respective height values for all towers, can you determine who will win? If the first player wins, print ; otherwise, print .

Input Format

The first line contains an integer, , denoting the number of test cases.
Each of the  subsequent lines defines a test case. Each test case is described over the following two lines:

An integer, , denoting the number of towers.
 space-separated integers, , where each  describes the height of tower .
Constraints

Output Format

For each test case, print a single integer denoting the winner (i.e., either  or ) on a new line.

Sample Input

2
2
1 2
3
1 2 3
Sample Output

1
2
 */
public class TowerBreakersRevisited {

    static int[] primeCount = new int[(int)1e6+1];

    public static void main(String[] args) {
        TowerBreakersRevisited.seive();
        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println(TowerBreakersRevisited.towerBreakers(list));
    }
    public static void seive(){
        boolean[] prime = new boolean[(int)1e6+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for(int i=2;i<= (int)1e6;i++){
            if(prime[i]){
                primeCount[i]=1;
                for(int j=i*2;j<=(int)1e6; j+=i){
                    prime[j]= false;
                    int temp = j;
                    while(temp%i==0){
                        primeCount[j]++;
                        temp/=i;
                    }
                }
            }
        }
    }
    public static int towerBreakers(List<Integer> arr) {
        // Write your code here
        int nimSum =0;
        for(int i=0;i<arr.size();i++){
            nimSum ^= primeCount[arr.get(i)];
        }
        if(nimSum!=0)
            return 1;
        else
            return 2;
    }
}
