package com.binarysearch;

import java.util.Arrays;

/*
2616. Minimize the Maximum Difference of Pairs

You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the
maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the
p pairs.

Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|,
where |x| represents the absolute value of x.

Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.



Example 1:

Input: nums = [10,1,2,7,1,3], p = 2
Output: 1
Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5.
The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.

Intuition
To solve mini-max problem,
we can apply binary search.


Explanation
First we don't care the original order of A[i],
we want to compare the difference,
so we sort them.

The result is in range of left = 0 and right = A[n - 1] - A[0]
each iteration of search,
we assume the minimum maximum difference is mid = left +(right-left) / 2,
then we check if we can have p pairs.

We take pairs (A[i], A[i - 1]) greedily if A[i] - A[i - 1] <= mid.
If we take this pair, we move to next available pair (A[i + 2], A[i + 1])
If not, we move to next available pair (A[i + 1], A[i])

In the end of each iteration,
we check if we can have p pairs.
If so, mid is big enough, right = mid
If not, mid is too small, left = mid + 1.

Finally we return the binary seach result left.


Complexity
Time O(nlog(max(A)) + nlogn)
Space O(logn)

 */
public class MinimizeTheMaximumDifferenceOfPairs {

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,1,3};
        System.out.println(new MinimizeTheMaximumDifferenceOfPairs().minimizeMax(nums,2));
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left =0, right = nums[n-1] - nums[0];
        while(left<right){

            int mid = left + (right-left)/2, k=0;
            for(int i=1;i<n;i++){
                if(nums[i]-nums[i-1]<=mid)
                {
                    k++;
                    i++;
                }
            }
            if(k>=p){
                right = mid;
            } else{
                left = mid+1;
            }
        }

        return left;
    }
}
