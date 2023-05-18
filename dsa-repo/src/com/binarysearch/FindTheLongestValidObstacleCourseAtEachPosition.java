package com.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1964. Find the Longest Valid Obstacle Course at Each Position

You want to build some obstacle courses. You are given a 0-indexed integer array obstacles of length n,
where obstacles[i] describes the height of the ith obstacle.

For every index i between 0 and n - 1 (inclusive), find the length of the longest obstacle course in obstacles
such that:

You choose any number of obstacles between 0 and i inclusive.
You must include the ith obstacle in the course.
You must put the chosen obstacles in the same order as they appear in obstacles.
Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it.
Return an array ans of length n, where ans[i] is the length of the longest obstacle course for index i as
    described above.



Example 1:

Input: obstacles = [1,2,3,2]
Output: [1,2,3,3]
Explanation: The longest valid obstacle course at each position is:
- i = 0: [1], [1] has length 1.
- i = 1: [1,2], [1,2] has length 2.
- i = 2: [1,2,3], [1,2,3] has length 3.
- i = 3: [1,2,3,2], [1,2,2] has length 3.

TC : o(nlogn)
SC: o(n)
 */
public class FindTheLongestValidObstacleCourseAtEachPosition {

    public static void main(String[] args) {
        int[] obs = new int[]{1,2,3,2};
        int[] res = new FindTheLongestValidObstacleCourseAtEachPosition()
                            .longestObstacleCourseAtEachPosition(obs);
        Arrays.stream(res).forEach(System.out::println);
    }

    /*
    the idea is -
    for each index, we will find this ith element's upperBound index
    in the computed list. And once we get the index,
    we can add that element in the same index and add that (index+1) to res[] araay
    to get number of obstacles.
     */
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] res = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(list.size()==0 || list.get(list.size()-1)<= obstacles[i]){
                list.add(obstacles[i]);
                res[i] = list.size();
            } else{
                int upperBoundIndex = util(obstacles[i],list);
                list.set(upperBoundIndex, obstacles[i]);
                res[i] = upperBoundIndex +1;
            }
        }
        return res;
    }

    private int util(int obstacle, List<Integer> list){
        int low = 0, high = list.size();
        while(low<high){
            int mid = low+(high-low)/2;
            if(list.get(mid)<=obstacle){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return high;

    }
}
