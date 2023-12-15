package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1436. Destination City

You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to
cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one
destination city.



Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip
consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

TC : o(n)
SC: o(n)
 */
public class DestinationCity {

    public static void main(String[] args) {
        System.out.println(new DestinationCity().destCity(
                List.of(
                        List.of("London","New York"),
                        List.of("New York","Lima"),
                        List.of("Lima","Sao Paulo"))
        ));
    }
    public String destCity(List<List<String>> paths) {
        Map<String,List<String>> map = new HashMap<>();
        for(List<String> path : paths){
            map.computeIfAbsent(path.get(0), value -> new ArrayList<>()).add(path.get(1));
            map.putIfAbsent(path.get(1), new ArrayList<>());
        }

        for(String key : map.keySet()){
            if(map.get(key).size()==0)
                return key;
        }
        return "";
    }

}
