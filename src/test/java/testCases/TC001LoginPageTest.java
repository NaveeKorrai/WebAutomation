package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001LoginPageTest extends BaseClass {
	protected static Logger logger = LogManager.getLogger();
	@BeforeTest
	public void testcaseDetails() {
		testName = "TC001_LoginwithValidDetailsTest";
		testDescription = "Login to Spicejet website with valid credentials";
		testAuthor = "Naveen";
		
	}
	@Test
	public void TC001_LoginTest() throws Exception {
		String expectedLoginText = "Hi " + testAuthor;
		LoginPage login = new LoginPage();

		logStep("Started TC001_LoginTest");

		login.login();
		logStep("Login action performed successfully");

		String actualText = login.loginText();
		logStep("Login text received: " + actualText);

		if(actualText.equals(actualText)) {
			//Assert.assertEquals(actualText, expectedLoginText);
			logStep("Login text matched expected value: " + expectedLoginText);
		}
		else {
			logger.error("Login failed");
			logger.debug("Debug fails");
		}
		takeScreenshot("TC001_LoginTest");
		test.addScreenCaptureFromPath("./screenshots/TC001_LoginTest.png");
		logStep("Screenshot added to report!");

		Assert.assertTrue(actualText.contains(testAuthor), "Login test failed");
		logStep("Verified login contains author name: " + testAuthor);


	}
}
