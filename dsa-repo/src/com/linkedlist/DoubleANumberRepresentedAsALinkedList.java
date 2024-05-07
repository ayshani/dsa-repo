package com.linkedlist;
/*
2816. Double a Number Represented as a Linked List

You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

Example 1:
Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189.
Hence, the returned linked list represents the number 189 * 2 = 378

TC : o(n)
SC: o(1)
 */
public class DoubleANumberRepresentedAsALinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        new PrintLinkedList().print(new DoubleANumberRepresentedAsALinkedList().doubleIt(head));
    }
    public ListNode doubleIt(ListNode head) {
        // reverse the linkedlist
        head = reverse(head);
        ListNode prev = head, temp = head;

        // have one carry over
        int carry =0;

        // iterate over the while list and doubling it.
        while(head != null){
            head.val *=2;
            head.val += carry;
            if(head.val >9){
                carry = head.val/10;
                head.val %= 10;
            } else{
                carry =0;
            }
            prev = head;
            head = head.next;
        }
        if(carry >0){
            prev.next = new ListNode(carry);
            prev = prev.next;
        }

        head = reverse(temp);
        return head;
    }

    ListNode reverse(ListNode head){
        ListNode cur = head, prev = null;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
