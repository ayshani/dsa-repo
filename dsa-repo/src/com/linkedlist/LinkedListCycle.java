package com.linkedlist;
/*
141. Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

TC : o(n)
SC : o(n)
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(new LinkedListCycle().hasCycle(head));
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast = fast.next.next;
            if(fast==slow)
                return true;
        }

        return false;
    }
}
