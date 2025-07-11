package com.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
2402. Meeting Rooms III

You are given an integer n. There are n rooms numbered from 0 to n - 1.

You are given a 2D integer array meetings where meetings[i] = [starti, endi]
means that a meeting will be held during the half-closed time interval [starti, endi).
All the values of starti are unique.

Meetings are allocated to rooms in the following manner:

Each meeting will take place in the unused room with the lowest number.
If there are no available rooms, the meeting will be delayed until a room becomes free. T
he delayed meeting should have the same duration as the original meeting.
When a room becomes unused, meetings that have an earlier original start time should be given the room.
Return the number of the room that held the most meetings. If there are multiple rooms,
return the room with the lowest number.

A half-closed interval [a, b) is the interval between a and b including a and not including b.

Example 1:

Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 0
Explanation:
- At time 0, both rooms are not being used. The first meeting starts in room 0.
- At time 1, only room 1 is not being used. The second meeting starts in room 1.
- At time 2, both rooms are being used. The third meeting is delayed.
- At time 3, both rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
Both rooms 0 and 1 held 2 meetings, so we return 0.

TC : o(nlogn)
SC : o(n)
 */
public class MeetingRoomsIII {

    public static void main(String[] args) {
        int n = 2, meetings[][] = new int[][]{{0,10},{1,5},{2,7},{3,4}};
        System.out.println(new MeetingRoomsIII().mostBooked(n,meetings));
    }
    public int mostBooked(int n, int[][] meetings) {
        // Counter for number of meetings held in room
        int[] rooms = new int[n];

        // 1. Each meeting will take place in the free room with the lowest number.
        PriorityQueue<Long> freeRooms = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            freeRooms.add((long)i);
        }


        //List(start, end, room number)
        PriorityQueue<Long[]> occupiedRooms = new PriorityQueue<>((x,y)-> Long.compare(x[1], y[1]));
        // 3. Meetings that have an earlier original start time should be given the room
        Arrays.sort(meetings,(a, b)-> a[0]-b[0]);

        long currentTime =0;

        for(int[] meet: meetings){
            // Update time to meeting time if meeting time is later
            currentTime = Math.max(currentTime,meet[0]);

            // If no meeting rooms left, go to time where earliest room will be cleared
            if(freeRooms.isEmpty()){
                long earliestFreeTime = occupiedRooms.peek()[1];
                currentTime = Math.max(currentTime,earliestFreeTime);
            }

            // Clear all rooms occuring at and before this time
            while(!occupiedRooms.isEmpty() && currentTime>=occupiedRooms.peek()[1]){
                long freeRoom = occupiedRooms.poll()[2];
                freeRooms.add(freeRoom);
            }

            // Occupy a new room,
            // 2. Delayed meeting should have same duration
            long nextRoom = freeRooms.poll();
            rooms[(int)nextRoom] += 1;
            occupiedRooms.add(new Long[]{currentTime, currentTime+meet[1]-meet[0],nextRoom});
        }

        // Get smallest room with largest meetings held
        int max =0, ansRoom =0;
        for(int i=n-1;i>=0;i--){
            if(rooms[i]>=max){
                max = rooms[i];
                ansRoom =i;
            }
        }

        return ansRoom;
    }
}
