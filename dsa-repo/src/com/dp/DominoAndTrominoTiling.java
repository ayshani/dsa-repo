package com.dp;

import java.util.HashMap;
import java.util.Map;

/*
790. Domino and Tromino Tiling

You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile.
Two tilings are different if and only if there are two 4-directionally adjacent cells on
the board such that exactly one of the tilings has both squares occupied by a tile.

Example 1:
Input: n = 3
Output: 5
Explanation: The five different ways are show above.

Overview
The objective of this question is as follows: Count how many ways to completely fill a 2 x n board using 2 shapes
(2 x 1 dominos and L shaped trominos). Note that rotation of these shapes is allowed.

At first glance, one might consider testing every possible combination of dominos and trominos and then count
the ones that completely fill the 2 x n board. This can be achieved through backtracking, where we fill the
board from left to right and, at each step, we try all valid ways to place a domino or a tromino.
Once the board is full or no tile will fit in the remaining space, we remove the last tile placed (backtrack)
to return to the previous board state and try all of the remaining tile placement options.
As you can imagine, constructing every possible board would be a time-consuming process.
Furthermore, we are not actually interested in finding every possible way to completely fill
the board - we are only interested in the number of ways the board can be completely filled.
With this in mind, there should be a more efficient way to solve this problem. It seems like we are stuck now.
What else can we do to solve this problem?

Whenever you are not sure how to approach a problem, it is a good idea to draw out the first couple of scenarios.

Now, let's define:

Fully covered board: All tiles on board are covered by a domino or a tromino.
Partially covered board: Same as a fully covered board, except leave the tile in the upper-right corner
    (the top row of the rightmost column) uncovered. Note, a board with only the lower-right corner
    uncovered is also considered "partially covered." However, as we will discover soon, we do not need
    to keep track of which corner is uncovered because of symmetry.
f(k): The number of ways to fully cover a board of width k.
p(k): The number of ways to partially cover a board of width k.
We can determine the number of ways to fully or partially tile a board of width k by considering
every possible way to arrive at f(k) or p(k) by placing a domino or a tromino.
Let's find f(k) together and then you can pause to practice by finding p(k) on your own.
All of the ways to arrive at a fully tiled board of width k are as follows:

From f(k−1) we can add 1 vertical domino for each tiling in a fully covered board with a width of k−1
From f(k−2) we can add 2 horizontal dominos for each tiling in a fully covered board with a width of k−2
    - Note that we don't need to add 2 vertical dominos to f(k−2), since f(k−1) will cover that case
        and it will cause duplicates if we count it again.
From p(k−1) we can add an L-shaped tromino for each tiling in a partially covered board with a width of k−1.
We will multiply by p(k−1) by 2 because for any partially covered tiling,
   there will be a horizontally symmetrical tiling of it. For example,
   the animation below shows two p(k−1) board states that are identical when reflected over the
   horizontal edge of the board. Logically,
   there must be an equal number of ways to fully tile the board from both p(k−1) states.
   So rather than count the number of ways twice, we simply multiply the number of ways from one p(k−1) state by 2.
Summing the ways to reach f(k) gives us the following equation:

f(k) = f(k-1) + f(k-2) + 2 * p(k-1)

Now that we know where tilings on f(k) are coming from, how about p(k)?
Can we apply the same logic and find that out? Absolutely yes!

Take a pen and start drawing scenarios that contribute to p(4)
(this is a good technique to aid critical thinking during an interview).
Start by drawing p(4), remember p(4) is a board of width 4 with the first 3 columns fully covered
and the last column half covered. Now, try removing a domino or a tromino to find which scenarios
contribute to p(4). Notice that p(k) can come from the below scenarios:

Adding a tromino to a fully covered board of width k−2 (i.e. f(k−2))
Adding a horizontal domino to a partially covered board of width k−1 (i.e. p(k−1))
Thus, we arrive at the following conclusion for p(k):

p(k) = p(k-1) + f(k-2)


Intuition

One of the drawbacks to the previous top-down DP solution is that it uses a recursive call
stack which requires additional time and space to maintain. When we know that all of the subproblems
(i.e. f(1) through f(n−1)) must be solved and there is a logical order to the subproblems (i.e. f(1)
must be solved before f(2), and f(2) before ... f(n−1)), then bottom-up DP will generally be more efficient
than top-down DP because it will solve the same number of subproblems and do so without maintaining a call stack.
Different from the previous top-down solution, this solution will be in a bottom-up fashion. As such,
we will start by calculating the base case (when nnn is very small, like 0, 1, 2 etc.), then move to
the next case (when nnn grows to a larger number) and gradually get the result for the final case f(n).

Algorithm

Create two arrays, f and p, of size n+1, where f(k) represents the number of ways to fully cover a board of width k
 and p(k) represents the number of ways to partially cover a board of width k (as described in the overview).
Initialize f and p according to the following base cases:
f(1)=1 because to fully cover a board of width 1, there is only one way, add one vertical domino.
f(2)=2 because to fully cover a board of width 2, there are two ways, either add two horizontal dominos or
    add two vertical dominos.
p(2)=1 because to partially cover a board of width 2, there is only one way using an L-shaped tromino
    (leave the upper-right corner uncovered).
Iterate k from 2 to n (inclusive) and at each iteration update f and p according to the transition functions
we derived in the overview:
f(k) = f(k-1) + f(k-2) + 2 * p(k-1)
p(k) = p(k-1) + f(k-2)
Return f(n) which now represents the number of ways to fully cover a board of width n.

Complexity Analysis

Let NNN be the width of the board.

Time complexity: O(N)

Array iteration requires N−2 iterations where each iteration takes constant time.

Space complexity: O(N)

Two arrays of size N+1 are used to store the number of ways to fully and partially tile boards of
various widths between 1 and N.
 */
public class DominoAndTrominoTiling {

    public static void main(String[] args) {
        System.out.println(new DominoAndTrominoTiling().numTilings(3));
        System.out.println(new DominoAndTrominoTiling().numTilingsV2(3));


    }
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        // handle base case scenarios
        if (n <= 2) {
            return n;
        }
        // f[k]: number of ways to "fully cover a board" of width k
        long[] f = new long[n + 1];
        // p[k]: number of ways to "partially cover a board" of width k
        long[] p = new long[n + 1];
        // initialize f and p with results for the base case scenarios
        f[1] = 1L;
        f[2] = 2L;
        p[2] = 1L;
        for (int k = 3; k < n + 1; ++k) {
            f[k] = (f[k - 1] + f[k - 2] + 2 * p[k - 1]) % MOD;
            p[k] = (p[k - 1] + f[k - 2]) % MOD;
        }
        return (int) (f[n]);
    }

    //https://leetcode.com/problems/domino-and-tromino-tiling/solutions/116581/detail-and-explanation-of-o-n-solution-why-dp-n-2-d-n-1-dp-n-3/?envType=study-plan-v2&envId=leetcode-75
    /*
    when N==0, we need return 0, but in dp , we need make dp[0]=1 for easy to construct formula
    dp[n]=dp[n-1]+dp[n-2]+ 2*(dp[n-3]+...+d[0])
            =dp[n-1]+dp[n-2]+dp[n-3]+dp[n-3]+2*(dp[n-4]+...+d[0])
            =dp[n-1]+dp[n-3]+(dp[n-2]+dp[n-3]+2*(dp[n-4]+...+d[0]))
            =dp[n-1]+dp[n-3]+dp[n-1]
            =2*dp[n-1]+dp[n-3]
     */
    public int numTilingsV2(int n) {
        int MOD = 1_000_000_007;
        // handle base case scenarios
        if (n <= 2) {
            return n;
        }
        long[] dp = new long[n+1];
        dp[1] =1;
        dp[2] = 2;
        dp[3] = 5;
        if(n<=3)
            return (int)dp[n];
        for(int i=4;i<=n;i++){
            dp[i] = (2*dp[i-1] + dp[i-3])%MOD;
        }
        return (int)dp[n];
    }
}
