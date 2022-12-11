package com.example.demo.controller;

import com.example.demo.dto.ErrorCode;
import com.example.demo.exception.ApiException;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ErrorResponseHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(ApiException e) {
        return ErrorResponse.of(e.getErrorCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ErrorResponse.of(ErrorCode.INVALID_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        return ErrorResponse.of(ErrorCode.USER_NOT_FOUND);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        return ErrorResponse.of(ErrorCode.DUPLICATE_RESOURCE);
    }

    @Data
    @Builder
    static class ErrorResponse {
        private Integer status;
        private String code;
        private String message;

       public static ResponseEntity<ErrorResponse> of(ErrorCode errorCode) {
           return ResponseEntity
                   .status(errorCode.getHttpStatus())
                   .body(
                           ErrorResponse.builder()
                                   .status(errorCode.getHttpStatus().value())
                                   .code(errorCode.name())
                                   .message(errorCode.getMessage())
                                   .build()
                   );
       }
    }
}
