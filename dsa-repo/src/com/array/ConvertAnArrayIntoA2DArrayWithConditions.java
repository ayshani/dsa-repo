package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
2610. Convert an Array Into a 2D Array With Conditions

You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.



Example 1:

Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.

TC : o(n)
SC: o(n)
 */
public class ConvertAnArrayIntoA2DArrayWithConditions {

    public static void main(String[] args) {
        System.out.println(new ConvertAnArrayIntoA2DArrayWithConditions()
                .findMatrix(new int[]{1,3,4,1,2,3,1}));
    }
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>>  result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max =0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            max = Math.max(max,map.get(num));
        }

        for(int i=0;i<max;i++){
            result.add(new ArrayList<>());
        }
        for(int num : map.keySet()){
            int count = map.get(num);
            int index =0;
            while(index< count){
                result.get(index).add(num);
                index++;
            }
        }
        return result;
    }
}
