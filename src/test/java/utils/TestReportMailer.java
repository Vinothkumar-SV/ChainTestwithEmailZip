package utils;

import java.io.File;
import java.io.IOException;

public class TestReportMailer {
	public static void main(String[] args) {
		try {
			
			
			
			String sourceFolder = "./test-output"; // TestNG report folder
			String zipFile = "./TestNG_Report.zip";
			ZipUtils.zipFolder(sourceFolder, zipFile);
			
			File filezip = new File("TestNG_Report.zip");
			File renamedFile = new File("TestNG_Report.zp");
			filezip.renameTo(renamedFile);
			System.out.println("TestNG report folder zipped successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
