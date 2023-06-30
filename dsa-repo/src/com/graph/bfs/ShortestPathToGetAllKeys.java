package com.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
864. Shortest Path to Get All Keys

You are given an m x n grid grid where:

'.' is an empty cell.
'#' is a wall.
'@' is the starting point.
Lowercase letters represent keys.
Uppercase letters represent locks.
You start at the starting point and one move consists of walking one space in one of the four cardinal directions.
You cannot walk outside the grid, or walk into a wall.

If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.

For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English
alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key;
and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

Return the lowest number of moves to acquire all keys. If it is impossible, return -1.

Example 1:
Input: grid = ["@.a..","###.#","b.A.B"]
Output: 8
Explanation: Note that the goal is to obtain all the keys not to open all the locks.



Complexity Analysis
------------------
Let m×ntimes nm×n be the size of grid and kkk be the number of keys.

Time complexity: O(m⋅n⋅2^k)
The BFS algorithm visits each cell in the grid once for each key-holding state. Therefore, the worst-case
time complexity is proportional to the product of the number of cells and the number of key-holding states.
There are 2^k possible key-holding states and we need to consider each one separately.
Space complexity: O(m⋅n⋅2^k).
To keep track of the visited cells and their key-holding states, we need to store them in seen.
There are at most m×n times m×n cells, and each cell can have 2^k possible key-holding states,
so the maximum amount of space required is proportional to the product of the number of cells and the
number of key-holding states.

 */
public class ShortestPathToGetAllKeys {

    public static void main(String[] args) {
        String[] grid = new String[]{
                "@.a..", "###.#", "b.A.B"
        };
        System.out.println(new ShortestPathToGetAllKeys().shortestPathAllKeys(grid));
    }
    public int shortestPathAllKeys(String[] grid) {
        int x= -1,y=-1, maxKeys =0;
        int m = grid.length, n = grid[0].length();

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                char cur = grid[i].charAt(j);
                // get [x,y] of starting position
                if(cur=='@'){
                    x = i;
                    y = j;
                }
                // here we are using bitmask method.
                // there can be max 26 bits as there are 26 alphabets.
                // set 1 to ith bit of ith character.
                // for e.g. :
                // for a = 0 : we set 0th bit
                // for b = 1: we set 1th bit
                if(isKey(cur))
                    maxKeys += (1<<(cur-'a'));
            }
        }
        System.out.println(maxKeys);

        State start = new State(0, x,y);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0+" "+x+" "+y);
        q.offer(start);
        int[] dir = new int[]{0,1,0,-1,0};
        int steps =0;
        while(!q.isEmpty()){
            System.out.println("Steps : "+ steps);
            int size = q.size();
            while(size-->0){
                State cur = q.poll();
                System.out.println(cur.keys + " "+cur.i+" "+cur.j);
                // once we collected all keys, we return the step
                if(cur.keys == maxKeys)
                    return steps;
                for(int d=0;d<4;d++){
                    int i= cur.i+dir[d];
                    int j = cur.j + dir[d+1];
                    int keys = cur.keys;

                    if(i>=0 && i<m && j>=0 && j<n && grid[i].charAt(j) !='#')
                    {
                        char next = grid[i].charAt(j);
                        // if its a key, we add it to existing keys
                        if(isKey(next)){
                            keys = keys |  (1<<(next-'a'));
                        }
                        // incase it is a lock and we already have its key
                        // we can consider this flow  otherwise
                        // we can't go forward and we have to continue for next co-ordinate
                        if(isLock(next) && (keys >> (next - 'A') & 1)==0)
                            continue;
                        if(!visited.contains(keys+" "+i+" "+j)){
                            visited.add(keys+" "+i+" "+j);
                            q.offer(new State(keys,i,j));
                        }
                    }

                }
            }
            steps++;
        }
        return -1;
    }

    boolean isKey(char cur){
        if(cur >='a' && cur<='z')
            return true;
        return false;
    }

    boolean isLock(char cur){
        if(cur >='A' && cur<='Z')
            return true;
        return false;
    }
}

class State{
    int keys, i,j;
    public State(int keys, int i, int j){
        this.keys = keys;
        this.i =i;
        this.j =j;
    }
}