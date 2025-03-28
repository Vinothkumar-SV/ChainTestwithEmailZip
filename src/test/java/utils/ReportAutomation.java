package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.chaintest.service.ChainPluginService;

public class ReportAutomation {

	public ChromeDriver driver;
	
	public File renamedFile;
	

	@Test
	public void sendReport() {

		System.out.println("Sending Report");

		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String currentUrl = driver.getCurrentUrl();

		System.out.println(currentUrl);
		/*
		 * String reportFolder = "./test-output"; String zipFile =
		 * "./TestNG_Report.html";
		 * 
		 * // Zip the report try { ZipUtils.zipFolder(reportFolder, zipFile); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * 
		 * // Send email with attachment // MailSender.sendMailWithAttachment(zipFile);
		 */

	}

	@BeforeMethod
	public void preMethod() {
		ChainPluginService.getInstance().addSystemInfo("Build#", "1.0");
		ChainPluginService.getInstance().addSystemInfo("Owner Name#", "Vinoth Kumar");
	}

	@AfterMethod
	public void attachScreenshot(ITestResult result) {
		// if (!result.isSuccess()) {
		ChainTestListener.embed(takeScreenshot(), "image/png");
		// }

	}

	/**
	 * takescreenshot
	 * 
	 * @return
	 */

	public byte[] takeScreenshot() {
		return ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.BYTES);
	}

	@AfterClass
	private void renamedReport() throws InterruptedException {

		driver.close();
		try {
			String sourceFolder = "./target/chaintest"; // TestNG report folder
			String zipFile = "./chaintest.zip";
			ZipUtils.zipFolder(sourceFolder, zipFile);

			File filezip = new File("./chaintest.zip");
			renamedFile = new File("./TestNG_ReportwithChain.zp");
			filezip.renameTo(renamedFile);

			//refreshing the Project
			ZipUtils.refreshEclipse();
			
			
			// Send email with attachment
					} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	@AfterSuite
	public void last() {
		
		
		MailSender.sendMailWithAttachment(renamedFile);
		System.out.println("TestNG report folder zipped successfully.");

	}
}
