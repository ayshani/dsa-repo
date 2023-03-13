package com.math;
/*
Maximum Possible Value

https://practice.geeksforgeeks.org/problems/2d3fc3651507fc0c6bd1fa43861e0d1c43d4b8a1/1

Given two arrays A[] and B[] of same length N. There are N types of sticks of lengths specified.
Each stick of length A[i] is present in B[i] units (i=1 to N). You have to construct the squares and rectangles
using these sticks. Each unit of a stick can be used as length or breadth of a rectangle or as a side of square.
A single unit of a stick can be used only once.

Let S be the sum of lengths of all sticks that are used in constructing squares and rectangles.
The task is to calulate the maximum possible value of S.

Example 1:

Input:
N = 4
A[] = {3,4,6,5}
B[] = {2,3,1,6}
Output:
38
Explanation:
There are 2 sticks of length 3.
There are 3 sticks of length 4.
There is a 1 stick of length 6.
There are 6 sticks of length 5.
One square can be made using 4 sticks of
4th kind (5*4=20)
A rectangle can be made using 2 sticks of
4th kind and 2 sticks of 2nd kind (5*2+4*2=18)
S = 20 + 18 = 38

TC: o(n)
SC: o(1)
 */
public class MaximumPossibleValue {

    public static void main(String[] args) {
        int[] A = new int[]{3,4,6,5} , B = new int[]{2,3,1,6};

        System.out.println(new MaximumPossibleValue().maxPossibleValue(4,A,B));
    }
    long maxPossibleValue(int N, int A[] ,int B[]) {
        // code here
        long answer =0, min = Long.MAX_VALUE, sticks=0;

        for(int i=0;i<N;i++){
            long length = A[i], count = B[i];

            // check if count is even or odd
            // if odd, make it even
            if((count&1)>0)
                count--;

            // incase count is even , get the min length
            if(count>=2){
                min = Math.min(min,length);
            }

            answer+= (length*count);
            sticks+=count;
        }

        // incase number of sticks is not divisible by 4
        // remove 2 from there to make it divisible
        // we are considering only 2 count as
        // we are already tkaing care of odd remainder in the above loop. Hence we can get nly remainder
        // as 0,2.
        // Hence in case of remainder 2, we need to remove two sticks are this two sticks shud be of minimum length
        // as we need to consider maximum length first
        if(sticks%4!=0){
            answer -= (2l*min);
        }

        return answer;
    }
}
