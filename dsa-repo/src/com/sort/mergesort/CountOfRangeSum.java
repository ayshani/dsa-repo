package com.sort.mergesort;

import java.util.Arrays;

/*
 * 327. Count of Range Sum
 *
 * Given an integer array nums and two integers lower and upper,
 * return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j inclusive, where i <= j.
 *
 * Example 1:
 * Input: nums = [-2,5,-1], lower = -2, upper = 2
 * Output: 3
 * Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.
 *
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * -105 <= lower <= upper <= 105
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * Logic
 * --------
 * Have a cumulative sum in array.
 * Do a mergesort with cumulative sum.
 * for every part, check the sum range and return the count
 *
 * TC : O(nlogn)
 * SC : O(n)
 */
public class CountOfRangeSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[] {-2,5,-1};
        int lower = -2, upper = 2;
        CountOfRangeSum obj = new CountOfRangeSum();
        System.out.println(obj.countRangeSum(nums, lower, upper));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        long[] sums = new long[n+1];

        for(int i=1;i<sums.length;i++){
            sums[i] = sums[i-1]+nums[i-1];
        }

        return mergeSort(sums,0,sums.length-1,lower,upper);
    }

    int mergeSort(long[] nums, int l, int r, int lower, int upper){
        if(l>=r)
            return 0;
        int mid = l+(r-l)/2;
        int count = mergeSort(nums,l,mid,lower,upper) + mergeSort(nums,mid+1,r,lower,upper);

        int i = mid+1, j = mid+1;
        for(int k=l;k<=mid;k++){
            // get the last i for which the sum is <= upper
            while(i<=r && (nums[i] - nums[k]) <= upper )
                i++;
            // get the last j for which the summation is < lower
            while(j<=r && (nums[j] - nums[k]) < lower )
                j++;

            /*
             * the logic is we have last i which is upper bound for sum
             * we also have j which is the lower bound of sum i.e. sum >= lower starts from here
             * So, if we substract j-i, then we have the count for this range of (l,r)
             */
            count+= i-j;
        }

        //merge(nums, l,r);
        Arrays.sort(nums,l,r+1);
        return count;
    }

}
