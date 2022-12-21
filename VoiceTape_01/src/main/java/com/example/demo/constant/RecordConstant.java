package com.example.demo.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RecordConstant {
    CONTENT_TYPE("audio/mpeg"),
    FILE_EXTENSION(".mp3");

    private final String value;
}
