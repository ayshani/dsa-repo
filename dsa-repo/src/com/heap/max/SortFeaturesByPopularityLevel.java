package com.heap.max;

import java.util.*;

/*
1772. Sort Features by Popularity Level

You are given a string array features where features[i] is a single word representing the name of a feature
of the latest product you are working on. You made a survey where users reported which features they like.
You are given a string array responses, where responses[i] is a string containing space-separated words.

You want to sort the features according to their popularity. More formally, let appearances(word) be the
number of is such that responses[i] contains word as a word. Then the x-th feature is more popular than
the y-th feature if appearances(features[x]) > appearances(features[y]).

Return an array sortedFeatures consisting of the feature names sorted by their popularity.
If the x-th and y-th features have the same popularity where x < y, then you should put the x-th feature
before the y-th one.

Example 1:

Input: features = [“cooler”,”lock”,”touch”],
responses = [“i like cooler cooler”,”lock touch cool”,”locker like touch”]

Output: [“touch”,”cooler”,”lock”]


TC : o(nlogn)
SC : o(n)
 */
public class SortFeaturesByPopularityLevel {

    public static void main(String[] args) {
        String[] features =  new String[]{"cooler","lock","touch"};

        String[] response = new String[]{
                "i like cooler cooler", "lock touch cool", "locker like touch"
        };

        String[] res = new SortFeaturesByPopularityLevel().sortFeatures(features,response);

        Arrays.stream(res).forEach(e -> System.out.print(e + " "));
    }
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String,Integer> featureMap = new HashMap<>();

        for(int i=0;i<features.length;i++){
            featureMap.put(features[i], i);
        }

        Map<String,Integer> appearanceMap = new HashMap<>();

        int length = responses.length;

        for(int i=0;i<length;i++){
            String[] currentSentence = responses[i].split(" ");
            Set<String> uniqueWords = new HashSet<>();

            for(String word : currentSentence){
                uniqueWords.add(word);
            }

            for(String feature : features){
                if(uniqueWords.contains(feature)){
                    appearanceMap.put(feature,appearanceMap.getOrDefault(feature,0)+1);
                }
            }
        }

        Arrays.sort(features, (str1, str2) -> {
            int appearanceOfStr1 = appearanceMap.get(str1);
            int appearanceOfStr2 = appearanceMap.get(str2);
            if(appearanceOfStr1==appearanceOfStr2)
                return featureMap.get(str1) - featureMap.get(str2);
            else
                return appearanceOfStr2 - appearanceOfStr1;
        });

        return features;
    }
}
