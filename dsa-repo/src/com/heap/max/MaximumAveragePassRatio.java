package com.heap.max;

import java.util.PriorityQueue;

/*
1792. Maximum Average Pass Ratio

There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.

You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.



Example 1:

Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
Output: 0.78333
Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.

TC : o(nlogn)
SC: o(n)
 */
public class MaximumAveragePassRatio {

    public static void main(String[] args) {
        System.out.println(new MaximumAveragePassRatio().maxAverageRatio(
                new int[][]{{1,2},{3,5},{2,2}}, 2
        ));
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Lambda to calculate the gain of adding an extra student
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) ->
                Double.compare(b[0], a[0])
        );

        for (int[] singleClass : classes) {
            int passes = singleClass[0];
            int totalStudents = singleClass[1];
            double gain = calculateGain(passes, totalStudents);
            maxHeap.offer(new double[] { gain, passes, totalStudents });
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] current = maxHeap.poll();
            double currentGain = current[0];
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            maxHeap.offer(
                    new double[] {
                            calculateGain(passes + 1, totalStudents + 1),
                            passes + 1,
                            totalStudents + 1,
                    }
            );
        }

        // Calculate the final average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }

        return totalPassRatio / classes.length;
    }

    private double calculateGain(int passes, int totalStudents) {
        return (
                (double) (passes + 1) / (totalStudents + 1) -
                        (double) passes / totalStudents
        );
    }
}
