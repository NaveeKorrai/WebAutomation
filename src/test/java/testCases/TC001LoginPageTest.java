package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001LoginPageTest extends BaseClass {

	@BeforeTest
	public void testcaseDetails() {
		testName = "TC001_LoginTest";
		testDescription = "Login to Spicejet website with valid credentials";
		testAuthor = "Naveen";
	}

	@Test
	public void TC001_LoginTest() throws Exception {
		String expectedLoginText = "Hi " + testAuthor;
		LoginPage login = new LoginPage();
		login.login();
		Assert.assertEquals(login.loginText(), expectedLoginText);
		takeScreenshot("TC001_LoginTest");
		Assert.assertTrue(login.loginText().contains(testAuthor), "Login test failed");

	}}
