package com.slidingwindow;

import com.graph.bfs.JumpGameIV;

import java.util.ArrayDeque;
import java.util.Deque;

/*
1696. Jump Game VI

You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside
the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)]
inclusive.

You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index
j you visited in the array.

Return the maximum score you can get.

Example 1:

Input: nums = [1,-1,-2,4,-7,3], k = 2
Output: 7
Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.

TC : o(n)
SC: o(n)
 */
public class JumpGameVI {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-2,4,-7,3};
        System.out.println(new JumpGameIV().minJumps(nums));
    }
    public int maxResult(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.offer(0);
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[dq.peekFirst()]+ nums[i];
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i])
                dq.pollLast();
            dq.offerLast(i);
            if(i - dq.peekFirst()>=k)
                dq.pollFirst();
        }
        return nums[nums.length-1];
    }

}
