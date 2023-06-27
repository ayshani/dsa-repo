package com.dp.knapsack;
/*
Minimum Number of Refueling Stops

You need to find the minimum number of refueling stops that a car needs to make to cover a distance, target. For
simplicity, assume that the car has to travel from west to east in a straight line. There are various fuel stations
on the way, that are represented as a 2-D array of stations, i.e.
station[i] = [di,fi]
di  is the distance in miles of the ith gas station from the starting position, and fi s the amount of fuel in liters
that it stores. Initially, the car starts with k liters of fuel. The car consumes one liter of fuel for every
mile traveled. Upon reaching a gas station, the car can stop and refuel using all the petrol stored at the station.
In case it cannot reach the target, the program simply returns −1.

Note: If the car reaches a station with 0 fuel left, it can refuel from that station, and all the fuel from that
station can be transferred to the car. If the car reaches the target with 0 fuel left, it is still considered to
have arrived.

For example:
target: 15
start fuel: 2
stations: [[1,2],[2,8],[4,10],[6,7],[7,2],[8,1]]

If we want to reach the target of 15 miles, we have to refuel from a minimum of 2
stations to reach the target. First, we will refuel our car with 8 liters from the second station and then refuel
10 liters from the third station.


 */
public class MinimumNumberOfRefuelingStops {

    public static void main(String[] args) {
        int[][] stations = new int[][]{
                {1,2},{2,8},{4,10},{6,7},{7,2},{8,1}
        };
        System.out.println(new MinimumNumberOfRefuelingStops().minRefuelStops(15,2,stations));
    }
    public  int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Write your code here
//TODO
        // your code will replace the placeholder return statement below
        return -1;
    }
}
