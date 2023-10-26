package com.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
823. Binary Trees With Factors

Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times.
Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.

Example 1:

Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].

Logic
-------
Let dp[i] be the number of ways to have a root node with value A[i].

Since in the above example we always have x < v and y < v, we can calculate the values of dp[i] in increasing order
using dynamic programming.

For some root value A[i], let's try to find candidates for the children with values A[j] and A[i] / A[j]
(so that evidently A[j] * (A[i] / A[j]) = A[i]). To do this quickly,
we will need index which looks up this value: if A[k] = A[i] / A[j], then index[A[i] / A[j]] = k.

After, we'll add all possible dp[j] * dp[k] (with j < i, k < i) to our answer dp[i].
In our Java implementation, we carefully used long so avoid overflow issues.

Complexity Analysis

Time Complexity: O(N^2)
where N is the length of A. This comes from the two for-loops iterating i and j.

Space Complexity: O(N), the space used by dp and index.
 */
public class BinaryTreesWithFactors {

    public static void main(String[] args) {
        int[] A = new int[]{2,4,5,10};
        System.out.println(new BinaryTreesWithFactors().numFactoredBinaryTrees(A));
    }
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1000000007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap<>();

        for(int i=0;i<N;i++){
            index.put(A[i],i);
        }
        long ans =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(A[i]%A[j]==0){
                    int right = A[i]/A[j];
                    if(index.containsKey(right)){
                        dp[i] =  (dp[i]+ dp[j]*dp[index.get(right)])%MOD;
                    }
                }
            }
            ans+= dp[i];
        }

        return (int)(ans%MOD);
    }
}
