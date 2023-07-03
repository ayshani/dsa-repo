package com.array;

import java.util.*;

/*
6916. Prime Pairs With Target Sum
You are given an integer n. We say that two integers x and y form a prime number pair if:

1 <= x <= y <= n
x + y == n
x and y are prime numbers
Return the 2D sorted list of prime number pairs [xi, yi]. The list should be sorted in increasing order of xi.
If there are no prime number pairs at all, return an empty array.

Note: A prime number is a natural number greater than 1 with only two factors, itself and 1.



Example 1:

Input: n = 10
Output: [[3,7],[5,5]]
Explanation: In this example, there are two prime pairs that satisfy the criteria.
These pairs are [3,7] and [5,5], and we return them in the sorted order as described in the problem statement.
Example 2:

Input: n = 2
Output: []
Explanation: We can show that there is no prime number pair that gives a sum of 2, so we return an empty array.


Constraints:

1 <= n <= 106

TC : oO(n*log(log(n)))
SC: o(n)
Ref : https://www.geeksforgeeks.org/sieve-of-eratosthenes/
 */
public class PrimePairsWithTargetSum {

    public static void main(String[] args) {
        System.out.println(new PrimePairsWithTargetSum().findPrimePairs(10));
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n<2)
            return result;
        boolean[] isPrimeCheck = new boolean[n+1];
        Arrays.fill(isPrimeCheck, true);
        isPrimeCheck[0] =false;
        isPrimeCheck[1]= false;
        //O(n*log(log(n)))
        filluptAllPrimes(isPrimeCheck, n);

        Set<Integer> set = new HashSet<>();
        if(isPrimeCheck[n-2]){
            result.add(List.of(2,n-2));
            set.add(2);
            set.add(n-2);
        }
        for(int i=3;i<n;i++){
            if(isPrimeCheck[i] && !set.contains(i) && !set.contains(n-i) &&  isPrimeCheck[n-i]){
                result.add(List.of(i,n-i));
                set.add(i);
                set.add(n-i);
            }
        }
        return result;
    }
    void filluptAllPrimes(boolean[] isPrimeCheck, int n){
        for(int i=2;i*i<=n;i++){
            if(isPrimeCheck[i]){
                for(int j= i*i;j<=n;j+=i){
                    isPrimeCheck[j] = false;
                }
            }
        }
    }
}
