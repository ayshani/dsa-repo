package com.math;
/*
1359. Count All Valid Pickup and Delivery Options


Given n orders, each order consist in pickup and delivery services.

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).

Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:

Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.

Intuition 1
Assume we have already n - 1 pairs, now we need to insert the nth pair.
To insert the first element, there are n * 2 - 1 chioces of position。
To insert the second element, there are n * 2 chioces of position。
So there are (n * 2 - 1) * n * 2 permutations.
Considering that delivery(i) is always after of pickup(i), we need to divide 2.
So it's (n * 2 - 1) * n.


Intuition 2
We consider the first element in all 2n elements.
The first must be a pickup, and we have n pickups as chioce.
Its pair can be any position in the rest of n*2-1 positions.
So it's (n * 2 - 1) * n.


Intuition 3
The total number of all permutation obviously eauqls to 2n!.
For each pair, the order is determined, so we need to divide by 2.
So the final result is (2n)!/(2^n)


Complexity
For each run, Time O(N), Space O(1).
Also we can cache the result, so that O(1) amortized for each n.
But in doesn't help in case of LC.
Also we can pre calculate all results, so that we have O(N) space and O(1) time.



 */
public class CountAllValidPickupAndDeliveryOptions {

    public static void main(String[] args) {
        System.out.println(new CountAllValidPickupAndDeliveryOptions().countOrders(2));
    }
    public int countOrders(int n) {
        long res = 1, mod = (long)1e9+7;
        for(int i=1;i<=n;i++){
            res = res * (i*2-1)*i%mod;
        }
        return (int)res;
    }

}
