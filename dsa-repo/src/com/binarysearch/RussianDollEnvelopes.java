package com.binarysearch;

import java.util.Arrays;

/*
354. Russian Doll Envelopes

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the
height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than
the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.



Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

TC: o(nlogn)
SC: o(n)
 */
public class RussianDollEnvelopes {

    public static void main(String[] args) {
        int[][] env = new int[][]{
                {5,4},{6,4},{6,7},{2,3}
        };
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(env));
    }
    /*
    the idea is we need to sort the 2D array according to its widths in
    ascending order. If we get width as same, we will sort in descending order of
    height because, we can't fit [3,3] to [3,4] otherwise, it ll be considered as
    ascending order [3,3],[3,4] and will try to consider. So, we changed the order.

    as because we already sorted according to width in ascending order, so, it will
    reduce our problem to 1D as we need to check only for longest Increasing order wrt
    heights only.
    Ex. after sorting: (1,3), (3,5), (6,8), (6,7), (8,4), (9,5)
    transform to question find LIS: [3,5,8,7,4,5]
    */
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length<2){
            return envelopes.length;
        }

        Arrays.sort(envelopes, (a, b)->
                (a[0] == b[0] )? (b[1]-a[1]) : (a[0]-b[0])
        );

        int[] dp = new int[envelopes.length];
        int size =0;

        for(int[] envelope : envelopes){
            int height = envelope[1];
            int left =0, right = size;
            while(left<right){
                int mid = left +(right -left)/2;
                if(dp[mid]<height){
                    left =  mid +1;
                } else{
                    right = mid;
                }
            }

            // left is the right position to 'replace' in dp array
            dp[left] = height;
            if(left == size)
                size++;
        }
        return size;
    }
}
