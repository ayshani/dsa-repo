package com.dp;
/*
1871. Jump Game VII

You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:

i + minJump <= j <= min(i + maxJump, s.length - 1), and
s[j] == '0'.
Return true if you can reach index s.length - 1 in s, or false otherwise.



Example 1:

Input: s = "011010", minJump = 2, maxJump = 3
Output: true
Explanation:
In the first step, move from index 0 to index 3.
In the second step, move from index 3 to index 5.

TC: o(n)
SC: o(n)
 */
public class JumpGameVII {

    public static void main(String[] args) {
        System.out.println(new JumpGameVII().canReach("011010", 2 ,3));
    }
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] f = new int[n];
        int[] pre = new int[n];
        f[0] = 1;
        // since we start dynamic programming from i=minJump, we need to precompute the prefix sums for the part [0, minJump)
        for (int i = 0; i < minJump; i++) {
            pre[i] = 1;
        }
        for (int i = minJump; i < n; i++) {
            int left = i - maxJump;
            int right = i - minJump;
            if (s.charAt(i) == '0') {
                int total = pre[right] - (left <= 0 ? 0 : pre[left - 1]);
                f[i] = total != 0 ? 1 : 0;
            }
            pre[i] = pre[i - 1] + f[i];
        }
        return f[n - 1] == 1;
    }
}
