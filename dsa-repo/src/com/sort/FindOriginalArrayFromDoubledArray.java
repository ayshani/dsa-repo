package com.sort;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
2007. Find Original Array From Doubled Array

An integer array original is transformed into a doubled array changed by appending twice the value of every
element in original, and then randomly shuffling the resulting array.

Given an array changed, return original if changed is a doubled array. If changed is not a doubled array,
return an empty array. The elements in original may be returned in any order.



Example 1:

Input: changed = [1,3,4,2,6,8]
Output: [1,3,4]
Explanation: One possible original array could be [1,3,4]:
- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.
Other original arrays could be [4,3,1] or [3,1,4].

TC : o(n)
SC: o(n)
 */
public class FindOriginalArrayFromDoubledArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,6,8};
        Arrays.stream(new FindOriginalArrayFromDoubledArray().findOriginalArray(nums))
                .forEach(e -> System.out.print(e+" "));
    }
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length, index =0;
        if(n%2!=0)
            return new int[]{};

        int[] res = new int[n/2];
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num : changed){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int num : map.keySet()){
            if(map.get(num)> map.getOrDefault(num+num,0)){
                return new int[]{};
            }

            for(int j=0;j<map.get(num);j++){
                res[index++] = num;
                map.put(num+num, map.get(num+num)-1);
            }
        }
        return res;
    }
}
