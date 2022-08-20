package com.heap.max;

import java.util.Collections;
import java.util.PriorityQueue;

/*
871. Minimum Number of Refueling Stops

A car travels from a starting position to a destination which is target miles east of the starting position.

There are gas stations along the way. The gas stations are represented as an array stations where
stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the
starting position and has fueli liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
It uses one liter of gas per one mile that it drives. When the car reaches a gas station,
it may stop and refuel, transferring all the gas from the station into the car.

Return the minimum number of refueling stops the car must make in order to reach its destination.
If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

Example 1:

Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.

Example 2:

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.

Logic
-----
"index" is the index of next stops to refuel.
result is the times that we have refeuled.
pq is a priority queue that we store all available gas.

We initial result = 0 and in every loop:

We add all reachable stop to priority queue.
We pop out the largest gas from pq and refeul once.
If we can't refuel, means that we can not go forward and return -1

TC : o(nlogn)
SC : o(n)
 */
public class MinimumNumberOfRefuelingStops {

    public static void main(String[] args) {
        int target = 100, start =10;
        int[][] station = new int[][]{
                {10,60},{20,30},{30,30},{60,40}
        };

        System.out.println(new MinimumNumberOfRefuelingStops().minRefuelStops(target,start,station));
    }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int result =0, index =0;
        for(result =0;startFuel<target;result++){
            while(index<stations.length && stations[index][0]<=startFuel){
                pq.offer(stations[index++][1]);
            }

            if(pq.isEmpty())
                return -1;

            startFuel+=pq.poll();
        }

        return result;
    }
}
