package com.amarpreet.logparser.service;

import com.amarpreet.logparser.data.LogDataSummaryDetail;
import org.springframework.stereotype.Service;

@Service
public interface LogDataSummaryDetailService {
    LogDataSummaryDetail fetchLogDataSummary();
}
