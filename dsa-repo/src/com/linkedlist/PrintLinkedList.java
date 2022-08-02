package com.linkedlist;

public class PrintLinkedList {

    public void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
