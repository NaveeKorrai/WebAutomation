/**
 * Framework Base Class
 * @author Naveen Korrai
 */
package testBase;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.UtilClass;

public class BaseClass extends UtilClass {
	//public  Logger logger;
	//protected static Logger logger = LogManager.getLogger();
	protected Logger logger = LogManager.getLogger(getClass());
	public static String reportPath;
	//	public static ExtentReports extent;
	//	public static ExtentSparkReporter sparkReporter;

	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test; // For logging steps in report
	//public static Logger logger = LogManager.getLogger(BaseTest.class);


	//	@BeforeSuite
	//	public void startReport() {
	//	    String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss").format(new Date()); // fixed date format for file naming
	//	    String reportPath = System.getProperty("user.dir") + "/Reports/Result - " + timeStamp + ".html";
	//	    File reportDir = new File(System.getProperty("user.dir") + "/Reports");
	//	    if (!reportDir.exists()) {
	//	        reportDir.mkdirs();
	//	    }
	//	    ExtentHtmlReporter reporter = new ExtentHtmlReporter(reportPath);
	//	    reporter.setAppendExisting(false);
	//	    extent = new ExtentReports();
	//	    extent.attachReporter(reporter);
	//	}

	@BeforeSuite
	public void startReport() throws Exception {
		// Time stamp for unique report
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss").format(new Date());
		 reportPath = System.getProperty("user.dir") + "/Reports/Result_" + timeStamp + ".html";

		// Create Reports folder
		File reportDir = new File(System.getProperty("user.dir") + "/Reports");
		if (!reportDir.exists()) {
			reportDir.mkdirs();
		}

		// Spark Reporter setup (Dark Theme)
		sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setReportName("Selenium Test Execution Report");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		// System Info
		extent.setSystemInfo("Tester", "Navee");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser", readProperty("browser"));

		logger.info("Extent Report initialized at: " + reportPath);
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
	
	//use this only when you are executing the parallel test
//	@BeforeMethod()
//	@Parameters({"os","browser"})
//	public void setUp(String os, String br)  {
//		
//		logger=LogManager.getLogger(this.getClass());
//		
//		switch(br.toLowerCase())
//		{
//		case "chrome" : driver=new ChromeDriver();
//		case "edge" : driver=new EdgeDriver();
//		case "firefox" : driver=new FirefoxDriver();		
//		default : System.out.println("Invalid browser name"); return;
//
//		}
//	}
	
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}

	@AfterSuite
	public void flushReport() {
		extent.flush();
		try {
			Desktop.getDesktop().browse(new File(reportPath).toURI()); // Use stored path
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Extent Report generated successfully.");
	}

	public void logStep(String message) {
		logger.info(message);      // Log4j2 log
		if (test != null) {
			test.info(message);    // Extent Report log
		}
	}
}
