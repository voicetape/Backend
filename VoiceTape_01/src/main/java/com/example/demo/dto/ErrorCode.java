package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "권한 정보가 없는 토큰입니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "요청 정보가 올바르지 않습니다"),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 정보의 사용자를 찾을 수 없습니다."),
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "데이터가 이미 존재합니다."),
    USER_CONFLICT(HttpStatus.CONFLICT, "이미 존재하는 사용자입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
