package com.ty.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestEnv {

	@Value(value="${msg}")
	private String message;
	
	public String getMessage() {
		return message;
	}
}
