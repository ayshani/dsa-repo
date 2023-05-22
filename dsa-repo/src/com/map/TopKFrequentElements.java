package com.map;

import java.util.*;

/*
347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return
the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

TC: o(n)
SC: o(number of unique elements)
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        Arrays.stream(new TopKFrequentElements().topKFrequent(nums, 2))
                .forEach(System.out::println);
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        //System.out.println(map);
        List[] bucket = new List[nums.length+1];
        for(int key : map.keySet()){
            int frequency = map.get(key);
            //System.out.println(key +"    "+ frequency);
            if(bucket[frequency]==null){
                bucket[frequency] = new LinkedList<Integer>();
            }
            bucket[frequency].add(key);
            //System.out.println(bucket[frequency]);
        }
        int index=0;
        for(int i= bucket.length-1;i>0 && k>0;i--){

            if(bucket[i]!=null){
                List<Integer> aux = bucket[i];
                for(Integer num : aux){
                    res[index++] = num;
                }
                k-= aux.size();
            }
        }
        return res;
    }
}
