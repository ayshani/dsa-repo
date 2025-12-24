package com.greedy;

import java.util.Arrays;

/*
3074. Apple Redistribution into Boxes

You are given an array apple of size n and an array capacity of size m.

There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.

Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.

Note that, apples from the same pack can be distributed into different boxes.



Example 1:

Input: apple = [1,3,2], capacity = [4,3,1,5,2]
Output: 2
Explanation: We will use boxes with capacities 4 and 5.
It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.

TC : o(nlogn)
SC: o(1)
 */
public class AppleRedistributionIntoBoxes {

    public static void main(String[] args) {
        System.out.println(new AppleRedistributionIntoBoxes().minimumBoxes(
                new int[]{1,3,2}, new int[]{4,3,1,5,2}
        ));
    }
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples =0;
        for(int app : apple){
            totalApples += app;
        }

        int m = capacity.length, j =m-1, count=0;
        Arrays.sort(capacity);
        while(totalApples>0 && j>=0){
            totalApples -= capacity[j--];
            count++;
        }
        return count;
    }
}
