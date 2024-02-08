package com.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
279. Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words,
it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.



Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

// Time complexity: O(N * sqrt(N))
// Space complexity: O(N)
 */
public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }
    public int numSquaresv2(int n) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(n);
        int l=0;
        while(!q.isEmpty()){
            int size = q.size();
            l++;
            while(size-->0){
                int no = q.poll();
                for(int i=1;i*i<=no;i++){
                    int sub = no - i*i;
                    if(sub==0)
                        return l;
                    q.offer(sub);
                }
            }
        }
        return 0;
    }

    // DP approach
    public int numSquares(int n) {
        int[] memo = new int[n+1];

        return util(n, memo);
    }

    private int util(int n, int[] memo){
        if(n<4)
            return n;
        if(memo[n]!= 0)
            return memo[n];
        int ans =n;
        for(int i=1;i*i<=n;i++){
            int square = i*i;
            ans = Math.min(ans, 1 + util(n- square, memo));
        }
        return ans;
    }
}
