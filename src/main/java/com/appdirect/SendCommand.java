package com.appdirect;

import org.apache.commons.cli.Options;

public class SendOrder {
	public static void registerOption(Options options) {
		options.addOption("send", true, "sends an event of type <type>. Supported type is ORDER.");
	}
}
