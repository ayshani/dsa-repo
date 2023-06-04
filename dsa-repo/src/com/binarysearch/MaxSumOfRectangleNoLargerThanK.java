package com.binarysearch;

import java.util.TreeSet;

/*
363. Max Sum of Rectangle No Larger Than K

Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its
sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

Example 1:
Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number
no larger than k (k = 2).

TC: o(m*m*n*n*logn)
SC : (n)
 */
public class MaxSumOfRectangleNoLargerThanK {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,0,1},{0,-2,3}
        };
        System.out.println(new MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix(mat, 2));
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for(int r1=0;r1<m;r1++){
            int[] arr = new int[n];
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

    private int maxSumSubArray(int[] arr, int n, int k){
        int right=0;

        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            right+=arr[i];
            Integer left = set.ceiling(right-k);
            if(left !=  null){
                ans = Math.max(ans, right - left);
            }
            set.add(right);
        }

        return ans;
    }
}
