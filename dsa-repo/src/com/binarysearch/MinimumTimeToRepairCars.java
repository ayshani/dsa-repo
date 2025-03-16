package com.binarysearch;
/*
2594. Minimum Time to Repair Cars

You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.

You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.

Return the minimum time taken to repair all the cars.

Note: All the mechanics can repair the cars simultaneously.



Example 1:

Input: ranks = [4,2,3,1], cars = 10
Output: 16
Explanation:
- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
It can be proved that the cars cannot be repaired in less than 16 minutes.

TC : o(m*log(n*max_rank))
SC: o(1)
 */
public class MinimumTimeToRepairCars {

    public static void main(String[] args) {
        System.out.println(new MinimumTimeToRepairCars().repairCars(new int[]{4,2,3,1},10));
    }
    public long repairCars(int[] ranks, int cars) {
        // The minimum possible time is 1,
        // and the maximum possible time is when the slowest mechanic (highest rank) repairs all cars.
        long low = 1, high = 1L * ranks[0] * cars * cars;

        // Perform binary search to find the minimum time required.
        while (low < high) {
            long mid = (low + high) / 2, carsRepaired = 0;

            // Calculate the number of cars that can be repaired in 'mid' time by all mechanics.
            for (int rank : ranks) carsRepaired += (long) (Math.sqrt(
                    (1.0 * mid) / rank
            ));

            // If the total cars repaired is less than required, increase the time.
            if (carsRepaired < cars) low = mid + 1;
            else high = mid; // Otherwise, try a smaller time.
        }

        return low;
    }
}
