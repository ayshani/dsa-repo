package com.design;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
3408. Design Task Manager

There is a task management system that allows users to manage their tasks, each associated with a priority. The system should efficiently handle adding, modifying, executing, and removing tasks.

Implement the TaskManager class:

TaskManager(vector<vector<int>>& tasks) initializes the task manager with a list of user-task-priority triples. Each element in the input list is of the form [userId, taskId, priority], which adds a task to the specified user with the given priority.

void add(int userId, int taskId, int priority) adds a task with the specified taskId and priority to the user with userId. It is guaranteed that taskId does not exist in the system.

void edit(int taskId, int newPriority) updates the priority of the existing taskId to newPriority. It is guaranteed that taskId exists in the system.

void rmv(int taskId) removes the task identified by taskId from the system. It is guaranteed that taskId exists in the system.

int execTop() executes the task with the highest priority across all users. If there are multiple tasks with the same highest priority, execute the one with the highest taskId. After executing, the taskId is removed from the system. Return the userId associated with the executed task. If no tasks are available, return -1.

Note that a user may be assigned multiple tasks.



Example 1:

Input:
["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
[[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]

Output:
[null, null, null, 3, null, null, 5]

Explanation

TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]);
// Initializes with three tasks for Users 1, 2, and 3.
taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
taskManager.edit(102, 8); // Updates priority of task 102 to 8.
taskManager.execTop(); // return 3. Executes task 103 for User 3.
taskManager.rmv(101); // Removes task 101 from the system.
taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
taskManager.execTop(); // return 5. Executes task 105 for User 5.

Intuition
We need a task management system where we can:

Add tasks with a priority to users.
Edit the priority of existing tasks.
Remove tasks.
Execute the highest-priority task (with ties broken by the taskId).
A straightforward approach is to use a PriorityQueue or a TreeMap for efficient access to the highest-priority
task. However, both of these solutions have trade-offs when it comes to removing tasks or editing priorities.
Therefore, a combination of TreeMap for priority-based sorting and HashMap for quick lookup can solve the problem
efficiently.
 */
public class DesignTaskManager {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(List.of(
                List.of(1, 101, 10),
                List.of(2, 102, 20),
                List.of(3, 103, 15)));
        taskManager.add(4, 104, 5);
        taskManager.edit(102, 8);
        System.out.println(taskManager.execTop());
        taskManager.rmv(101);
        taskManager.add(5, 105, 15);
        System.out.println(taskManager.execTop());

    }
}
class TaskManager {
    private final TreeMap<Task, Integer> sortedTasks;
    private final Map<Integer, Task> taskMap;

    // o(nlogn)
    public TaskManager(List<List<Integer>> tasks) {
        sortedTasks = new TreeMap<>();
        taskMap = new HashMap<>();

        for (List<Integer> task : tasks) {
            int userId = task.get(0), taskId = task.get(1), priority = task.get(2);
            add(userId, taskId, priority);
        }
    }

    // o(logn)
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        sortedTasks.put(task, userId);
        taskMap.put(taskId, task);
    }

    // o(logn)
    public void edit(int taskId, int newPriority) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            sortedTasks.remove(task);
            task.priority = newPriority;
            sortedTasks.put(task, task.userId);
        }
    }

    //o(logn)
    public void rmv(int taskId) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            sortedTasks.remove(task);
            taskMap.remove(taskId);
        }
    }

    // o(logn)
    public int execTop() {
        if (sortedTasks.isEmpty()) {
            return -1;
        }
        Task topTask = sortedTasks.firstKey();
        sortedTasks.remove(topTask);
        taskMap.remove(topTask.taskId);
        return topTask.userId;
    }
}

class Task implements Comparable<Task>{

    int userId, taskId, priority;

    Task(int userId, int taskId, int priority){
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other){
        if(this.priority != other.priority){
            return Integer.compare(other.priority, this.priority);
        }
        return Integer.compare(other.taskId, this.taskId);
    }
}
