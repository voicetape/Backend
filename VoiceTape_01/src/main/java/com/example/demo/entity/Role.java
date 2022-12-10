package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;


@Getter
@RequiredArgsConstructor
public enum Role implements CodeEnum {
    ADMIN(1, "ROLE_ADMIN", "관리자"),
    USER(2, "ROLE_USER", "일반 사용자");

    private final int id;

    private final String code;
    private final String name;

    private static final Map<String, Role> codeMap = new HashMap<>();
    static {
        Stream.of(Role.values()).forEach(role -> codeMap.put(role.getCode(), role));
    }

    @Override
    public Role getEnumByCode(String code) {
        return Optional.ofNullable(codeMap.get(code))
                .orElseThrow(ValidationException::new);
    }

}
