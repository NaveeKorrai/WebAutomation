package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BookingPage;
import testBase.BaseClass;

public class TC006SearchForFlightRoundTripTest extends BaseClass {

	@BeforeTest
	public void testDetails() {
		testName = "TC006_searchFlightforRoundTrip";
		testDescription = "Searching for flight on Spicejet website for round trip";
		testAuthor = "Naveen Korrai";
	}

	@Test
	public void TC006_searchFlightforRoundTripTest() throws InterruptedException, IOException {
		BookingPage bookingpage = new BookingPage();
		bookingpage.roundtripBooking();
		Assert.assertTrue(bookingpage.roundtripText().contains("Mumbai to Bengaluru"));
		takeScreenshot("TC006_searchFlightforRoundTripTest");
		if (bookingpage.roundtripText().contains("Mumbai to Bengaluru")) {
			test.pass("Round trip flight search test passed");
		} else
			test.fail("Round trip flight search test failed!");

	}

}

