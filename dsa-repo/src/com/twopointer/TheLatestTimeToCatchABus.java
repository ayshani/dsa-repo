package com.twopointer;

import java.util.Arrays;

/*
2332. The Latest Time to Catch a Bus

You are given a 0-indexed integer array buses of length n, where buses[i] represents the departure time of the ith bus.
You are also given a 0-indexed integer array passengers of length m, where passengers[j] represents the arrival time
of the jth passenger. All bus departure times are unique. All passenger arrival times are unique.

You are given an integer capacity, which represents the maximum number of passengers that can get on each bus.

When a passenger arrives, they will wait in line for the next available bus. You can get on a bus that departs
at x minutes if you arrive at y minutes where y <= x, and the bus is not full. Passengers with the earliest arrival
times get on the bus first.

More formally when a bus arrives, either:

If capacity or fewer passengers are waiting for a bus, they will all get on the bus, or
The capacity passengers with the earliest arrival times will get on the bus.
Return the latest time you may arrive at the bus station to catch a bus. You cannot arrive at the
same time as another passenger.

Note: The arrays buses and passengers are not necessarily sorted.

Example 1:

Input: buses = [10,20], passengers = [2,17,18,19], capacity = 2
Output: 16
Explanation: Suppose you arrive at time 16.
At time 10, the first bus departs with the 0th passenger.
At time 20, the second bus departs with you and the 1st passenger.
Note that you may not arrive at the same time as another passenger,
which is why you must arrive before the 1st passenger to catch the bus.

TC : o(nlogn)
SC : o(1)
 */
public class TheLatestTimeToCatchABus {

    public static void main(String[] args) {
        int[] buses = new int[]{20,30,10}, passengers= new int[]{19,13,26,4,25,11,21};
        int capacity =2;
        System.out.println(new TheLatestTimeToCatchABus().latestTimeCatchTheBus(buses,passengers,capacity));
    }
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        if(passengers[0]>buses[buses.length-1])
            return buses[buses.length-1];

        int result = passengers[0]-1;
        int busIndex =0, passIndex =0;

        while(busIndex< buses.length){
            int occupiedSeats =0;
            while(occupiedSeats< capacity && passIndex< passengers.length && passengers[passIndex]<=buses[busIndex] ){
                if(passIndex>0 && passengers[passIndex]- passengers[passIndex-1]!=1)
                    result = passengers[passIndex]-1;
                passIndex++;
                occupiedSeats++;
            }

            if(passIndex>0 && occupiedSeats< capacity && buses[busIndex]!= passengers[passIndex-1])
                result = buses[busIndex];

            busIndex++;
        }

        return result;
    }
}
