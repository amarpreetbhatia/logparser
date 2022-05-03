package com.amarpreet.logparser.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@UtilityClass
@Slf4j
public class DateConverterUtil {
    public static Date convertToDate(String logDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
        Date logDateFormatted = null;
        try {
            String trimedlogDate = logDate.replace("[", "").trim();
            logDateFormatted = formatter.parse(trimedlogDate);
        } catch (ParseException e) {
           log.info("invalid date format {}", e);
        }
        return logDateFormatted;
    }
}

