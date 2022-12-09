package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
public class Bgm {

	@NonNull private int id;
	@NonNull private String code;
	@NonNull private String name;

	public Bgm(int m_id, String m_code, String m_name) {
		this.id = m_id;
		this.code = m_code;
		this.name = m_name;
	}
}
