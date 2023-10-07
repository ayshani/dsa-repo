package com.dp;

import java.util.Arrays;

/*1420. Build Array Where You Can Find The Maximum Exactly K Comparisons

You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array
of positive integers:
You should build the array arr which has the following properties:

arr has exactly n integers.
1 <= arr[i] <= m where (0 <= i < n).
After applying the mentioned algorithm to arr, the value search_cost is equal to k.
Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large,
the answer must be computed modulo 109 + 7.



Example 1:

Input: n = 2, m = 3, k = 1
Output: 6
Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]


Approach 1: Top-Down Dynamic Programming
Intuition


Before we start solving the problem, let's carefully read the algorithm given in the problem description to try
to figure out exactly what the problem is asking for. Upon careful inspection, we can deduce that the problem is
asking:

How many arrays of length n with values in the range [1, m] exist, such that you will find exactly k new maximums
when traversing from left to right?

Given the massive number of possibilities, it seems impossible to actually try to build the arrays. Can we break
the problem down?

Let's say you are currently building a candidate array. We don't need to know the exact contents of the array, but
we need to know the following:

How many elements have we placed so far? Suppose we add elements to the array in order. We can represent this with
an index i that indicates the index of the next element we will place. For example, if the current array
is [1, 6, 4], the next element we will place is at i = 3.

The maximum element in the array. We can represent this with an integer maxSoFar. In the example of [1, 6, 4],
we have maxSoFar = 6.

How many remaining new maximums must we encounter before the end? We can represent this with an integer remain.
In the example of [1, 6, 4], both 1 and 6 are maximums, so if we need a total of x maximums, we have remain = x - 2.

Given a state i, maxSoFar, remain, can we come up with a recursive way to solve the problem? Let's define a function
dp(i, maxSoFar, remain) that returns the number of ways to build a valid array if we have already placed i elements,
the maximum element we have placed so far is maxSoFar, and we need to place remain more new maximums. Then, the
answer to the original problem would be dp(0, 0, k). We start with an empty array and need to place k new maximums.

What would our base cases be?

If i == n, we have filled the array. The array is valid if remain == 0 and we will return 1 in that case, or 0 otherwise.
If remain < 0, then we have placed too many new maximums. We should immediately return 0 as it is impossible to form a
valid array from this point forward.
Now that we have the base cases, how do we calculate a given state i, maxSoFar, remain? We will attempt to place a new
element at index i. There are 2 possibilities:

We place a number that is not a new maximum. How many ways are there to do this? The range of numbers we could
choose from is [1, maxSoFar]. The size of this range is maxSoFar - 1 + 1 = maxSoFar. After placing a number, the
next state is i + 1, maxSoFar, remain. We move to the next index, and maxSoFar and remain are unchanged since we
didn't place a new maximum. Thus, the total possibilities is maxSoFar * dp(i + 1, maxSoFar, remain).

We place a number that is a new maximum. How many ways are there to do this? The range of numbers we could choose
from is [maxSoFar + 1, m]. Let's say that we choose a number num from this range. The state would be i + 1, num,
remain - 1. We move to the next index, maxSoFar is updated, and we placed a new maximum. We need to try all
possibilities in the range [maxSoFar + 1, m].


Complexity Analysis

Time complexity: O(n⋅m^2⋅k)
There are n⋅m⋅k possible states of dp. Because of memoization, we never calculate a state more than once.
To calculate a given state, we have for loops that iterate O(m) times. Thus, to calculate O(n⋅m⋅k) states
costs O(n⋅m^2⋅k)

Space complexity: O(n⋅m⋅k)
The recursion call stack uses some space, but it will be dominated by the memoization of dp. We are storing the
results of O(n⋅m⋅k) states.
 */
public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {

    public static void main(String[] args) {
        System.out.println(new BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons().numOfArrays(2,3,1));
    }
    int[][][] memo;
    int MOD = (int) 1e9 + 7;
    int n;
    int m;

    public int numOfArrays(int n, int m, int k) {
        memo = new int[n][m + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        this.n = n;
        this.m = m;
        return dp(0, 0, k);
    }

    public int dp(int i, int maxSoFar, int remain) {
        if (i == n) {
            if (remain == 0) {
                return 1;
            }

            return 0;
        }

        if (remain < 0) {
            return 0;
        }

        if (memo[i][maxSoFar][remain] != -1) {
            return memo[i][maxSoFar][remain];
        }

        int ans = 0;
        for (int num = 1; num <= maxSoFar; num++) {
            ans = (ans + dp(i + 1, maxSoFar, remain)) % MOD;
        }

        for (int num = maxSoFar + 1; num <= m; num++) {
            ans = (ans + dp(i + 1, num, remain - 1)) % MOD;
        }

        memo[i][maxSoFar][remain] = ans;
        return ans;
    }
}
