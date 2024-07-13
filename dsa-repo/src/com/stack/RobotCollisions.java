package com.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
2751. Robot Collisions

There are n 1-indexed robots, each having a position on a line, health, and movement direction.

You are given 0-indexed integer arrays positions, healths, and a string directions (directions[i] is either 'L' for
left or 'R' for right). All integers in positions are unique.

All robots start moving on the line simultaneously at the same speed in their given directions. If two robots ever
share the same position while moving, they will collide.

If two robots collide, the robot with lower health is removed from the line, and the health of the other robot
decreases by one. The surviving robot continues in the same direction it was going. If both robots have the same
health, they are both removed from the line.

Your task is to determine the health of the robots that survive the collisions, in the same order that the robots
were given, i.e. final heath of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there
are no survivors, return an empty array.

Return an array containing the health of the remaining robots (in the order they were given in the input), after no
further collisions can occur.

Note: The positions may be unsorted.

Example 1:
Input: positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
Output: [2,17,9,15,10]
Explanation: No collision occurs in this example, since all robots are moving in the same direction. So,
the health of the robots in order from the first robot is returned, [2, 17, 9, 15, 10].

TC : o(nlogn)
SC: o(n)
 */
public class RobotCollisions {

    public static void main(String[] args) {
        System.out.println(new RobotCollisions().survivedRobotsHealths(
              new int[]{5,4,3,2,1}, new int[]{2,17,9,15,10},   "RRRRR"
        ));
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> index = new ArrayList<>();
        for(int i=0;i<n;i++){
            index.add(i);
        }

        index.sort((a,b)->positions[a] - positions[b] );
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i : index){
            if(directions.charAt(i)=='R'){
                dq.push(i);
                continue;
            }
            while(!dq.isEmpty() && healths[i]>0){
                if(healths[dq.peek()]< healths[i]){
                    healths[dq.pop()] = 0;
                    healths[i] -= 1;
                } else if(healths[dq.peek()]> healths[i]){
                    healths[dq.peek()] -= 1;
                    healths[i] = 0;
                } else{
                    healths[dq.pop()] = 0;
                    healths[i] = 0;
                }
            }

        }
        List<Integer> res = new ArrayList<>();
        for(int val : healths){
            if(val >0){
                res.add(val);
            }
        }
        return res;
    }
}
