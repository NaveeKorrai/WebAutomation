package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BookingPage;
import testBase.BaseClass;

public class TC005SearchforFlightOnewayTest extends BaseClass {

	@BeforeTest
	public void testDetails() {
		testName = "TC005_searchFlightforOneWayTrip";
		testDescription = "Searching for flight on Spicejet website for one way trip";
		testAuthor = "Naveen";
	}

	@Test
	public void TC005_searchFlightforOneWayTrip() throws IOException {
		BookingPage bookingpage = new BookingPage();
		bookingpage.oneWayTripBooking();
		Assert.assertTrue(bookingpage.onewaytripText().contains("Mumbai to Kolkata"));
		takeScreenshot("TC005_searchFlightforOneWayTrip");
		if (bookingpage.onewaytripText().contains("Mumbai to Kolkata")) {
			test.pass("Oneway Flight search test passed");
		} else
			test.fail("Oneway Flight search test failed");
	}
}
