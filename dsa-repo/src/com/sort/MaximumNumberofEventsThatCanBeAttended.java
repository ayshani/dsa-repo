package com.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 1353. Maximum Number of Events That Can Be Attended
 * You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.

Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.

Logic
---------------
- sort events[] wrt starti.
get Maximum day till which an event can span

Use a priorityQueue.
Iterate over day =1 to day = max
	 -> check if queue is Empty or not. If not, poll all if its endi is less than current day.
	 -> add the event[endi] to priorityQueue if its starti is == day
	 -> Poll from queue and increase the counter.


 TC : O(NlogN)
 SC : O(N)
 */
public class MaximumNumberofEventsThatCanBeAttended {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] events = new int[][] {{1,2},{2,3},{3,4}};
        System.out.println(new MaximumNumberofEventsThatCanBeAttended().maxEvents(events));
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a, b)-> a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        int max =0,res =0, n = events.length, i=0;

        for(int j=0;j<n;j++){
            max = Math.max(max, events[j][1]);
        }

        for(int d=1;d<=max;d++){
            while(!pq.isEmpty() && pq.peek()<d)
                pq.poll();

            while(i<n && events[i][0]==d)
                pq.add(events[i++][1]);
            if(!pq.isEmpty()){
                pq.poll();
                res++;
            }
        }

        return res;
    }
}

