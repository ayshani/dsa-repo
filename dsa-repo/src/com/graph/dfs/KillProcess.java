package com.graph.dfs;

import java.util.*;

/*
582. Kill Process

You have n processes forming a rooted tree structure. You are given two integer arrays pid and ppid,
where pid[i] is the ID of the ith process and ppid[i] is the ID of the ith process's parent process.

Each process has only one parent process but may have multiple children processes.
Only one process has ppid[i] = 0, which means this process has no parent process (the root of the tree).

When a process is killed, all of its children processes will also be killed.

Given an integer kill representing the ID of a process you want to kill, return a list of the IDs of
the processes that will be killed. You may return the answer in any order.

Example 1:
Input: pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
Output: [5,10]
Explanation: The processes colored in red are the processes that should be killed.

TC : o(n)
SC: o(n)
 */
public class KillProcess {

    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1,3,10,5), ppid = Arrays.asList(3,0,5,3);
        System.out.println(new KillProcess().killProcess(pid,ppid,5));
    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // build graph.
        // ppid is parent . so edges start from it then go it child pid
        for(int i=0;i<pid.size();i++){
            graph.computeIfAbsent(ppid.get(i), value -> new ArrayList<>()).add(pid.get(i));
        }

        List<Integer> killedProcesses = new ArrayList<>();
        // we do dfs as from kill process, we need to kill all its children direct and indirect ones
        dfs(kill,graph, killedProcesses);
        return killedProcesses;
    }

    private void dfs(int id, Map<Integer, List<Integer>> graph, List<Integer> killedProcesses){
        killedProcesses.add(id);
        if(graph.get(id)==null)
            return;
        for(int childId : graph.get(id)){
            dfs(childId,graph, killedProcesses);
        }
    }
}
