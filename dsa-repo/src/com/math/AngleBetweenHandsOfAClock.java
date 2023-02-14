package com.math;
/*
1344. Angle Between Hands of a Clock

Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.

Answers within 10-5 of the actual value will be accepted as correct.



Example 1:
Input: hour = 12, minutes = 30
Output: 165

Analysis
---------
Hour Hand
In 12 hours Hour hand complete whole circle and cover 360°
So, 1 hour = 360° / 12 = 30°

Since 1 hours = 30°
In 1 minute, hours hand rotate -> 30° / 60 = 0.5°
So total angle because of minutes by hour hand is minutes/60 * 30 or minutes * 0.5

Minute Hand
In 60 minutes Minute Hand completes whole circle and cover 360°.
So, 1 minute -> 360° / 60 = 6°


TC : o(1)
SC: o(1)

 */
public class AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        System.out.println(new AngleBetweenHandsOfAClock().angleClock(12,30));
    }
    public double angleClock(int hour, int minutes) {
        // Degree covered by hour hand (hour area + minutes area)
        double hourDegree = (hour%12 * 30 )+ ((double)minutes/60 * 30);
        // Degree covered by minute hand (Each minute = 6 degree)
        double minuteDegree = minutes*6;

        // Absolute angle between them
        double angle = Math.abs(hourDegree-minuteDegree);

        // return which ever is smaller : acute (0<=x<=180)/ normal angle
        return Math.min(angle, 360.0 - angle);
    }
}
