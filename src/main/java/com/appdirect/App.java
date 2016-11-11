package com.appdirect;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.appdirect.commands.CancelCommand;
import com.appdirect.commands.OrderCancelOrderCommand;
import com.appdirect.commands.OrderCommand;

public class App {
	public static void main(String[] args) throws ParseException, IOException, InterruptedException {
		Options options = new Options();
		HttpClient httpClient = new HttpClient();

		OrderCommand orderCommand = new OrderCommand(httpClient);
		orderCommand.registerOption(options);

		CancelCommand cancelCommand = new CancelCommand(httpClient);
		cancelCommand.registerOption(options);

		OrderCancelOrderCommand ocoCommand = new OrderCancelOrderCommand(httpClient);
		ocoCommand.registerOption(options);

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption(OrderCommand.ORDER)) {
			orderCommand.execute(cmd);
		} else if (cmd.hasOption(CancelCommand.CANCEL)) {
			cancelCommand.execute(cmd);
		} else if (cmd.hasOption(OrderCancelOrderCommand.OCO)) {
			ocoCommand.execute(cmd);
		}
	}
}
