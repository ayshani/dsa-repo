package com.string.manipulation;
/*
3443. Maximum Manhattan Distance After K Changes

You are given a string s consisting of the characters 'N', 'S', 'E', and 'W', where s[i] indicates movements in an infinite grid:

'N' : Move north by 1 unit.
'S' : Move south by 1 unit.
'E' : Move east by 1 unit.
'W' : Move west by 1 unit.
Initially, you are at the origin (0, 0). You can change at most k characters to any of the four directions.

Find the maximum Manhattan distance from the origin that can be achieved at any time while performing the movements in order.

The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.


Example 1:

Input: s = "NWSE", k = 1

Output: 3

Explanation:

Change s[2] from 'S' to 'N'. The string s becomes "NWNE".

Movement	Position (x, y)	Manhattan Distance	Maximum
s[0] == 'N'	(0, 1)	0 + 1 = 1	1
s[1] == 'W'	(-1, 1)	1 + 1 = 2	2
s[2] == 'N'	(-1, 2)	1 + 2 = 3	3
s[3] == 'E'	(0, 2)	0 + 2 = 2	3
The maximum Manhattan distance from the origin that can be achieved is 3. Hence, 3 is the output.

TC : o(n)
SC: o(1)
 */
public class MaximumManhattanDistanceAfterKChanges {

    public static void main(String[] args) {
        System.out.println(new MaximumManhattanDistanceAfterKChanges().maxDistance("NWSE", 1));
    }
    public int maxDistance(String s, int k) {
        int lat = 0, longi = 0, ans =0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            switch(c){
                case 'N':
                    lat++;
                    break;
                case 'S':
                    lat--;
                    break;
                case 'E':
                    longi++;
                    break;
                case 'W':
                    longi--;
                    break;
            }
            ans = Math.max(ans, Math.min(Math.abs(lat) + Math.abs(longi) + k*2, i+1));
        }
        return ans;
    }
}
