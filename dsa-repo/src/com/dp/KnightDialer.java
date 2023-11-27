package com.dp;
/*
935. Knight Dialer

The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two
squares horizontally and one square vertically (with both forming the shape of an L). The possible movements of
chess knight are shown in this diagaram:

We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).

Given an integer n, return how many distinct phone numbers of length n we can dial.

You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial
a number of length n. All jumps should be valid knight jumps.

As the answer may be very large, return the answer modulo 109 + 7.



Example 1:

Input: n = 1
Output: 10
Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is
sufficient.
Example 2:

Input: n = 2
Output: 20
Explanation: All the valid number we can dial are
[04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]

Complexity Analysis

Time complexity: O(n)

If kkk is the size of the phone pad, then there are O(n⋅k) states to our DP. Because k=10 in this problem,
we can treat kkk as a constant and thus there are O(n) states to our DP.

Due to memoization, we never calculate a state more than once. Since the number of nextSquare is no more than
3 for each square, calculating each state is done in O(1) as we simply perform a for loop that never iterates
more than 3 times.

Overall, we calculate O(n) states with each state costing O(1) to calculate. Thus, our time complexity is O(n).

Space complexity: O(n)

The recursion call stack will grow to a size of O(n). With memoization, we also store the results to every
DP state. As there are O(n) states, we require O(n) space to store all the results.


 */
public class KnightDialer {

    int n, mod = (int)1e9+7;
    int[][] memo;
    int[][] jumps ={
            {4,6},
            {6,8},
            {7,9},
            {4,8},
            {3,9,0},
            {},
            {1,0,7},
            {2,6},
            {1,3},
            {2,4}
    };
    public int knightDialer(int n) {
        this.n = n;
        memo = new int[n+1][10];
        int ans =0;
        for(int sq =0;sq<10;sq++){
            ans = (ans + dp(n-1, sq))%mod;
        }
        return ans;
    }

    private int dp(int remain, int square){
        if(remain ==0)
            return 1;
        if(memo[remain][square]!=0){
            return memo[remain][square];
        }

        int ans =0;
        for(int nextSq : jumps[square]){
            ans = (ans + dp(remain-1, nextSq))%mod;
        }
        return memo[remain][square] = ans;
    }

    public static void main(String[] args) {
        System.out.println(new KnightDialer().knightDialer(10));
    }
}
