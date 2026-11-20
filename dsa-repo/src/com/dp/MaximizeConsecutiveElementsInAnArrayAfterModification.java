package com.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
3041. Maximize Consecutive Elements in an Array After Modification

You are given a 0-indexed array nums consisting of positive integers.

Initially, you can increase the value of any element in the array by at most 1.

After that, you need to select one or more elements from the final array such that those elements are consecutive when sorted in increasing order. For example, the elements [3, 4, 5] are consecutive while [3, 4, 6] and [1, 1, 2, 3] are not.

Return the maximum number of elements that you can select.



Example 1:

Input: nums = [2,1,5,1,1]
Output: 3
Explanation: We can increase the elements at indices 0 and 3. The resulting array is nums = [3,1,5,2,1].
We select the elements [3,1,5,2,1] and we sort them to obtain [1,2,3], which are consecutive.
It can be shown that we cannot select more than 3 consecutive elements.

TC : o(nlogn)
SC: o(n)
 */
public class MaximizeConsecutiveElementsInAnArrayAfterModification {

    public static void main(String[] args) {
        System.out.println(new MaximizeConsecutiveElementsInAnArrayAfterModification().maxSelectedElements(
                new int[]{2,1,5,1,1}
        ));
    }
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int x : nums) {
            dp.put(
                    x + 1,
                    Math.max(dp.getOrDefault(x + 1, 0), dp.getOrDefault(x, 0) + 1)
            );
            dp.put(
                    x,
                    Math.max(dp.getOrDefault(x, 0), dp.getOrDefault(x - 1, 0) + 1)
            );
            ans = Math.max(ans, Math.max(dp.get(x), dp.get(x + 1)));
        }
        return ans;
    }
}
