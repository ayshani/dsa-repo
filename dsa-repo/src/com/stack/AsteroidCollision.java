package com.stack;

import java.util.Arrays;
import java.util.Stack;

/*
735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.


TC : o(n)
SC: o(n)
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        int[] ast = new int[]{5,10,-5};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(ast)));
    }
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null)
            return null;
        if(asteroids.length<=1)
            return asteroids;
        Stack<Integer> st = new Stack<>();

        for(int cur : asteroids){
            // if the current element is +ve, then there is no need to
            // check for previous element as, there can eb two cases:
            // 1. previous element is +ve : hence no collisions
            // 2. previous element is -ve, the its direction is towards left,
            //    and current one's is towards right. hence no collision
            if(cur>0){
                st.push(cur);
                // incase the current element is -ve, we need to take action
            } else{
                // incase, stack is not empty
                // and the previous values are +ve and
                // current one is -ve and greater than those
                // thet pop it out until previous element is +ve>cur or -ve
                while(!st.isEmpty() && st.peek()>0 && -cur > st.peek())
                    st.pop();
                // incase previous element is -ve and its value is same as
                // current one, then pop it
                if(!st.isEmpty() && st.peek()==-cur)
                    st.pop();
                    // incase, stack is empty
                    // one the prev value is -v1, the current -ve is also added
                    // as there ll be no collisions.
                else if(st.isEmpty() || st.peek()<0)
                    st.push(cur);

            }
        }

        //return st.stream().mapToInt(i -> i ).toArray();

        // Add the asteroids from the stack to the vector in the reverse order.
        int[] remainingAsteroids = new int[st.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = st.peek();
            st.pop();
        }
        return remainingAsteroids;
    }
}
