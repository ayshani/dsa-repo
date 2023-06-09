package com.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
18. 4Sum

Given an array nums of n integers, return an array of all the unique quadruplets
[nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

TC : o(n^3)
SC: o(1)
 */
public class FourSum {

    public static void main(String[] args) {
        //int[] a = new int[]{1,0,-1,0,-2,2};
        int[] a = new int[]{1000000000,1000000000,1000000000,1000000000};
        //System.out.println(new FourSum().fourSum(a,0));
        System.out.println(new FourSum().fourSum(a,-294967296));
    }
    public List<List<Integer>> fourSum(int[] A, int X) {
        List<List<Integer>> result = new ArrayList<>();
        int n = A.length;
        int l, r;
        Arrays.sort(A);
        for (int i = 0; i < n - 3; i++)
        {
            if(i==0 || i>0 && A[i] != A[i-1]) {
                for (int j = i + 1; j < n - 2; j++)
                {
                    if(j==i+1 || j>i+1 && A[j] != A[j-1]){
                        // Initialize two variables as indexes of the first and last
                        // elements in the remaining elements
                        l = j + 1;
                        r = n - 1;

                        long partSum = A[i] + A[j];
                        long rest = ((long)X - partSum);
                        // To find the remaining two elements, move the index
                        // variables (l & r) toward each other.
                        while (l < r)
                        {

                            long sum = A[l] + A[r] ;
                            if (sum == rest)
                            {
                                List<Integer> temp = Arrays.asList(A[i],A[j],A[l],A[r]);

                                Collections.sort(temp);

                                if(!result.contains(temp))
                                    result.add(temp);
                                l++;
                                r--;
                            }
                            else if (sum < rest)
                                l++;
                            else // A[i] + A[j] + A[l] + A[r] > X
                                r--;
                        } // end of while
                    }
                } // end of inner for loop
            }
        } // end of outer for loop
        return result;
    }
}
