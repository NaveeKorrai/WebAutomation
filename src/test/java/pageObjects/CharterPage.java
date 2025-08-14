package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.BaseClass;

public class CharterPage extends BaseClass {

	String sourceCity="Vishakhapatnam (VTZ)";
	String destinationCity="Boa Vista (BVB)";

	//Charter
	@FindBy(xpath = "//div[text()='Book your Charter']")
	private WebElement bookYourCharter;

	@FindBy(id = "ctl00_mainContent_ddlCashlessOrigin")
	private WebElement orgin;


	@FindBy(id = "ctl00_mainContent_ddlCashlessDestination")
	private WebElement destination;

	@FindBy(id = "txtCashlessDatePicker")
	private WebElement date;

	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
	private WebElement calanderNext;

	@FindBy(xpath = "(//a[@class='ui-state-default'])[28]")
	private WebElement futureDate;

	@FindBy(id = "txtCashlessReturnDatePicker")
	private WebElement returnDate;

	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
	private WebElement returnDateNext;

	@FindBy(id = "txtPDName")
	private WebElement personName;

	@FindBy(id = "txtPDEmail")
	private WebElement personEmail;

	@FindBy(id = "txtPDMobileNumber")
	private WebElement personMobileNo;

	@FindBy(id = "txtPDCity")
	private WebElement personCity;

	@FindBy(id = "btnCharterFlightSubmit")
	private WebElement formSbmit;

	//Error messages
	@FindBy(id = "errorNm")
	private WebElement nameError;

	@FindBy(id = "errorMobile")
	private WebElement mobileError;

	@FindBy(id = "errorEmail")
	private WebElement mailError;

	@FindBy(id = "errorCity")
	private WebElement cityError;

	//Navigation from one page to another

	@FindBy(id = "highlight-addons")
	private WebElement addOn;


	@FindBy(xpath = "//a[text()='Add-Ons']")
	private WebElement addOns;

	@FindBy(xpath = "//a[text()='Govt. Employee']")
	private WebElement govtEmployee;


	@FindBy(xpath = "//div[@class='col-xs-11 col-sm-11 col-lg-11 text-center introhead mb-3']")
	private WebElement govtPageMessage;


	public CharterPage() {
		PageFactory.initElements(driver, this);
	}	

	public void charterStatus() throws InterruptedException {
		wait(bookYourCharter);
		bookYourCharter.click();
		switchtochildwindow();
		Thread.sleep(3000);
		wait(addOns);
		//addOns.click();
		movetoelement(addOns);
		Thread.sleep(1000);
		govtEmployee.click();
		Thread.sleep(1000);
		wait(govtPageMessage);
		Thread.sleep(1000);
		messageFromGovtPage();
		navigateback();

		Thread.sleep(3000);

		scroll();
		wait(orgin);
		selectoptionfromDropdown(orgin,sourceCity);
		Thread.sleep(1000);
		wait(destination);
		Thread.sleep(1000);
		selectoptionfromDropdown(destination,destinationCity);
		Thread.sleep(1000);
		date.click();
		Thread.sleep(1000);
		calanderNext.click();
		Thread.sleep(1000);
		futureDate.click();
		Thread.sleep(1000);
		returnDate.click();
		calanderNext.click();
		Thread.sleep(1000);
		futureDate.click();
		Thread.sleep(1000);
		personName.sendKeys(firstName());
		Thread.sleep(1000);
		personEmail.sendKeys(mail());
		Thread.sleep(1000);
		personMobileNo.sendKeys(phoneNumber());
		Thread.sleep(1000);
		personCity.sendKeys(city());
		Thread.sleep(1000);
		scrollToElement(formSbmit);
		Thread.sleep(1000);
		formSbmit.click();
		Thread.sleep(1000);
//		scrollToElement(addOns);
		popupAlert();
	}
	public String NameMandatory() {
		//System.out.println("Error message :"+nameError.getText());
		return nameError.getText();

	}
	public String mobileNoMandatory() {
		//System.out.println("Error message :"+mobileError.getText());
		return mobileError.getText();

	}
	public String mailMandatory() {
		//System.out.println("Error message :" +mailError.getText());
		return mailError.getText();

	}
	public String cityMandatory() {
		//System.out.println("Error message :"+cityError.getText());
		return cityError.getText();

	}

	public String messageFromGovtPage() {
		System.out.println("Government page message :"+govtPageMessage.getText());
		return govtPageMessage.getText();

	}
	public void navigateback() {
		driver.navigate().back();

	}

	public void charterPageErrorValidations() throws InterruptedException {

		bookYourCharter.click();
		Thread.sleep(3000);
		switchtochildwindow();
		scroll();
		wait(orgin);
		selectoptionfromDropdown(orgin,sourceCity);
		Thread.sleep(1000);
		wait(destination);
		Thread.sleep(1000);
		selectoptionfromDropdown(destination,destinationCity);
		Thread.sleep(1000);
		date.click();
		Thread.sleep(1000);
		calanderNext.click();
		Thread.sleep(1000);
		futureDate.click();
		Thread.sleep(1000);
		returnDate.click();
		calanderNext.click();
		Thread.sleep(1000);
		futureDate.click();
		Thread.sleep(3000);

		scrollToElement(formSbmit);
		Thread.sleep(1000);
		formSbmit.click();

		Thread.sleep(1000);
		scrollToElement(destination);
		Thread.sleep(1000);
		NameMandatory();
		mobileNoMandatory();
		mailMandatory();
		cityMandatory();

	}


}
