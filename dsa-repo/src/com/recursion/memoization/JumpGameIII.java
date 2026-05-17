package com.recursion.memoization;
/*
1306. Jump Game III

Given an array of non-negative integers arr, you are initially positioned at start index of the array.
When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.

Notice that you can not jump outside of the array at any time.



Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3

TC : o(n)
SC: o(1)
 */
public class JumpGameIII {

    public static void main(String[] args) {
        System.out.println(new JumpGameIII().canReach(new int[]{4,2,3,0,3,1,2}, 5));
    }
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        int jumpDistance = arr[start];
        arr[start] = -1; // Mark as visited
        return canReach(arr, start + jumpDistance) || canReach(arr, start - jumpDistance);
    }
}
