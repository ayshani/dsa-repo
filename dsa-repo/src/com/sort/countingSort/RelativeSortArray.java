package com.sort.countingSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1122. Relative Sort Array

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.


Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

TC : o(maxElement)
SC: o(maxElement)
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RelativeSortArray().relativeSortArray(
                new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6}
        )));
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxElement = Arrays.stream(arr1).max().orElse(0);
        int[] count = new int[maxElement+1];

        for(int val : arr1){
            count[val]++;
        }

        List<Integer> result = new ArrayList<>();
        for(int val : arr2){
            while(count[val]>0){
                result.add(val);
                count[val]--;
            }
        }

        for(int i=0;i<=maxElement; i++){
            while(count[i]>0){
                result.add(i);
                count[i]--;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
