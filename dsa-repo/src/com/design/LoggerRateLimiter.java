package com.design;

import java.util.HashMap;
import java.util.Map;

/*
359. Logger Rate Limiter

Design a logger system that receives a stream of messages along with their timestamps. Each unique message
should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other
identical messages from being printed until timestamp t + 10).

All messages will come in chronological order. Several messages may arrive at the same timestamp.

Implement the Logger class:

Logger() Initializes the logger object.
bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in
the given timestamp, otherwise returns false.


Example 1:

Input
["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage",
"shouldPrintMessage", "shouldPrintMessage"]
[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
Output
[null, true, true, false, false, false, true]

TC : o(n)
SC: o(n)
 */
public class LoggerRateLimiter {

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }

}

class Logger{
    Map<String,Integer> logger;

    public Logger(){
        logger = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!logger.containsKey(message)){
            logger.put(message, timestamp);
            return true;
        }else{
            int time = logger.get(message);
            if(time+10<=timestamp){
                logger.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}
