package com.heap.max;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
857. Minimum Cost to Hire K Workers

There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the
ith worker and wage[i] is the minimum wage expectation for the ith worker.

We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according
to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid
group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions.
Answers within 10-5 of the actual answer will be accepted.

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], k = 2
Output: 105.00000
Explanation: We pay 70 to 0th worker and 35 to 2nd worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
Output: 30.66667
Explanation: We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.

Logic
--------
Let's read description first and figure out the two rules:

"1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the
paid group."
So for any two workers in the paid group,
we have wage[i] : wage[j] = quality[i] : quality[j]
So we have wage[i] : quality[i] = wage[j] : quality[j]
We pay wage to every worker in the group with the same ratio compared to his own quality.

"2. Every worker in the paid group must be paid at least their minimum wage expectation."
For every worker, he has an expected ratio of wage compared to his quality.

So to minimize the total wage, we want a small ratio.
So we sort all workers with their expected ratio, and pick up K first worker.
Now we have a minimum possible ratio for K worker and we their total quality.

As we pick up next worker with bigger ratio, we increase the ratio for whole group.
Meanwhile we remove a worker with highest quality so that we keep K workers in the group.
We calculate the current ratio * total quality = total wage for this group.

We redo the process and we can find the minimum total wage.
Because workers are sorted by ratio of wage/quality.
For every ratio, we find the minimum possible total quality of K workers.

Time Complexity
O(NlogN) for sort.
O(NlogK) for priority queue.

SC complexity : o(n)
 */
public class MinimumCostToHireKWorkers {

    public static void main(String[] args) {
        //int quality[] = new int[]{3,1,10,10,1}, wage[]= new int[]{4,8,2,2,7}, k = 3;
        int quality[] = new int[]{10,20,5}, wage[]= new int[]{70,50,30}, k = 2;
        System.out.println(new MinimumCostToHireKWorkers().mincostToHireWorkers(quality,wage,k));
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];

        for(int i=0;i<n;i++){
            workers[i] = new double[]{(double)(wage[i])/quality[i], (double)quality[i]};
        }
        Arrays.sort(workers, (a, b)-> Double.compare(a[0],b[0]));
        PriorityQueue<Double> pq = new PriorityQueue<>();

        double result =Double.MAX_VALUE, sum = 0;
        Arrays.stream(workers).forEach(worker -> System.out.println(Arrays.toString(worker)));
        for(double[] worker : workers){
            System.out.println("worker : "+Arrays.toString(worker));
            sum+=worker[1];
            pq.offer(-worker[1]);
            System.out.println("sum : "+ sum +" pq.peek() : " + pq.peek());
            if(pq.size()>k)
                sum+=pq.poll();
            System.out.println("sum : "+ sum +" worker[0] : " + worker[0]);
            if(pq.size() == k)
                result = Math.min(result, sum*worker[0]);
            System.out.println("result : "+ result);
        }

        return result;
    }
}
