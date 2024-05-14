package com.starquick.constants;

import com.starquick.utils.PropertyUtils;

public final class frameworkConstranst {

	private frameworkConstranst(){}
	
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String USERDIRECTORY = System.getProperty("user.dir");
	private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static final String EXCELFILEPATH = USERDIRECTORY+"/excel/testdata.xlsx";
	private static final int  EXPLICITWAIT = 10;
	private static final String JSONFILEPATH = USERDIRECTORY+"/json/jsonConfig.json";
	
	private static final String EXTENDREPORTPATH = USERDIRECTORY+"/extent-test-output" ;
	private static 	String extendReporterFile = "";
	private static 	String runerdatasheet = "Sheet1";
	private static 	String execuriondatasheet = "DATA";
	public static String getExecuriondatasheet() {
		return execuriondatasheet;
	}

	

	public static String getRunerdatasheet() {
		return runerdatasheet;
	}

	public static String getExtendFileReports() throws Exception {
		if(extendReporterFile.isEmpty()) {
			extendReporterFile= createReportPath();
		}
		
		return extendReporterFile;
		
	}
	private static String createReportPath() throws Exception {
		if(PropertyUtils.get("overridereports").toLowerCase().equals("yes")) {
			return EXTENDREPORTPATH+"/"+ System.currentTimeMillis()+"index.html";
		}
		return EXTENDREPORTPATH;
	}

	public static String getJsonfilepath() {
		return JSONFILEPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	public static String getExcelfilepath() {
		return EXCELFILEPATH;
	}

	
}
