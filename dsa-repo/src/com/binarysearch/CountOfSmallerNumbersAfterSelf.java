package com.binarysearch;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 315. Count of Smaller Numbers After Self
 *
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 *
 * Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Logic
--------
start from n-1 to 0
check the insert Position of nums[i] in the list of i-n segment
This insert position will be after after its smaller elements in right side of the original array.
Hence solve the purpose.

TC : O(nlogn)
SC : O(n)

 */
public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[] {5,2,6,1};
        CountOfSmallerNumbersAfterSelf obj = new CountOfSmallerNumbersAfterSelf();
        System.out.println(obj.countSmaller(nums));
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> aux = new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            int pos  = insertPosition(aux,nums[i]);
            result.addFirst(pos);
        }

        return result;
    }

    private int insertPosition(List<Integer> aux, int num){
        int l =0, r = aux.size()-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int midVal = aux.get(mid);
            if(num<=midVal){
                r= mid-1;
            } else
                l = mid+1;
        }
        aux.add(l,num);
        return l;
    }

}

