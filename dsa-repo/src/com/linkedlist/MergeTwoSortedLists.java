package com.linkedlist;
/*
21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of
the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

TC : o(n)
SC: o(1)
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next =  new ListNode(4);
        node1.next.next =  new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next =  new ListNode(3);
        node2.next.next =  new ListNode(4);
        ListNode head = new MergeTwoSortedLists().mergeTwoLists(node1,node2);
        new PrintLinkedList().print(head);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }

    private ListNode merge(ListNode A, ListNode B) {
        if(A== null && B== null)
            return null;
        if(A== null)
            return B;
        if(B== null)
            return A;


        if(A.val<B.val){
            A.next = merge(A.next,B);
            return A;
        } else if(B.val<A.val){
            B.next =  merge(A,B.next);
            return B;
        }else{
            ListNode temp = A.next;
            A.next = B;
            A.next.next = merge(temp,B.next);
            return A;
        }

    }

}
