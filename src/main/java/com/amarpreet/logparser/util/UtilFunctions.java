package com.amarpreet.logparser.util;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class UtilFunctions {

    public Map<String,Long> sortByValues(Map<String,Long> urlsWithCounter) {
        return urlsWithCounter.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1,e2) -> e1, LinkedHashMap::new));
    }
}
