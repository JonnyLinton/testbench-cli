package com.appdirect.commands;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public interface Command {
	void registerOption(Options options);

	void execute(CommandLine cmd) throws IOException, InterruptedException;
}
