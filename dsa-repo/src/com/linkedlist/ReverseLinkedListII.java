package com.linkedlist;
/*
92. Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of
the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

TC : o(n)
SC: o(1)
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);
        new PrintLinkedList().print(new ReverseLinkedListII().reverseBetween(head,3,5));
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null, cur = head;

        while(left>1){
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }

        ListNode tail = cur, start = prev;

        while(right>0){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            right--;
        }

        if(start != null)
            start.next = prev;
        else
            head = prev;
        tail.next = cur;
        return head;
    }
}
