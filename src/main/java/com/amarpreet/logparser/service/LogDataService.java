package com.amarpreet.logparser.service;

import com.amarpreet.logparser.data.LogData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogDataService {

    Integer getNumberOfUniqueIP(List<LogData> logData);
    List<String> getTop3VisitedURLS(List<LogData> logData);
    List<String> getTop3ActiveIP(List<LogData> logData);
}
