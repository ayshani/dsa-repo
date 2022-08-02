package com.linkedlist;
/*
19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]


 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);

        new RemoveNthNodeFromEndOfList().removeNthFromEnd(head,2);
        new PrintLinkedList().print(head);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;
        ListNode slow = head, fast = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        // edge case if n == len
        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
