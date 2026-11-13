package com.slidingwindow;

import java.util.*;

/*
3420. Count Non-Decreasing Subarrays After K Operations

You are given an array nums of n integers and an integer k.

For each subarray of nums, you can apply up to k operations on it. In each operation, you increment any element of
the subarray by 1.

Note that each subarray is considered independently, meaning changes made to one subarray do not persist to another.

Return the number of subarrays that you can make non-decreasing ​​​​​after performing at most k operations.

An array is said to be non-decreasing if each element is greater than or equal to its previous element, if it exists.



Example 1:

Input: nums = [6,3,1,2,4,4], k = 7

Output: 17

Explanation:

Out of all 21 possible subarrays of nums, only the subarrays [6, 3, 1], [6, 3, 1, 2], [6, 3, 1, 2, 4] and
[6, 3, 1, 2, 4, 4] cannot be made non-decreasing after applying up to k = 7 operations. Thus, the number of
non-decreasing subarrays is 21 - 4 = 17.

TC : o(nlogn)
SC: o(n)
 */
public class CountNonDecreasingSubarraysAfterKOperations {

    public static void main(String[] args) {
        System.out.println(new CountNonDecreasingSubarraysAfterKOperations().countNonDecreasingSubarrays(
                new int[]{6,3,1,2,4,4}, 7
        ));
    }
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long operations = 0;
        // Maintain the window maximum with a priority queue
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // Record the set of elements covered by this index
        List<List<Integer>> cnt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cnt.add(new ArrayList<>());
        }
        // Index of the first greater-or-equal element to the right
        int[] pos = new int[n];
        Arrays.fill(pos, n);
        // Decreasing monotonic stack
        Deque<Integer> st = new ArrayDeque<>();

        for (int left = 0, right = 0; right < n; right++) {
            // Maintain the monotonic stack
            while (!st.isEmpty() && nums[right] >= nums[st.peek()]) {
                pos[st.peek()] = right;
                st.pop();
            }
            // The stack top is the nearest greater element to the left of nums[right]
            if (!st.isEmpty()) {
                cnt.get(st.peek()).add(right);
            }
            st.push(right);

            // The priority queue front is the window maximum
            q.offer(new int[] { nums[right], right });
            // Adding nums[right] increases the operation count
            operations += Math.max(0, q.peek()[0] - nums[right]);

            // The minimum operation count exceeds k; shrink the window
            while (operations > k) {
                // Removing nums[left] from the window decreases the operation count
                for (int i : cnt.get(left)) {
                    // Subtract the contribution
                    operations -=
                            (long) (nums[left] - nums[i]) *
                                    (Math.min(pos[i], right + 1) - i);
                }
                left++;
            }

            // Remove elements with indices less than left from the priority queue
            while (!q.isEmpty() && q.peek()[1] < left) {
                q.poll();
            }

            // There are right - left + 1 valid contiguous subarrays ending at right
            ans += right - left + 1;
        }

        return ans;
    }
}
