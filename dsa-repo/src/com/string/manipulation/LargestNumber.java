package com.string.manipulation;

import java.util.Arrays;
import java.util.Comparator;

/*
179. Largest Number

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"

TC : o(nlogn)
SC : o(n)
 */
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{10,2}));
    }
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new LargeNumberComparater());

        if(str[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: str){
            sb.append(s);
        }
        return sb.toString();
    }
}

class LargeNumberComparater implements Comparator<String> {
    public int compare(String a, String b){
        String one = a+b;
        String sec = b+a;
        return sec.compareTo(one);
    }
}
