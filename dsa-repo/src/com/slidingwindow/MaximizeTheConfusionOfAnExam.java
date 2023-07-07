package com.slidingwindow;
/*
2024. Maximize the Confusion of an Exam

A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants
to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or
multiple falses in a row).

You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you
are given an integer k, the maximum number of times you may perform the following operation:

Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k
times.

Example 1:

Input: answerKey = "TTFF", k = 2
Output: 4
Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
There are four consecutive 'T's.

TC : o(n)
SC: o(1)
 */
public class MaximizeTheConfusionOfAnExam {

    public static void main(String[] args) {
        System.out.println(new MaximizeTheConfusionOfAnExam().maxConsecutiveAnswers("TTFTTFTT", 1));
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxSize =k;
        int countT =0, countF=0;
        for(int i=0;i<k;i++){
            if(answerKey.charAt(i)=='T')
                countT++;
            else
                countF++;
        }
        int start =0;
        for(int end=k;end<answerKey.length();end++){
            if(answerKey.charAt(end)=='T')
                countT++;
            else
                countF++;

            while(Math.min(countT,countF)>k){
                if(answerKey.charAt(start)=='T')
                    countT--;
                else
                    countF--;
                start++;
            }
            maxSize = Math.max(maxSize, end-start+1);
        }
        return maxSize;
    }
}
