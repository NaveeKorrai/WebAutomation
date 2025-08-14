package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.BaseClass;

public class BookingPage extends BaseClass {
//Multiple tables in booking page 
	@FindBy(xpath = "//div[@data-testid='check-in-horizontal-nav-tabs']")
	private WebElement checkinTab;

	@FindBy(xpath = "//div[@data-testid='flight status-horizontal-nav-tabs']")	private WebElement flightstatusTab;

	@FindBy(xpath = "//div[@data-testid='manage booking-horizontal-nav-tabs']")
	private WebElement managebookingTab;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement from;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement toDestination;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'])[1]")
	private WebElement onewaytrip;

	@FindBy(xpath = "//div[@data-testid='round-trip-radio-button']")
	private WebElement roundtrip;

	@FindBy(xpath = "//div[contains(text(),'Departure Date')]")
	private WebElement departureDate;

	@FindBy(xpath= "(//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-1loqt21 r-17b3b9k r-1otgn73 r-1aockid'])[21]")
	private WebElement datefordeparture;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and text()='30'])[1]")
	private WebElement roundtripdatedeparture;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and text()='30'])[1]")
	private WebElement roundtripdatereturn;

	@FindBy(xpath = "//div[contains(text(),'Passengers')]")
	private WebElement passengers;

	@FindBy(xpath = "//div[@data-testid='Adult-testID-plus-one-cta']")
	private WebElement adult;

	@FindBy(xpath = "//div[@data-testid='Children-testID-plus-one-cta']")
	private WebElement children;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	private WebElement searchFlight;

	@FindBy(xpath = "(//span[@class='css-76zvg2 css-16my406 r-homxoj r-1s6pnzw'])[1]")
	private WebElement searchResultText;

	@FindBy(xpath = "(//div[contains(.,'Round Trip')])[9]")
	private WebElement searchResultRoundTripText;

	@FindBy(xpath = "//div[text()='Please select a date for the return trip']")
	private WebElement roundTripTextErrorText;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-1qxgc49']")
	private WebElement formElement;

	@FindBy(xpath = "//div[text()='Destination city cannot be empty']")
	private WebElement onewaytriperrorText;

	//Checkin 
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-18u37iz r-1ugchlj r-12kfsgm'])[1]/input")
	private WebElement pnrNnumber;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-18u37iz r-1ugchlj r-12kfsgm'])[2]/input")
	private WebElement emailorLastnam;

	@FindBy(css = ".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-z2wwpe.r-1loqt21.r-18u37iz.r-1777fci.r-d9fdf6.r-1w50u8q.r-ah5dr5.r-1otgn73.r-13qz1uu")
	private WebElement searchBooking;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[1]")
	private WebElement checkIn;

	@FindBy(xpath = "//div[@class='css-76zvg2 css-cens5h r-jwli3a']")
	private WebElement checkInError;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-18u37iz r-1ifxtd0 r-6ity3w']//div[2]/div[2]/input")
	private WebElement emaildOrLastName;

	//flight status
	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[2]")
	private WebElement flightStatus;

	@FindBy(xpath = "//div[text()='Departure Date']")
	private WebElement dateOfDeparture;

	@FindBy(xpath = "(//div[@class=\"css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-tju18j r-5njf8e r-1otgn73\"])[1]")
	private WebElement flightFrom;

	@FindBy(xpath = "(//div[@class=\"css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-tju18j r-5njf8e r-1otgn73\"])[2]")
	private WebElement flightTo;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu'])[1]")
	private WebElement searchFlights;
	
	@FindBy(xpath = "//div[text()='All times displayed are the selected airport local time']")
	private WebElement flightStatusModify;
	
	@FindBy(xpath = "//div[text()='On Time']")
	private WebElement	onTime;
	
	@FindBy(xpath = "//div[text()='Tomorrow']")
	private WebElement selectTomorrow;
	
	//Charter
	

	public BookingPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkNavigationTabs() {
		String checkinText = checkinTab.getText();
		Assert.assertEquals(checkinText, "Check-In");
		String flightstatustext = flightstatusTab.getText();
		Assert.assertEquals(flightstatustext, "Flight Status");
		String managebookingtext = managebookingTab.getText();
		Assert.assertEquals(managebookingtext, "Manage Booking");
	}

	public String managebookingtext() {
		return managebookingTab.getText();
	}

	public String onewaytripText() {
		return searchResultText.getText();
	}

	public String onewaytriperrorText() {
		return onewaytriperrorText.getText();
	}




	public void onewayTripInvalid() {
		onewaytrip.click();
		from.sendKeys("Chennai");
		toDestination.clear();
		datefordeparture.click();
		passengers.click();
		adult.click();
		passengers.click();
		searchFlight.click();
		wait(onewaytriperrorText);
	}

	public void roundtripBooking() throws InterruptedException {
		roundtrip.click();
		from.clear();
		from.sendKeys("MUM");
		toDestination.clear();
		toDestination.sendKeys("BEN");
		roundtripdatedeparture.click();
		roundtripdatereturn.click();
		passengers.click();
		adult.click();
		children.click();
		movetoelement(searchFlight);
		searchFlight.click();
		Thread.sleep(2000);
		wait(searchResultRoundTripText);
	}

	public String roundtripText() {
		return searchResultRoundTripText.getText();
	}

	public String roundtripErrorText() {
		return roundTripTextErrorText.getText();
	}

	public String checkInErrorText() {
		return checkInError.getText();
	}
	
	public String flightStatusMessage() {
		return flightStatusModify.getText();
	}
	
	public void roundtripInvalidBooking() throws InterruptedException {
		onewaytrip.click();
		from.clear();
		from.sendKeys("KOL");
		toDestination.clear();
		toDestination.sendKeys("HYD");
		roundtrip.click();
		movetoelement(searchFlight);
		searchFlight.click();
		wait(roundTripTextErrorText);
	}
	public void oneWayTripBooking() {
		onewaytrip.click();
		from.sendKeys("MUM");
		toDestination.clear();
		toDestination.sendKeys("KOL");
		datefordeparture.click();
		passengers.click();
		implicitWait();
		searchFlight.click();
		wait(searchResultText);
	}

	public void flightCheckIn() throws InterruptedException {
		wait(checkIn);
		checkIn.click();
		Thread.sleep(1000);
		wait(emaildOrLastName);
		emaildOrLastName.sendKeys("abc@gmail.com");
		wait(pnrNnumber);
		pnrNnumber.sendKeys("987987");		
		Thread.sleep(3000);
		searchBooking.click();
		wait(checkInError);
	}
	public void flightStatus() throws InterruptedException {
		wait(flightStatus);
		flightStatus.click();
		Thread.sleep(1000);
		from.sendKeys("MUM");
		toDestination.sendKeys("KOL");		
		dateOfDeparture.click();
		Thread.sleep(2000);
		wait(selectTomorrow);
		Thread.sleep(2000);
		selectTomorrow.click();
		searchFlights.click();
		Thread.sleep(2000);
		wait(flightStatusModify);
		onTime.click();
		



	}

}
