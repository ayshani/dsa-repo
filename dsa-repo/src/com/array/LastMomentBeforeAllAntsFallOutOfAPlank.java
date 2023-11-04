package com.array;
/*
1503. Last Moment Before All Ants Fall Out of a Plank

We have a wooden plank of the length n units. Some ants are walking on the plank, each ant moves with a speed of 1 unit
per second. Some of the ants move to the left, the other move to the right.

When two ants moving in two different directions meet at some point, they change their directions and continue moving
again. Assume changing directions does not take any additional time.

When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.

Given an integer n and two integer arrays left and right, the positions of the ants moving to the left and the right,
return the moment when the last ant(s) fall out of the plank.



Example 1:
Input: n = 4, left = [4,3], right = [0,1]
Output: 4
Explanation: In the image above:
-The ant at index 0 is named A and going to the right.
-The ant at index 1 is named B and going to the right.
-The ant at index 3 is named C and going to the left.
-The ant at index 4 is named D and going to the left.
The last moment when an ant was on the plank is t = 4 seconds. After that, it falls immediately out of the plank.
(i.e., We can say that at t = 4.0000000001, there are no ants on the plank).
 TC : o(n)
 SC: o(1)
 */
public class LastMomentBeforeAllAntsFallOutOfAPlank {

    public static void main(String[] args) {
        System.out.println(new LastMomentBeforeAllAntsFallOutOfAPlank().
                getLastMoment(4, new int[]{4,3}, new int[]{0,1}));
    }
    public int getLastMoment(int n, int[] left, int[] right) {
        if(n==0)
            return 0;
        int max =0;
        // basically, we have to cover the whole plank length to fall off.
        // suppose there is no clause and no direction change, A->-> and B<-<-.
        // so, we need to take how much max one has to travel to fall off form that particular position
        for(int num : left){
            max = Math.max(num, max);
        }

        for(int num : right){
            max = Math.max(n - num, max);
        }
        return max;
    }
}
