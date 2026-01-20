package com.binarysearch;
/*
1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold

Given a m x n matrix mat and an integer threshold, return the maximum side-length of a square with a sum
less than or equal to threshold or return 0 if there is no such square.


Example 1:
Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
Output: 2
Explanation: The maximum side length of square with sum less than 4 is 2 as shown.

TC : o(mn * log(min(m,n))
SC: o(mn)
 */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

    public static void main(String[] args) {
        System.out.println(new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold().maxSideLength(
                new int[][]{
                        {1,1,3,2,4,3,2},
                        {1,1,3,2,4,3,2},
                        {1,1,3,2,4,3,2}
                }, 4
        ));
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] p = new int[m+1][n+1];
        // compute prefix sum
        for(int i=1;i<=m;i++){
            for(int j= 1; j<=n;j++){
                p[i][j] = p[i-1][j]+ p[i][j-1] - p[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int l =1, r = Math.min(m,n);
        int ans =0;
        while(l<=r){
            int mid = (l+r)/2;
            boolean find = false;
            for(int i=1;i<=m-mid+1;i++){
                for(int j = 1; j<= n- mid+1;j++){
                    int sum = p[i+mid-1][j+mid-1]-
                            p[i-1][j+mid-1] - p[i+mid-1][j-1]+ p[i-1][j-1];
                    if(sum <= threshold){
                        find = true;
                        break;
                    }
                }
                if(find){
                    break;
                }
            }
            if(find){
                ans = mid;
                l = mid +1;
            } else{
                r = mid -1;
            }
        }
        return ans;
    }
}
