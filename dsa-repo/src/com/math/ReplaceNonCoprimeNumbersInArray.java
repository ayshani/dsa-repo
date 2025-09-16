package com.math;

import java.util.LinkedList;
import java.util.List;

/*
2197. Replace Non-Coprime Numbers in Array

You are given an array of integers nums. Perform the following steps:

Find any two adjacent numbers in nums that are non-coprime.
If no such numbers are found, stop the process.
Otherwise, delete the two numbers and replace them with their LCM (Least Common Multiple).
Repeat this process as long as you keep finding two adjacent non-coprime numbers.
Return the final modified array. It can be shown that replacing adjacent non-coprime numbers in any arbitrary order will lead to the same result.

The test cases are generated such that the values in the final array are less than or equal to 108.

Two values x and y are non-coprime if GCD(x, y) > 1 where GCD(x, y) is the Greatest Common Divisor of x and y.



Example 1:

Input: nums = [6,4,3,2,7,6,2]
Output: [12,7,6]
Explanation:
- (6, 4) are non-coprime with LCM(6, 4) = 12. Now, nums = [12,3,2,7,6,2].
- (12, 3) are non-coprime with LCM(12, 3) = 12. Now, nums = [12,2,7,6,2].
- (12, 2) are non-coprime with LCM(12, 2) = 12. Now, nums = [12,7,6,2].
- (6, 2) are non-coprime with LCM(6, 2) = 6. Now, nums = [12,7,6].
There are no more adjacent non-coprime numbers in nums.
Thus, the final modified array is [12,7,6].
Note that there are other ways to obtain the same resultant array.

Explanation :
For each number a in input array nums,
check if it is coprime with the last number b in res.
If it's not coprime, then we can merge them by calculating a * b / gcd(a, b).
and check we can continue to do this process.

Until it's coprime with the last element in res,
we append a at the end of res.



TC : o(nlogn)
SC: o(n)
 */
public class ReplaceNonCoprimeNumbersInArray {

    public static void main(String[] args) {
        System.out.println(new ReplaceNonCoprimeNumbersInArray().replaceNonCoprimes(new int[]{6,4,3,2,7,6,2}));
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> res = new LinkedList();
        for (int a : nums) {
            while(true){
                int last = res.isEmpty() ? 1 : res.getLast();
                int x = gcd(last,a);
                if(x==1)
                    break;
                a *= res.removeLast() / x;
            }
            res.add(a);
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
