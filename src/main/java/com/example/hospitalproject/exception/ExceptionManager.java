package com.example.hospitalproject.exception;


import com.example.hospitalproject.domain.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {
    @ExceptionHandler(HospitalReviewException.class)
    public ResponseEntity<?> hospitalReviewExceptionHandler(HospitalReviewException e){
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(Response.error(e.getErrorCode().name()));
    }
}