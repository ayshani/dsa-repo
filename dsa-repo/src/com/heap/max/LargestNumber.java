package com.heap.max;

import java.util.PriorityQueue;

/*
179. Largest Number

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"

TC : o(nlogn)
SC: o(n)
 */
public class LargestNumber {

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3,30,34,5,9}));
    }
    public String largestNumber(int[] nums) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
                (a,b) -> (b+a).compareTo(a+b)
        );
        int totalLength =0 ;
        for(int num : nums){
            String s = Integer.toString(num);
            totalLength += s.length();
            maxHeap.offer(s);
        }

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            sb.append(maxHeap.poll());
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
