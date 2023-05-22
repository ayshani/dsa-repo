package com.map;

import java.util.HashMap;
import java.util.Map;

/*
2023. Number of Pairs of Strings With Concatenation Equal to Target

Given an array of digit strings nums and a digit string target, return the number of pairs of indices (i, j)
(where i != j) such that the concatenation of nums[i] + nums[j] equals target.

Example 1:

Input: nums = ["777","7","77","77"], target = "7777"
Output: 4
Explanation: Valid pairs are:
- (0, 1): "777" + "7"
- (1, 0): "7" + "777"
- (2, 3): "77" + "77"
- (3, 2): "77" + "77"

TC: o(n*m)
SC: o(number of unique strings)
 */
public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {

    public static void main(String[] args) {
        String[] nums = new String[]{"777","7","77","77"};
        System.out.println(new NumberOfPairsOfStringsWithConcatenationEqualToTarget().numOfPairs(nums,"7777"));
    }
    public int numOfPairs(String[] nums, String target) {
        Map<String,Integer> map = new HashMap<>();
        for(String num : nums){
            if(num.length()< target.length())
                map.put(num, map.getOrDefault(num,0)+1);
        }

        int result =0;
        for(int i=0;i<target.length();i++){
            String a = target.substring(0,i+1);
            String b = target.substring(i+1);

            if(map.containsKey(a) && map.containsKey(b)){
                if(a.equals(b)){
                    result += map.get(a)*(map.get(a)-1);
                } else{
                    result += map.get(a)*map.get(b);
                }
            }
        }

        return result;
    }
}
