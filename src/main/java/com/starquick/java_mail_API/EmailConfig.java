package com.starquick.java_mail_API;

import com.starquick.constants.FrameworkConstants;

/**
 * Data for Sending EMail after execution
 */
public class EmailConfig {

	public static final String SERVER = "smtp.gmail.com";
	public static final String PORT = "587";

	public static final String FROM = "infinitemonitoring09@gmail.com";
	public static final String PASSWORD = "begolhijumdmmoro";

	/* "**********@gmail.com", */
	public static final String[] TO = {"monitoringtrigger@gmail.com"};
	public static final String SUBJECT = FrameworkConstants.getProjectName();
}