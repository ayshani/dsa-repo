package com.bit.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
1386. Cinema Seat Allocation

A cinema has n rows of seats, numbered from 1 to n. Each row has 10 seats, numbered from 1 to 10.

You are given a 2D integer array reservedSeats, where reservedSeats[i] = [rowi, seati] means that seat seati in row rowi is already reserved.

A four-person group must be assigned to four seats in the same row. The group can be seated in one of the following seat blocks:

seats 2, 3, 4, 5
seats 4, 5, 6, 7
seats 6, 7, 8, 9
A block can be used only if none of its seats are reserved. Each seat can be assigned to at most one group.

Return an integer denoting the maximum number of four-person groups that can be assigned.



Example 1:



Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
Output: 4
Explanation: The figure above shows an optimal allocation of four groups. Seats marked in blue are already reserved, and each set of four contiguous seats marked in orange is assigned to one group.
Example 2:

Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
Output: 2

TC : o(r)
SC: o(r)
 */
public class CinemaSeatAllocation {

    public static void main(String[] args) {
        System.out.println(new CinemaSeatAllocation().maxNumberOfFamilies(3,
                new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}));
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int left = 0b11110000;
        int middle = 0b11000011;
        int right = 0b00001111;

        Map<Integer, Integer> occupied = new HashMap<Integer, Integer>();
        for (int[] seat : reservedSeats) {
            if (seat[1] >= 2 && seat[1] <= 9) {
                int origin = occupied.containsKey(seat[0])
                        ? occupied.get(seat[0])
                        : 0;
                int value = origin | (1 << (seat[1] - 2));
                occupied.put(seat[0], value);
            }
        }

        int ans = (n - occupied.size()) * 2;
        for (Map.Entry<Integer, Integer> entry : occupied.entrySet()) {
            int row = entry.getKey(),
                    bitmask = entry.getValue();
            if (
                    (bitmask | left) == left ||
                            (bitmask | middle) == middle ||
                            (bitmask | right) == right
            ) {
                ++ans;
            }
        }
        return ans;
    }
}
