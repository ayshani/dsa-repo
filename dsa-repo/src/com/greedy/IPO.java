package com.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
502. IPO

Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources,
it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize
its total capital after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of
capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit
will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final capital, and return
the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.

Example 1:

Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.

Algorithm
------------
Sort the projects by increasing capital. Keep a pointer ptr to the first unavailable project in the sorted array.
Maintain a priority queue for the profits of available projects. Initially, the priority queue is empty.
Do the following kkk times:
Add to the priority queue the profits of the newly available projects.
    We move the pointer through the sorted array when new projects become available.
If the priority queue is empty, terminate the algorithm.
The maximum value in the priority queue is the profit of the project we will start now.
    Increase our capital by this value. Delete it so since we can not use it anymore.

Complexity Analysis
Let nnn be the number of projects.

Time complexity: O(nlogn). Sorting the projects by increasing capital takes O(nlogn) time. Also,
we perform O(n) operations with the priority queue, each in O(logn).

Space complexity: O(n). The sorted array of projects and the priority queue take linear space.
 */
public class IPO {

    public static void main(String[] args) {
        int[] p = new int[]{1,2,3}, w = new int[]{0,1,1};
        System.out.println(new IPO().findMaximizedCapital(2,0,p,w));
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for(int i=0;i<n;i++){
            projects[i] = new Project(capital[i], profits[i]);
        }

        Arrays.sort(projects);

        // PriorityQueue is a min heap, but we need a max heap, so we use
        // Collections.reverseOrder()
        PriorityQueue<Integer> q = new PriorityQueue<>(n, Collections.reverseOrder());
        int ptr =0;

        for(int i=0;i<k;i++){
            while(ptr<n && projects[ptr].capacity<=w){
                q.add(projects[ptr++].profit);
            }

            if(q.isEmpty())
            {
                break;
            }

            w+= q.poll();
        }
        return w;

    }
}

class Project implements Comparable<Project>{
    int capacity, profit;

    public Project(int capacity, int profit){
        this.capacity = capacity;
        this.profit = profit;
    }

    public int compareTo(Project cur){
        return this.capacity - cur.capacity;
    }
}
