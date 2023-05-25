package com.string.manipulation;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) throws ParseException {
        Test obj = new Test();
        //obj.parseDate("Mon Dec 28 15:18:16 2021");
        //obj.convertDateV2("29-02-2023");
        obj.chnageDateFromEpoch();
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

    public void convertDate(String stringDate) throws ParseException {
        Date srcDate=new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);
        System.out.println(srcDate);

        Date tomorrowDate = new Date(srcDate.getTime() + (1000 * 60 * 60 * 24));
        DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String tomorrowExpected = dateFormat.format(tomorrowDate);
        System.out.println(tomorrowExpected);

        Date yesterdayDate = new Date(srcDate.getTime() - (1000 * 60 * 60 * 24));
        String yesterdayExpected = dateFormat.format(yesterdayDate);
        System.out.println(yesterdayExpected);
    }

    private static final Locale LOCALE = Locale.ENGLISH;
    public void convertDateV2(String stringDate) throws ParseException {
        Date srcDate=new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);
        System.out.println(srcDate);

        DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
                .appendPattern("dd-")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendPattern("-uuuu")
                .toFormatter(LOCALE);
        LocalDate tomorrowDate = new java.sql.Date(srcDate.getTime()).toLocalDate().plusDays(1);

        String tomorrowExpected = tomorrowDate.format(DATE_FORMATTER);
        System.out.println(tomorrowExpected);

        LocalDate yesterdayDate = new java.sql.Date(srcDate.getTime()).toLocalDate().minusDays(1);
        String yesterdayExpected = yesterdayDate.format(DATE_FORMATTER);
        System.out.println(yesterdayExpected);


    }

    public void chnageDateFromEpoch(){
        String syncDateTime = null ;

        try{
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Date date = new Date(timestamp.getTime());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSS z");
            dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
            syncDateTime = dateFormat.format(date);
            System.out.println(syncDateTime);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}


