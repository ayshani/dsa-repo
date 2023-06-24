package com.slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
480. Sliding Window Median

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
So the median is the mean of the two middle values.

For examples, if arr = [2,3,4], the median is 3.
For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from
the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding
window moves right by one position.

Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
Explanation:
Window position                Median
---------------                -----
[1  3  -1] -3  5  3  6  7        1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7        3
 1  3  -1  -3 [5  3  6] 7        5
 1  3  -1  -3  5 [3  6  7]       6

 Logic
 ------
Use two Heaps to store numbers.
maxHeap for numbers smaller than current median, minHeap for numbers bigger than and equal to current median.
A small trick I used is always make size of maxHeap equal (when there are even numbers) or 1 element more
(when there are odd numbers) than the size of minHeap. Then it will become very easy to calculate current median.
Keep adding number from the right side of the sliding window and remove number from left side of the sliding window.
And keep adding current median to the result.

TC : o(n*logK + n*k)
SC : o(k)
 */
public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,2,3,1,4,2};
        double[] res = new SlidingWindowMedian().medianSlidingWindow(nums,3);
        Arrays.stream(res).forEach( value -> System.out.print(value +" "));
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n -k+1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            if(maxHeap.size()<=minHeap.size()){
                minHeap.offer(nums[i]);
                maxHeap.offer(minHeap.poll());
            } else{
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
            }

            if(maxHeap.size() + minHeap.size() == k){
                double median =0;

                if(maxHeap.size() > minHeap.size()){
                    median = (double) maxHeap.peek();
                } else
                    median = (double)((long)maxHeap.peek() + (long)minHeap.peek())/2.0;

                int start = i-k+1;
                result[start] =median;
                if(!maxHeap.remove(nums[start]))
                    minHeap.remove(nums[start]);
            }
        }

        return result;
    }
}
