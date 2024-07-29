package com.dp;
/*
1395. Count Number of Teams

There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where
(0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).



Example 1:

Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).

TC : o(n^2)
SC: o(1)
 */
public class CountNumberOfTeams {

    public static void main(String[] args) {
        System.out.println(new CountNumberOfTeams().numTeams(
                new int[]{2,5,3,4,1}
        ));
    }
    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams =0;
        for(int mid =0;mid<n;mid++){
            int leftSmaller =0, rightLarger =0;
            for(int left = mid -1; left>=0;left--){
                if(rating[left]<rating[mid]){
                    leftSmaller++;
                }
            }

            for(int right = mid +1; right<n;right++){
                if(rating[right]>rating[mid]){
                    rightLarger++;
                }
            }
            teams+=leftSmaller*rightLarger;
            int leftLarger = mid - leftSmaller;
            int rightSmaller = n-mid-1 -rightLarger;
            teams += leftLarger*rightSmaller;
        }
        return teams;
    }
}
