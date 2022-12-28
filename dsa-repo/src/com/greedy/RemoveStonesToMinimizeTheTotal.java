package com.greedy;

import java.util.PriorityQueue;

/*
1962. Remove Stones to Minimize the Total

You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile,
and an integer k. You should apply the following operation exactly k times:

Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
Notice that you can apply the operation on the same pile more than once.

Return the minimum possible total number of stones remaining after applying the k operations.

floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).



Example 1:

Input: piles = [5,4,9], k = 2
Output: 12
Explanation: Steps of a possible scenario are:
- Apply the operation on pile 2. The resulting piles are [5,4,5].
- Apply the operation on pile 0. The resulting piles are [3,4,5].
The total number of stones in [3,4,5] is 12.

Intuition

At any given step, which number should we choose? We want to minimize the total number of stones remaining,
which means we want to maximize the number of stones we remove at each step, so we should choose greedily
choose the largest number at every step.

Every time we complete an operation, the data changes and we need to find the maximum number again.
The best data structure for this would be a heap, as it allows us to update the data and always retrieve
the maximum value in O(logn) time, compared to O(n) if we just used an array.

Algorithm

Initialize a max heap from piles.

Perform the following k times:

Pop the maximum element from the heap, call it curr.
Calculate how many stones remove should be removed from curr after performing the operation.
It is the floor of curr / 2.
Push curr - remove onto the heap.
Return the sum of the elements in the heap.

Complexity Analysis

Given n as piles.length,

Time complexity: O(n+k⋅logn)

An array can be converted to a heap in linear time (O(n)) using a method like Python's heapq.heapify().
After converting the input to a heap, we perform k heap operations. Each heap operation costs O(logn),
which gives us a time complexity of O(n+k⋅logn).

Space complexity: O(n)

The heap's length is equal to n, which is all the extra space we use.
 */
public class RemoveStonesToMinimizeTheTotal {
    public static void main(String[] args) {
        int[] piles = new int[]{5,4,9};
        System.out.println(new RemoveStonesToMinimizeTheTotal().minStoneSum(piles,2));
    }
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int num: piles) {
            heap.add(num);
        }

        for (int i = 0; i < k; i++) {
            int curr = heap.remove();
            int remove = curr / 2;
            heap.add(curr - remove);
        }

        int ans = 0;
        for (int num: heap) {
            ans += num;
        }

        return ans;
    }
}
