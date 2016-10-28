package com.appdirect;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public class SendCommand {
	public static final String COMMAND_NAME = "send";

	public void registerOption(Options options) {
		options.addOption(COMMAND_NAME, true, "sends an event of type <type>. Supported type is ORDER.");
	}

	public void execute(CommandLine cmd) {
		if (!cmd.hasOption(COMMAND_NAME)) {
			return;
		}

		System.out.println("SEND!!!!!!!");
	}
}
