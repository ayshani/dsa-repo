package com.array;
/*
1491. Average Salary Excluding the Minimum and Maximum Salary

You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary.
Answers within 10-5 of the actual answer will be accepted.

Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500

TC : o(n)
SC: o(1)
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public static void main(String[] args) {
        int[] sal = new int[]{4000,3000,1000,2000};
        System.out.println(new AverageSalaryExcludingTheMinimumAndMaximumSalary().average(sal));
    }
    public double average(int[] salary) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE,sum=0;
        int n = salary.length;
        for(int i=0;i<n;i++){
            sum+=salary[i];
            max= Math.max(max,salary[i]);
            min = Math.min(min, salary[i]);
        }
        System.out.println(max+" "+min);
        return ((sum-max-min)*1.0)/(n-2);
    }
}
