package com.heap.min;

import java.util.PriorityQueue;

/*
313. Super Ugly Number

A super ugly number is a positive integer whose prime factors are in the array primes.

Given an integer n and an array of integers primes, return the nth super ugly number.

The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

Example 1:

Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of
the first 12 super ugly numbers given primes = [2,7,13,19].

Logic
------
It is actually like how we merge k sorted list:

ugly number                       k sorted list
    1                            2     7    13   19     1 * [2,7,13,19]
    |                            |     |    |    |
    2                            4     14   26   38     2 * [2,7,13,19]
    |                            |     |    |    |
    4                            8     28   52   76     4 * [2,7,13,19]
    |                            |     |    |    |
    7                            14    49   91   133    7 * [2,7,13,19]
    |                            |     |    |    |
    8                            16    56   ...   ...   8 * [2,7,13,19]
    |                            |     |    |     |
    .                            .     .     .    .
    .                            .     .     .    .
    .                            .     .     .    .
We can see that each prime number in primes[] form a sorted list,
and now our job is to merge them and find the nth minimum.

Here we don't have the next pointer for each node to trace the next potential candidate.
But as we can see in the graph, we can make use of the ugly number we have produced so far!


TC : o(nlogk)
SC : o(n+k)

 */
public class SuperUglyNumber {

    public static void main(String[] args) {
        int[] prime = new int[]{2,7,13,19};
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(12,prime));
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for(int i=0;i<primes.length;i++){
            pq.offer(new int[]{primes[i],primes[i],0});
        }

        int[] nums = new int[n+1];
        nums[0] =1;
        int i=1;
        while(i<n){
            int[] temp = pq.poll();
            int factor = temp[0], prime = temp[1], index = temp[2];

            if(factor!=nums[i-1]){
                nums[i] = factor;
                i++;
            }

            pq.offer(new int[]{prime*nums[index+1], prime, index+1});
        }

        return nums[n-1];
    }
}
