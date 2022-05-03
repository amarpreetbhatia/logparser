package com.amarpreet.logparser.service.impl;

import com.amarpreet.logparser.data.LogData;
import com.amarpreet.logparser.service.LogDataService;
import com.amarpreet.logparser.util.UtilFunctions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class LogDataServiceImpl implements LogDataService {

    @Override
    public Integer getNumberOfUniqueIP(List<LogData> logData) {
        return logData
                .stream()
                .map(l -> l.getIpAddress())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public List<String> getTop3VisitedURLS(List<LogData> logData) {
        Map<String, Long> urlsWithCounters = logData.stream()
                .map(line -> line.getUrl())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> urlSortedByCounters = UtilFunctions.sortByValues(urlsWithCounters);
        List<String> sortedUrlList = Arrays
                .asList(urlSortedByCounters.keySet().toArray(new String[]{}));
        Collections.sort(sortedUrlList, Collections.reverseOrder());
        return sortedUrlList.stream().limit(3).collect(Collectors.toList());
    }

    @Override
    // Assuming Top 3 active IP that is most visited with 200 HTTP Response
    public List<String> getTop3ActiveIP(List<LogData> logData) {
        Map<String, Long> urlsWithCounters = logData.stream()
                .filter(line -> line.getHttpStatus().equals(200))
                .map(line -> line.getIpAddress())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> urlSortedByCounters = UtilFunctions.sortByValues(urlsWithCounters);
        List<String> sortedUrlList = Arrays
                .asList(urlSortedByCounters.keySet().toArray(new String[]{}));
        Collections.sort(sortedUrlList, Collections.reverseOrder());
        return sortedUrlList.stream().limit(3).collect(Collectors.toList());
    }
}
