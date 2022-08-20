package com.sort;

import java.util.Map;
import java.util.TreeMap;

/*
1296. Divide Array in Sets of K Consecutive Numbers

Given an array of integers nums and a positive integer k,
check whether it is possible to divide this array into sets of k consecutive numbers.

Return true if it is possible. Otherwise, return false.

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

TC : o(nlogn + nk)
SC : o(n)
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer,Integer> occurrenceMap = new TreeMap<>();

        // have occurrence of all nums in TreeMap in increasing order of numbers
        for(int num : nums){
            occurrenceMap.put(num, occurrenceMap.getOrDefault(num,0)+1);
        }

        // Iterate over the map
        for(int num : occurrenceMap.keySet()){
            // Incase the occurrence is greater than 0, so we need to check if we can form a
            // consecutive increasing group of size k.
            // If we cna get , we cut off (index - (index + k - 1)) from the counter.
            if(occurrenceMap.get(num) > 0) {
                for(int index = k-1; index>=0;index--){

                    if(occurrenceMap.getOrDefault(num + index,0) < occurrenceMap.get(num))
                        return false;
                    occurrenceMap.put(num+index, occurrenceMap.get(num+index)- occurrenceMap.get(num));
                }
            }
        }

        return true;
    }
}
