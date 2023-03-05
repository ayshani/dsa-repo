package com.graph.bfs;

import java.util.*;

/*
1345. Jump Game IV

Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.



Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

TC : o(n)
SC : o(n)
 */
public class JumpGameIV {

    public static void main(String[] args) {
        int[] ar = new int[]{100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(new JumpGameIV().minJumps(ar));
    }
    public int minJumps(int[] arr) {
        int n = arr.length;
        // Create an unordered map to store the indices of all elements in the array
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],value-> new ArrayList<>()).add(i);
        }
        // Create a queue to implement BFS
        Queue<Integer> q = new LinkedList<>();
        // Push the starting index into the queue
        q.offer(0);
        // Create a vector to store the minimum distance of each index from the starting index
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        // Initialize the distance of the starting index to 0
        distance[0] = 0;
        while(!q.isEmpty()){
            // Pop the front element from the queue
            int cur = q.poll();
            // Check if the last index has been reached
            if(cur==n-1){
                // Return the minimum number of steps to reach the last index
                return distance[cur];
            }

            // Jump to the index curr+1 if it is within the array bounds and has not been visited yet
            if(cur+1<n && distance[cur+1]== -1){
                // Update its distance
                distance[cur+1] = distance[cur] +1;
                // Push it into the queue
                q.offer(cur+1);
            }
            // Jump to the index curr-1 if it is within the array bounds and has not been visited yet
            if(cur-1>0 && distance[cur-1]== -1){
                // Update its distance
                distance[cur-1] = distance[cur] +1;
                // Push it into the queue
                q.offer(cur-1);
            }
            if(map.containsKey(arr[cur])){
                // Jump to any index next with the same value as arr[curr] if it has not been visited yet
                for(int sameValueIndex : map.get(arr[cur])){
                    if(sameValueIndex != cur && distance[sameValueIndex]== -1){
                        // Update its distance
                        distance[sameValueIndex] = distance[cur] +1;
                        // Push it into the queue
                        q.offer(sameValueIndex);
                    }
                }
                // Clear the indices of the current element in indices
                map.remove(arr[cur]);
            }
        }
        // Return -1 if no path to the last index exists
        return -1;
    }
}
