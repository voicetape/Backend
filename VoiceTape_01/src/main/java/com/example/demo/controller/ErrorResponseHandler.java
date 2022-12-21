package com.example.demo.controller;

import com.example.demo.dto.ErrorCode;
import com.example.demo.exception.ApiException;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
