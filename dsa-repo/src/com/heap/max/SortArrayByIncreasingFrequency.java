package com.heap.max;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
1636. Sort Array by Increasing Frequency

Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

TC : o(nlogn)
SC : o(n)
 */
public class SortArrayByIncreasingFrequency {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,2,3};

        int[] res = new SortArrayByIncreasingFrequency().frequencySort(nums);
        int[] res1 = new SortArrayByIncreasingFrequency().frequencySortV2(nums);
        Arrays.stream(res).forEach(e -> System.out.print(e+ " "));
        System.out.println("\nV2 --");
        Arrays.stream(res1).forEach(e -> System.out.print(e+ " "));
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b)
                -> a.getValue() == b.getValue() ? b.getKey()-a.getKey() : a.getValue()-b.getValue());
        System.out.println(pq);
        pq.addAll(map.entrySet());
        int[] res = new int[nums.length];
        int index =0;
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> e = pq.poll();
            System.out.println(" e: "+ e);
            for(int i=0;i<e.getValue();i++){
                res[index++] = e.getKey();
            }

        }

        return res;

    }

    public int[] frequencySortV2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        Integer[] numObject = new Integer[n];
        for(int i=0;i<n;i++){
            numObject[i] = nums[i];
        }

        Arrays.sort(numObject, (a,b)->{
            if(freq.get(a).equals(freq.get(b))){
                return Integer.compare(b,a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });
        for(int i=0;i<n;i++){
            nums[i] = numObject[i];
        }
        return nums;
    }
}
