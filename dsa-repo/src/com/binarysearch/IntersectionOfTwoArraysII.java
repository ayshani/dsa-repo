package com.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
350. Intersection of Two Arrays II

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

TC : o(nlogn)
SC: o(nlogn)
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] m = new int[]{1,2,2,1}, n = new int[]{2,2};
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(m,n)));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        //we need to iterate for larger size array of elements
        //we need to check whether elements of larger size array available in lower size array
        // for intersection
        if(nums1.length< nums2.length)
            return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int leftIndex =0;
        for(int num : nums1){
            // get the index post leftIndex where num is there in num2[]
            int index = binarySearch(nums2, num, leftIndex);
            // if we get a hit, we add it to list and update the leftIndex
            if(index!=-1){
                list.add(num);
                leftIndex = index+1;
            }
        }
        return list.stream().mapToInt( i -> i).toArray();
    }

    private int binarySearch(int[] nums, int target, int left){
        int right = nums.length-1;
        int index =-1;

        while(left<=right){
            int mid = left +(right - left)/2;
            if(nums[mid]==target){
                // if we get a hit, we need to take left most index. Hence , not
                // returning from this point.
                index=mid;
                right = mid-1;
            } else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return index;
    }
}
