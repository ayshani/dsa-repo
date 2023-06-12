package com.twopointer;

import java.util.ArrayList;
import java.util.List;

/*
228. Summary Ranges

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element
of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges
but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b


Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

TC: o(n)
SC: o(1)
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int start =0, end =0, n = nums.length;
        while(end<n){
            int j = end;
            while( j+1<n && (nums[j]+1 == nums[j+1])){
                j++;
            }
            String cur = "";
            if(j==end){
                cur = nums[start] +"";
            } else{
                cur = nums[start]+"->"+nums[j];
                end=j;
            }
            result.add(cur);
            end++;
            start = end;
        }
        return result;
    }
}
