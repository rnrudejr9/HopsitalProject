package com.example.hospitalproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    HOSPITAL_NOT_FOUND(HttpStatus.NOT_FOUND, "Hospital Not Found"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "UserName Not Found")
    ;

    private HttpStatus status;
    private String message;
}