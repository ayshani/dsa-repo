package com.math;

import java.util.HashSet;
import java.util.Set;

/*
874. Walking Robot Simulation

A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot can receive a sequence of these
three possible types of commands:

-2: Turn left 90 degrees.
-1: Turn right 90 degrees.
1 <= k <= 9: Move forward k units, one unit at a time.
Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot
runs into an obstacle, then it will instead stay in its current location and move on to the next command.

Return the maximum Euclidean distance that the robot ever gets from the origin squared (i.e. if the distance is
5, return 25).

Note:

North means +Y direction.
East means +X direction.
South means -Y direction.
West means -X direction.
There can be obstacle in [0,0].

Example 1:

Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: The robot starts at (0, 0):
1. Move north 4 units to (0, 4).
2. Turn right.
3. Move east 3 units to (3, 4).
The furthest point the robot ever gets from the origin is (3, 4), which squared is 32 + 42 = 25 units away.

TC : o(m + n)
SC: o(n)
 */
public class WalkingRobotSimulation {

    private int HASH = 60001;

    public static void main(String[] args) {
        System.out.println(new WalkingRobotSimulation().robotSim(
                new int[]{4,-1,3}, new int[][]{}
        ));
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obstacleSet = new HashSet<>();
        for(int[] obstacle : obstacles){
            obstacleSet.add(hash(obstacle[0], obstacle[1]));
        }

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        int[] currentPosition = new int[]{0,0};
        int maxDistanceSquared =0;
        int currentDirection =0; // 0: North, 1: East, 2: South, 3: West

        for(int command : commands){
            // turn right
            if(command == -1){
                currentDirection = (currentDirection+1)%4;
                continue;
            }
            // turn left
            if(command == -2){
                currentDirection = (currentDirection+3)%4;
                continue;
            }

            // Move forward
            int[] direction = directions[currentDirection];
            for(int step = 0; step < command; step++){
                int nextX = currentPosition[0] + direction[0];
                int nextY = currentPosition[1] + direction[1];
                if(obstacleSet.contains(hash(nextX, nextY))){
                    break;
                }
                currentPosition[0] = nextX;
                currentPosition[1] = nextY;
            }
            maxDistanceSquared = Math.max(maxDistanceSquared,
                    currentPosition[0] * currentPosition[0] +
                            currentPosition[1] * currentPosition[1]
            );
        }
        return maxDistanceSquared;
    }

    private int hash(int x, int y){
        return x + HASH * y;
    }
}
