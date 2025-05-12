package com.array;

import java.util.*;

/*
2094. Finding 3-Digit Even Numbers

You are given an integer array digits, where each element is a digit. The array may contain duplicates.

You need to find all the unique integers that follow the given requirements:

The integer consists of the concatenation of three elements from digits in any arbitrary order.
The integer does not have leading zeros.
The integer is even.
For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.

Return a sorted array of the unique integers.



Example 1:

Input: digits = [2,1,3,0]
Output: [102,120,130,132,210,230,302,310,312,320]
Explanation: All the possible integers that follow the requirements are in the output array.
Notice that there are no odd integers or integers with leading zeros.
TC : o(n^3)
SC: o(n)
 */
public class Finding3DigitEvenNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Finding3DigitEvenNumbers().findEvenNumbers(
                new int[]{2,1,3,0}
        )));
    }
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        int n = digits.length;
        // Traverse the indices of three digits
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    // Determine whether it meets the condition of the target even number
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num >= 100 && num % 2 == 0) {
                        nums.add(num);
                    }
                }
            }
        }
        // Converted to an array sorted in ascending order
        List<Integer> res = new ArrayList<>(nums);
        Collections.sort(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }
        return result;
    }
}
