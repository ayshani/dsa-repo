package com.map;

import java.util.HashMap;
import java.util.Map;

/*
2244. Minimum Rounds to Complete All Tasks

You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task.
In each round, you can complete either 2 or 3 tasks of the same difficulty level.

Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.



Example 1:

Input: tasks = [2,2,3,3,2,4,4,4,4,4]
Output: 4
Explanation: To complete all the tasks, a possible plan is:
- In the first round, you complete 3 tasks of difficulty level 2.
- In the second round, you complete 2 tasks of difficulty level 3.
- In the third round, you complete 3 tasks of difficulty level 4.
- In the fourth round, you complete 2 tasks of difficulty level 4.
It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.

TC : o(n)
SC : o(Number of Unique task)
 */
public class MinimumRoundsToCompleteAllTasks {

    public static void main(String[] args) {
        int[] tasks = new int[]{2,2,3,3,2,4,4,4,4,4};
        System.out.println(new MinimumRoundsToCompleteAllTasks().minimumRounds(tasks));
    }
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        // Store the frequencies in the map.
        for(int num : tasks){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int minRound=0;
        // Iterate over the task's frequencies.
        for(int count : map.values()){
            // If the frequency is 1, it's not possible to complete tasks.
            if(count==1)
                return -1;

            if(count%3==0){
                // Group all the task in triplets.
                minRound+= count/3;
            } else{
                // If count % 3 = 1; (count / 3 - 1) groups of triplets and 2 pairs.
                // If count % 3 = 2; (count / 3) groups of triplets and 1 pair.
                minRound += count/3 +1;
            }
        }

        return minRound;
    }
}
