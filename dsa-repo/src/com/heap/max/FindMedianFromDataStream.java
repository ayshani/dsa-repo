package com.heap.max;

import java.util.Collections;
import java.util.PriorityQueue;

/*
295. Find Median from Data Stream

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0

Logic
-------
MaxHeap to store a half of low numbers, MinHeap to store a half of high numbers

The idea is to divide numbers into 2 balanced halves, one half low stores low numbers,
the other half high stores high numbers. To access the median in O(1), we need a data structure that give us the
maximum of low half and the minimum of high half in O(1). That's where maxHeap and minHeap come into play.

We use maxHeap to store a half of low numbers, top of the maxHeap is the highest number among low numbers.

We use minHeap to store a half of high numbers, top of the minHeap is the lowest number among high numbers.

We need to balance the size between maxHeap and minHeap while processing. Hence after adding k elements,
If k = 2 * i then maxHeap.size = minHeap.size = i
If k = 2 * i + 1, let maxHeap store 1 element more than minHeap, then maxHeap.size = minHeap.size + 1.

When adding a new number num into our MedianFinder:
Firstly, add num to the maxHeap, now maxHeap may contain the big element (which should belong to minHeap).
So we need to balance, by removing the highest element from maxHeap, and offer it to minHeap.
Now, the minHeap might hold more elements than maxHeap, in that case, we need to balance the size,
by removing the lowest element from minHeap and offer it back to maxHeap.

When doing findMedian():
If maxHeap.size > minHeap.size return top of the maxHeap, which is the highest number amongs low numbers.
Else if maxHeap.size == minHeap return the (maxHeap.top() + minHeap.top()) / 2.

Complexity

Time:
Constructor: O(1)
addNum: O(logN)
findMedian: O(1)
Space: O(N)
 */
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size())
            return maxHeap.peek();

        return (maxHeap.peek() + minHeap.peek())/2.0;
    }
}
