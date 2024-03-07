package com.linkedlist;
/*
876. Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.


Logic
----------------
Have a fast node and slow node.
slow will increment by one pace.
fast will increment by 2 pace.
when fast become null, slow is right at the middle position

TC : o(n)
SC :  o(1)
 */
public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(new MiddleOfTheLinkedList().middleNode(head).val);
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
