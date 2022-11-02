package com.map;

import java.util.HashMap;
import java.util.Map;

/*
149. Max Points on a Line

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
return the maximum number of points that lie on the same straight line.

Example 1:
Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Explanation
 -----------
 A line is determined by two factors,say y=ax+b

If two points(x1,y1) (x2,y2) are on the same line(Of course).
Consider the gap between two points.
We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant
If a third point (x3,y3) are on the same line. So we must have y3=ax3+b
Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
 So we can use y0&x0 to track a line;

TC : o(n^2)
SC : o(n)
 */
public class MaxPointsOnALine {

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {1,1},{3,2},{5,3},{4,1},{2,3},{1,4}
        };
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }
    public int maxPoints(int[][] points) {
        int n = points.length;

        if(n<2)
            return n;
        // map contains(x,innermap(y,count of same x/y gradient))
        Map<Integer, Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        int result =0;
        for(int i=0;i<points.length;i++){
            map.clear();
            int overlap=0, max=0;
            for(int j=i+1;j<points.length;j++){
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];

                if(x==0 && y==0){
                    overlap++;
                    continue;
                }
                int gcdxy = gcd(x,y);

                if(gcdxy!=0){
                    x/=gcdxy;
                    y/=gcdxy;
                }

                map.putIfAbsent(x, new HashMap<Integer,Integer>());
                map.get(x).put(y,map.get(x).getOrDefault(y,0)+1);
                max = Math.max(max, map.get(x).get(y));
            }

            result = Math.max(result, max+overlap+1);
        }

        return result;

    }

    private int gcd(int a , int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}
