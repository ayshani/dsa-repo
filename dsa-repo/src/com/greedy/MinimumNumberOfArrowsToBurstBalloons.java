package com.greedy;

import java.util.Arrays;

/*
452. Minimum Number of Arrows to Burst Balloons

There are some spherical balloons taped onto a flat wall that represents the XY-plane.
The balloons are represented as a 2D integer array points where points[i] = [xstart, xend]
denotes a balloon whose horizontal diameter stretches between xstart and xend.
You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely,
bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

TC : o(nlogn)
SC : o(logn) == Quicksort requires o(logn) space for sorting in java
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {10,16},{2,8},{1,6},{7,12}
        };
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length==0)
            return 0;

        // Sort wrt increasing end time
        Arrays.sort(points, (a, b)->{
            // We put these whole as there is a possibility that the numbers become quite large
            // and can cause overflow
                    if(a[1]==b[1])
                        return 0;
                    else if(a[1]<b[1])
                        return -1;
                    else
                        return 1;
                }
        );

        int count =1, start =0, end =0, firstEnd = points[0][1];

        for(int[] point : points){
            // Incase the previous End is less than the current Start
            // We need another arrow i.e. count++;
            if(firstEnd < point[0]){
                count++;
                firstEnd = point[1];
            }
        }

        return count;
    }
}
