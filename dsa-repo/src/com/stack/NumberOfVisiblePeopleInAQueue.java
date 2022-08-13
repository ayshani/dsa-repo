package com.stack;

import java.util.Arrays;
import java.util.Stack;

/*
1944. Number of Visible People in a Queue

There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order.
You are given an array heights of distinct integers where heights[i] represents the height of the ith person.

A person can see another person to their right in the queue if everybody in between is shorter than both of them.
More formally, the ith person can see the jth person if i < j and
min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]).

Return an array answer of length n where answer[i] is the number of people the ith person can see to
their right in the queue.


Example 1:
Input: heights = [10,6,8,5,11,9]
Output: [3,1,2,1,1,0]
Explanation:
Person 0 can see person 1, 2, and 4.
Person 1 can see person 2.
Person 2 can see person 3 and 4.
Person 3 can see person 4.
Person 4 can see person 5.
Person 5 can see no one since nobody is to the right of them.

Logic
------
use stack and store maximum from right to left to a specific number.
So when we get one max number we pop until we get another maximum number from stack and have one count incrementing.
So, till that maximum number, we can see. Hence once the popping is done,
if stack has any element that means we see that number also. hence count is incremented once more.

TC : o(n)
SC : o(n)
 */
public class NumberOfVisiblePeopleInAQueue {

    public static void main(String[] args) {
        int[] heights = new int[]{10,6,8,5,11,9};

        int res[] = new NumberOfVisiblePeopleInAQueue().canSeePersonsCount(heights);

        Arrays.stream(res).forEach(element -> System.out.print(element +" "));
    }
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
            int count = 0;

            while(!st.isEmpty() && heights[i]> st.peek()){
                st.pop();
                count++;
            }
            if(!st.isEmpty()){
                count++;
            }

            st.push(heights[i]);
            res[i] = count;
        }

        return res;
    }
}
