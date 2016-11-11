package com.appdirect.commands;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import com.appdirect.HttpClient;
import com.appdirect.HttpResponse;

public class OrderCommand implements Command{
	public static final String ORDER = "order";

	private HttpClient httpClient;

	public OrderCommand(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public void registerOption(Options options) {
		options.addOption(ORDER, true, "Sends an event of type ORDER.");
	}

	public void execute(CommandLine cmd) throws IOException, InterruptedException {
		if (cmd.hasOption(ORDER)) {
//			String accountID = cmd.getOptionValue(ORDER);
			HttpResponse response = httpClient.getURL("http://localhost:8888/subscription/order");
			response.isResponseSuccessful(ORDER);
		}
	}
}
