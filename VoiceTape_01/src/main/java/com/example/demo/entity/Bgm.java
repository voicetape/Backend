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

	CURIOUS_DAY(1, "BGM_CURIOUS_DAY", "신나고 밝은 분위기"),
	ALL_ABOUT(2, "BGM_ALL_ABOUT", "벅참"),
	MOON_DANCE(3, "BGM_MOON_DANCE", "잔잔한 재즈"),
	JINGLE_BELL_FLUTE(4, "BGM_JINGLE_BELL", "크리스마스");

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
