package com.string.manipulation;
/*
2272. Substring With Largest Variance

The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters
present in the string. Note the two characters may or may not be the same.

Given a string s consisting of lowercase English letters only, return the largest variance possible among all
substrings of s.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: s = "aababbb"
Output: 3
Explanation:
All possible variances along with their respective substrings are listed below:
- Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
- Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
- Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
- Variance 3 for substring "babbb".
Since the largest possible variance is 3, we return it.
 */
public class SubstringWithLargestVariance {

    public static void main(String[] args) {
        System.out.println(new SubstringWithLargestVariance().largestVarianceV1("aababbb"));
        System.out.println(new SubstringWithLargestVariance().largestVarianceV2("aababbb"));
    }
    public int largestVarianceV1(String s) {
        int n=s.length();
        int ans =0;
        for(char i= 'a';i<='z';i++){
            for(char j ='a';j<='z';j++){
                if(i==j)
                    continue;

                char[] aux = s.toCharArray();
                for(int it =1;it<=2;it++){
                    int count1=0,count2=0;
                    for(char c: aux){
                        if(c==i){
                            count1++;
                        }
                        if(c==j)
                            count2++;

                        if(count1<count2)
                        {
                            count1=0;
                            count2=0;
                        }

                        if(count1>0 && count2>0)
                            ans = Math.max(ans, count1-count2);
                    }
                    rev(aux);
                }
            }
        }

        return ans;
    }

    private void rev(char[] c){
        int l=0,h = c.length-1;
        while(l<h){
            char temp=c[l];
            c[l]=c[h];
            c[h]=temp;
            l++;
            h--;
        }
    }

    /*
    Time complexity: O(n * k^2)
Kadane's algorithm requires O(n) time to traverse s. For each pair of alphabets (major, minor), we need to
traverse s once. In the worst-case scenario, s contains k=26k = 26k=26 different letters, so there are
    k⋅(k−1) possible pairs of letters.
Space complexity: O(1)

In the Kadane's algorithm, we only need to update a few variables, major_count, minor_count, rest_minor and
global_max, which require O(1) space.
     */
    public int largestVarianceV2(String s) {
        int[] counter = new int[26];
        for (char ch : s.toCharArray()) {
            counter[(int)(ch - 'a')]++;
        }
        int globalMax = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                // major and minor cannot be the same, and both must appear in s.
                if (i == j || counter[i] == 0 || counter[j] == 0) {
                    continue;
                }

                // Find the maximum variance of major - minor.
                char major = (char)('a' + i);
                char minor = (char)('a' + j);
                int majorCount = 0;
                int minorCount = 0;

                // The remaining minor in the rest of s.
                int restMinor = counter[j];

                for (char ch : s.toCharArray()) {
                    if(ch == major) {
                        majorCount++;
                    }
                    if(ch == minor) {
                        minorCount++;
                        restMinor--;
                    }

                    // Only update the variance if there is at least one minor.
                    if (minorCount > 0)
                        globalMax = Math.max(globalMax, majorCount - minorCount);

                    // We can discard the previous string if there is at least one remaining minor.
                    if (majorCount < minorCount && restMinor > 0) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }

        return globalMax;
    }
}
