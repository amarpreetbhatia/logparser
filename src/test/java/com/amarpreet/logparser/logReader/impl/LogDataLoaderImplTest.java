package com.amarpreet.logparser.logReader.impl;

import com.amarpreet.logparser.data.LogData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogDataLoaderImplTest {
    LogDataLoaderImpl logDataLoader = new LogDataLoaderImpl();

    @Test
    void testLoadLogDataWithValidFilePath() {

        List<String[]> loadLogData = logDataLoader
                .loadLogData("C:\\Users\\amarpreet\\Downloads\\logparser\\logparser\\src\\main\\resources\\programming-task-example-data.log");

        Assertions.assertEquals(23,loadLogData.size());
    }

    @Test
    void testCovertToLogData() {

        String[] line = "177.71.128.21 - - [10/Jul/2018:22:21:28 +0200] \"GET /intranet-analytics/ HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (X11; U; Linux x86_64; fr-FR) AppleWebKit/534.7 (KHTML, like Gecko) Epiphany/2.30.6 Safari/534.7\"".split(" ");
        List<String[]> lines = new ArrayList<>();
        lines.add(line);
        List<LogData> logData = logDataLoader.covertToLogData(lines);
        assertEquals("177.71.128.21", logData.get(0).getIpAddress());
        assertEquals("/intranet-analytics/", logData.get(0).getUrl());
        assertEquals(200, logData.get(0).getHttpStatus());
    }


}