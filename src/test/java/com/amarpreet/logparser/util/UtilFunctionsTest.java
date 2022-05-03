package com.amarpreet.logparser.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class UtilFunctionsTest {

    @Test
    public void sortByValues() {
        HashMap<String,Long> unsortedMap = new HashMap<>();
        unsortedMap.put("url1",3l);
        unsortedMap.put("url2",2l);
        unsortedMap.put("url3",5l);
        unsortedMap.put("url4",3l);
        unsortedMap.put("url5",8l);
        Map<String, Long> sortByValues = UtilFunctions.sortByValues(unsortedMap);
        sortByValues.forEach((k,v) ->
        {
            System.out.println("key " + k + " value " + v);
        });
        List<String> urls = Arrays.asList(sortByValues.keySet().toArray(new String[]{}));
        Collections.sort(urls,Collections.reverseOrder());
        Assertions.assertEquals("url5",urls.get(0));
    }
}
