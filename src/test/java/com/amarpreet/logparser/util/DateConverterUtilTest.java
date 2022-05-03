package com.amarpreet.logparser.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateConverterUtilTest {

    @Test
    void convertToDate() {
        String lDate = "[10/Jul/2018:22:21:28";
        Date date = DateConverterUtil.convertToDate(lDate);
        Assertions.assertNotNull(date);
    }
}