package com.greedy;

import java.util.Arrays;

/*
1402. Reducing Dishes

A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.

Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes
multiplied by its satisfaction level i.e. time[i] * satisfaction[i].

Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.

Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.



Example 1:

Input: satisfaction = [-1,-8,0,5,-9]
Output: 14
Explanation: After Removing the second and last dish, the maximum total like-time coefficient will be equal
to (-1*1 + 0*2 + 5*3 = 14).
Each dish is prepared in one unit of time.

TC : o(n^2)
SC: o(1)
 */
public class ReducingDishes {

    public static void main(String[] args) {
        int[] sat = new int[]{-1,-8,0,5,-9};
        System.out.println(new ReducingDishes().maxSatisfaction(sat));
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int maxVal =0;
        for(int i=0;i<satisfaction.length;i++){
            int cook =1;
            int sum =0;

            for(int j=i;j<satisfaction.length;j++){
                sum += satisfaction[j]*cook;
                cook++;
            }

            maxVal = Math.max(maxVal,sum);
        }

        return maxVal;
    }
}
