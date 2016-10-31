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

	public void execute(CommandLine cmd) throws IOException {
		if (cmd.hasOption(COMMAND_NAME)) {
			System.out.println(httpClient.getURL("https://www.appdirect.com"));
		}
	}
}
