package com.amarpreet.logparser.controller;

import com.amarpreet.logparser.data.LogDataSummaryDetail;
import com.amarpreet.logparser.service.LogDataService;
import com.amarpreet.logparser.service.LogDataSummaryDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogDataRestController {

    @Autowired
    LogDataSummaryDetailService logDataSummaryDetailService;

    @GetMapping("/log/summary")
    public ResponseEntity<LogDataSummaryDetail> logDataSummaryDetail() {
        log.info("logDataSummaryDetail called");
        return ResponseEntity.ok(logDataSummaryDetailService.fetchLogDataSummary());
    }
}
