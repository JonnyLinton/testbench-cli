package com.appdirect;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public class SendCommand {
	private static final String COMMAND_NAME = "send";

	private HttpClient httpClient;

	public SendCommand(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public void registerOption(Options options) {
		options.addOption(COMMAND_NAME, true, "sends an event of type <type>. Supported type is ORDER.");
	}

	public void execute(CommandLine cmd) throws IOException, InterruptedException {
		if (cmd.hasOption(COMMAND_NAME)) {
			Thread.sleep(6000);
			HttpResponse response = httpClient.getURL("http://localhost:8888/subscription/order");
			System.out.println("Response: " + response.responseCode + " Body: \n" + response.body);
		}
	}
}
