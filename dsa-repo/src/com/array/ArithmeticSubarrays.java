package com.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
1630. Arithmetic Subarrays

A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between
every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if
s[i+1] - s[i] == s[1] - s[0] for all valid i.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic:

1, 1, 2, 5, 7
You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range
queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.

Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... ,
nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.

Example 1:

Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
Output: [true,false,true]
Explanation:
In the 0th query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
In the 1st query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
In the 2nd query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9], which is an arithmetic sequence.

TC : o(m*n)
SC: o(n)
 */
public class ArithmeticSubarrays {

    public static void main(String[] args) {
        System.out.println(new ArithmeticSubarrays().
                checkArithmeticSubarrays(new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5}));
    }
    
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }

            ans.add(check(arr));
        }

        return ans;
    }

    public Boolean check(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        Set<Integer> arrSet = new HashSet();

        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
            arrSet.add(num);
        }

        if ((maxElement - minElement) % (arr.length - 1) != 0) {
            return false;
        }

        int diff = (maxElement - minElement) / (arr.length - 1);
        int curr = minElement + diff;

        while (curr < maxElement) {
            if (!arrSet.contains(curr)) {
                return false;
            }

            curr += diff;
        }
        return true;
    }
}
