package com.gametheory;

import java.util.*;

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
public class TowerBreakersAgain {
    static ArrayList<Integer>[] divisors = new ArrayList[(int)1e6+1];

    public static void main(String[] args) {
        TowerBreakersAgain.seive();
        Arrays.fill(divisors, new ArrayList<Integer>());
        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println(TowerBreakersAgain.towerBreakers(list));
    }
    static Map<Integer,Integer> map = new HashMap<>();
    public static void seive(){
        boolean[] prime = new boolean[(int)1e6+1];
        Arrays.fill(prime,true);
        prime[0] = prime[1] = false;
        for(int i=2;i<= (int)1e6;i++){
            if(prime[i]){
                for(int j=i*2;j<=(int)1e6; j+=i){
                    prime[j]= false;
                    if(divisors[j]==null)
                        divisors[j] = new ArrayList<>();
                    divisors[j].add(i);
                }
            }
        }
    }

    public static int grundy(int n){
        if(n==1)
            return 0;
        if(map.containsKey(n))
            return map.get(n);
        Set<Integer> set = new HashSet<>();
        for(int y : divisors[n]){
            int z = n/y;
            int g = grundy(z);
            if(y%2==0)
                g=0;
            set.add(g);
        }
        int mex =0;
        for(int i=0;;i++){
            if(!set.contains(i)) {
                mex = i;
                break;
            }
        }
        map.put(n, mex);
        return mex;
    }
    public static int towerBreakers(List<Integer> arr) {
        // Write your code here
        int nimSum =0;
        for(int i=0;i<arr.size();i++){
            nimSum ^= grundy(arr.get(i));
        }
        if(nimSum!=0)
            return 1;
        else
            return 2;
    }
}
