package com.appdirect;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws ParseException {
		Options options = new Options();
		SendCommand sendCommand = new SendCommand();
		sendCommand.registerOption(options);

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);

		sendCommand.execute(cmd);
	}
}
