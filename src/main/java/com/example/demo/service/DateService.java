package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class DateService {
    public static Date dateStringtoDateType(String date) {
        Date localDatetoDate;
        LocalDateTime localDateTime;
        try {
            // Convert HTML5 datetime-local to Date type
            // date to LocalDateTime
            localDateTime = LocalDateTime.parse(date + ":00",
                    DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:00"));
        } catch (Exception e) {
            String localDateTimeString = LocalDateTime.now().toString();
            localDateTime = LocalDateTime.parse(localDateTimeString,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:00"));
        }

        // LocalDateTime to Date
        localDatetoDate = Date.from(localDateTime.atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant());
        return localDatetoDate;
    }

    public static LocalDate dateTypeToLocalDateType(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDate();
    }

    public static Date localDateTypeToDateType(LocalDate localDateToConvert) {
        return Date.from(localDateToConvert.atStartOfDay(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant());
    }

}
