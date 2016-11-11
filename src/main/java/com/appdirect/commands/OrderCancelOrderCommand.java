package com.appdirect.commands;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import com.appdirect.HttpClient;
import com.appdirect.HttpResponse;
import com.appdirect.TestFailureException;

public class OrderCancelOrderCommand implements Command {
	public static final String OCO = "oco";

	private HttpClient httpClient;

	public OrderCancelOrderCommand(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public void registerOption(Options options) {
		options.addOption(OCO, true, "Sends an Order, then a Cancel, then an Order");
	}

	public void execute(CommandLine cmd) throws IOException, InterruptedException {
		if (cmd.hasOption(OCO)) {
			// ORDER
			HttpResponse response = httpClient.getURL("http://localhost:8888/subscription/order");
			response.isResponseSuccessful(OCO);

			String accountId = response.getAccountIdentifier_fromResponseBody();
			String cpAccountId = response.getCPAccountID();

			//CANCEL
			response = httpClient.getURL("http://localhost:8888/subscription/cancel/" + accountId);
			response.isResponseSuccessful(OCO);

			//ORDER
			response = httpClient.getURL("http://localhost:8888/subscription/order");
			response.isResponseSuccessful(OCO);

			String cpAccountId2 = response.getCPAccountID();

			// VALIDATE
			if (!cpAccountId.equals(cpAccountId2)) {
				// account IDs are not equal -- therefore the OCO command did not succeed.
				throw new TestFailureException(OCO, "The marketplace responded with an invalid accountId. \nExpected = " + cpAccountId+ "\nActual = " + cpAccountId2);
			}
			else{
				System.out.println("Test \'" +OCO +"\' SUCCEEDED!");
			}
		}
	}
}
