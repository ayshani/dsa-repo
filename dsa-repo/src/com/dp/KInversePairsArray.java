package com.dp;
/*
629. K Inverse Pairs Array

For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length
and nums[i] > nums[j].

Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such
that there are exactly k inverse pairs. Since the answer can be huge, return it modulo 109 + 7.

Example 1:

Input: n = 3, k = 0
Output: 1
Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pairs.


 */
public class KInversePairsArray {

    public static void main(String[] args) {
        System.out.println(new KInversePairsArray().kInversePairs(3,1));
        System.out.println(new KInversePairsArray().kInversePairsV1(3,1));
    }

    /*
    TC : o(nk)
    SC: o(k)
     */
    public int kInversePairs(int n, int k) {
        int[] dp = new int[k+1];
        int M = 1000000007;
        for(int i=1;i<=n;i++){
            int[] temp = new int[k+1];
            temp[0]=1;
            for(int j=1;j<=k;j++){
                int val = (dp[j]+M-((j-i)>=0?dp[j-i]:0))%M;
                temp[j]=(temp[j-1]+val)%M;
            }
            dp=temp;
        }
        return ((dp[k]+M-(k>0?dp[k-1]:0)) % M);
    }


    /*
    TC : o(nkmin(n,k))
    SC: o(nk)
     */
    Integer[][] memo = new Integer[1001][1001];
    public int kInversePairsV1(int n, int k) {
        if (n == 0)
            return 0;
        if (k == 0)
            return 1;
        if (memo[n][k] != null)
            return memo[n][k];
        int inv = 0;
        for (int i = 0; i <= Math.min(k, n - 1); i++)
            inv = (inv + kInversePairsV1(n - 1, k - i)) % 1000000007;
        memo[n][k] = inv;
        return inv;
    }
}
