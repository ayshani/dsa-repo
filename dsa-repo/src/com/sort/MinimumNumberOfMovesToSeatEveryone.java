package com.sort;

import java.util.Arrays;

/*
2037. Minimum Number of Moves to Seat Everyone

There are n seats and n students in a room. You are given an array seats of length n, where seats[i] is the
position of the ith seat. You are also given the array students of length n, where students[j] is the position of
the jth student.

You may perform the following move any number of times:

Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from position x to x + 1
or x - 1)
Return the minimum number of moves required to move each student to a seat such that no two students are in the
same seat.

Note that there may be multiple seats or students in the same position at the beginning.



Example 1:

Input: seats = [3,1,5], students = [2,7,4]
Output: 4
Explanation: The students are moved as follows:
- The first student is moved from from position 2 to position 1 using 1 move.
- The second student is moved from from position 7 to position 5 using 2 moves.
- The third student is moved from from position 4 to position 3 using 1 move.
In total, 1 + 2 + 1 = 4 moves were used.

TC : o(nlogn)
SC: o(1)
 */
public class MinimumNumberOfMovesToSeatEveryone {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfMovesToSeatEveryone().minMovesToSeat(
                new int[]{3,1,5}, new int[]{2,7,4}
        ));
    }
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int minMove =0;
        for(int i=0;i<seats.length;i++){
            minMove += Math.abs(seats[i] - students[i]);
        }

        return minMove;
    }
}
