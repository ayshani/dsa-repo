package com.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
1882. Process Tasks Using Servers

You are given two 0-indexed integer arrays servers and tasks of lengths n and m respectively. servers[i] is the weight
of the ith server, and tasks[j] is the time needed to process the jth task in seconds.

Tasks are assigned to the servers using a task queue. Initially, all servers are free, and the queue is empty.

At second j, the jth task is inserted into the queue (starting with the 0th task being inserted at second 0).
As long as there are free servers and the queue is not empty, the task in the front of the queue will be assigned to
a free server with the smallest weight, and in case of a tie, it is assigned to a free server with the smallest index.

If there are no free servers and the queue is not empty, we wait until a server becomes free and immediately assign
the next task. If multiple servers become free at the same time, then multiple tasks from the queue will be assigned
in order of insertion following the weight and index priorities above.

A server that is assigned task j at second t will be free again at second t + tasks[j].

Build an array ansof length m, where ans[j] is the index of the server the jth task will be assigned to.

Return the array ans.



Example 1:

Input: servers = [3,3,2], tasks = [1,2,3,2,1,2]
Output: [2,2,0,2,1,2]
Explanation: Events in chronological order go as follows:
- At second 0, task 0 is added and processed using server 2 until second 1.
- At second 1, server 2 becomes free. Task 1 is added and processed using server 2 until second 3.
- At second 2, task 2 is added and processed using server 0 until second 5.
- At second 3, server 2 becomes free. Task 3 is added and processed using server 2 until second 5.
- At second 4, task 4 is added and processed using server 1 until second 5.
- At second 5, all servers become free. Task 5 is added and processed using server 2 until second 7.

Time complexity: O((m+n)logm) or O(m+nlogm).

Putting all servers into idle takes O(mlogm) or O(m) time, depending on the API used.

Iterating through the tasks takes O(n) time. Each task is assigned exactly one server. This assignment moves the server
 from idle to busy, and at some future time, when the task finishes, the server moves back from busy to idle. Therefore,
  each task incurs O(1) amortized priority queue operations. Since each priority queue operation takes O(logm) time,
  processing all tasks takes O(nlogm) time, leading to a total time complexity of O((m+n)logm) (or O(m+nlogm) if a
  linear-time heapify is supported).

Space complexity: O(m).

This is the space required by the priority queues busy and idle (excluding the O(n) space for the return array).
 */
public class ProcessTasksUsingServers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProcessTasksUsingServers().assignTasks(
                new int[]{3,3,2}, new int[]{1,2,3,2,1,2}
        )));
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        // Busy servers, stored as pairs (t, idx)
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Idle servers, stored as pairs (w, idx)
        PriorityQueue<int[]> idle = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < servers.length; i++) {
            idle.offer(new int[] { servers[i], i });
        }

        int ts = 0;
        int[] ans = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            ts = Math.max(ts, i);
            release(busy, idle, servers, ts);
            if (idle.isEmpty()) {
                ts = busy.peek()[0];
                release(busy, idle, servers, ts);
            }

            int[] server = idle.poll();
            int idx = server[1];
            ans[i] = idx;
            busy.offer(new int[] { ts + tasks[i], idx });
        }

        return ans;
    }

    // Move servers with t<=ts from priority queue busy to priority queue idle one by one
    private void release(
            PriorityQueue<int[]> busy,
            PriorityQueue<int[]> idle,
            int[] servers,
            int ts
    ) {
        while (!busy.isEmpty() && busy.peek()[0] <= ts) {
            int[] server = busy.poll();
            int idx = server[1];
            idle.offer(new int[] { servers[idx], idx });
        }
    }
}
