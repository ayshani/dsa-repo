package com.graph.topologicalsort;

import java.util.*;

/*
207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
So it is impossible.

TC : o(m+n)
SC: o(m+n)
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] pre = new int[][]{{1,0},{0,1}};
        System.out.println(new CourseSchedule().canFinish(2,pre));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            adj.put(i,new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.offer(i);
        }

        int numberOfNodesVisited=0;
        while(!q.isEmpty()){
            int cur = q.poll();
            numberOfNodesVisited++;
            for(int neighbour : adj.get(cur)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                    q.offer(neighbour);
            }
        }
        return numCourses == numberOfNodesVisited;
    }
}
