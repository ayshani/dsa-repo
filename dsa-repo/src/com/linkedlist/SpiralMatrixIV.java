package com.linkedlist;

import java.util.Arrays;

/*
2326. Spiral Matrix IV

You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise),
starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.



Example 1:
Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1.

TC : o(n)
SC: o(1)
 */
public class SpiralMatrixIV {

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);
        int[][] res = new SpiralMatrixIV().spiralMatrix(3,2, head);
        Arrays.stream(res).forEach(e -> System.out.println(Arrays.toString(e)));
    }
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix =  new int[m][n];
        System.out.println(n + " "+m);
        ListNode temp = head;
        int fr=0,fc=0,lr=m-1,lc=n-1;
        while(fr<=lr && fc<=lc){
            for(int i=fc;i<=lc;i++){
                //System.out.println(i);
                if(temp!=null) {
                    //System.out.println(temp.val + " ");
                    matrix[fr][i] = temp.val;
                    //System.out.print(matrix[fr][i] + " ");
                    temp=temp.next;
                }
                else
                    matrix[fr][i] = -1;
            }
            fr++;
            for(int i=fr;i<=lr;i++){
                if(temp!=null) {
                    //System.out.print(temp.val + " ");
                    matrix[i][lc] = temp.val;
                    temp=temp.next;
                }
                else
                    matrix[i][lc] = -1;
            }
            lc--;
            if(fr<lr){
                for(int i=lc;i>=fc;i--){
                    if(temp!=null) {
                        // System.out.print(temp.val + " ");
                        matrix[lr][i] = temp.val;
                        temp=temp.next;
                    }
                    else
                        matrix[lr][i] = -1;
                }
                lr--;
            }
            if(fc<lc){
                for(int i=lr;i>=fr;i--){
                    if(temp!=null) {
                        // System.out.print(temp.val + " ");
                        matrix[i][fc] = temp.val;
                        temp=temp.next;
                    }
                    else
                        matrix[i][fc] = -1;
                }
                fc++;
            }
        }

        return matrix;
    }
}
