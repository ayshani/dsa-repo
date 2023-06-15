package com.linkedlist;
/*
143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]


TC: o(n)
SC: o(1)
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);
        new ReorderList().reorderList(head);
        new PrintLinkedList().print(head);
    }
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow =slow.next;
        }

        ListNode revHead = reverse(slow.next);
        slow.next = null;

        while(head!= null && revHead != null){
            ListNode temp1 = head.next, temp2 = revHead.next;
            revHead.next = head.next;
            head.next = revHead;
            revHead =temp2;
            head = temp1;
        }
    }

    private ListNode reverse(ListNode node){
        ListNode cur = node, prev = null;
        while(cur!=null){
            ListNode forward = cur.next;
            cur.next = prev;
            prev =cur;
            cur = forward;
        }
        return prev;
    }
}
