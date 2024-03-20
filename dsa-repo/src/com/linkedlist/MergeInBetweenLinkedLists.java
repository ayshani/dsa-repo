package com.linkedlist;
/*
1669. Merge In Between Linked Lists

You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

Build the result list and return its head.
Example 1:
Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [10,1,13,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place.
The blue edges and nodes in the above figure indicate the result.

TC : o(n)
SC: o(1)
 */
public class MergeInBetweenLinkedLists {

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(1);
        head.next.next =  new ListNode(13);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1000000);
        head2.next = new ListNode(1000001);
        head2.next.next =  new ListNode(1000002);
        ListNode headResult = new MergeInBetweenLinkedLists().mergeInBetween(head, 3,4,head2);
        new PrintLinkedList().print(headResult);
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1, tempStart = list1;
        for(int i=0;i<b && list1!=null;i++){
            if(i==a-1){
                tempStart = list1;
            }
            list1 = list1.next;
        }

        //System.out.println(tempStart.val +" "+ list1.val);
        tempStart.next = list2;
        while(list2.next!=null){
            list2 = list2.next;
        }
        list2.next=list1.next;
        return head;
    }
}
