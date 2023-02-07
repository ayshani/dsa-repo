package com.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
1673. Find the Most Competitive Subsequence

Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.

An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position
where a and b differ, subsequence a has a number less than the corresponding number in b. For example, [1,3,4]
is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.



Example 1:

Input: nums = [3,5,2,6], k = 2
Output: [2,6]
Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6]
is the most competitive.


Algorithm
-----------------
To implement the solution discussed above, we need 2 things,
First, we need a data structure that could hold the chosen elements for the resultant subsequence.
We should be able to add or remove any number of elements from the end of the subsequence, as well as read
elements at the beginning of the subsequence. The data structure that comes in our mind is Double-Ended Queue.

Second, we need a way to know the number of elements we could drop from the array nums to build the resultant subsequence.

For example, if nums = [3, 4, 1] and k = 3, we know that we cannot drop any element from the array,
and the result would be [3, 4, 1]. Hence, there are 0 elements that can be dropped.

If nums = [3, 4, 1, 5] and k = 3, we know that we can drop 1 element from the array as we need only 3 elements
in the resultant subsequence.

Let additionalCount be the number of elements that we can drop from the array nums to build the result.
Initially, additionalCount would be initialized to ( length of nums array - k )

Steps:

Build a double-ended queue, named queue that holds the chosen subsequence at any given point.

Iterate over array nums, choose the most competitive elements and add it to the queue.

Compare the last element of the queue (last chosen element for the resultant subsequence) with the current element.

Until the last element of the queue is greater than the current element and
additionalCount is greater than 0, we know that we can remove the last chosen element from the queue
and replace it with the current element which is smaller and hence a better candidate.
Every time an element is removed from queue, decrement the additionalCount by 1.

Otherwise, simply add the current element at the end of the queue.

In the end, we have the most suitable candidates in the queue. Get the first k elements from the queue and
build the resultant array.

TC : o(n)
SC: o(n)
 */
public class FindTheMostCompetitiveSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,3,5,4,9,6};
        int res[] = new FindTheMostCompetitiveSubsequence().mostCompetitive(nums,4);
        Arrays.stream(res).forEach(e -> System.out.print(e+" "));
    }
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        int count = nums.length -k;

        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && nums[i] < dq.peekLast() && count>0){
                dq.pollLast();
                count--;
            }
            dq.addLast(nums[i]);
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = dq.pollFirst();
        }
        return res;
    }
}
