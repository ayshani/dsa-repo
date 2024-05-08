package com.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
506. Relative Ranks

You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place
athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's
rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.



Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].

TC : o(nlogn)
SC: o(n)
 */
public class RelativeRanks {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RelativeRanks().findRelativeRanks(
                new int[]{5,4,3,2,1}
        )));
    }
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i=0;i<n;i++){
            indexMap.put(score[i], i);
        }

        Arrays.sort(score);

        for(int i=0;i<n;i++){
            if(i==0){
                result[indexMap.get(score[n-1-i])] = "Gold Medal";
            } else if(i==1){
                result[indexMap.get(score[n-1-i])] = "Silver Medal";
            } else if(i==2){
                result[indexMap.get(score[n-1-i])] = "Bronze Medal";
            } else{
                result[indexMap.get(score[n-1-i])] = String.valueOf(i+1);
            }
        }
        return result;
    }
}
