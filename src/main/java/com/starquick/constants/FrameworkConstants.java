package com.starquick.constants;


import com.starquick.utils.PropertyUtils;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public final class FrameworkConstants {

	private FrameworkConstants(){}
	
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String USERDIRECTORY = System.getProperty("user.dir");
	private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static final String EXCELFILEPATH = USERDIRECTORY+"/excel/testdata.xlsx";
	private static final int  EXPLICITWAIT = 10;
	private static final String JSONFILEPATH = USERDIRECTORY+"/json/jsonConfig.json";
	@Getter
    private static final String Zipped_ExtentReports_Folder_Name = "ExtentReports.zip";
	private static final String EXTENDREPORTPATH = USERDIRECTORY+"/extent-test-output" ;
	public static final String ZIPEXTENTREPORT = EXTENDREPORTPATH+"/"+ dateForReport()+"/"+getInstance().dateTime();
	private static 	String extendReporterFile = "";
	@Getter
    private static final	String runerdatasheet = "Sheet1";
	@Getter
    private static final	String execuriondatasheet = "DATA";
	private static final String Project_Name = "Automation Test Suite Report - Infinite - Starquick";
	private static FrameworkConstants FrameworkConstants ;

	public static FrameworkConstants getInstance() {
		if (FrameworkConstants == null) {
			FrameworkConstants = new FrameworkConstants();
		}
		return FrameworkConstants;
	}

    public static String getExtendFileReports() {
		if(extendReporterFile.isEmpty()) {
			extendReporterFile= createReportPath();
		}
		
		return extendReporterFile;
		
	}
	private static String createReportPath() {
		if(PropertyUtils.get("overridereports").toLowerCase().equalsIgnoreCase("yes")) {

			return EXTENDREPORTPATH+"/"+ dateForReport()+"/"+getInstance().dateTime()+"index.html";
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
	public static String getExcelfilepath() {return EXCELFILEPATH;}
	public static String getProjectName() { return Project_Name;}

	private String dateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_dd-MM-yyyy_HHmmss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	private static String dateForReport() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}
