package com.binarysearch;
/*
441. Arranging Coins

You have n coins and you want to build a staircase with these coins.
The staircase consists of k rows where the ith row has exactly i coins.
The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:
Input: n = 5
$
$ $
$ $ _
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Logic
-------
we need to think with the perspective of n number (1....n) summation.
for n=1 -> 1
    n =2 -> 1+2 =3
    n = 3 -> 1+2+3 = 6

Now we need to find the last completely filled row.
so, we start with mid row, check till that row if all the total from 1... mid_row == n
    If yes -> return mid row
    if < n -> we increment low by 1
    else    decrement high by 1

finally return high

TC : o(logn)
SC : o(1)

 */
public class ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(5));
    }

    public int arrangeCoins(int n) {
        long low=0,high=n;
        long midRow,curSumTillMidRow;

        while(low<=high){
            midRow = low+(high-low)/2;
            curSumTillMidRow = midRow*(midRow+1)/2;

            if(curSumTillMidRow==n)
                return (int)midRow;
            if(n<curSumTillMidRow)
                high= midRow-1;
            else
                low = midRow+1;
        }

        return (int)high;
    }
}
