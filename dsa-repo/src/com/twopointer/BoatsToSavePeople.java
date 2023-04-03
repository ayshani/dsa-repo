package com.twopointer;

import java.util.Arrays;

/*
881. Boats to Save People

You are given an array people where people[i] is the weight of the ith person, and an infinite number
of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the
same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.



Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

TC : o(nlogn)
SC : o(1)
 */
public class BoatsToSavePeople {

    public static void main(String[] args) {
        int[] p = new int[]{1,2};

        System.out.print(new BoatsToSavePeople().numRescueBoats(p,3));
    }
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l =0, r = people.length-1, count=0;

        while(l<=r){
            int sum = people[l]+ people[r];
            if(sum<=limit){
                count++;
                l++;
                r--;
            } else {
                count++;
                r--;
            }
        }

        return count;
    }
}
