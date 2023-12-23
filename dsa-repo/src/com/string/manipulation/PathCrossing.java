package com.string.manipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
1496. Path Crossing

Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or
west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously
visited. Return false otherwise.



Example 1:
Input: path = "NES"
Output: false
Explanation: Notice that the path doesn't cross any point more than once.

TC: o(n)
SC: o(n)
 */
public class PathCrossing {

    public static void main(String[] args) {
        System.out.println(new PathCrossing().isPathCrossing("NESWW"));
    }
    public boolean isPathCrossing(String path) {
        Set<String> points = new HashSet<>();
        int x=0, y=0;
        Map<Character, MovePair> moves = new HashMap<>();
        moves.put('N', new MovePair(0,1));
        moves.put('S', new MovePair(0,-1));
        moves.put('E', new MovePair(1,0));
        moves.put('W', new MovePair(-1,0));

        //points.add(new MovePair(0,0));
        points.add("0,0");

        for(int i=0;i<path.length();i++){
            MovePair move = moves.get(path.charAt(i));
            x += move.x;
            y += move.y;
            MovePair pt = new MovePair(x, y);
            String to = x+","+y;
            if(points.contains(to)){
                return true;
            }
            points.add(to);
        }
        return false;
    }
}

class MovePair{
    int x, y;
    public MovePair(int x, int y){
        this.x= x;
        this.y =y;
    }
}
