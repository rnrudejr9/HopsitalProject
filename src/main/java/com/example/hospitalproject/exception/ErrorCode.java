package com.example.hospitalproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "User name is duplicated"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    USER_NOT_FOUNDED(HttpStatus.NOT_FOUND, ""),
    NOT_FOUNDED(HttpStatus.NOT_FOUND, ""),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, ""),
    HOSPITAL_NOT_FOUND(HttpStatus.NOT_FOUND,"hospital not found"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"user not found");

    private HttpStatus status;
    private String message;
}