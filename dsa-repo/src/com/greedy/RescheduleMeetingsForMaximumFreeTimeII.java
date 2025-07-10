package com.greedy;
/*
3440. Reschedule Meetings for Maximum Free Time II

You are given an integer eventTime denoting the duration of an event. You are also given two integer arrays startTime and endTime, each of length n.

These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 and time t = eventTime, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most one meeting by moving its start time while maintaining the same duration, such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.

Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.



Example 1:

Input: eventTime = 5, startTime = [1,3], endTime = [2,5]

Output: 2

Explanation:



Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

TC : o(n)
SC: o(n)
 */
public class RescheduleMeetingsForMaximumFreeTimeII {

    public static void main(String[] args) {
        System.out.println(new RescheduleMeetingsForMaximumFreeTimeII().maxFreeTime(
                5, new int[]{1,3}, new int[]{2,5}
        ));
    }
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        boolean[] q = new boolean[n];
        for (int i = 0, t1 = 0, t2 = 0; i < n; i++) {
            if (endTime[i] - startTime[i] <= t1) {
                q[i] = true;
            }
            t1 = Math.max(t1, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));
            if (endTime[n - i - 1] - startTime[n - i - 1] <= t2) {
                q[n - i - 1] = true;
            }
            t2 = Math.max(
                    t2,
                    (i == 0 ? eventTime : startTime[n - i]) - endTime[n - i - 1]
            );
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : endTime[i - 1];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            if (q[i]) {
                res = Math.max(res, right - left);
            } else {
                res = Math.max(res, right - left - (endTime[i] - startTime[i]));
            }
        }
        return res;
    }
}
