package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.SignUpPage;
import testBase.BaseClass;

public class TC004SignUpwithInvalidDetailsTest extends BaseClass {
	
	@BeforeTest
	public void testDetails() {
		testName = "TC004_SignUpwithInvalidDetails";
		testDescription = "Create an account on Spicejet website with invalid credentials";
		testAuthor = "Naveen";
	}
	
	@Test
	public void TC004_SignUpwithInvalidDetails() throws IOException, InterruptedException {
		
		SignUpPage signup = new SignUpPage();
		signup.SignUpInvalid();
		Assert.assertEquals(signup.signMandatoryError(), "Please fill all mandatory fields marked with an '*' to proceed");
		takeScreenshot("TC004_SignUpwithInvalidDetails");
		if (signup.signMandatoryError().contains("Please fill all mandatory fields")) {
			test.pass("SignUp with invalid details test passed");
		} else
			test.fail("SignUp with invalid details test failed");

		
	}
}
