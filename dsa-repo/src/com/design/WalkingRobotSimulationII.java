package com.design;

import java.util.*;

/*
2069. Walking Robot Simulation II

A width x height grid is on an XY-plane with the bottom-left cell at (0, 0) and the top-right cell at (width - 1, height - 1). The grid is aligned with the four cardinal directions ("North", "East", "South", and "West"). A robot is initially at cell (0, 0) facing direction "East".

The robot can be instructed to move for a specific number of steps. For each step, it does the following.

Attempts to move forward one cell in the direction it is facing.
If the cell the robot is moving to is out of bounds, the robot instead turns 90 degrees counterclockwise and retries the step.
After the robot finishes moving the number of steps required, it stops and awaits the next instruction.

Implement the Robot class:

Robot(int width, int height) Initializes the width x height grid with the robot at (0, 0) facing "East".
void step(int num) Instructs the robot to move forward num steps.
int[] getPos() Returns the current cell the robot is at, as an array of length 2, [x, y].
String getDir() Returns the current direction of the robot, "North", "East", "South", or "West".

Example 1:
Input
["Robot", "step", "step", "getPos", "getDir", "step", "step", "step", "getPos", "getDir"]
[[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
Output
[null, null, null, [4, 0], "East", null, null, null, [1, 2], "West"]

Explanation
Robot robot = new Robot(6, 3); // Initialize the grid and the robot at (0, 0) facing East.
robot.step(2);  // It moves two steps East to (2, 0), and faces East.
robot.step(2);  // It moves two steps East to (4, 0), and faces East.
robot.getPos(); // return [4, 0]
robot.getDir(); // return "East"
robot.step(2);  // It moves one step East to (5, 0), and faces East.
                // Moving the next step East would be out of bounds, so it turns and faces North.
                // Then, it moves one step North to (5, 1), and faces North.
robot.step(1);  // It moves one step North to (5, 2), and faces North (not West).
robot.step(4);  // Moving the next step North would be out of bounds, so it turns and faces West.
                // Then, it moves four steps West to (1, 2), and faces West.
robot.getPos(); // return [1, 2]
robot.getDir(); // return "West"

TC :
 */
public class WalkingRobotSimulationII {

    public static void main(String[] args) {
        Robot robot = new Robot(6, 3); // Initialize the grid and the robot at (0, 0) facing East.
        robot.step(2);  // It moves two steps East to (2, 0), and faces East.
        robot.step(2);  // It moves two steps East to (4, 0), and faces East

        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());

        robot.step(2);  // It moves one step East to (5, 0), and faces East.
        // Moving the next step East would be out of bounds, so it turns and faces North.
        // Then, it moves one step North to (5, 1), and faces North.
        robot.step(1);  // It moves one step North to (5, 2), and faces North (not West).
        robot.step(4);  // Moving the next step North would be out of bounds, so it turns and faces West.
        // Then, it moves four steps West to (1, 2), and faces West.

        System.out.println(Arrays.toString(robot.getPos()));
        System.out.println(robot.getDir());
    }
}

class Robot {

    private boolean moved = false;
    private int idx = 0;
    private List<int[]> pos = new ArrayList<>();
    private List<Integer> dir = new ArrayList<>();
    private Map<Integer, String> toDir = new HashMap<>();

    public Robot(int width, int height) {
        toDir.put(0, "East");
        toDir.put(1, "North");
        toDir.put(2, "West");
        toDir.put(3, "South");

        for (int i = 0; i < width; ++i) {
            pos.add(new int[] { i, 0 });
            dir.add(0);
        }
        for (int i = 1; i < height; ++i) {
            pos.add(new int[] { width - 1, i });
            dir.add(1);
        }
        for (int i = width - 2; i >= 0; --i) {
            pos.add(new int[] { i, height - 1 });
            dir.add(2);
        }
        for (int i = height - 2; i > 0; --i) {
            pos.add(new int[] { 0, i });
            dir.add(3);
        }
        dir.set(0, 3);
    }

    public void step(int num) {
        moved = true;
        idx = (idx + num) % pos.size();
    }

    public int[] getPos() {
        return pos.get(idx);
    }

    public String getDir() {
        if (!moved) {
            return "East";
        }
        return toDir.get(dir.get(idx));
    }
}
