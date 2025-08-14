package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CharterPage;
import testBase.BaseClass;

public class TC014CharterpageValidations extends BaseClass {

	@BeforeTest
	public void testDetails() {
		testName = "TC014_CharterPageValidations";
		testDescription = " Spicejet website Charter page validations";
		testAuthor = "Naveen Korrai";
	}

	@Test
	public void TC014CharterValidations() throws IOException, InterruptedException {
		CharterPage charter = new CharterPage();
		charter.charterPageErrorValidations();
		Assert.assertEquals("Can't leave this field empty", charter.NameMandatory());
		Assert.assertEquals("Please enter valid email", charter.mailMandatory());
		Assert.assertEquals("Please enter valid mobile number", charter.mobileNoMandatory());
		Assert.assertEquals("Please enter valid city", charter.cityMandatory());
		takeScreenshot("TC014_BookYourCharter");

	}
}

