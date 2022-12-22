package com.sort;

import java.util.Arrays;

/*
252. Meeting Rooms

Given an array of meeting time intervals where intervals[i] = [starti, endi],
determine if a person could attend all meetings.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

TC : o(nlogn)
SC : o(1)
 */
public class MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {0,30},{5,10},{15,20}
        };

        System.out.println(new MeetingRooms().canAttendMeetings(intervals));
    }
    public boolean canAttendMeetings(int[][] intervals) {
        // Sort in start time in ascending order
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);

        for(int i=0;i<intervals.length-1;i++){
            // check if current meeting end time is greater than next meeting start time
            // if yes - > then user can't attend all the meeting
            if(intervals[i][1]>intervals[i+1][0])
                return false;
        }
        return true;
    }
}
