package com.binarysearch;
/*
1482. Minimum Number of Days to Make m Bouquets

You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly
one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is
impossible to make m bouquets return -1.



Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did
not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

TC : o(nlogD ) - D being max value in array
SC : o(1)
 */
public class MinimumNumberOfDaysToMakemBouquets {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfDaysToMakemBouquets().minDays(
                new int[]{1,10,3,10,2}, 3,1
        ));
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n<(m*k)){
            return -1;
        }

        int start =0, end =0;
        for(int day : bloomDay){
            end = Math.max(day, end);
        }

        int minDays =-1;
        while(start<= end){
            int mid = (start + end)/2;
            if(getNumOfBouquets(bloomDay, mid, k) >= m){
                minDays = mid;
                end = mid -1;
            } else{
                start = mid + 1;
            }
        }
        return minDays;
    }

    private int getNumOfBouquets(int[] bloomDay, int mid,int k){
        int numOfBouquet =0, count =0;
        for(int i=0;i<bloomDay.length; i++){
            if(bloomDay[i]<= mid){
                count++;
            } else{
                count = 0;
            }
            if(count ==k){
                numOfBouquet++;
                count = 0;
            }
        }
        return numOfBouquet;
    }
}
