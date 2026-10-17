package com.tree;

import java.util.HashMap;
import java.util.Map;

/*
2916. Subarrays Distinct Element Sum of Squares II

You are given a 0-indexed integer array nums.

The distinct count of a subarray of nums is defined as:

Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].
Return the sum of the squares of distinct counts of all subarrays of nums.

Since the answer may be very large, return it modulo 109 + 7.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,2,1]
Output: 15
Explanation: Six possible subarrays are:
[1]: 1 distinct value
[2]: 1 distinct value
[1]: 1 distinct value
[1,2]: 2 distinct values
[2,1]: 2 distinct values
[1,2,1]: 2 distinct values
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 + 22 + 22 + 22 = 15.


 */
public class SubarraysDistinctElementSumOfSquaresII {

    public static void main(String[] args) {
        System.out.println(new SubarraysDistinctElementSumOfSquaresII().sumCounts(new int[]{1,2,1}));
    }
    public int sumCounts(int[] A) {
        int n = A.length;
        long res = 0,
                cur = 0;
        BIT bit = new BIT(n + 10);
        Map<Integer, Integer> seen = new HashMap<>();

        long mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int a = A[i];
            int j = seen.getOrDefault(a, -1) + 1;
            long q = bit.query(j, i);
            cur = (cur + q * 2 + i - j + 1) % mod;
            res = (res + cur) % mod;
            bit.add(j, i, 1);
            seen.put(a, i);
        }
        return (int) res;
    }
}


class BIT {

    int size;
    long[] _tree1;
    long[] _tree2;

    public BIT(int n) {
        this.size = n;
        this._tree1 = new long[n + 2];
        this._tree2 = new long[n + 2];
    }

    private int _lowbit(int index) {
        return index & -index;
    }

    public void add(int left, int right, int delta) {
        _add(left, delta);
        _add(right + 1, -delta);
    }

    public long query(int left, int right) {
        return _query(right) - _query(left - 1);
    }

    private void _add(int index, int delta) {
        index += 1;
        long rawIndex = index;
        while (index <= size) {
            _tree1[index] += delta;
            _tree2[index] += rawIndex * delta;
            index += _lowbit(index);
        }
    }

    private long _query(int index) {
        index += 1;
        long rawIndex = index + 1;
        if (index > size) {
            index = size;
        }
        long res = 0;
        while (index > 0) {
            res += rawIndex * _tree1[index] - _tree2[index];
            index -= _lowbit(index);
        }
        return res;
    }
}