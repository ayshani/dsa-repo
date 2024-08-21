package com.dp;
/*
664. Strange Printer

There is a strange printer with the following two special properties:

The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any place and will cover the
original existing characters.
Given a string s, return the minimum number of turns the printer needed to print it.



Example 1:

Input: s = "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".

Intuition
In this approach, we will calculate the same DP as in the previous one, but the manner of organizing computations
will differ.

We will use the recursive function solve(l,r) that returns the value of dp[l][r].

One can rewrite the DP recurrence relation in terms of solve\text{solve}solve as follows. If the substring
sl..r consists of the same character, solve(l,r) returns zero (the base case of the DP). Otherwise, it returns
the minimum of 1+solve(j,i)+solve(i+1,r) over all j≤i<r

The answer to the problem is solve(0,n−1)+1=dp[0][n−1]+1.

The issue here is that solve might be called (exponentially) many times for the same pair of parameters
(l,r).

Each time we call, for instance, solve(4,7), we recompute the same result for l=4,r=7.

Instead, one may keep the calculated values of solve(l,r) in memory. We will store the same DP table as in the
previous approach. In this case, the process will be as follows.

For example, we call solve(4,7) for the first time, calculate the result for l=4,r=7, and write this result
into dp[4][7]. When we call solve(4,7) for the second time, we immediately return dp[4][7].

In this way, we calculate the value of solve for each state (each pair of parameters (l,r)) only once.

There remains one small technical question: how to know whether we call solve(l,r) for the first time and need to
compute the result, or we call it later and can return dp[l][r] found earlier? One can handle this by having Integer
object  of the dp array . As soon as we find the result of solve(l,r), we will write it into dp[l][r],
and this value will not be null anymore.

Algorithm
In the code, we use left for l and right for r for clarity.

The function solve takes parameters left and right.

If dp[left][right]≠ null, return dp[left][right].
Set dp[left][right]=n. Since we will find the minimum, we initialize it with a large value.
Set j=−1. It will be the leftmost index of the character differing from s[right]. j=−1 means we have not found any
such character yet.
Iterate i from l to r−1.
If s[i] != s[r] (the character differs from s[right]) and j=−1 (there was no differing character earlier),
set j=i (it is the first such character).
If j≠−1, update dp[left][right] with the value of 1+solve(j,i)+solve(i+1,right), if it is smaller.
If j=−1 (the substring sl..r consists of the same character), set dp[left][right]=0. (The base case of the DP.)
Return dp[left][right].
One has to declare the DP table of size n×n.

The answer to the problem is solve(0,n−1)+1.

Complexity Analysis
Time complexity: O(n^3)
Even though we changed the order of calculating DP, the time complexity is the same as in the previous approach:
for each left, right, we compute dp[left][right] in O(n). Since we store the results in memory, we will calculate
each dp[left][right] only once.

Space complexity: O(n^2)
It is the same as in the first approach. The dp array we are using to cache results takes O(n^2)
 space. We also use some stack space for the recursion, but it is dominated by dp.
 */
public class StrangePrinter {

    public static void main(String[] args) {
        System.out.println(new StrangePrinter().strangePrinter("leetcode"));
    }
    public int strangePrinter(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];

        return solve(s,n,0,n-1,dp)+1;
    }

    private int solve(String s, int n, int left, int right, Integer[][] dp){
        if(dp[left][right]!=null)
            return dp[left][right];
        dp[left][right] = n;
        int j=-1;
        for(int i=left;i<right;i++){
            if(s.charAt(i) != s.charAt(right) && j==-1){
                j=i;
            }
            if(j!=-1){
                dp[left][right] = Math.min(dp[left][right], 1 + solve(s,n,j,i,dp) +
                        solve(s,n,i+1,right,dp));
            }
        }

        if(j==-1){
            dp[left][right] = 0;
        }
        return dp[left][right];
    }
}
