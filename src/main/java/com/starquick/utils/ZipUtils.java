package com.starquick.utils;

import com.starquick.constants.FrameworkConstants;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;


public class ZipUtils {

	/* make Zip file of Extent Reports in Project Root folder */
	public static void zip() {

		/*
		 * FrameworkConstants.getExtentReportFolderPath():
		 * D:\Work_In_Local_Machine\OneDrive -
		 * Nagarro\Eclipse_Java_Developers_06_2021_Copy\LearningWS\Final_Code\
		 * OC_MasterSeleniumFramework/ExtentReports/
		 * FrameworkConstants.getZipped_ExtentReports_Folder_Name(): ExtentReports.zip
		 */

//		ZipUtil.pack(new File(FrameworkConstants.getExtentReportFolderPath()),
//				new File(FrameworkConstants.getZipped_ExtentReports_Folder_Name()));


		ZipUtil.pack(new File(FrameworkConstants.getExtendFileReports()),
				new File(FrameworkConstants.getZipped_ExtentReports_Folder_Name()));

		System.out.println("Zipped ExtentReports folder successfuly");
	}

	//public static void main(String[] args) {
//		System.out.println(
//				"FrameworkConstants.getExtentReportFolderPath(): " + FrameworkConstants.getExtentReportFolderPath());
//		System.out.println("FrameworkConstants.getZipped_ExtentReports_Folder_Name(): "
//				+ FrameworkConstants.getZipped_ExtentReports_Folder_Name());
//		String reportsLocation = FrameworkConstants.getProjectPath() + "/ExtentReports";
		//ZipUtil.pack(new File("C:\\Users\\admin\\Desktop\\advance\\advance\\extent-test-output\\"), new File("ExtentReports.zip"));

	//}

}