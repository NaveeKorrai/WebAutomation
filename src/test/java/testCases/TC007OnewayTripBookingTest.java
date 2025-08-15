package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BookingPage;
import pageObjects.PassengerDetailsPage;
import testBase.BaseClass;

public class TC007OnewayTripBookingTest extends BaseClass {

	@BeforeTest
	public void testDetails() {
		testName = "TC007_onewaytripbookingTest";
		testDescription = "Booking a flight for oneway trip by providing passenger and payment details";
		testAuthor = "Naveen Korrai";
	}
	@Test
	public void TC007_onewaytripbookingTest() throws InterruptedException, IOException {
		BookingPage bookingpage = new BookingPage();
		bookingpage.oneWayTripBooking();
		PassengerDetailsPage details = new PassengerDetailsPage();
		details.bookFlight();
		Assert.assertEquals(details.paymenterrorText(), "Either Card Number or Card Pin is Incorrect.");
		takeScreenshot("TC007_onewaytripbookingTest");
		if (details.paymenterrorText().contains("Either Card Number or Card Pin is Incorrect.")) {
			test.pass("Flight booking test passed");
		} else
			test.fail("Flight Booking test failed!");
	}
}
