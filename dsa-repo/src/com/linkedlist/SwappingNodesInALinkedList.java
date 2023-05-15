package com.linkedlist;
/*
1721. Swapping Nodes in a Linked List

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning
and the kth node from the end (the list is 1-indexed).

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
 */
public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);
        new SwappingNodesInALinkedList().swapNodes(head,2);
        new PrintLinkedList().print(head);
    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow = head;

        for(int i=0;i<k-1;i++)
            fast= fast.next;

        ListNode first = fast;

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode second = slow;

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}
