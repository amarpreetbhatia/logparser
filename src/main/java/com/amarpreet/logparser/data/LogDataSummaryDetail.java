package com.amarpreet.logparser.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor
public class LogDataSummaryDetail {
    private String numberOfUnique;
    private List<String> top3Urls;
    private List<String> top3Ips;
}
