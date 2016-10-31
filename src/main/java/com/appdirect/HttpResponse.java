package com.appdirect;

public class HttpResponse {

	public final int responseCode;
	public final String body;

	public HttpResponse(int responseCode, String body) {
		this.responseCode = responseCode;
		this.body = body;
	}
}
