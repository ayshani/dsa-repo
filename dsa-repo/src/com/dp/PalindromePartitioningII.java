package com.dp;
/*
132. Palindrome Partitioning II

Given a string s, partition s such that every
substring
 of the partition is a
palindrome
.

Return the minimum cuts needed for a palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

TC: o(n^2)
SC: o(n^2)

Explanation
https://www.youtube.com/watch?v=qmTtAbOTqcg&list=RDCMUC7rNzgC2fEBVpb-q_acpsmw&start_radio=1&rv=qmTtAbOTqcg&t=275
 */
public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII().minCut("aab"));
    }
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int gap =0;gap<n;gap++){
            for(int i=0, j=gap;j<n;j++,i++){
                if(gap==0){
                    dp[i][j]= true;
                } else if(gap==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                } else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])
                        dp[i][j]= true;
                }
            }
        }

        int[] storage = new int[n];
        storage[0] =0;
        for(int j=1;j<n;j++){
            int min=Integer.MAX_VALUE;
            if(dp[0][j])
                storage[j] =0;
            else{
                for(int i=j;i>=1;i--){
                    if(dp[i][j]){
                        min = Math.min(min,storage[i-1]);
                    }
                }
                storage[j] = min+1;
            }
        }
        return storage[n-1];
    }
}
