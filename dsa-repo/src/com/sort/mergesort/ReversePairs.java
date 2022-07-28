package com.sort.mergesort;
//493. Reverse Pairs

import java.util.Arrays;

/*
 * Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1


Input: nums = [1,3,2,3,1]
Output: 2

Explanation : (3,1), (3,1)

TC : O(N)
SC : O(1)

Logic
----------------

 In each round, we divide our array into two parts and sort them.
 So after "int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); ",
 the left part and the right part are sorted and now our only job is to count
 how many pairs of number (leftPart[i], rightPart[j]) satisfies leftPart[i] <= 2*rightPart[j].
For example,
left: 4 6 8 right: 1 2 3
so we use two pointers to travel left and right parts. For each leftPart[i],
if j<=e && nums[i]/2.0 > nums[j], we just continue to move j to the end,
to increase rightPart[j], until it is valid. Like in our example, left's 4 can match 1 and 2;
left's 6 can match 1, 2, 3, and left's 8 can match 1, 2, 3. So in this particular round,
there are 8 pairs found, so we increases our total by 8.

 */
public class ReversePairs {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[] {1,3,2,3,1};
        ReversePairs obj = new ReversePairs();
        System.out.println(obj.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    private int mergeSort(int[] nums, int s, int e){
        if(s>=e)
            return 0;
        int mid = s+(e-s)/2;
        int count = mergeSort(nums,s,mid) + mergeSort(nums,mid+1,e);

        for(int i=s,j=mid+1;i<=mid;i++){
            while(j<=e && nums[i]/2.0>nums[j]){
                j++;
            }
            count+= j-(mid+1);
        }

        Arrays.sort(nums,s,e+1);
        return count;
    }

}

