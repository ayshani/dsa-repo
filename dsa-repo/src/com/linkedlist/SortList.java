package com.linkedlist;
/*
148. Sort List

Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

TC : o(n)
SC: o(logn)
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);
        new PrintLinkedList().print(new SortList().sortList(head));
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode slow = head, fast = head, temp = head;
        while(fast!=null && fast.next!=null){
            temp =slow;
            slow= slow.next;
            fast = fast.next.next;
        }

        temp.next = null;

        ListNode first = sortList(head);
        ListNode sec = sortList(slow);
        return mergeList(first, sec);
    }

    private ListNode mergeList(ListNode first, ListNode sec){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(first!=null && sec!=null){
            if(first.val<= sec.val){
                cur.next = first;
                first = first.next;
            } else{
                cur.next = sec;
                sec = sec.next;
            }
            cur = cur.next;
        }

        if(first!=null){
            cur.next = first;
        }
        if(sec !=null){
            cur.next = sec;
        }

        return head.next;
    }
}
