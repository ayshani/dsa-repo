package com.heap.min;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
1383. Maximum Performance of a Team

You are given two integers n and k and two integer arrays speed and efficiency both of length n.
There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the
ith engineer respectively.

Choose at most k different engineers out of the n engineers to form a team with the maximum performance.

The performance of a team is the sum of their engineers' speeds multiplied by the minimum
efficiency among their engineers.

Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.

Example 1:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
Output: 60
Explanation:
We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4)
and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.

Intuition
Doesn't efficiency and speed are the same thing?
Like efficiency = speed = produce / time?
Speed sounds more like time actually.
You work slow, so you need more time.

We keep the queue with maximum size of k.
Each time when we introduce a new engineer,
we need only O(logK) to find the smallest speed in the team now.


Complexity
Time O(NlogN) for sorting
Time O(NlogK) for priority queue
Space O(N)
 */
public class MaximumPerformanceOfATeam {

    public static void main(String[] args) {
        int speed[] = new int[]{2,10,3,1,5,8}, efficiency[]= new int[]{5,4,3,9,7,2}, k = 2;
        System.out.println(new MaximumPerformanceOfATeam().maxPerformance(speed.length,speed,efficiency,k));
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] ess = new int[n][2];
        for(int i=0;i<n;i++){
            ess[i]= new int[]{efficiency[i],speed[i]};
        }

        // Maximum efficiency first
        Arrays.sort(ess, (a, b)-> b[0]-a[0]);

        //min heap of speed
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(a, b) -> a-b);
        long result =0, SumOfSpeed =0;
        for(int[] es : ess){
            pq.offer(es[1]);
            SumOfSpeed+= es[1];
            if(pq.size()>k)
                SumOfSpeed-=pq.poll();

            result = Math.max(result, SumOfSpeed*es[0]);
        }

        return (int)(result%(long)(1e9+7));
    }
}
