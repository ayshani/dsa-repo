package com.linkedlist;
/*
23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6


TC : o(n)
SC: o(n)S
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next =  new ListNode(4);
        node1.next.next =  new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next =  new ListNode(3);
        node2.next.next =  new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next =  new ListNode(6);

        ListNode [] nodelist = new ListNode[]{node1,node2,node3};

        ListNode res = new MergeKSortedLists().mergeKLists(nodelist);
        new PrintLinkedList().print(res);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        for(int i=1;i<lists.length;i++){
            lists[0] = merge(lists[0],lists[i]);
        }

        return lists[0];
    }

    public ListNode merge(ListNode A, ListNode B){
        if(A==null && B==null)
            return null;
        else if(A!=null && B==null)
            return A;
        else if(A==null && B!=null)
            return B;
        else{
            if(A.val<B.val){
                A.next=merge(A.next,B);
                return A;
            } else if(B.val<A.val){
                B.next=merge(A,B.next);
                return B;
            } else{
                ListNode tA= A.next;
                ListNode tB = B.next;
                A.next=B;
                A.next.next= merge(tA,tB);
                return A;
            }
        }
    }
}
