package com.sort;

import java.util.Arrays;

/*
621. Task Scheduler

You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or
interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint:
identical tasks must be separated by at least n intervals due to cooling time.

​Return the minimum number of intervals required to complete all tasks.



Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd
interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.

TC : o(n)
SC : o(1)
 */
public class TaskScheduler {

    public static void main(String[] args) {
        System.out.println(new TaskScheduler()
                .leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }
    public int leastInterval(char[] tasks, int n) {
        // Create a frequency array to keep track of the count of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Sort the frequency array in non-decreasing order
        Arrays.sort(freq);

        // Calculate the maximum frequency of any task
        int maxFreq = freq[25] - 1;
        // Calculate the number of idle slots that will be required
        int idleSlots = maxFreq * n;

        // Iterate over the frequency array from the second-highest frequency to the lowest frequency
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            // Subtract the minimum of the maximum frequency and the current frequency from the idle slots
            idleSlots -= Math.min(maxFreq, freq[i]);
        }

        // If there are any idle slots left, add them to the total number of tasks
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
