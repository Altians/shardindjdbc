package com.example.demo.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class LocalDateToDateConvert {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(zonedDateTime.toInstant());
        System.out.println(date);

    }

    /**
     * localdate 转换为 date
     * @param localDate
     * @return
     */
    public static Date LocalDateToDate(LocalDate localDate){
        if (localDate == null)
            return null;
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(zonedDateTime.toInstant());
        return date;

    }

    /**
     * date 转换为 localdate
     * @param date
     * @return
     */
    public static LocalDate DateToLocalDate(Date date){
        if (date == null)
            return null;
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zonedDateTime.toLocalDate();
        return localDate;
    }

}
