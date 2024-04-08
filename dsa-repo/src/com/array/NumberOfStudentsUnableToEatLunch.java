package com.array;
/*
1700. Number of Students Unable to Eat Lunch

The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.

The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:

If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
Otherwise, they will leave it and go to the queue's end.
This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the
 ith sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the
  jth student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable
  to eat.

Example 1:

Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0
Explanation:
- Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
- Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
- Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
- Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
- Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
Hence all students are able to eat.

TC : o(n)
SC: o(1)
 */
public class NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {
        System.out.println(new NumberOfStudentsUnableToEatLunch()
                .countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
    }
    public int countStudents(int[] students, int[] sandwiches) {
        int squareSandwich =0, circleSandwich =0;
        for(int student :students){
            if(student==0){
                circleSandwich++;
            } else{
                squareSandwich++;
            }
        }

        for(int sandwich : sandwiches){
            // No student wants the circle sandwich on top of the stack
            if(sandwich ==0 && circleSandwich==0){
                return squareSandwich;
            }
            // No student wants the square sandwich on top of the stack
            if(sandwich ==1 && squareSandwich==0){
                return circleSandwich;
            }
            // Decrement the count of the served sandwich type
            if(sandwich ==0){
                circleSandwich--;
            } else{
                squareSandwich--;
            }
        }
        return 0;
    }
}
