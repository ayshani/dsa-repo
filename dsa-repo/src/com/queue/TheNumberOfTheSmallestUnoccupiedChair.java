package com.queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/*
1942. The Number of the Smallest Unoccupied Chair

There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.



Example 1:

Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
Output: 1
Explanation:
- Friend 0 arrives at time 1 and sits on chair 0.
- Friend 1 arrives at time 2 and sits on chair 1.
- Friend 1 leaves at time 3 and chair 1 becomes empty.
- Friend 0 leaves at time 4 and chair 0 becomes empty.
- Friend 2 arrives at time 4 and sits on chair 0.
Since friend 1 sat on chair 1, we return 1.

TC : o(n)
SC: o(n)
 */
public class TheNumberOfTheSmallestUnoccupiedChair {

    public static void main(String[] args) {
        System.out.println(new TheNumberOfTheSmallestUnoccupiedChair().smallestChair(
                new int[][]{
                        {1,4},{2,3},{4,6}
                }, 1
        ));
    }
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        int nextChair = 0;
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        TreeSet<Integer> availableChairs = new TreeSet<>();

        for (int[] time : times) {
            int arrival = time[0];
            int leave = time[1];

            // Free up chairs based on current time
            while (
                    !leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival
            ) {
                availableChairs.add(leavingQueue.poll()[1]);
            }

            int currentChair;
            // Assign chair from available set or increment new chair
            if (!availableChairs.isEmpty()) {
                currentChair = availableChairs.first();
                availableChairs.remove(currentChair);
            } else {
                currentChair = nextChair++;
            }

            // Push current leave time and chair
            leavingQueue.offer(new int[] { leave, currentChair });

            // Check if it's the target friend
            if (arrival == targetArrival) return currentChair;
        }

        return 0;
    }
}
