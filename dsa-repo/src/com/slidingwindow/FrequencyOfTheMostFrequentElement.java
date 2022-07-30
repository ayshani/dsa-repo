package com.slidingwindow;

import java.util.Arrays;

/*
1838. Frequency of the Most Frequent Element

The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation,
you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

Example 2:

Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.

Logic
--------------
A sliding window problem.
Sort the array first
have a prefixSum on jth index.
now check if (prefixSum+k) can be < nums[j] * (j-i+1)
this is because, if on jth index, we add the max operations allowed(k) with
cumulative sum till now , gives me (j-i+1) times nums[j] or greater
        then, we consider this range of j-i+1 as no. of frequency of jth element.
    else,
    we need to decrease sum from ith index and increment i.

TC : o(nlogn)
SC : o(n)
 */
public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,8,13};
        int k =5;
        System.out.println(new FrequencyOfTheMostFrequentElement().maxFrequency(nums,k));
    }

    public int maxFrequency(int[] nums, int k) {
        int res =1, i=0, j=0;
        long sum =0;
        Arrays.sort(nums);
        for(j=0;j<nums.length;j++){
            sum+=nums[j];
            while(sum+k< (long)nums[j]*(j-i+1))
            {
                sum-=nums[i++];
            }
            res = Math.max(res, (j-i+1));
        }

        return res;
    }
}
