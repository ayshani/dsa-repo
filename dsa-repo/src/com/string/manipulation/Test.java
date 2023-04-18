package com.string.manipulation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        Test obj = new Test();
        obj.parseDate("Mon Dec 28 15:18:16 2021");
    }

    public void parseDate(String stringDate) throws ParseException {
        SimpleDateFormat formatRecived = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy");
        try{
            Date date = (Date)formatRecived.parse(stringDate);
            System.out.println(date);
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            String finalString = newFormat.format(date);
            System.out.println(finalString);
        }catch (ParseException parseException){
            System.out.println(parseException.getMessage());
        }

    }
}


