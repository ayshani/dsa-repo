package com.heap.min;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
1481. Least Number of Unique Integers after K Removals

Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly
k elements.

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.


TC : o(n + mlogm + klogk)
SC: o(n===m)
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {

    public static void main(String[] args) {
        System.out.println(new LeastNumberOfUniqueIntegersAfterKRemovals()
                .findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2},3));
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());

        int elementsRemoved =0;
        while(!pq.isEmpty()){
            elementsRemoved += pq.peek();
            if(elementsRemoved>k){
                return pq.size();
            }
            pq.poll();
        }
        return 0;
    }
}
