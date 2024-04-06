package com.graph.topologicalsort;

import java.util.*;

/*
2050. Parallel Courses III

You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given a 2D
integer array relations where relations[j] = [prevCoursej, nextCoursej] denotes that course prevCoursej has to be
completed before course nextCoursej (prerequisite relationship). Furthermore, you are given a 0-indexed integer
array time where time[i] denotes how many months it takes to complete the (i+1)th course.

You must find the minimum number of months needed to complete all the courses following these rules:

You may start taking a course at any time if the prerequisites are met.
Any number of courses can be taken at the same time.
Return the minimum number of months needed to complete all the courses.

Note: The test cases are generated such that it is possible to complete every course (i.e., the graph is a directed
acyclic graph).

E.g. 1
Input: n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
Output: 8
Explanation: The figure above represents the given graph and the time required to complete each course.
We start course 1 and course 2 simultaneously at month 0.
Course 1 takes 3 months and course 2 takes 2 months to complete respectively.
Thus, the earliest time we can start course 3 is at month 3, and the total time required is 3 + 5 = 8 months.

Complexity Analysis

Given eee as the length of relations,

Time complexity: O(n+e)

It costs O(e) to build graph and O(n) to initialize maxTime, queue, and indegree.

During Kahn's algorithm, each node is pushed and popped to queue once, costing O(n). We have a for loop inside the
while loop, but this for loop is iterating over edges. Because we only visit each node once, each edge in the input
can only be iterated over once as well. This means all for loop iterations across the algorithm will cost O(e).

Space complexity: O(n+e)

graph takes O(n+e) space, the queue can take up to O(n) space, maxTime and indegree both take O(n) space.
 */
public class ParallelCoursesIII {

    public static void main(String[] args) {
        int[][] rel = new int[][]{
                {1,3},{2,3}
        };
        int[] time = new int[]{3,2,5};
        System.out.println(new ParallelCoursesIII().minimumTime(3,rel,time));
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int[] edge: relations) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph.get(x).add(y);
            indegree[y]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] maxTime = new int[n];

        for (int node = 0; node < n; node++) {
            if (indegree[node] == 0) {
                queue.add(node);
                maxTime[node] = time[node];
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int neighbor: graph.get(node)) {
                maxTime[neighbor] = Math.max(maxTime[neighbor], maxTime[node] + time[neighbor]);
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        int ans = 0;
        for (int node = 0; node < n; node++) {
            ans = Math.max(ans, maxTime[node]);
        }

        return ans;
    }
}
