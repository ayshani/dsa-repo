package com.design;

import java.util.PriorityQueue;

/*
1845. Seat Reservation Manager

Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the SeatManager class:

SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are
initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.


Example 1:

Input
["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
[[5], [], [], [2], [], [], [], [], [5]]
Output
[null, 1, 2, null, 2, 3, 4, 5, null]

Explanation
SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
seatManager.reserve();    // The only available seat is seat 5, so return 5.
seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].

Complexity Analysis
Let mmm be the maximum number of calls made.

Time complexity: O((m+n)⋅logn)

While initializing the SeatManager object, we iterate over all n seats and push it into our heap, each push operation
takes O(logn) time, thus, overall it will take O(nlogn) time.
In the reserve() method, we pop the minimum-valued element from the availableSeats heap, which takes
O(logn) time.
In the unreserve(seatNumber) method, we push the seatNumber into the availableSeats heap which will also
take O(logn) time.
There are a maximum of mmm calls to reserve() or unreserve() methods, thus the overall
time complexity is O(m⋅logn).

Space complexity: O(n)

The availableSeats heap contains all nnn elements, taking O(n)O(n)O(n) space.
 */
public class SeatReservationManager {
    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);

    }
}

class SeatManager {
    PriorityQueue<Integer> pq;
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            pq.offer(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}