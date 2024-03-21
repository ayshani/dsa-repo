package com.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Stack;

/*
587. Erect the Fence

You are given an array trees where trees[i] = [xi, yi] represents the location of a tree in the garden.

You are asked to fence the entire garden using the minimum length of rope as it is expensive.
The garden is well fenced only if all the trees are enclosed.

Return the coordinates of trees that are exactly located on the fence perimeter.

Example 1:
Input: points = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]


Monotone Chain
Algorithm

The idea behing Monotone Chain Algorithm is somewhat similar to Graham Scan Algorithm.
It mainly differs in the order in which the points are considered while being included in the hull.
Instead of sorting the points based on their polar angles as in Graham Scan,
we sort the points on the basis of their x-coordinate values.
If two points have the same x-coordinate values, the points are sorted based on their y-coordinate values.
The reasoning behind this will be explained soon.

In this algorithm, we consider the hull as being comprised of two sub-boundaries-
The upper hull and the lower hull. We form the two portions in a slightly different manner.

We traverse over the sorted points array after adding the initial two points in the hull temporarily
(which are pushed over the stack hull).
For every new point considered, we check if the current point lies in the counter-clockwise direction
relative to the last two points. If so, the current point is staightaway pushed onto hull.
If not(indicated by a positive orientation), we again get the inference that the last point on the hull
needs to lie inside the boundary and not on the boundary. Thus, we keep on popping the points from hull
till the current point lies in a counterclockwise direction relative to the top two points on the hull.

Note that this time, we need not consider the case of collinear points explicitly,
since the points have already been sorted based on their x-coordinate values.
So, the collinear points, if any, will implicitly be considered in the correct order.

Doing so, we reach a state such that we reach the point with the largest x-coordinate.
But, the hull isn't complete yet. The portion of the hull formed till now constitutes the lower poriton of the hull.
Now, we need to form the upper portion of the hull.

Thus, we continue the process of finding the next counterclockwise points and popping in case of a conflict,
but this time we consider the points in the reverse order of their x-coordinate values.
For this, we can simply traverse over the sorted points array in the reverse order.
We append the new upper hull values obtained to the previous hull itself.
At the end, hull gives the points on the required boundary.

TC : o(nlogn)
SC : o(n)
 */
public class ErectTheFence {

    public static void main(String[] args) {
        int[][] p = new int[][]{
                {1,2},{2,2},{4,2}
        };
        int[][] ret = new ErectTheFence().outerTrees(p);
        Arrays.stream(ret).forEach( e -> {Arrays.stream(e).forEach(el -> System.out.print(el+" ")); System.out.println();});
    }
    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }
    public int[][] outerTrees(int[][] points) {
        Arrays.sort(points, (p, q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);
        Stack<int[]> hull = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0)
                hull.pop();
            hull.push(points[i]);
        }
        hull.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0)
                hull.pop();
            hull.push(points[i]);
        }
        // remove redundant elements from the stack
        HashSet<int[]> ret = new HashSet<>(hull);
        return ret.toArray(new int[ret.size()][]);
    }
}
