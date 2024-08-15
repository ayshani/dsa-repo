package com.math;
/*
860. Lemonade Change

At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at
a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5,
$10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the
 customer pays $5.

Note that you do not have any change in hand at first.

Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide
every customer with the correct change, or false otherwise.



Example 1:

Input: bills = [5,5,5,10,20]
Output: true
Explanation:
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.

TC : o(n)
SC: o(1)
 */
public class LemonadeChange {

    public static void main(String[] args) {
        System.out.println(new LemonadeChange().lemonadeChange(new int[]{5,5,5,10,20}));
    }
    public boolean lemonadeChange(int[] bills) {
        // Count of $5 and $10 bills in hand
        int fiveDollarBills = 0;
        int tenDollarBills = 0;

        // Iterate through each customer's bill
        for (int customerBill : bills) {
            if (customerBill == 5) {
                // Just add it to our count
                fiveDollarBills++;
            } else if (customerBill == 10) {
                // We need to give $5 change
                if (fiveDollarBills > 0) {
                    fiveDollarBills--;
                    tenDollarBills++;
                } else {
                    // Can't provide change, return false
                    return false;
                }
            } else { // customerBill == 20
                // We need to give $15 change
                if (tenDollarBills > 0 && fiveDollarBills > 0) {
                    // Give change as one $10 and one $5
                    fiveDollarBills--;
                    tenDollarBills--;
                } else if (fiveDollarBills >= 3) {
                    // Give change as three $5
                    fiveDollarBills -= 3;
                } else {
                    // Can't provide change, return false
                    return false;
                }
            }

        }
        // If we've made it through all customers, return true
        return true;
    }
}
