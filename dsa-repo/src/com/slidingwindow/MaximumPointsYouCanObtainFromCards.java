package com.slidingwindow;
/*
1423. Maximum Points You Can Obtain from Cards

There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.



Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will
maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score
of 1 + 6 + 5 = 12.

TC : o(n)
SC: o(1)
 */
public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        int[] card = new int[]{9,7,7,9,7,8,9};
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(card,3));
    }
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = Integer.MIN_VALUE, n = cardPoints.length;
        int left = k-1, right = n-1, curSum =0;

        for(int i=0;i<k;i++){
            curSum+= cardPoints[i];
        }
        maxSum = curSum;

        for(int i=0;i<k;i++){
            curSum += cardPoints[right]  -cardPoints[left];
            maxSum = Math.max(curSum, maxSum);
            left--;
            right--;
        }
        return maxSum;
    }
}
