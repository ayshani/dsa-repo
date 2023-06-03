package com.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
1376. Time Needed to Inform All Employees

A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one
with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th
employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his
direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i]
minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.

Example:
Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
Output: 1
Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company
and needs 1 minute to inform them all.
The tree structure of the employees in the company is shown.

TC : o(n)
SC: o(n)
 */
public class TimeNeededToInformAllEmployees {

    public static void main(String[] args) {
        int n = 6, headId = 2;
        int[] manager = new int[]{2,2,-1,2,2,2}, informTime = new int[]{0,0,1,0,0,0};

        System.out.println(new TimeNeededToInformAllEmployees().numOfMinutes(n,headId,manager,informTime));
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        // for every emploee, add him to his manager graph adj list
        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                graph.get(manager[i]).add(i);
            }
        }

        // we don't require any visited boolean array as the structure is like
        // a tree.
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{headID, 0});
        int ans =0;

        // loop over until queue is empty
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int currentManager = cur[0], totalTimeTakenSoFar = cur[1];

            ans = Math.max(ans,totalTimeTakenSoFar);
            for(int subordinate : graph.get(currentManager)){
                q.offer(new int[]{subordinate, totalTimeTakenSoFar + informTime[currentManager]});
            }
        }

        return ans;
    }
}
