package com.system.growth_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapMessage = new HashMap<>();
        if (responseObj instanceof String) {
            mapMessage.put("message", responseObj);
            map.put("data", mapMessage);
        }else {
            map.put("data", responseObj);
        }
        map.put("message", message);
        map.put("status", status.value());

        return new ResponseEntity<>(map, status);
    }
}
