package com.appdirect;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
	public HttpResponse getURL(String url) throws IOException {
		URL urlObject = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		return new HttpResponse(connection.getResponseCode(), getBody(connection));
	}

	private String getBody(HttpURLConnection connection) throws IOException {
		boolean isSuccess = connection.getResponseCode() >= 200 && connection.getResponseCode() < 300;
		InputStream stream = isSuccess ? connection.getInputStream() : connection.getErrorStream();
		return convertStreamToString(stream);
	}

	private String convertStreamToString(InputStream stream) throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = stream.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		return result.toString("UTF-8");
	}
}
