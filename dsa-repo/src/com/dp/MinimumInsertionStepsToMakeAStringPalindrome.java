package com.dp;
/*
1312. Minimum Insertion Steps to Make a String Palindrome

Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.



Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.

Intuition
-------------------
Split the string s into to two parts,
and we try to make them symmetrical by adding letters.

The more common symmetrical subsequence they have,
the less letters we need to add.

Now we change the problem to find the length of longest common sequence.
This is a typical dynamic problem.
like a string and its reverse version.
so if we cn get longest common sequence, we can subtract from total length of the string which needs to be replaced.


Explanation
Step1.
Initialize dp[n+1][n+1],
wheredp[i][j] means the length of longest common sequence between
i first letters in s1 and j first letters in s2.

Step2.
Find the the longest common sequence between s1 and s2,
where s1 = s and s2 = reversed(s)

Step3.
return n - dp[n][n]


Complexity
Time O(N^2)
Space O(N^2)
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {

    public static void main(String[] args) {
        System.out.println(new MinimumInsertionStepsToMakeAStringPalindrome().minInsertions("leetcode"));
    }
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1] = s.charAt(i) == s.charAt(n-j-1) ? dp[i][j]+1 :
                        Math.max(dp[i][j+1], dp[i+1][j]);

            }
        }
        return n- dp[n][n];

    }
}
