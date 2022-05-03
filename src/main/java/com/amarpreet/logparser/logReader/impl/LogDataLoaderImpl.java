package com.amarpreet.logparser.logReader.impl;

import com.amarpreet.logparser.data.LogData;
import com.amarpreet.logparser.logReader.LogDataLoader;
import com.amarpreet.logparser.util.DateConverterUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class LogDataLoaderImpl implements LogDataLoader {

    @Override
    public List<String[]> loadLogData(String filepath) {
        if (filepath == null) {
            log.info("filepath not found, loading from default location");
            filepath = "C:\\Users\\amarpreet\\Downloads\\logparser\\logparser\\src\\main\\resources\\programming-task-example-data.log";
        }
        List<String[]> lines = null;
        try (Stream<String> stream = Files.lines(Paths.get(filepath))) {
            lines = stream
                    .map(line -> line.split(" "))
                    .collect(Collectors.toList());
        } catch (IOException ie) {
            log.error("internal error in loading file");
        }
        log.info("number of lines read in files {}", lines != null ? lines.size() : null);
        return lines;
    }

    @Override
    public List<LogData> covertToLogData(List<String[]> logdata) {
        List<LogData> logDataList = Collections.emptyList();
        try {
            logDataList = logdata
                    .stream()
                    .map(line -> LogData.builder()
                            .ipAddress(line[0])
                            .ldate(DateConverterUtil.convertToDate(line[3]))
                            .url(line[6])
                            .httpStatus(Integer.valueOf(line[8]))
                            .build())
                    .collect(Collectors.toList());
        }catch (Exception e) {
            log.info("Invalid record found in logs while parsing");
    }

        return logDataList;
    }

}
