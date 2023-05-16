package com.linkedlist;
/*
24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem
without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

TC: o(n)
SC: o(1)s
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);
        new PrintLinkedList().print(new SwapNodesInPairs().swapPairs(head));
    }
    public ListNode swapPairs(ListNode head) {
        if(head== null || head.next==null)
            return head;

        ListNode temp = head;
        head = head.next;

        temp.next = swapPairs(head.next);
        head.next = temp;
        return head;
    }
}
