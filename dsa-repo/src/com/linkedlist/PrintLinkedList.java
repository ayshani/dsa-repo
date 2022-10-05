package com.linkedlist;

public class PrintLinkedList {

    public void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public void printList(ListNode[] head){
        for(int i=0;i<head.length;i++){
            print(head[i]);
            System.out.println();
        }
    }
}
