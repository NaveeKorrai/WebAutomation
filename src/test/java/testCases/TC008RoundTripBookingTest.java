package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BookingPage;
import pageObjects.PassengerDetailsPage;
import testBase.BaseClass;

public class TC008RoundTripBookingTest extends BaseClass {

	@BeforeTest
	public void testDetails() {
		testName = "TC008_roundtripbookingTest";
		testDescription = "Booking a flight for round way trip by providing passenger and payment details";
		testAuthor = "Naveen";
	}

	@Test
	public void TC008_roundtripbookingTest() throws InterruptedException, IOException {
		
		BookingPage bookingpage = new BookingPage();
		bookingpage.roundtripBooking();
		PassengerDetailsPage details = new PassengerDetailsPage();
		details.passengerDetails();
		Assert.assertEquals(details.paymenterrorText(), "Something went wrong. Please try again after sometime.");
		takeScreenshot("TC008_roundtripbookingTest");
		if (details.paymenterrorText().contains("Something went wrong. Please try again after sometime.")) {
			test.pass("Flight booking test passed");
		} else
			test.fail("Flight Booking test failed");
	}

}
