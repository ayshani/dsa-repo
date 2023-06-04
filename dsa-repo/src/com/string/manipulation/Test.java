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
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Test obj = new Test();
        //obj.parseDate("Mon Dec 28 15:18:16 2021");
        //obj.convertDateV2("29-02-2023");
        //obj.chnageDateFromEpoch();
        obj.check();
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


    public void check(){
        Employee e1 = new Employee(1,"abc");
        Employee e2 = new Employee(1,"abc");
        Map<Employee, String> empMap = new HashMap<>();
        empMap.put(e1, "employee 1");
        empMap.put(e2, "employee 2");

        for(int i=0;i<98;i++) {
            Employee e = new Employee(i, "abc");
            empMap.put(e, "employee "+i);
        }

        System.out.println(empMap.size());
        for(int i=0;i<100;i++){
            System.out.println("------- "+i+" --------");
            System.out.println(empMap.get(e1));
            System.out.println(empMap.get(e2));
        }
    }

}

class Employee{
    int id;
    String name;

    public Employee(int id, String name){
        this.id = id;
        this.name =name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

