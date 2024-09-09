package com.kickstart.backend.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ResponseEntityUtil {

    public static ResponseEntity<Object> buildResponseEntity(Map<String, Object> response) {
        int status = (int) response.get("status");
        Object responseObject = response.get("object");

        if (status == 200) {
            return new ResponseEntity<>(responseObject, HttpStatus.OK);
        } else if (status == 201) {
            return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
        } else if (status == 400) {
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
