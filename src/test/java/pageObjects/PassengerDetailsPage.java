package pageObjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import testBase.BaseClass;

public class PassengerDetailsPage extends BaseClass {
	Faker faker = new Faker();
	String fName = faker.name().firstName();
	String lName = faker.name().lastName();
	String mailid = faker.internet().emailAddress();
	String phonenum="9878987899";

	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	private WebElement continueBtn;

	@FindBy(xpath = "//div[@data-testid='title-contact-detail-card']")
	private WebElement title;

	@FindBy(xpath = "//div[text()='Contact Details']")
	private WebElement contactdetails;

	@FindBy(xpath = "//div[contains(text(),'Mrs')]")
	private WebElement titleSelect;

	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	private WebElement lastname;

	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	private WebElement phone;

	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	private WebElement email;

	@FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
	private WebElement city;

	@FindBy(xpath = "//div[contains(text(),'I am flying as the primary passenger')]")
	private WebElement primarycustomerCheckbox;

	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	private WebElement co;
	@FindBy(xpath = "//div[text()='Gift Card']")
	private WebElement giftCard;

	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement continueB;
	@FindBy(xpath = "//div[@data-testid='add-ons-continue-footer-button']")
	private WebElement cB;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1loqt21 r-5scogr r-u8s1d r-v2u3o6 r-s5r7i3 r-1otgn73 r-8fdsdq']")
	private WebElement popuupclose;

	@FindBy(xpath = "//div[text()='Trip Summary']")
	private WebElement tripSummary;

	@FindBy(xpath = "//input[@class='card_number']")
	private WebElement cardNumberq;
	@FindBy(xpath = "//input[@placeholder='Enter Card Number Here']")
	private WebElement creditcardnum;



	@FindBy(xpath = "//input[@placeholder='Cardholder Name']")
	private WebElement cardholdername;

	@FindBy(xpath = "//input[@name='name_on_card']")
	private WebElement nameoncard;

	@FindBy(xpath = "//input[@id='card_exp_month']")
	private WebElement expMonth;

	@FindBy(xpath = "//input[@id='card_exp_year']")
	private WebElement expYear;

	@FindBy(xpath = "//input[@id='security_code']")
	private WebElement cvv;

	@FindBy(xpath = "//div[contains(.,'Continue')]")
	private WebElement continuetopayment;

	@FindBy(xpath = "//input[@data-testid='common-proceed-to-pay']")
	private WebElement proceedtopay;

	@FindBy(xpath = "//div[text()='Either Card Number or Card Pin is Incorrect.']")
	private WebElement paymenterror;
	@FindBy(xpath = "//div[text()='Check Balance']")
	private WebElement checkbalancebutton;

	@FindBy(id = "at_addon_close_icon")
	private WebElement closebutton;

	@FindBy(xpath = "//div[text()='Passenger 2']")
	private WebElement passenger2;

	@FindBy(xpath = "//input[@data-testid='traveller-1-first-traveller-info-input-box']")
	private WebElement NamePassenger2;

	@FindBy(xpath = "//input[@data-testid='traveller-1-last-traveller-info-input-box']")
	private WebElement lastNamePassenger2;

	@FindBy(xpath = "//input[@data-testid='sc-member-mobile-number-input-box']")
	private WebElement phonePassenger2;

	@FindBy(xpath = "//div[@id='pax-item-MiFDSEQ-']")
	private WebElement Passenger3;

	@FindBy(xpath = "//div[@data-testid='traveller-2-title-field']")
	private WebElement Passenger3Title;

	@FindBy(xpath = "(//div[contains(text(),'Mrs')])[3]")
	private WebElement Passenger3TitleSelect;

	@FindBy(xpath = "//input[@data-testid='traveller-2-first-traveller-info-input-box']")
	private WebElement Passenger3Name;

	@FindBy(xpath = "//input[@data-testid='traveller-2-last-traveller-info-input-box']")
	private WebElement Passenger3LastName;


	@FindBy(xpath = "(//input[@class='css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy'])[1]")
	private WebElement giftcardnumber;	
	@FindBy(xpath = "(//input[@autocomplete='new-password'])[3]")
	private WebElement giftpin;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-obd0qt r-18u37iz r-1x0uki6']//div[3]")
	private WebElement balancegift;
	@FindBy(xpath = "//div[text()='Miss']")
	private WebElement miss;
	@FindBy(xpath = "//div[text()='Credit/Debit Card']")
	private WebElement creditcard;

	public PassengerDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public void bookFlight() throws InterruptedException {

		wait(continueBtn);
		continueBtn.click();
		Thread.sleep(1000);
		wait(contactdetails);
		title.click();
		titleSelect.click();
		firstName.sendKeys(fName);
		lastname.sendKeys(lName);
		phone.sendKeys(phonenum);
		email.sendKeys(mailid);
		city.sendKeys("HYD");
		primarycustomerCheckbox.click();
		Thread.sleep(3000);
		//scroll();
		co.click();
		wait(tripSummary);
		wait(cB);
		cB.click();
		wait(popuupclose);
		popuupclose.click();
		wait(tripSummary);
		giftCard.click();
		wait(giftcardnumber);
		giftcardnumber.sendKeys("12345678901234");
		wait(giftpin);
		giftpin.sendKeys("123456");
		Thread.sleep(5000);
		wait(balancegift);
		balancegift.click();
		implicitWait();

	}
	public void passengerDetails() throws InterruptedException {
		wait(continueBtn);
		continueBtn.click();
		wait(contactdetails);
		title.click();
		titleSelect.click();
		firstName.sendKeys(fName);
		lastname.sendKeys(lName);
		phone.sendKeys(phonenum);
		email.sendKeys(mailid);
		city.sendKeys("HYD");
		primarycustomerCheckbox.click();
		scroll();
		passenger2.click();
		NamePassenger2.sendKeys("Michele");
		lastNamePassenger2.sendKeys("K");
		phonePassenger2.sendKeys("9878987898");
		scroll();
		Passenger3.click();
		Passenger3Title.click();
		miss.click();
		Passenger3Name.sendKeys("Samantha");
		Passenger3LastName.sendKeys("Jonny");

		Thread.sleep(3000);
		//scroll();
		co.click();
		wait(tripSummary);
		wait(cB);
		cB.click();
		wait(popuupclose);
		popuupclose.click();
		wait(tripSummary);
		Thread.sleep(3000);
		giftCard.click();
		wait(giftcardnumber);
		giftcardnumber.sendKeys("12345678901234");
		wait(giftpin);
		giftpin.sendKeys("123456");
		Thread.sleep(5000);
		wait(balancegift);
		balancegift.click();
		implicitWait();

	}


	public String paymenterrorText() {
		return paymenterror.getText();
	}

}
