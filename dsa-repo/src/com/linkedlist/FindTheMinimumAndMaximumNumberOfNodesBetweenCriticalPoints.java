package com.linkedlist;

import java.util.Arrays;

/*
2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

A critical point in a linked list is defined as either a local maxima or a local minima.

A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.

A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.

Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.

Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is
the minimum distance between any two distinct critical points and maxDistance is the maximum distance between
any two distinct critical points. If there are fewer than two critical points, return [-1, -1].

Example :
Input: head = [5,3,1,2,5,1,2]
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.


TC : o(n)
SC: o(1)
 */
public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next =  new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);
        System.out.println(Arrays.toString(new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints()
                .nodesBetweenCriticalPoints(head)));
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1,-1};
        int minDistance = Integer.MAX_VALUE;

        ListNode previous = head, current = head.next;
        int curIndex = 1, prevCriticalIndex = 0, firstCriticalIndex = 0;

        while(current.next != null){
            if((current.val < previous.val && current.val < current.next.val) ||
                    (current.val > previous.val && current.val > current.next.val)){
                if(prevCriticalIndex==0){
                    prevCriticalIndex = curIndex;
                    firstCriticalIndex = curIndex;
                } else{
                    minDistance = Math.min(minDistance, curIndex - prevCriticalIndex);
                    prevCriticalIndex = curIndex;
                }
            }
            curIndex++;
            previous = current;
            current = current.next;
        }

        if(minDistance != Integer.MAX_VALUE){
            int maxDistance = prevCriticalIndex - firstCriticalIndex;
            result = new int[]{minDistance, maxDistance};
        }
        return result;
    }
}
