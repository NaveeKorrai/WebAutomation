package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.github.javafaker.Faker;
import testBase.BaseClass;

public class SignUpPage extends BaseClass {
	Faker faker = new Faker();
	String fName = faker.name().firstName();
	String lName = faker.name().lastName();
	String mailid = faker.internet().emailAddress();


	@FindBy(xpath = "//div[contains(text(),'Signup')]")
	private WebElement signUpLink;
	@FindBy(xpath = "(//select[contains(@class,'form-control form-select')])[1]")
	private WebElement title;

	@FindBy(id = "first_name")
	private WebElement firstName;

	@FindBy(id = "last_name")
	private WebElement lastName;

	@FindBy(css = "select[class='form-control form-select']")
	private WebElement country;

	@FindBy(xpath = "//img[@alt='date']")
	private WebElement calender;

	@FindBy(xpath = "(//select[@class='react-datepicker__month-select'])[1]")
	private WebElement month;

	@FindBy(xpath = "(//select[@class='react-datepicker__year-select'])[1]")
	private WebElement year;

	@FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--002']")
	private WebElement date;

	@FindBy(css = "input[type='tel']")
	private WebElement phone;

	@FindBy(xpath = "//input[@id='email_id']")
	private WebElement email;

	@FindBy(id = "new-password")
	private WebElement password;

	@FindBy(id = "c-password")
	private WebElement confirmpassword;

	@FindBy(xpath = "//input[@class='form-check-input mt-02']")
	private WebElement checkbox;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement submitBtn;
	
	@FindBy(css = ".btn.btn-red[type='button']")
	private WebElement submit;
	

	@FindBy(xpath = "//label[contains(text(),'OTP Verification')]")
	private WebElement signInText;

	@FindBy(xpath = "(//div[@class='font-13 mt-10 inlineErrors'])[1]")
	private WebElement errorText;
	@FindBy(xpath = "//div[text()=\"Please fill all mandatory fields marked with an '*' to proceed\"]")
	private WebElement signUpPageError;

	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	public String signInText() {
		scrollup();
		return signInText.getText();

	}

	public String signMandatoryError() {
		scrollup();
		wait(signUpPageError);
		return signUpPageError.getText();

	}



	public String errorText() {
		return errorText.getText();

	}
	




	public void SignUpInvalid() throws InterruptedException {
		wait(signUpLink);
		signUpLink.click();
		switchtochildwindow();
		scrollToElement(submit);
		Thread.sleep(3000);
		submit.click();
	}
	public void signUp() throws InterruptedException {

		signUpLink.click();
		switchtochildwindow();
		wait(title);
		selectoptionfromDropdown(title, "Mr");
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		scroll();
		Thread.sleep(2000);
		calender.click();
		selectoptionfromDropdown(month, "July");
		selectoptionfromDropdown(year, "1997");
		date.click();
		phone.sendKeys(phoneNumber());
		Thread.sleep(3000);
		email.click();
		email.sendKeys(mailid);
		Thread.sleep(2000);
		wait(password);
		password.sendKeys("Demo@123456");
		confirmpassword.sendKeys("Demo@123456");
		email.click();
		email.sendKeys(mailid);
		//email.sendKeys("testautomation8809@gmail.com");
		password.click();
		wait(checkbox);
		checkbox.click();
		submitBtn.click();
		Thread.sleep(2000);
	}
}
