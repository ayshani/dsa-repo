package com.matrix;

import java.util.TreeSet;

/*
363. Max Sum of Rectangle No Larger Than K

Given an m x n matrix and an integer k, return the max sum of a rectangle in
the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

Example 1:
Input: matrix = [[1,0,1],[0,-2,3]], k = 2
        1  0  1
        0 -2  3

Output: 2
Explanation: Because the sum of the rectangle [[0, 1], [-2, 3]] is 2,
and 2 is the max number no larger than k (k = 2).

Logic
-----
Firstly, let solve this sub problem Max Sum of Subarray No Larger Than K,
    which is "Given an array of N integers, find the maximum sum of subarray which is no larger than K".
Iterating index i from left to right.
Calculate prefixSum so far, let name it right
Try to find the left prefixSum so that right - left <= k => left >= right - k.
We can use TreeSet (implemented as BST), and use ceiling(x) to find the least key greater than or
    equal to the given x. So left = bst.ceiling(right-k).
If we found a valid left, then we update the answer by ans = max(ans, right - left).
Then we try all possible pairs of (r1, r2) of rows in the matrix, where 0 <= r1 <= r2 < m.
Make an array of n integer, where arr[c] = sum(matrix[r1][c]...matrix[r2][c]), then solve that sub problem.

Complexity

Time: O(M^2 * N * logN), where M <= 100 is number of rows, N <= 100 is number of columns in the matrix.
Space: O(N)
 */
public class MaxSumOfRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for(int r1=0;r1<m;r1++){
            int[] arr = new int[n]; // arr[i] is sum(matrix[r1][c]...matrix[r2][c])
            for(int r2=r1;r2<m;r2++){
                for(int c=0;c<n;c++)
                {
                    arr[c]+=matrix[r2][c];
                }
                ans = Math.max(ans, maxSumSubArray(arr,n,k));
            }
        }

        return ans;
    }

    private int maxSumSubArray(int[] arr, int n, int k){ // O(N * logN)
        int right=0;

        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            right+=arr[i];
            Integer left = set.ceiling(right-k);// right - left <= k -> left >= right - k
            if(left !=  null){
                ans = Math.max(ans, right - left);
            }
            set.add(right);
        }

        return ans;
    }
}
