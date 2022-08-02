package com.linkedlist;

public class ReverseLinkedList {

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
