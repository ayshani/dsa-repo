package com.linkedlist;
/*
445. Add Two Numbers II

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
 */
public class AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next =  new ListNode(1);
        head.next.next.next = new ListNode(9);

        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next =  new ListNode(1);
        new PrintLinkedList().print(new AddTwoNumbersII().addTwoNumbers(head,head1));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l2);

        int totalSum =0, carry =0;
        ListNode ans = new ListNode();
        while(rev1!=null || rev2 != null){
            if(rev1!=null)
                totalSum+= rev1.val;
            if(rev2!=null)
                totalSum+= rev2.val;
            ans.val = totalSum%10;
            carry = totalSum/10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;
            rev1 = rev1!=null ? rev1.next : null;
            rev2 = rev2!=null ? rev2.next : null;
        }
        return carry == 0 ? ans.next : ans;
    }

    private ListNode reverse(ListNode head){
        ListNode cur = head, prev = null;
        while(cur!=null){
            ListNode forward = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forward;
        }
        return prev;
    }
}
