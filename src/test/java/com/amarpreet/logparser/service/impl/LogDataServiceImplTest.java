package com.amarpreet.logparser.service.impl;

import com.amarpreet.logparser.data.LogData;
import com.amarpreet.logparser.logReader.impl.LogDataLoaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class LogDataServiceImplTest {
    public static LogDataLoaderImpl logDataLoader = new LogDataLoaderImpl();
    public static List<LogData> logDataList = null;
    LogDataServiceImpl service = new LogDataServiceImpl();

    @BeforeAll
    static void setUp() {
        logDataList = logDataLoader.covertToLogData(logDataLoader.loadLogData(null));
    }

    @Test
    void getNumberOfUniqueIP() {
        Integer numberOfUniqueIP = service.getNumberOfUniqueIP(logDataList);
        Assertions.assertEquals(11,numberOfUniqueIP);
    }

    @Test
    void getTop3VisitedURLS() {
        List<String> top3VisitedURLS = service.getTop3VisitedURLS(logDataList);
        Assertions.assertEquals("http://example.net/faq/",top3VisitedURLS.get(0));
        Assertions.assertEquals("http://example.net/blog/category/meta/",top3VisitedURLS.get(1));
        Assertions.assertEquals("/translations/",top3VisitedURLS.get(2));
    }

    @Test
    void getTop3ActiveIP() {
        List<String> top3ActiveIP = service.getTop3ActiveIP(logDataList);
        Assertions.assertEquals("79.125.00.21",top3ActiveIP.get(0));
        Assertions.assertEquals("72.44.32.10",top3ActiveIP.get(1));
        Assertions.assertEquals("50.112.00.28",top3ActiveIP.get(2));
    }
}