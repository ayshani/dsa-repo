package com.design;

import java.util.HashMap;
import java.util.TreeMap;

/*
981. Time Based Key-Value Store

Design a time-based key-value data structure that can store multiple values for the same key at different time

stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously,
with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with
the largest timestamp_prev. If there are no values, it returns "".


Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3
                                  and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"

Algorithm
-----------
Create a hashmap keyTimeMap which stores string as key and a sorted map as value, as discussed.

In the set() function, store value at key, timestamp location in keyTimeMap.

In the get() function, we find time equal to or less than timestamp using binary-search on SortedMap.

If no time equal to or less than timestamp exists, we return an empty string.
Otherwise, we return the value stored at the time equal to or just less than timestamp.

TC :
In the set() function, in each call we store a value at (key, timestamp) location, which takes O(L⋅logM) time
as the internal implementation of sorted maps is some kind of balanced binary tree and in worst case we might
have to compare logM nodes (height of tree) of length L each with our key.
Thus, for M calls overall it will take, O(L⋅M⋅logM) time.

In the get() function, we will find correct key in our map, which can take O(L⋅logM) time and then use binary
search on that bucket which can have at most M elements, which takes O(logM) time.
Thus, for N calls overall it will take, O(N⋅(L⋅logM+logM)) time.
 */
public class TimeBasedKeyValueStore {


    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }
}

class TimeMap {

    private HashMap<String, TreeMap<Integer,String>> timeKeyMap;
    public TimeMap() {
        timeKeyMap = new HashMap<String, TreeMap<Integer,String>>();
    }

    public void set(String key, String value, int timestamp) {
        if(!timeKeyMap.containsKey(key)){
            timeKeyMap.put(key,new TreeMap<Integer,String>());
        }

        timeKeyMap.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(!timeKeyMap.containsKey(key))
            return "";

        Integer floorKey = timeKeyMap.get(key).floorKey(timestamp);

        if(null!= floorKey)
            return timeKeyMap.get(key).get(floorKey);

        return "";
    }
}
