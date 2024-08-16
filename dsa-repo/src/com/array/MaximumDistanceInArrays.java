package com.array;

import java.util.List;

/*
624. Maximum Distance in Arrays

You are given m arrays, where each array is sorted in ascending order.

You can pick up two integers from two different arrays (each array picks one) and calculate the distance.
We define the distance between two integers a and b to be their absolute difference |a - b|.

Return the maximum distance.



Example 1:

Input: arrays = [[1,2,3],[4,5],[1,2,3]]
Output: 4
Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the
second array.

TC : o(n)
SC : o(1)
 */
public class MaximumDistanceInArrays {

    public static void main(String[] args) {
        System.out.println(new MaximumDistanceInArrays().maxDistance(
                List.of(List.of(1,2,3), List.of(4,5), List.of(1,2,3))
        ));
    }
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;

        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int min = arrays.get(0).get(0);

        for(int i=1; i<arrays.size(); i++){
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min)) ;
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        return result;
    }
}
