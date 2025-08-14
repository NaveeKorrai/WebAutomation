package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CharterPage;
import testBase.BaseClass;

public class TC013BookYourCharterTest extends BaseClass {

	@BeforeTest
	public void testDetails() {
		testName = "TC013_BookYourCharter";
		testDescription = "Book your charter on Spicejet website";
		testAuthor = "Naveen Korrai";
	}

	@Test
	public void TC013BookCharter() throws IOException, InterruptedException {
		CharterPage charter = new CharterPage();
		//this line is to work with charter page
		charter.charterStatus();
		
		takeScreenshot("TC013_BookYourCharter");

	}
}

