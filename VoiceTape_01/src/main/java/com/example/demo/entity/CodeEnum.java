package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public interface CodeEnum {

    int getId();

    @JsonValue
    String getName();

    @JsonCreator
    CodeEnum getEnumByName(String name);
}
