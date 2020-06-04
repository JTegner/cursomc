package com.nomedaempresa.cursomc.resources.exception;

import java.io.Serializable;

import lombok.Data;

@Data
public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;
	
	public FieldMessage() {
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	
	

}
