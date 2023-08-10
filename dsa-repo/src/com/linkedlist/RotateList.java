package com.linkedlist;
/*
61. Rotate List

Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

TC : o(n)
SC: o(n)
 */
public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);
        new PrintLinkedList().print(new RotateList().rotateRight(head,2));
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next== null || k==0)
            return head;
        ListNode fast = head, slow = head;
        ListNode p = head;
        int len =0;
        while(p!=null){
            p=p.next;
            len++;
        }

        k%=len;
        if(k==0)
            return head;

        for(int i=1;i<=k;i++){
            fast = fast.next;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode tempHead = slow.next;
        slow.next = null;
        fast.next = head;
        return tempHead;

    }
}
