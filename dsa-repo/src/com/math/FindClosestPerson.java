package com.math;
/*
3516. Find Closest Person

You are given three integers x, y, and z, representing the positions of three people on a number line:

x is the position of Person 1.
y is the position of Person 2.
z is the position of Person 3, who does not move.
Both Person 1 and Person 2 move toward Person 3 at the same speed.

Determine which person reaches Person 3 first:

Return 1 if Person 1 arrives first.
Return 2 if Person 2 arrives first.
Return 0 if both arrive at the same time.
Return the result accordingly.



Example 1:

Input: x = 2, y = 7, z = 4

Output: 1

Explanation:

Person 1 is at position 2 and can reach Person 3 (at position 4) in 2 steps.
Person 2 is at position 7 and can reach Person 3 in 3 steps.
Since Person 1 reaches Person 3 first, the output is 1.

TC : o(1)
SC: o(1)
 */
public class FindClosestPerson {

    public static void main(String[] args) {
        System.out.println(new FindClosestPerson().findClosest(2,7,4));
    }
    public int findClosest(int x, int y, int z) {
        int diff1 = Math.abs(x-z), diff2 = Math.abs(y-z);
        return diff1 < diff2 ? 1 : ( diff1>diff2 ? 2 : 0);
    }
}
