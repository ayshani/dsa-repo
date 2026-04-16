package com.array;
/*
2515. Shortest Distance to Target String in a Circular Array

You are given a 0-indexed circular string array words and a string target. A circular array means that the array's end connects to the array's beginning.

Formally, the next element of words[i] is words[(i + 1) % n] and the previous element of words[i] is words[(i - 1 + n) % n], where n is the length of words.
Starting from startIndex, you can move to either the next word or the previous word with 1 step at a time.

Return the shortest distance needed to reach the string target. If the string target does not exist in words, return -1.



Example 1:

Input: words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
Output: 1
Explanation: We start from index 1 and can reach "hello" by
- moving 3 units to the right to reach index 4.
- moving 2 units to the left to reach index 4.
- moving 4 units to the right to reach index 0.
- moving 1 unit to the left to reach index 0.
The shortest distance to reach "hello" is 1.

TC : o(n)
SC: o(1)
 */
public class ShortestDistanceToTargetStringInACircularArray {

    public static void main(String[] args) {
        System.out.println(new ShortestDistanceToTargetStringInACircularArray().closestTarget(
                new String[]{"hello","i","am","leetcode","hello"}, "hello", 1
        ));
    }
    public int closestTarget(String[] words, String target, int startIndex) {
        int ans = words.length;
        int n = words.length;

        for (int i = 0; i < n; ++i) {
            if (words[i].equals(target)) {
                int dist = Math.abs(i - startIndex);
                ans = Math.min(ans, Math.min(dist, n - dist));
            }
        }

        return ans < n ? ans : -1;
    }
}
