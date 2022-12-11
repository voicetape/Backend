package com.example.demo.entity;

import lombok.*;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Voice implements CodeEnum {

	BLUE(1, "VOICE_BLUE", "파랑"),
	FEMALE(2, "VOICE_FEMALE", "여지"),
	MALE(3, "VOICE_MALE", "남자"),
	KID(4, "VOICE_KID", "잼민");

	private final int id;

	private final String code;
	private final String name;

	private static final Map<String, Role> codeMap = new HashMap<>();
	static {
		Stream.of(Role.values()).forEach(voice -> codeMap.put(voice.getCode(), voice));
	}

	@Override
	public Role getEnumByCode(String code) {
		return Optional.ofNullable(codeMap.get(code))
				.orElseThrow(ValidationException::new);
	}

}
