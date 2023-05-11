package com.dp;
/*
1035. Uncrossed Lines

You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2
(in the order they are given) on two separate horizontal lines.

We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:

nums1[i] == nums2[j], and
the line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong
to one connecting line).

Return the maximum number of connecting lines we can draw in this way.

Example 1:
Input: nums1 = [1,4,2], nums2 = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4
will intersect the line from nums1[2]=2 to nums2[1]=2.

TC: o(m*n)
SC: o(m*n) [for V1, we need extra space for recursion]

Explanation
-------------
this is basically a variant of Longest common subsequence problem of dynamic programming
where we need to find the max matching subsequence between two arrays.
 */
public class UncrossedLines {

    public static void main(String[] args) {
        int[] a = new int[]{1,4,2}, b = new int[]{1,2,4};
        System.out.println(new UncrossedLines().maxUncrossedLinesV1(a,b));
        System.out.println(new UncrossedLines().maxUncrossedLinesV2(a,b));
    }
    public int maxUncrossedLinesV1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Integer[][] dp = new Integer[m][n];
        return util(nums1, nums2, 0,0,dp);
    }

    private int util(int[] nums1, int[] nums2, int i, int j, Integer[][] dp){
        if(i>=nums1.length || j>=nums2.length)
            return 0;
        if(null!= dp[i][j])
            return dp[i][j];
        int ans =0;
        if(nums1[i] == nums2[j])
            ans = 1+ util(nums1, nums2, i+1, j+1, dp);
        else
            ans = Math.max(util(nums1, nums2, i, j+1, dp), util(nums1, nums2, i+1, j, dp));
        return dp[i][j] = ans;
    }

    public int maxUncrossedLinesV2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]== nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
