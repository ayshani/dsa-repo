package com.binarysearch;

import java.util.Arrays;
import java.util.TreeMap;

/*
 * 2054. Two Best Non-Overlapping Events
 *
 * You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei].
 * The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei.
 * You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
 *
 * Return this maximum sum.
 *
 * Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts
 * and the other ends at the same time.
 * More specifically, if you attend an event with end time t, the next event must start at or after t + 1.
 *
 * Example 1:
 * Input: events = [[1,3,2],[4,5,2],[2,4,3]]
 * Output: 4
 * Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
 *
 * Logic
 * ---------------
 * Sort the array wrt end time
 * have one treeMap
 * iterate over the array.
 * 	-> get the nearest last meeting endtime entry from map. ( i.e. floor value from map)
 * 	-> as it is told to pick only two events, have two variables ->
 * 		maximumProfitTillNow  : it indicates the maximum profit of one event from 0-i
 * 		topTwoProfitSum : two events in consideration
 * 	-> update these two variables taking maximum with current event's last time.
 * 	-> In case the floor value is not null, that means we have a one previous events.
 * 		so we compare with existing topTwoProfitSum and floor value profit and update
 *
 * TC : o(nlogn)
 * SC : o(n)
 */
public class TwoBestNonOverlappingEvents {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][]  events = new int[][] {
                {1,3,2},
                {4,5,2},
                {2,4,3}
        };
        TwoBestNonOverlappingEvents obj = new TwoBestNonOverlappingEvents();
        System.out.println(obj.maxTwoEvents(events));
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a, b)-> a[1]-b[1]);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int maxProfitTillNow=0,answer=0;
        for(int[] event : events){
            Integer prevEventEndTime = map.lowerKey(event[0]);
            answer = Math.max(answer,event[2]);
            maxProfitTillNow = Math.max(maxProfitTillNow,event[2]);
            if(prevEventEndTime!=null){
                answer = Math.max(answer, map.get(prevEventEndTime)+event[2]);
            }
            map.put(event[1],maxProfitTillNow);
        }

        return answer;
    }
}

