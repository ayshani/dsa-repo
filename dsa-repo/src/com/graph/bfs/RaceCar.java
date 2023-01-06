package com.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
818. Race Car

Your car starts at position 0 and speed +1 on an infinite number line.
Your car can go into negative positions. Your car drives automatically according to a
sequence of instructions 'A' (accelerate) and 'R' (reverse):

When you get an instruction 'A', your car does the following:
position += speed
speed *= 2
When you get an instruction 'R', your car does the following:
If your speed is positive then speed = -1
otherwise speed = 1
Your position stays the same.
For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3,
and your speed goes to 1 --> 2 --> 4 --> -1.

Given a target position target, return the length of the shortest sequence of instructions to get there.



Example 1:

Input: target = 3
Output: 2
Explanation:
The shortest instruction sequence is "AA".
Your position goes from 0 --> 1 --> 3.

TC : o(logt)
SC : o(logt)

This is because for acceleration, we are doubling the speed, so the time space gets shortened by 2.
 */
public class RaceCar {

    public static void main(String[] args) {
        System.out.println(new RaceCar().racecar(6));
    }
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        //{move,position,speed}
        queue.offer(new int[]{0,0,1});

        Set<String> visited = new HashSet<>();
        // combination od position and speed i.e. 0_1 i.e. position_speed
        //visited.add("0_1");

        while(!queue.isEmpty()){
            // poll all current move details
            int[] current = queue.poll();
            int move = current[0], position = current[1], speed = current[2];

            // if we reach the target position, then return the moves
            if(position==target)
                return move;

            // String of position+"_"+speed for visit set
            String key = position+"_"+speed;

            // check if we have already visited the same combination of position and speed
            if(visited.contains(key))
                continue;
            else{
                // add the key in visited set
                visited.add(key);
                // this depicts A as per question
                queue.offer(new int[]{move+1,position+speed,speed*2});

                /* There are two edge scenario
                     1. If we are acccelarating and we will be at the next position where
                        it will exceed target position, then in that case we need to make
                        reverse move
                     2. If the speed is <0 i.e. we are going to left / opposite direction
                        than target posiiton, and we will nt be in target poisition
                        then we need to accelarate again.
                */
                if(((position+speed> target) && speed>0) || ((position + speed< target) && speed<0)){
                    speed = speed> 0 ? -1:1;

                    queue.offer(new int[]{move+1,position,speed});
                }
            }


        }

        return -1;
    }
}
