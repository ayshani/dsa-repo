package com.linkedlist;
/*
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

TC : o(n)
SC: o(1)
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);
        new PrintLinkedList().print(ReverseLinkedList.reverse(head));
    }
    public static ListNode reverse(ListNode head){
        ListNode cur = head, prev = null;
        while(cur !=null){
            ListNode forward = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forward;
        }

        return prev;
    }
}
