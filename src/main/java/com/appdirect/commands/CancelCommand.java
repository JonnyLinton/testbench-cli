package com.appdirect.commands;


import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import com.appdirect.HttpClient;
import com.appdirect.HttpResponse;

public class CancelCommand implements Command{
	public static final String CANCEL = "cancel";

	private HttpClient httpClient;

	public CancelCommand(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public void registerOption(Options options) {
		options.addOption(CANCEL, true, "Sends an event of type CANCEL.");
	}

	public void execute(CommandLine cmd) throws IOException, InterruptedException {
		if (cmd.hasOption(CANCEL)) {
			String accountId = cmd.getOptionValue(CANCEL); // TODO: checks?
			HttpResponse response = httpClient.getURL("http://localhost:8888/subscription/cancel/" +accountId); //TODO: correct endpoint
			System.out.println("Response: " + response.responseCode + " Body: \n" + response.body);
		}
	}
}
