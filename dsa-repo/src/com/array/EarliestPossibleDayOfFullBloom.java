package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
2136. Earliest Possible Day of Full Bloom

You have n flower seeds. Every seed must be planted first before it can begin to grow, then bloom.
Planting a seed takes time and so does the growth of a seed. You are given two 0-indexed integer arrays
plantTime and growTime, of length n each:

plantTime[i] is the number of full days it takes you to plant the ith seed. Every day, you can work on
planting exactly one seed. You do not have to work on planting the same seed on consecutive days, but the
planting of a seed is not complete until you have worked plantTime[i] days on planting it in total.
growTime[i] is the number of full days it takes the ith seed to grow after being completely planted. After
the last day of its growth, the flower blooms and stays bloomed forever.
From the beginning of day 0, you can plant the seeds in any order.

Return the earliest possible day where all seeds are blooming.

Example 1:
Input: plantTime = [1,4,3], growTime = [2,3,1]
Output: 9
Explanation: The grayed out pots represent planting days, colored pots represent growing days,
and the flower represents the day it blooms.
One optimal way is:
On day 0, plant the 0th seed. The seed grows for 2 full days and blooms on day 3.
On days 1, 2, 3, and 4, plant the 1st seed. The seed grows for 3 full days and blooms on day 8.
On days 5, 6, and 7, plant the 2nd seed. The seed grows for 1 full day and blooms on day 9.
Thus, on day 9, all the seeds are blooming.

Algorithm
-----------
Sort the seeds by descending growth time. Plant the seeds in this order.
For each, find the day it blooms and update the answer.


Complexity Analysis
Let n denote the number of seeds.

Time complexity: O(nlogn).

We sort the seeds with O(nlogn) time and iterate it with O(n) time.

Space complexity: O(n).

We use O(n) memory for indices and sorting.

 */
public class EarliestPossibleDayOfFullBloom {

    public static void main(String[] args) {
        int[] plantTime = new int[]{1,2,3,2}, growTime = new int[]{2,1,2,1};

        System.out.println(new EarliestPossibleDayOfFullBloom().earliestFullBloom(plantTime,growTime));
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = growTime.length;
        List<Integer> indices = new ArrayList<>();
        for(int i=0;i<n;i++){
            indices.add(i);
        }

        Collections.sort(indices, Comparator.comparingInt(i-> -growTime[i]));

        int result =0;

        for(int i=0, currentPlantTime =0; i<n;i++){
            int index = indices.get(i);
            int time = currentPlantTime + plantTime[index] + growTime[index];

            result = Math.max(result,time);

            currentPlantTime+=plantTime[index];
        }

        return result;
    }
}
