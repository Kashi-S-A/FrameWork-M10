package com.ty.cp.rs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure<T> {

	private String message;
	
	private T data;
}
