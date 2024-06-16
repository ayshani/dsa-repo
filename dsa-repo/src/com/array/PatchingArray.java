package com.array;
/*
330. Patching Array

Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the
range [1, n] inclusive can be formed by the sum of some elements in the array.

Return the minimum number of patches required.



Example 1:

Input: nums = [1,3], n = 6
Output: 1
Explanation:
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

TC : o(n)
SC : o(1)
 */
public class PatchingArray {

    public static void main(String[] args) {
        System.out.println(new PatchingArray().minPatches(new int[]{1,3},6));
    }

    public int minPatches(int[] nums, int n) {
        long ans = 0, sum = 0;
        for (int i = 0; i < nums.length && sum < n; i++) {
            if (nums[i] <= sum + 1) {
                sum += nums[i];
            } else {
                i--;
                ans++;
                sum = sum * 2 + 1;
            }
        }
        while (sum < n) {
            sum = sum * 2 + 1;
            ans++;
        }
        return (int) ans;
    }
}
