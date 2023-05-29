package com.example.demo.exception;

public class MyCustomeException extends RuntimeException {

	private String msg;

	public MyCustomeException(String msg) {
		super(msg);
		this.msg = msg;
	}

}
