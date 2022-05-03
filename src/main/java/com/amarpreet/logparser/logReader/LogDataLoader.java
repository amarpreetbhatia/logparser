package com.amarpreet.logparser.logReader;

import com.amarpreet.logparser.data.LogData;

import java.util.List;

public interface LogDataLoader {

    List<String[]> loadLogData(String filepath);
    List<LogData> covertToLogData(List<String[]> logdata);
}
