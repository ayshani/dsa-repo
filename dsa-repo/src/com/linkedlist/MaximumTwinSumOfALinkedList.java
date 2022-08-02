package com.linkedlist;
/*
2130. Maximum Twin Sum of a Linked List

n a linked list of size n, where n is even,
the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3,
and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.

Example 1:

Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6.

Logic
--------
get middle of the list
reverse the list from mid to end
once reversed, add (first.val+ mid.val) and store the global maxVal.

TC : o(n)
SC : o(1)
 */
public class MaximumTwinSumOfALinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(new MaximumTwinSumOfALinkedList().pairSum(head));
    }

    public int pairSum(ListNode head) {
        ListNode slow=head, fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow;
        ListNode cur = head;
        ListNode rev = ReverseLinkedList.reverse(slow);

        int maxSum =0;

        while(cur!= slow && rev!=null){
            int sum = cur.val+rev.val;
            maxSum = Math.max(maxSum,sum);
            cur = cur.next;
            rev = rev. next;
        }

        return maxSum;
    }


}


