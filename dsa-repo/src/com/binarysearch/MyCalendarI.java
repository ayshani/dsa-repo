package com.binarysearch;

import java.util.TreeMap;

/*
729. My Calendar I

You are implementing a program to use as your calendar.
We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection
(i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and
end that represents a booking on the half-open interval [start, end),
the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int start, int end)
Returns true if the event can be added to the calendar successfully without causing a double booking.
Otherwise, return false and do not add the event to the calendar.


Example 1:

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False,
    It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True,
    The event can be booked, as the first event takes every time less than 20, but not including 20.

Logic
-------
Intuition

If we maintained our events in sorted order,
we could check whether an event could be booked in O(\log N)O(logN) time
(where NN is the number of events already booked) by binary searching for where the event should be placed.
We would also have to insert the event in our sorted structure.

Algorithm

We need a data structure that keeps elements sorted and supports fast insertion.
In Java, a TreeMap is the perfect candidate. In Python, we can build our own binary tree structure.

For Java, we will have a TreeMap where the keys are the start of each interval,
and the values are the ends of those intervals. When inserting the interval [start, end),
we check if there is a conflict on each side with neighboring intervals:
we would like calendar.get(prev)) <= start <= end <= next for the booking to be valid
(or for prev or next to be null respectively.)

For Python, we will create a binary tree.
Each node represents some interval [self.start, self.end) while
self.left, self.right represents nodes that are smaller or larger than the current node.

TC : o(nlogn)
SC : o(n)
 */
public class MyCalendarI {
    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(10,20));
        System.out.println(obj.book(15,25));
        System.out.println(obj.book(20,30));
    }
}

class MyCalendar {
    TreeMap<Integer,Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // previous end
        Integer prev = calendar.floorKey(start);
        // next start
        Integer next = calendar.ceilingKey(start);

        if((prev ==  null || calendar.get(prev) <=start)
                && (next == null || end<= next))
        {
            calendar.put(start,end);
            return true;
        }

        return false;
    }
}
