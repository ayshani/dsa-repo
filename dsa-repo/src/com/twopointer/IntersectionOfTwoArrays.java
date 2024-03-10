package com.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
349. Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

TC: o(nlogn)
SC: o(n)
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] m = new int[]{1,2,2,1}, n = new int[]{2,2};
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(m,n)));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length, n = nums2.length;
        int i=0, j=0;
        Set<Integer> set = new HashSet<>();

        while(i<m && j<n){
            if(i>0 && nums1[i]== nums1[i-1])
                i++;
            if(j>0 && nums2[j]== nums2[j-1])
                j++;

            if(i<m && j<n){
                if(nums1[i]== nums2[j]){
                    set.add(nums1[i]);
                    i++;
                    j++;
                } else if(nums1[i] < nums2[j]){
                    i++;
                } else{
                    j++;
                }
            }
        }
        //int[] res = new ArrayList<>(set).stream().mapToInt(i->i).toArray();
        int[] result = new ArrayList<>(set).stream().mapToInt(e -> e).toArray();
        return result;
    }
}
