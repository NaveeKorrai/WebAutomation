package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002LoginWithInvalidDetailsTest extends BaseClass {

	@BeforeTest
	public void testcaseDetails() {
		testName = "TC002_LoginwithInvalidDetailsTest";
		testDescription = "Login to Spicejet website with invalid credentials";
		testAuthor = "Naveen Korrai";
	}

	@Test
	public void TC002_LoginwithInvalidDetailsTest() throws Exception {
	    LoginPage login = new LoginPage();
	    login.loginInvalid();
	    Assert.assertEquals(login.loginErrortext(), "Please enter valid Email", "Error message mismatch.");
	    if (!login.loginErrortext().contains("Please enter valid Email")) {
	        takeScreenshot("TC002_LoginwithInvalidDetailsTest_Failure");
	    }
	    Assert.assertTrue(login.loginErrortext().contains("Please enter valid Email"), "Login with invalid details test failed");
	}

}
