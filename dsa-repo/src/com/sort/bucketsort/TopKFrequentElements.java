package com.sort.bucketsort;

import java.util.*;

/*
347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

TC : o(n)
SC : o(n)
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k =2;
        int[] res = new TopKFrequentElements().topKFrequent(nums,k);
        Arrays.stream(res).forEach(e -> System.out.print(e+ " "));
    }

    // use an array to save numbers into different bucket whose index is the frequency
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length+1];

        for(int num : map.keySet()){
            int frequency = map.get(num);
            if(bucket[frequency]==null)
                bucket[frequency] = new LinkedList<>();
            bucket[frequency].add(num);
        }

        List<Integer> res = new ArrayList<>();

        for(int i=bucket.length-1;i>0 && k>0 ;i--){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i];
                res.addAll(list);
                k-= list.size();
            }
        }

        int[] r = new int[res.size()];
        int index =0;
        for(int i: res){
            r[index++] = i;
        }

        return r;
    }
}
