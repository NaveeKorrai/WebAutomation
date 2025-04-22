/**
 * Framework Base Class
 * @author Naveen Korrai
 */
package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.UtilClass;

public class BaseClass extends UtilClass {
	
	
	@BeforeSuite
	public void startReport() {
	    String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss").format(new Date()); // fixed date format for file naming
	    String reportPath = System.getProperty("user.dir") + "/Reports/Result : " + timeStamp + ".html";
	    File reportDir = new File(System.getProperty("user.dir") + "/Reports");
	    if (!reportDir.exists()) {
	        reportDir.mkdirs();
	    }
	    ExtentHtmlReporter reporter = new ExtentHtmlReporter(reportPath);
	    reporter.setAppendExisting(false);
	    
	    extent = new ExtentReports();
	    extent.attachReporter(reporter);
	}

	@BeforeClass
	public void detail() {
		test = extent.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);

	}

	@BeforeMethod()
	public void setUp() throws Exception {
		LaunchBrowser(readProperty("browser"));
		launch(readProperty("url"));

	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}


	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
