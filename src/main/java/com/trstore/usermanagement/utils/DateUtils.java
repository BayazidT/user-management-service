package com.trstore.usermanagement.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    public static Date getStartOfDay(LocalDateTime date) {
//        LocalDateTime startOfDay = date.atStartOfDay();
//        date = date.minusMinutes(59);
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getEndOfDay(LocalDateTime date) {
//        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
//        date = date.plusMinutes(59);
        return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime getSearchRangeStart(Date current, String start, String end) {
        String currentStr = current.toString().split("[.]", 0)[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String finalStart = "", finalEnd = "";

        String[] startArray = start.split("[T]", 0);
        if (startArray[1].split(":").length == 2) {
            finalStart = startArray[0] + " " + startArray[1] + ":00";
        } else {
            finalStart = startArray[0] + " " + startArray[1];
        }

        String[] endArray = end.split("[T]", 0);
        if (endArray[1].split(":").length == 2) {
            finalEnd = endArray[0] + " " + endArray[1] + ":00";
        } else {
            finalEnd = endArray[0] + " " + endArray[1];
        }

        LocalDateTime currentSearch = LocalDateTime.parse(currentStr, formatter);
        LocalDateTime currentStart = LocalDateTime.parse(finalStart, formatter);
        LocalDateTime currentEnd = LocalDateTime.parse(finalEnd, formatter);

        if (currentSearch.getDayOfMonth() == currentStart.getDayOfMonth()) {
            return currentStart;
        } else {
            return LocalDateTime.of(currentSearch.getYear(), currentSearch.getMonth(), currentSearch.getDayOfMonth(), 0, 0, 1);
        }
    }

    public static LocalDateTime getSearchRangeEnd(Date current, String start, String end) {
        String currentStr = current.toString().split("[.]", 0)[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String finalStart = "", finalEnd = "";

        String[] startArray = start.split("[T]", 0);
        if (startArray[1].split(":").length == 2) {
            finalStart = startArray[0] + " " + startArray[1] + ":00";
        } else {
            finalStart = startArray[0] + " " + startArray[1];
        }

        String[] endArray = end.split("[T]", 0);
        if (endArray[1].split(":").length == 2) {
            finalEnd = endArray[0] + " " + endArray[1] + ":00";
        } else {
            finalEnd = endArray[0] + " " + endArray[1];
        }

        LocalDateTime currentSearch = LocalDateTime.parse(currentStr, formatter);
        LocalDateTime currentStart = LocalDateTime.parse(finalStart, formatter);
        LocalDateTime currentEnd = LocalDateTime.parse(finalEnd, formatter);

        if (currentSearch.getDayOfMonth() == currentEnd.getDayOfMonth()) {
            return currentEnd;
        } else {
            return LocalDateTime.of(currentSearch.getYear(), currentSearch.getMonth(), currentSearch.getDayOfMonth(), 23, 59, 59);
        }
    }

    public static LocalDateTime getFloorDate(LocalDateTime date) {
        date = date.minusMinutes(59);
        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), date.getHour(), 0, 0);
    }

    public static LocalDateTime getCeilingDate(LocalDateTime date) {
        date = date.plusMinutes(59);
        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), date.getHour(), 0, 0);
    }

    public static Date stringToDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException pe) {
            pe.printStackTrace();
            throw new RuntimeException("Date parse error.");
        }
    }
}
