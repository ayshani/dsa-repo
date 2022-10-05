package com.math;
/*
204. Count Primes

Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Logic
------
This algorithm eliminates all the composite numbers, so that you are finally left with only the prime ones.
We start with a number, if it is prime, then we mark all its multiples. We do this iteratively.

TC : o(n)
SC : o(n)

 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(20));
    }
    public int countPrimes(int n) {
        if(n<2)
            return 0;
        boolean[] isComposite = new boolean[n+1];

        for(int i=2;i<=Math.sqrt(n+1);i++){
            if(!isComposite[i]){
                for(int j=i+i;j<n;j+=i){
                    isComposite[j]= true;
                }
            }
        }
        int count =0;
        for(int i=2;i<n;i++)
        {
            if(!isComposite[i])
                count++;
        }

        return count;
    }
}
