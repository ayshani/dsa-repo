package com.graph.topologicalsort;

import java.util.*;

/*
1203. Sort Items by Groups Respecting Dependencies

There are n items each belonging to zero or one of m groups where group[i] is the group that the i-th item belongs
to and it's equal to -1 if the i-th item belongs to no group. The items and the groups are zero indexed. A group
can have no item belonging to it.

Return a sorted list of the items such that:

The items that belong to the same group are next to each other in the sorted list.
There are some relations between these items where beforeItems[i] is a list containing all the items that should
come before the i-th item in the sorted array (to the left of the i-th item).
Return any solution if there is more than one solution and return an empty list if there is no solution.



Example 1:



Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
Output: [6,3,4,1,5,2,0,7]

TC : o(n^2)
SC: o(n^2)
 */
public class SortItemsByGroupsRespectingDependencies {

    public static void main(String[] args) {
        int[] group = new int[]{-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(Arrays.asList());
        beforeItems.add(Arrays.asList(6));
        beforeItems.add(Arrays.asList(5));
        beforeItems.add(Arrays.asList(6));
        beforeItems.add(Arrays.asList(3,6));
        beforeItems.add(Arrays.asList());
        beforeItems.add(Arrays.asList());
        beforeItems.add(Arrays.asList());

        System.out.println(Arrays.toString(new SortItemsByGroupsRespectingDependencies().sortItems(8,2,group,beforeItems)));
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // If an item belongs to zero group, assign it a unique group id.
        int groupId = m;
        for(int i=0;i<n;i++){
            if(group[i]==-1)
            {
                group[i] = groupId;
                groupId++;
            }
        }

        // Sort all items regardless of group dependencies.
        Map<Integer,List<Integer>> itemGraph = new HashMap<>();
        int[] itemIndegree = new int[n];
        for(int i=0;i<n;i++){
            itemGraph.put(i, new ArrayList<>());
        }

        // Sort all groups regardless of item dependencies.
        Map<Integer,List<Integer>> groupGraph = new HashMap<>();
        int[] groupIndegree = new int[groupId];
        for(int i=0;i<groupId;i++){
            groupGraph.put(i, new ArrayList<>());
        }

        for(int cur =0; cur<n;cur++){
            for(int prev : beforeItems.get(cur)){
                // Each (prev -> curr) represents an edge in the item graph.
                itemGraph.get(prev).add(cur);
                itemIndegree[cur]++;

                // If they belong to different groups, add an edge in the group graph.
                if(group[cur]!= group[prev]){
                    groupGraph.get(group[prev]).add(group[cur]);
                    groupIndegree[group[cur]]++;
                }
            }
        }

        // Topological sort nodes in the graph, return an empty array if a cycle exists.
        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[0];
        }

        // Items are sorted regardless of groups, we need to differentiate them by the groups they belong to.
        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (Integer item : itemOrder) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        // Concatenate sorted items in all sorted groups.
        // [group 1, group 2, ... ] -> [(item 1, item 2, ...), (item 1, item 2, ...), ...]
        List<Integer> answerList = new ArrayList<>();
        for (int groupIndex : groupOrder) {
            answerList.addAll(orderedGroups.getOrDefault(groupIndex, new ArrayList<>()));
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer key : graph.keySet()) {
            if (indegree[key] == 0) {
                stack.add(key);
            }
        }

        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            visited.add(curr);

            for (Integer prev : graph.get(curr)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    stack.add(prev);
                }
            }
        }

        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }
}
