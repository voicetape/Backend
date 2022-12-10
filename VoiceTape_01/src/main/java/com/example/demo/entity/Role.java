package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RequiredArgsConstructor
public enum Role implements CodeEnum {
    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private final int id;
    private final String name;

    private static final Map<String, Role> nameMap = new HashMap<>();
    static {
        Stream.of(Role.values()).forEach(role -> nameMap.put(role.getName(), role));
    }

    @JsonCreator
    public Role getEnumByName(String name) {
        return nameMap.get(name);
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
