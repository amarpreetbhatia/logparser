package com.amarpreet.logparser.service.impl;

import com.amarpreet.logparser.data.LogData;
import com.amarpreet.logparser.data.LogDataSummaryDetail;
import com.amarpreet.logparser.logReader.impl.LogDataLoaderImpl;
import com.amarpreet.logparser.service.LogDataSummaryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogDataSummaryDetailServiceImpl implements LogDataSummaryDetailService {

    @Autowired
    LogDataServiceImpl service;


    @Override
    public LogDataSummaryDetail fetchLogDataSummary() {
        LogDataLoaderImpl logDataLoader = new LogDataLoaderImpl();
        List<LogData> logDataList = logDataLoader.covertToLogData(logDataLoader.loadLogData(null));
        Integer numberOfUniqueIP = service.getNumberOfUniqueIP(logDataList);
        List<String> top3VisitedURLS = service.getTop3VisitedURLS(logDataList);
        List<String> top3ActiveIP = service.getTop3ActiveIP(logDataList);
        return LogDataSummaryDetail.builder()
                .numberOfUnique(numberOfUniqueIP.toString())
                .top3Urls(top3VisitedURLS)
                .top3Ips(top3ActiveIP)
                .build();
    }
}
