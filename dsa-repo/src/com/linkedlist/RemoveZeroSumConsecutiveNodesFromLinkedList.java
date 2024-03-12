package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
1171. Remove Zero Sum Consecutive Nodes from Linked List

Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there
are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.



(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next =  new ListNode(3);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(1);
        new RemoveZeroSumConsecutiveNodesFromLinkedList().removeZeroSumSublists(head);
        new PrintLinkedList().print(head);
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefix =0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer,ListNode> map = new HashMap<>();
        for(ListNode node = dummy; node != null; node = node.next){
            prefix += node.val;
            map.put(prefix, node);
        }

        prefix =0;
        for(ListNode node = dummy; node != null; node = node.next){
            prefix += node.val;
            node.next = map.get(prefix).next;
        }

        return dummy.next;
    }
}
