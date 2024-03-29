package com.map;

import java.util.TreeMap;
import java.util.TreeSet;

/*
2432. The Employee That Worked on the Longest Task

here are n employees, each with a unique id from 0 to n - 1.

You are given a 2D integer array logs where logs[i] = [idi, leaveTimei] where:

idi is the id of the employee that worked on the ith task, and
leaveTimei is the time at which the employee finished the ith task. All the values leaveTimei are unique.
Note that the ith task starts the moment right after the (i - 1)th task ends, and the 0th task starts at time 0.

Return the id of the employee that worked the task with the longest time.
If there is a tie between two or more employees, return the smallest id among them.



Example 1:

Input: n = 10, logs = [[0,3],[2,5],[0,9],[1,15]]
Output: 1
Explanation:
Task 0 started at 0 and ended at 3 with 3 units of times.
Task 1 started at 3 and ended at 5 with 2 units of times.
Task 2 started at 5 and ended at 9 with 4 units of times.
Task 3 started at 9 and ended at 15 with 6 units of times.
The task with the longest time is task 3 and the employee with id 1 is the one that worked on it, so we return 1.

TC : o(logn*logn)
SC : o(n)
 */
public class TheEmployeeThatWorkedOnTheLongestTask {

    public static void main(String[] args) {
        int[][] logs = new int[][]{
                {1,1},{3,7},{2,12},{7,17}
        };
        System.out.println(new TheEmployeeThatWorkedOnTheLongestTask().hardestWorker(26,logs));
    }
    public int hardestWorker(int n, int[][] logs) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();


        for(int i=0;i<logs.length;i++){
            int time =0;
            time = i==0? logs[i][1] : logs[i][1] - logs[i-1][1];
            map.putIfAbsent(time,new TreeSet<>());
            map.get(time).add(logs[i][0]);
        }

        return map.get(map.lastKey()).first();
    }



}
