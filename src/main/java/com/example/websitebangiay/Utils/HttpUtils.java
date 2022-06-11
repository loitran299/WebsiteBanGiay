package com.example.websitebangiay.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtils {

    private String value;

    public HttpUtils(String value) {
        this.value = value;
    }

    public <T> T toEntity(Class<T> entity) throws JsonProcessingException {
        return new ObjectMapper().readValue(value, entity);
    }

    public static HttpUtils of(BufferedReader reader) throws IOException {
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        return new HttpUtils(json.toString());
    }

}
