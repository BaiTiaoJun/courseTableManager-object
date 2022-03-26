package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class PrintJson {
    public static String convertJson(List list) {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
