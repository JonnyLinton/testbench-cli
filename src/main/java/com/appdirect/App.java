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
		options.addOption("helloworld", false, "prints hello world");

		CommandLineParser parser = new DefaultParser();

		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption("helloworld")) {
			System.out.println("Hello World!");
		}
	}
}
