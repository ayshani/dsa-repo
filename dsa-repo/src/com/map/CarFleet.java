package com.map;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
853. Car Fleet

There are n cars going to the same destination along a one-lane road. The destination is target miles away.

You are given two integer array position and speed, both of length n, where position[i] is the position of the
ith car and speed[i] is the speed of the ith car (in miles per hour).

A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed.
The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored
(i.e., they are assumed to have the same position).

A car fleet is some non-empty set of cars driving at the same position and same speed.
Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
Return the number of car fleets that will arrive at the destination.

Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
Note that no other cars meet these fleets before the destination, so the answer is 3.

Explanation
--------------
Sort cars by the start positions pos
Loop on each car from the end to the beginning
Calculate its time needed to arrive the target
cur records the current biggest time (the slowest)

If another car needs less or equal time than cur,
it can catch up this car fleet.

If another car needs more time,
it will be the new slowest car,
and becomes the new lead of a car fleet.


Complexity:
O(NlogN) Quick sort the cars by position. (Other sort can be applied)
O(N) One pass for all cars from the end to start (another direction also works).

O(N) Space for sorted cars.
O(1) space is possible if we sort pos inplace.
 */
public class CarFleet {

    public static void main(String[] args) {
        int[] pos = new int[]{10,8,0,5,3}, speed =new int[]{2,4,1,1,3};

        System.out.println(new CarFleet().carFleet(12,pos,speed));
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());

        for(int i=0;i<position.length;i++){
            map.put(position[i], (double) (target - position[i])/speed[i]);
        }

        int res=0;
        double currentTime = 0;

        for(double time : map.values()){
            if(currentTime< time){
                currentTime =time ;
                res++;
            }
        }

        return res;
    }
}
