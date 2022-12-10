package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public interface CodeEnum {

    int getId();

    @JsonValue
    String getCode();

    @JsonCreator
    CodeEnum getEnumByCode(String code);

    String getName();
}
