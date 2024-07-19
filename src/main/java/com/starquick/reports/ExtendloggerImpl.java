package com.starquick.reports;

public class ExtendloggerImpl implements Loggable {

	@Override
	public void log(String status, String message) {
		if(status.equalsIgnoreCase("pass")) {
		ExtendReportManager.getExtendTest().pass(message);
		}else if(status.equalsIgnoreCase("fail")) {
			ExtendReportManager.getExtendTest().fail(message);
		}
		
	}

}
