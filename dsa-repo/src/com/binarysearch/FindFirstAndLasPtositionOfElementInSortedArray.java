package com.binarysearch;
/*
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Logic
 * ---------
 * Array is sorted. so we can use binary search.
 * Once we get hold of one search position which is equal to target suppose pos, then we iterate over
 * pos>= low and nums[pos] == target
 * 	pos--
 * do same for pos to high
 * then get the start position and end position
 */
public class FindFirstAndLasPtositionOfElementInSortedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[] {5,7,7,8,8,10};
        int target =8;
        FindFirstAndLasPtositionOfElementInSortedArray obj = new FindFirstAndLasPtositionOfElementInSortedArray();
        int[] res = obj.searchRange(nums, target);
        System.out.println(res[0] + " "+res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0]=-1;
        res[1] =-1;

        int l=0,r=nums.length-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]>target)
                r= mid-1;
            else if(nums[mid]<target)
                l = mid+1;
            else{
                int i=mid, j = mid;
                while(i>=l && nums[i] == target )
                    i--;
                while(j<=r && nums[j] == target)
                    j++;

                res[0] = i+1;
                res[1] = j-1;

                break;
            }
        }

        return res;
    }

}
