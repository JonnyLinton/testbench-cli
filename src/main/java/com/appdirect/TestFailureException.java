package com.appdirect;

public class TestFailureException extends RuntimeException {

	public TestFailureException(String command, String message) {
		super("FAILURE for: " + command + " -- " + message);
	}
}
