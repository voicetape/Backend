package com.example.demo.entity;

import lombok.*;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Bgm implements CodeEnum {

	ADMIN(1, "ROLE_ADMIN", "관리자"),
	USER(2, "ROLE_USER", "일반 사용자");

	private final int id;

	private final String code;
	private final String name;

	private static final Map<String, Role> codeMap = new HashMap<>();
	static {
		Stream.of(Role.values()).forEach(bgm -> codeMap.put(bgm.getCode(), bgm));
	}

	@Override
	public Role getEnumByCode(String code) {
		return Optional.ofNullable(codeMap.get(code))
				.orElseThrow(ValidationException::new);
	}

}
