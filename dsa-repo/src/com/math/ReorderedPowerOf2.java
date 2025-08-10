package com.math;
/*
869. Reordered Power of 2

You are given an integer n. We reorder the digits in any order (including the original order)
such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false

counter will counter the number of digits 9876543210 in the given number.
Then I just compare counter(N) with all counter(power of 2).
1 <= N <= 10^9, so up to 8 same digits.
If N > 10^9, we can use a hash map.

TC : o(logn + 32*logi)
SC : o(1)
 */
public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(652));
    }
    public boolean reorderedPowerOf2(int n) {
        long c =  counter(n);

        for(int i=0;i<32;i++){

            int num = (int) counter(1<<i);
            System.out.println(i+" "+ (1<<i) +" " + num);
            if(counter(1<<i)==c)
                return true;
        }
        return false;
    }

    long counter(int N){
        long res =0;
        for(;N>0;N/=10){
            res+= (int)Math.pow(10,N%10);
        }

        return res;
    }
}
