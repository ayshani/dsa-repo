package com.binarysearch;
/*
2187. Minimum Time to Complete Trips

You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.

Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the
current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of
any other bus.

You are also given an integer totalTrips, which denotes the number of trips all buses should make in total.
Return the minimum time required for all buses to complete at least totalTrips trips.



Example 1:

Input: time = [1,2,3], totalTrips = 5
Output: 3
Explanation:
- At time t = 1, the number of trips completed by each bus are [1,0,0].
  The total number of trips completed is 1 + 0 + 0 = 1.
- At time t = 2, the number of trips completed by each bus are [2,1,0].
  The total number of trips completed is 2 + 1 + 0 = 3.
- At time t = 3, the number of trips completed by each bus are [3,1,1].
  The total number of trips completed is 3 + 1 + 1 = 5.
So the minimum time needed for all buses to complete at least 5 trips is 3.

TC : o(n*log(maxlimit od time))
SC: o(1)
 */
public class MinimumTimeToCompleteTrips {

    public static void main(String[] args) {
        int[] time = new int[]{1,2,3};
        System.out.println(new MinimumTimeToCompleteTrips().minimumTime(time,5));
    }
    public long minimumTime(int[] time, int totalTrips) {
        long l=0,r = 100000000000000L;
        while(l<r){
            long mid = l+(r-l)/2;

            long trip =0;
            for(int t : time){
                trip+= mid/t;
            }

            if(trip<totalTrips){
                l= mid+1;
            } else {
                r = mid;
            }
        }

        return r;

    }
}
