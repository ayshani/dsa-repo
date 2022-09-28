package com.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
841. Keys and Rooms

There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to
visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which
room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true
if you can visit all the rooms, or false otherwise.

Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation:
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.

TC : o(n)
SC : o(n)
 */
public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        for(int i=0;i<3;i++){
            rooms.add(new ArrayList<>());
        }

        rooms.get(0).add(1);
        rooms.get(1).add(0);
        rooms.get(1).add(2);
        rooms.get(2).add(0);
        System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0]=true;
        Stack<Integer> st = new Stack<>();
        st.push(0);

        while(!st.isEmpty()){
            int current = st.pop();
            for(int adj : rooms.get(current)){
                if(!visited[adj]){
                    visited[adj] = true;
                    st.push(adj);
                }
            }
        }

        for(int i=0;i<rooms.size();i++){
            if(!visited[i])
                return false;
        }

        return true;
    }
}
