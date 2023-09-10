package com.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Test {
    Set<int[]> visited;
    int[] dir = new int[]{0,1,0,-1,0};
    public static void main(String[] args) {
        System.out.println(new Test().isReachableAtTime(2,4,7,7,6));
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int time =0;

        /*Queue<int[]> q = new LinkedList<>();
        visited = new HashSet<>();

        q.offer(new int[]{sx,sy});
        visited.add(new int[]{sx,sy});
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] cur = q.poll();
                int i = cur[0] , j = cur[1];
                if(cur[0]== fx && cur[1]== fy){
                    if(time==t)
                        return true;
                    else
                        return false;
                }
                for(int d = 0;d<4;d++){
                    int x = dir[d]+ i, y = dir[d+1]+ j;
                    if(x>0 && y>0  && !visited.contains(new int[]{x,y})){
                        q.offer(new int[]{x,y});
                        visited.add(new int[]{x,y});
                    }
                }
            }
            time++;
            if(time>t)
                break;
        }
        return false;*/
        return dfs(sx,sy,fx,fy,0,t);

    }

    boolean dfs(int x, int y, int fx, int fy, int time, int t){
        if(x<=0 || y<=0 /*|| visited.contains(new int[]{x,y})*/ || time>t)
            return false;
        //visited.add(new int[]{x,y});
        if(x==fx && y == fy && time==t)
            return true;
        if(dfs(x+1,y,fx,fy,time+1,t) || dfs(x-1,y,fx,fy,time+1,t)
           || dfs(x,y+1,fx,fy,time+1,t) || dfs(x,y-1,fx,fy,time+1,t)
           || dfs(x-1,y-1,fx,fy,time+1,t) || dfs(x-1,y+1,fx,fy,time+1,t)
                || dfs(x+1,y+1,fx,fy,time+1,t) || dfs(x+1,y-1,fx,fy,time+1,t))   {
            return true;
        }
        return false;
    }
}
