package com.greedy;

import java.util.HashMap;
import java.util.Map;

/*
659. Split Array into Consecutive Subsequences

You are given an integer array nums that is sorted in non-decreasing order.

Determine if it is possible to split nums into one or more subsequences such that both
of the following conditions are true:

Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one
more than the previous integer).
All subsequences have a length of 3 or more.
Return true if you can split nums according to the above conditions, or false otherwise.

A subsequence of an array is a new array that is formed from the original array by deleting
some (can be none) of the elements without disturbing the relative positions of the remaining elements.
(i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).

Example 1:

Input: nums = [1,2,3,3,4,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,5] --> 1, 2, 3
[1,2,3,3,4,5] --> 3, 4, 5

Logic
------
used a greedy algorithm.
left[i] is a hashmap, left[i] counts the number of i that I haven't placed yet.
end[i] is a hashmap, end[i] counts the number of consecutive subsequences that ends at number i
Then I tried to split the nums one by one.
If I could neither add a number to the end of a existing
consecutive subsequence nor find two following number in the left, I returned False

TC : o(n)
SC : o(n)
 */
public class SplitArrayIntoConsecutiveSubsequences {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,4,5};

        System.out.println(new SplitArrayIntoConsecutiveSubsequences().isPossible(nums));
    }
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> left = new HashMap<>() , end  = new HashMap<>();

        for(int num : nums){
            left.put(num, left.getOrDefault(num,0)+1);
        }

        for(int num : nums){
            if(left.get(num)<=0)
                continue;

            left.put(num, left.get(num)-1);

            /*
                If we have already found once valid subsequence with num-1
                then we can remove and add that subsequence to current num subsequence
             */
            if(end.containsKey(num-1) && end.get(num-1)>0)
            {
                end.put(num-1, end.get(num-1)-1);
                end.put(num, end.getOrDefault(num,0)+1);
                continue;
            }

            /*
                If we can get two consecutive increasing numbers from the current num,
                then we can add the current subsequence to num+2
             */
            if(left.containsKey(num+1) && left.get(num+1)> 0 &&
                    left.containsKey(num+2) && left.get(num+2)>0){
                left.put(num+1, left.get(num+1)-1);
                left.put(num+2, left.get(num+2)-1);
                end.put(num+2, end.getOrDefault(num+2,0)+1);
                continue;
            }

            /*
            if we neither get any sequence with num-1
            nor does left contain num+1 and num+2,
            then that means we can't have a sequence witht his current
            number. So return false
             */
            return false;
        }

        return true;
    }
}
