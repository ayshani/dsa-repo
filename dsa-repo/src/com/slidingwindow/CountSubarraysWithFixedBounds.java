package com.slidingwindow;
/*
2444. Count Subarrays With Fixed Bounds

You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
 */
public class CountSubarraysWithFixedBounds {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,2,7,5};
        System.out.println(new CountSubarraysWithFixedBounds().countSubarrays(nums,1,5));
    }
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIndex =-1, maxIndex =-1, startNextSubArray =0;
        long count =0;
        for(int i=0;i<nums.length;i++){
            /*
            if nums[i] is out of bound,
            then we reset index to 0 and next subarray will start from i+1
            */
            if(nums[i] <minK || nums[i] >maxK){
                minIndex = 0;
                maxIndex =0;
                startNextSubArray = i+1;
            }

            //if nums[i] matches with min bound, store index
            if(nums[i] == minK)
                minIndex =i;

            //if nums[i] matches with max bound, store index
            if(nums[i] == maxK)
                maxIndex =i;

            /*
            it is possible that minBound is on right side and maxbound in left side
            i.e. minK =1, maxK =7   [9,4,3,7,5,1]
            Hence we take minIndex from this two.
                 0 1 2 3 4 5 -- Index
                [9,4,3,7,5,1]
            startNextSubArray = 1

            through iteration, unless we reach to last index, count remains 0 for this example.
            once we get minIndex = 5, maxIndex  =3,
            we consider the minimum value between this two i.e. maxIndex =3.
            now 3 - 1 +1 = 3 is the count.
            subarrays are : [4,3,7..] , [3,7..] , [7..]
            .. - this is because we consider only the min value of maxIndex and MinIndex
                as if we get two, then the subarray is already present,now we need to only check
                the extras i.e. left side and right side of the subarray whether
                it falls inside the bound.
                    if it falls, we count else the indices got resetted.
            */
            count  += Math.max(0L,Math.min(minIndex,maxIndex) - startNextSubArray+1);
        }
        return count;
    }
}
