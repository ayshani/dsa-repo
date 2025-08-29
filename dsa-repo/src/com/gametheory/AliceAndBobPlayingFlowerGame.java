package com.gametheory;
/*
3021. Alice and Bob Playing Flower Game

Alice and Bob are playing a turn-based game on a field, with two lanes of flowers between them. There are x flowers in the first lane between Alice and Bob, and y flowers in the second lane between them.

The game proceeds as follows:

Alice takes the first turn.
In each turn, a player must choose either one of the lane and pick one flower from that side.
At the end of the turn, if there are no flowers left at all, the current player captures their opponent and wins the game.
Given two integers, n and m, the task is to compute the number of possible pairs (x, y) that satisfy the conditions:

Alice must win the game according to the described rules.
The number of flowers x in the first lane must be in the range [1,n].
The number of flowers y in the second lane must be in the range [1,m].
Return the number of possible pairs (x, y) that satisfy the conditions mentioned in the statement.



Example 1:

Input: n = 3, m = 2
Output: 3
Explanation: The following pairs satisfy conditions described in the statement: (1,2), (3,2), (2,1).

Intuition
From the problem statement, we can see that Alice can only win the game when x+y is an odd number. There are two cases:

x is odd and y is even. The number of pairs (x,y) that satisfy the conditions of the problem is [n/2]*[m/2].

x is even and y is odd. The number of such pairs (x,y) is [n/2]*[m/2]

Thus, the total number of pairs (x,y) that meet the conditions is
[n/2]*[m/2] + [n/2]*[m/2]

Now, let us simplify this formula:

When both n and m are even, the expression simplifies to nm/2
When both n and m are odd, the expression simplifies to
n+1/2 * m-1/2 + n-1/2 * m+1/2 = nm-1/2

When one of n or m is odd (say n is odd), the expression simplifies to
n+1/2 * m/2 + n-1/2 * m/2 = nm/2

Therefore, the simplified formula can be summarized as nm/2

TC : o(1)
SC: o(1)
 */
public class AliceAndBobPlayingFlowerGame {

    public static void main(String[] args) {
        System.out.println(new AliceAndBobPlayingFlowerGame().flowerGame(3,4));
    }
    public long flowerGame(int n, int m) {
        return ((long) m*n)/2;
    }
}
