package com.dp;
/*
2140. Solving Questions With Brainpower

You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

The array describes the questions of an exam, where you have to process the questions in order
(i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving
question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri
questions. If you skip question i, you get to make the decision on the next question.

For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable
to solve questions 2 and 3.
Return the maximum points you can earn for the exam.

Example 1:
Input: questions = [[3,2],[4,3],[4,4],[2,5]]
Output: 5
Explanation: The maximum points can be earned by solving questions 0 and 3.
- Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
- Unable to solve questions 1 and 2
- Solve question 3: Earn 2 points
Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.

TC : o(n^2)
SC: o(n)
 */
public class SolvingQuestionsWithBrainpower {

    public static void main(String[] args) {
        int[][] q = new int[][]{
                {3,2},{4,3},{4,4},{2,5}
        };

        System.out.println(new SolvingQuestionsWithBrainpower().mostPoints(q));
    }
    public long mostPoints(int[][] questions) {
        Long[] dp = new Long[questions.length];
        return util(0,questions,dp);
    }

    /*
    this one is equivalent to 0/1 knapsack problem
    as we always have two choices, either to pick the current index or not to pick
     */
    private long util(int index, int[][] questions, Long[] dp){
        if(index>=questions.length)
            return 0;
        if(null!=dp[index])
            return dp[index];
        long pick = questions[index][0] + util(index + questions[index][1] +1, questions, dp);
        long notPick = util(index+1, questions, dp);
        return dp[index] = Math.max(pick,notPick);
    }
}
