package com.amarpreet.logparser.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
@AllArgsConstructor
public class LogData {
    private String ipAddress;
    private Date ldate;
    private String url;
    private Integer httpStatus;
}
