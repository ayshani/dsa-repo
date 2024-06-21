package com.slidingwindow;
/*
1052. Grumpy Bookstore Owner

There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the
store. You are given an integer array customers of length n where customers[i] is the number of the customer that
enters the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the
bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can
only use it once.

Return the maximum number of customers that can be satisfied throughout the day.

Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.

TC : o(n)
SC: o(1)
 */
public class GrumpyBookstoreOwner {

    public static void main(String[] args) {
        System.out.println(new GrumpyBookstoreOwner()
                .maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int unsatisfiedCustomer = 0;
        // get first minutes number of unsatisfied customers
        for(int i=0;i<minutes; i++){
            unsatisfiedCustomer += customers[i]*grumpy[i];
        }
        // this can be a max unsatisfied customers
        int maxUnsatisfiedCustomer = unsatisfiedCustomer;

        // run over a sliding window of minutes
        // add the last and remove which is outside of the sliding window
        // get the max from each sliding window
        for(int i= minutes; i<n; i++){
            unsatisfiedCustomer += customers[i]*grumpy[i];
            unsatisfiedCustomer -= customers[i-minutes]*grumpy[i-minutes];

            maxUnsatisfiedCustomer = Math.max(maxUnsatisfiedCustomer, unsatisfiedCustomer);
        }

        // this will be initial total satisfied customers using the trick
        int totalCustomers = maxUnsatisfiedCustomer;

        // rest add the customers when owner is not grumpy
        for(int i=0;i<n;i++){
            totalCustomers += customers[i]*(1-grumpy[i]);
        }

        return totalCustomers;
    }
}
