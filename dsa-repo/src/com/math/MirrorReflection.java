package com.math;
/*
858. Mirror Reflection

There is a special square room with mirrors on each of the four walls.
Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.

The square room has walls of length p and a laser ray from the southwest corner first meets
the east wall at a distance q from the 0th receptor.

Given the two integers p and q, return the number of the receptor that the ray meets first.

The test cases are guaranteed so that the ray will meet a receptor eventually.

Example :
Input: p = 2, q = 1
Output: 2
Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.

Logic
-----
https://www.youtube.com/watch?v=_xIBOUWEq1c

 */
public class MirrorReflection {

    public static void main(String[] args) {
        System.out.println(new MirrorReflection().mirrorReflection(2,1));
    }
    public int mirrorReflection(int p, int q) {
        int extension =q, reflection=p;

        while(extension%2 ==0 && reflection%2 ==0){
            extension/=2;
            reflection/=2;
        }

        if(reflection%2 !=0 && extension%2!=0)
            return 1;
        else if(reflection%2 ==0 && extension%2!=0)
            return 2;
        else if(reflection%2 !=0 && extension%2 ==0)
            return 0;
        return -1;
    }
}
