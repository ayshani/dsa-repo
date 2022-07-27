package com.binarysearch;

import java.util.Map;
import java.util.TreeMap;

/*
 * 2055. Plates Between Candles
 *
 * There is a long table with a line of plates and candles arranged on top of it.
 * You are given a 0-indexed string s consisting of characters '*' and '|' only,
 * where a '*' represents a plate and a '|' represents a candle.

You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti]
denotes the substring s[lefti...righti] (inclusive). For each query,
you need to find the number of plates between candles that are in the substring.
A plate is considered between candles if there is at least one candle to its left
and at least one candle to its right in the substring.

For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|".
The number of plates between candles in this substring is 2, as each of the two plates
 has at least one candle in the substring to its left and right.
Return an integer array answer where answer[i] is the answer to the ith query.

Example:
Input: s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
Output: [9,0,0,0,0]
Explanation:
- queries[0] has nine plates between candles.
- The other queries have zero plates between candles.

TC : O(nlogn)
SC : O(n)
 */
public class PlatesBetweenCandles {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PlatesBetweenCandles obj = new PlatesBetweenCandles();
        String s = "***|**|*****|**||**|*";
        int[][] queries = new int [][] {{1,17},{4,5},{14,17},{5,11},{15,16}};
        int[] res = obj.platesBetweenCandles(s, queries);
        for(int e : res) {
            System.out.print(e + " ");
        }
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];

        TreeMap<Integer,Integer> map = new TreeMap<>();
        int countPlates =0;
        /*
         * whenever we will get a candle, we will add total plate count so far in TreeMap
         */
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='|')
                map.put(i,countPlates);
            else
                countPlates++;
        }


        for(int i=0;i<n;i++){
            /*
             * get the position of  starting candles on queries[i][0] or right next to it
             * get the position of  ending candles on queries[i][1] or left next to it
             */
            Map.Entry<Integer,Integer> left = map.ceilingEntry(queries[i][0]), right = map.floorEntry(queries[i][1]);
            /*
             * Incase we get the boundary of candles, get the difference between this two positions plate values
             */
            if(null != left && null!= right){
                res[i] =  Math.max(0,right.getValue()-left.getValue());
            }
        }

        return res;
    }

}
