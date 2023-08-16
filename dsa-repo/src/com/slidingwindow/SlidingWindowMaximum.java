package com.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
239. Sliding Window Maximum

You are given an array of integers nums,
there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Logic
-------
Have one Deque.
Iterate over the whole array nums
until deque is not empty and starting from first position in dequeue, if element i.e. indices of nums[]
    if outside of the current window size (not in [i-k])
        -> pop from first
Again, until dequeu is empty and starting from last position in Deqeue, if nums[indices] where
    indices coming from last position of dequeue, is less than the current element nums[i]
        -> pop from last

Once above two operation is done, add current indices in last position of deque

if current i is >= than (k-1) [ i starts from 0]
    add in resultant array the nums[indices from first position of deque]

TC : O(n) since each element is processed (add/remove) at most twice.
SC : o(k)

 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int nums[] = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new SlidingWindowMaximum().maxSlidingWindow(nums,k);
        Arrays.stream(res).forEach(value -> System.out.print(value+" "));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n-k+1];

        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);
            if(i >= k-1){
                res[i-k+1]=nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
