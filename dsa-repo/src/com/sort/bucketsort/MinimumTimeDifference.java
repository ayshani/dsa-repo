package com.sort.bucketsort;

import java.util.List;

/*
539. Minimum Time Difference

Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any
two time-points in the list.


Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1


TC: o(n)
SC: o(1)
 */
public class MinimumTimeDifference {

    public static void main(String[] args) {
        System.out.println(new MinimumTimeDifference().findMinDifference(
                List.of("23:59","00:00")
        ));
    }
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[24*60];
        for(String time : timePoints){
            int min = Integer.parseInt(time.substring(0,2))*60 +
                    Integer.parseInt(time.substring(3));
            if(minutes[min])
                return 0;
            minutes[min] = true;
        }
        int prevIndex = Integer.MAX_VALUE;
        int firstIndex = Integer.MAX_VALUE;
        int lastIndex = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<24*60; i++){
            if(minutes[i]){
                if(prevIndex != Integer.MAX_VALUE){
                    ans = Math.min(ans, i-prevIndex);
                }
                prevIndex = i;
                if(firstIndex == Integer.MAX_VALUE){
                    firstIndex = i;
                }
                lastIndex =i;
            }
        }
        return Math.min(ans, 24*60 - lastIndex + firstIndex);
    }
}
