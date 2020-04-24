package com.restapi.exception;

public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private String name;

	public RecordNotFoundException(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RecordNotFoundException [name=" + name + "]";
	}
	
	
}
