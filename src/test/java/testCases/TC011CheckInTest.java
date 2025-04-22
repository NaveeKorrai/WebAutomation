package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BookingPage;
import testBase.BaseClass;

public class TC011CheckInTest extends BaseClass {

	@BeforeTest
	public void testDetails() {
		testName = "TC011_CheckInTest";
		testDescription = "Flight CheckIn on Spicejet website";
		testAuthor = "Naveen";
	}

	@Test
	public void TC011CheckIn() throws IOException, InterruptedException {
		BookingPage bookingpage = new BookingPage();
		bookingpage.flightCheckIn();
		Assert.assertTrue(bookingpage.checkInErrorText().contains("Unable to fetch your booking."));
		takeScreenshot("TC011_CheckInTest");
		if (bookingpage.checkInErrorText().contains("Unable to fetch your booking.")) {
			test.pass("Flight checkIn test passed");
		} else
			test.fail("Flight checkIn test failed");
	}
}
