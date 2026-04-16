package com.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
3488. Closest Equal Element Queries

You are given a circular array nums and an array queries.

For each query i, you have to find the following:

The minimum distance between the element at index queries[i] and any other index j in the circular array, where nums[j] == nums[queries[i]]. If no such index exists, the answer for that query should be -1.
Return an array answer of the same size as queries, where answer[i] represents the result for query i.



Example 1:

Input: nums = [1,3,1,4,1,3,2], queries = [0,3,5]

Output: [2,-1,3]

Explanation:

Query 0: The element at queries[0] = 0 is nums[0] = 1. The nearest index with the same value is 2, and the distance between them is 2.
Query 1: The element at queries[1] = 3 is nums[3] = 4. No other index contains 4, so the result is -1.
Query 2: The element at queries[2] = 5 is nums[5] = 3. The nearest index with the same value is 1, and the distance between them is 3 (following the circular path: 5 -> 6 -> 0 -> 1).


TC : o(n + nlogn)
SC: o(n)
 */
public class ClosestEqualElementQueries {

    public static void main(String[] args) {
        System.out.println(new ClosestEqualElementQueries().solveQueries(
                new int[]{1,3,1,4,1,3,2}, new int[]{0,3,5}
        ));
    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> numsPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numsPos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (ArrayList<Integer> pos : numsPos.values()) {
            int x = pos.get(0);
            int last = pos.get(pos.size() - 1);
            pos.add(0, last - n);
            pos.add(x + n);
        }
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            int x = nums[q];
            ArrayList<Integer> posList = numsPos.get(x);

            if (posList.size() == 3) {
                result.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(posList, q);
            if (idx < 0) idx = -idx - 1;

            int dist = Math.min(
                    posList.get(idx + 1) - posList.get(idx),
                    posList.get(idx) - posList.get(idx - 1)
            );
            result.add(dist);
        }
        return result;
    }



}
