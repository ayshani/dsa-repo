package com.array;

import java.util.HashSet;
import java.util.Set;

/*
2834. Find the Minimum Possible Sum of a Beautiful Array

You are given positive integers n and target.

An array nums is beautiful if it meets the following conditions:

nums.length == n.
nums consists of pairwise distinct positive integers.
There doesn't exist two distinct indices, i and j, in the range [0, n - 1], such that nums[i] + nums[j] == target.
Return the minimum possible sum that a beautiful array could have.



Example 1:

Input: n = 2, target = 3
Output: 4
Explanation: We can see that nums = [1,3] is beautiful.
- The array nums has length n = 2.
- The array nums consists of pairwise distinct positive integers.
- There doesn't exist two distinct indices, i and j, with nums[i] + nums[j] == 3.
It can be proven that 4 is the minimum possible sum that a beautiful array could have.

TC : o(n)
SC: o(1)
 */
public class FindTheMinimumPossibleSumOfABeautifulArray {

    public static void main(String[] args) {
        System.out.println(new FindTheMinimumPossibleSumOfABeautifulArray().minimumPossibleSum(3,3));
    }
    public long minimumPossibleSum(int n, int target) {
        Set<Long> set = new HashSet<>();
        long start =1, sum =0;
        while(set.size()<n){
            if(!set.contains(target-start)){
                sum += start;
                set.add(start);
            }
            start++;
        }
        return sum;
    }

}
