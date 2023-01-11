package com.mask.masking.utility;

import org.springframework.stereotype.Component;

@Component
public class MaskUtility {

    protected static String field[] = {};


    public void getFields(String []fields) {

        field = fields;
    }

    protected String replaceField(String text) {

        return text.replaceAll("(?<=..).(?=..)", "*");
    }
    protected Integer replaceField(Integer num) {

        return Integer.parseInt(Integer.toString(num).replaceAll("(?<=..).(?=..)", "*"));
    }
}
