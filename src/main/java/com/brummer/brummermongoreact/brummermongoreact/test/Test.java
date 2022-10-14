package com.brummer.brummermongoreact.brummermongoreact.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Test {

	@Id
	private String id;
	private String name;
	
	public Test(String name) {
		this.name = name;
	}
}
