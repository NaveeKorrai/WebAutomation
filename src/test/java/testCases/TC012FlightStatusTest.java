package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BookingPage;
import testBase.BaseClass;

public class TC012FlightStatusTest extends BaseClass {

	@BeforeTest
	public void testDetails() {
		testName = "TC011_CheckInTest";
		testDescription = "Flight CheckIn on Spicejet website";
		testAuthor = "Naveen";
	}

	@Test
	public void TC012FlightStatus() throws IOException, InterruptedException {
		BookingPage bookingpage = new BookingPage();
		bookingpage.flightStatus();
		Assert.assertTrue(bookingpage.flightStatusMessage().contains("All times displayed are the selected airport local time"));
		takeScreenshot("TC012_flightStatusTest");
		if (bookingpage.flightStatusMessage().contains("selected airport local time")) {
			test.pass("Flight Status test passed");
		} else
			test.fail("Flight Status test failed");}
}

