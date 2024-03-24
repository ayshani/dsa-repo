package com.math;
/*
3091. Apply Operations to Make Sum of Array Greater Than or Equal to k

You are given a positive integer k. Initially, you have an array nums = [1].

You can perform any of the following operations on the array any number of times (possibly zero):

Choose any element in the array and increase its value by 1.
Duplicate any element in the array and add it to the end of the array.
Return the minimum number of operations required to make the sum of elements of the final array greater than or
equal to k.



Example 1:

Input: k = 11

Output: 5

Explanation:

We can do the following operations on the array nums = [1]:

Increase the element by 1 three times. The resulting array is nums = [4].
Duplicate the element two times. The resulting array is nums = [4,4,4].
The sum of the final array is 4 + 4 + 4 = 12 which is greater than or equal to k = 11.
The total number of operations performed is 3 + 2 = 5.

TC : o(sqrt(n))
SC: o(1)
 */
public class ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualTok {

    public static void main(String[] args) {
        System.out.println(new ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualTok()
                .minOperations(11));
    }
    public int minOperations(int k) {
        if( k <= 1)
            return 0;

        int part = (int)Math.sqrt(k);
        int minCount =Integer.MAX_VALUE;
        for(int i=1;i<=part;i++){
            int q = (int)Math.round((k*1.0)/i);
            int count =0;
            if((q*i)>=k){
                count = (q-1) + (i-1);
            } else {
                count = (q - 1) + (i - 1) + (k % i);
            }
            minCount = Math.min(minCount, count);
        }
        return minCount;
    }
}
