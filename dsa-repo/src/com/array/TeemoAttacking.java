package com.array;
/*
495. Teemo Attacking

Our hero Teemo is attacking an enemy Ashe with poison attacks!
When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration seconds.
More formally, an attack at second t will mean Ashe is poisoned during the inclusive time interval
[t, t + duration - 1]. If Teemo attacks again before the poison effect ends, the timer for it is reset,
and the poison effect will end duration seconds after the new attack.

You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that
Teemo attacks Ashe at second timeSeries[i], and an integer duration.

Return the total number of seconds that Ashe is poisoned.

Example 1:

Input: timeSeries = [1,4], duration = 2
Output: 4
Explanation: Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.

Logic
------
Initiate total time in poisoned condition total = 0.

Iterate over timeSeries list. At each step add to the total time the minimum
between interval length and the poisoning time duration duration.

Return total + duration to take the last attack into account.

TC : o(n)
SC : o(1)
 */
public class TeemoAttacking {

    public static void main(String[] args) {
        int[] timeS = new int[]{1,4};
        int duration =2;
        System.out.println(new TeemoAttacking().findPoisonedDuration(timeS,duration));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;

        if(n==0)
            return 0;

        int total =0;

        for(int i=0;i<n-1;i++){
            total+= Math.min(timeSeries[i+1]-timeSeries[i],duration);
        }

        return total+duration;
    }
}
