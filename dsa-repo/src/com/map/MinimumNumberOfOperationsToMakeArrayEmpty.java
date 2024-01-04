package com.map;

import java.util.HashMap;
import java.util.Map;

/*
2870. Minimum Number of Operations to Make Array Empty

You are given a 0-indexed array nums consisting of positive integers.

There are two types of operations that you can apply on the array any number of times:

Choose two elements with equal values and delete them from the array.
Choose three elements with equal values and delete them from the array.
Return the minimum number of operations required to make the array empty, or -1 if it is not possible.



Example 1:

Input: nums = [2,3,3,2,2,4,2,3,4]
Output: 4
Explanation: We can apply the following operations to make the array empty:
- Apply the first operation on the elements at indices 0 and 3. The resulting array is nums = [3,3,2,4,2,3,4].
- Apply the first operation on the elements at indices 2 and 4. The resulting array is nums = [3,3,4,3,4].
- Apply the second operation on the elements at indices 0, 1, and 3. The resulting array is nums = [4,4].
- Apply the first operation on the elements at indices 0 and 1. The resulting array is nums = [].
It can be shown that we cannot make the array empty in less than 4 operations.

TC : o(n)
SC: o(number of unique elements)
 */
public class MinimumNumberOfOperationsToMakeArrayEmpty {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfOperationsToMakeArrayEmpty().minOperations(
                new int[]{14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12}
        ));
    }
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int total =0;

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int count = entry.getValue();
            if(count<2)
                return -1;
            /*
            below will also work but wrt time complexity,
            this take more time that whichever is implemented
            total += Math.ceil((double)count /3)
             */
            if(count %3 ==  0 || count%3==2){
                total += (count/3);
                count %=3;
            } else if(count%3==1){
                total += (count/3) -1;
                count %=3;
                count +=3;
            }
            if(count%2==0){
                total += count/2;
            } else{
                return -1;
            }
        }
        return total;
    }
}
