package com.array;
/*
3635. Earliest Finish Time for Land and Water Rides II

You are given two categories of theme park attractions: land rides and water rides.

Land rides
landStartTime[i] – the earliest time the ith land ride can be boarded.
landDuration[i] – how long the ith land ride lasts.
Water rides
waterStartTime[j] – the earliest time the jth water ride can be boarded.
waterDuration[j] – how long the jth water ride lasts.
A tourist must experience exactly one ride from each category, in either order.

A ride may be started at its opening time or any later moment.
If a ride is started at time t, it finishes at time t + duration.
Immediately after finishing one ride the tourist may board the other (if it is already open) or wait until it opens.
Return the earliest possible time at which the tourist can finish both rides.



Example 1:

Input: landStartTime = [2,8], landDuration = [4,1], waterStartTime = [6], waterDuration = [3]

Output: 9

Explanation:

Plan A (land ride 0 → water ride 0):
Start land ride 0 at time landStartTime[0] = 2. Finish at 2 + landDuration[0] = 6.
Water ride 0 opens at time waterStartTime[0] = 6. Start immediately at 6, finish at 6 + waterDuration[0] = 9.
Plan B (water ride 0 → land ride 1):
Start water ride 0 at time waterStartTime[0] = 6. Finish at 6 + waterDuration[0] = 9.
Land ride 1 opens at landStartTime[1] = 8. Start at time 9, finish at 9 + landDuration[1] = 10.
Plan C (land ride 1 → water ride 0):
Start land ride 1 at time landStartTime[1] = 8. Finish at 8 + landDuration[1] = 9.
Water ride 0 opened at waterStartTime[0] = 6. Start at time 9, finish at 9 + waterDuration[0] = 12.
Plan D (water ride 0 → land ride 0):
Start water ride 0 at time waterStartTime[0] = 6. Finish at 6 + waterDuration[0] = 9.
Land ride 0 opened at landStartTime[0] = 2. Start at time 9, finish at 9 + landDuration[0] = 13.
Plan A gives the earliest finish time of 9.

TC : o(m+n)
SC: o(n)
 */
public class EarliestFinishTimeForLandAndWaterRidesII {

    public static void main(String[] args) {
        System.out.println(new EarliestFinishTimeForLandAndWaterRidesII().earliestFinishTime(
                new int[]{2,8}, new int[]{4,1}, new int[]{6}, new int[]{3}
        ));
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int land_water = solve(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration
        );
        int water_land = solve(
                waterStartTime,
                waterDuration,
                landStartTime,
                landDuration
        );
        return Math.min(land_water, water_land);
    }

    private int solve(
            int[] start1,
            int[] duration1,
            int[] start2,
            int[] duration2
    ) {
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]);
        }
        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            finish2 = Math.min(
                    finish2,
                    Math.max(start2[i], finish1) + duration2[i]
            );
        }
        return finish2;
    }
}
