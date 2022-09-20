package com.dp;
/*
718. Maximum Length of Repeated Subarray

Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5

Intuition and Algorithm

Since a common subarray of A and B must start at some A[i] and B[j], let dp[i][j] be the longest common prefix
of A[i:] and B[j:]. Whenever A[i] == B[j], we know dp[i][j] = dp[i+1][j+1] + 1.
Also, the answer is max(dp[i][j]) over all i, j.

We can perform bottom-up dynamic programming to find the answer based on this recurrence.
Our loop invariant is that the answer is already calculated correctly and stored in dp for any larger i, j.

Complexity Analysis

Time Complexity: O(M∗N), where M,N are the lengths of A, B.

Space Complexity: O(M∗N), the space used by dp.
 */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1}, B = new int[]{3,2,1,4,7};
        System.out.println(new MaximumLengthOfRepeatedSubarray().findLength(A,B));
    }
    public int findLength(int[] A, int[] B) {
        int ans =0;
        int[][] memo = new int[A.length+1][B.length+1];

        for(int i= A.length-1;i>=0;i--){
            for(int j=B.length-1; j>=0;j--){
                if(A[i]==B[j]){
                    memo[i][j] = memo[i+1][j+1]+1;
                    ans= Math.max(ans,memo[i][j]);
                }
            }
        }

        return ans;
    }
}
