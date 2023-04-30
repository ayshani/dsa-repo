package com.graph.topologicalsort;

import java.util.*;

/*
1136. Parallel Courses

You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given an
array relations where relations[i] = [prevCoursei, nextCoursei], representing a prerequisite relationship between
course prevCoursei and course nextCoursei: course prevCoursei has to be taken before course nextCoursei.

In one semester, you can take any number of courses as long as you have taken all the prerequisites in the previous
semester for the courses you are taking.

Return the minimum number of semesters needed to take all courses. If there is no way to take all the courses,
return -1.

Example 1:
Input: n = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: The figure above represents the given graph.
In the first semester, you can take courses 1 and 2.
In the second semester, you can take course 3.

TC: o(n)
SC: o(n)
 */
public class ParallelCourses {

    public static void main(String[] args) {
        int n = 3, relations[][] = new int[][]{{1,3},{2,3}};
        System.out.println(new ParallelCourses().minimumSemesters(n,relations));
    }
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] indegree = new int[n+1];
        for(int[] relation : relations){
            int pre = relation[0] , next = relation[1];
            graph.computeIfAbsent(pre, value -> new ArrayList<>()).add(next);
            indegree[next]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0)
                q.offer(i);
        }

        int semester =0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                --n;
                int cur = q.poll();
                if(!graph.containsKey(cur))
                    continue;
                for(int next : graph.remove(cur)){
                    if(--indegree[next]==0){
                        q.offer(next);
                    }
                }
            }
            semester++;
        }

        return n==0 ? semester : -1;
    }
}
