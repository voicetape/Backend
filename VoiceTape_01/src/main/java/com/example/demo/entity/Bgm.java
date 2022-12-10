package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Bgm {

	@NonNull private int id;
	@NonNull private String code;
	@NonNull private String name;

}
