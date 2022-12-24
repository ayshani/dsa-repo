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
 */
public class DominoAndTrominoTiling {

    int MOD = 1_000_000_007;
    Map<Integer, Long> f_cache = new HashMap<>();
    Map<Integer, Long> p_cache = new HashMap<>();


    public static void main(String[] args) {
        System.out.println(new DominoAndTrominoTiling().numTilings(3));
    }
    public long p(int n) {
        if (p_cache.containsKey(n)) {
            return p_cache.get(n);
        }
        long val;
        if (n == 2) {
            val = 1L;
        } else {
            val = (p(n - 1) + f(n - 2)) % MOD;
        }
        p_cache.put(n, val);
        return val;

    }

    public long f(int n) {
        if (f_cache.containsKey(n)) {
            return f_cache.get(n);
        }
        long val;
        if (n == 1) {
            val = 1L;
        } else if (n == 2) {
            val = 2L;
        } else {
            val = (f(n - 1) + f(n - 2) + 2 * p(n - 1)) % MOD;
        }
        f_cache.put(n, val);
        return val;
    }

    public int numTilings(int n) {
        return (int) (f(n));
    }
}
