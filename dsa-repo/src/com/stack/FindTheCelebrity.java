package com.stack;

import java.util.Stack;

/*
277. Find the Celebrity

Suppose you are at a party with n people labeled from 0 to n - 1 and among them, there may exist one celebrity.
The definition of a celebrity is that all the other n - 1 people know the celebrity, but the celebrity does not
know any of them.

Now you want to find out who the celebrity is or verify that there is not one. You are only allowed to ask questions
like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity
(or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) that tells you whether a knows b. Implement a function int
findCelebrity(n). There will be exactly one celebrity if they are at the party.

Return the celebrity's label if there is a celebrity at the party. If there is no celebrity, return -1.

Example 1:
Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j,
otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because
both 0 and 2 know him but 1 does not know anybody.

Explanation
---------------
// In a nutshell

// The first loop is to find the candidate as the author explains. In detail,
// suppose the candidate after the first for loop is person k, it means 0 to k-1 cannot be the celebrity,
// because they know a previous or current candidate. Also, since k knows no one between k+1 and n-1,
// k+1 to n-1 can not be the celebrity either. Therefore, k is the only possible celebrity, if there exists one.

//The remaining job is to check if k indeed does not know any other persons and all other persons know k.

TC : o(n)
SC: o(n)
 */
public class FindTheCelebrity {

    public static void main(String[] args) {
        System.out.println(new FindTheCelebrity().findCelebrity(3));
    }
    public int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }

        while(st.size()>1){
            int a = st.pop();
            int b = st.pop();
            // if a knows b , a can not be celebrity, b is possibility , push b
            if(knows(a,b))
                st.push(b);
            else
                // if b knows a , b can not be celebrity, a is possibility , push a
                st.push(a);
        }

        int candidate = st.pop();
        for(int i=0;i<n;i++){
            if(i!=candidate && knows(candidate,i) && !knows(i,candidate))
                return -1;
        }
        return candidate;
    }

    private boolean knows(int a, int b) {
        int[][] graph = new int[][]{{1,1,0},{0,1,0},{1,1,1}};
        return graph[a][b]==1;
    }
}
