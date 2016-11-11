package com.appdirect;

import org.json.JSONObject;

public class HttpResponse {

	public final int responseCode;
	public final String body;

	public HttpResponse(int responseCode, String body) {
		this.responseCode = responseCode;
		this.body = body;
	}

	public String getAccountIdentifier_fromResponseBody() {
		JSONObject jsonObject = new JSONObject(this.body);
		String message = jsonObject.getString("accountIdentifier");
		return message;
	}
	
	public String getCPAccountID() {
		JSONObject jsonObject = new JSONObject(this.body);
		String message = jsonObject.getString("message");
		return message.substring(message.indexOf("=") + 2, message.indexOf(",")); // TODO: need to find a better way to parse this. Call CP or maybe add a JSON attribute for example?
	}

	public boolean isResponseSuccessful(String command) {
		if (this.responseCode >= 200 && this.responseCode < 300) {
			System.out.println("responseCode: " + this.responseCode + " Body:\n" + this.body);
			return true;
		} else {
			throw new TestFailureException(command, "The response received was not successful! responseCode: " + this.responseCode + " Body:\n" + this.body);
		}
	}
}
