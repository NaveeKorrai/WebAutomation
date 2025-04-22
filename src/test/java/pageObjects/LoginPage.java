package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(css=".css-1cwyjr8.r-homxoj.r-13awgt0.r-ubezar.r-tmtnm0.r-oxtfae.r-10paoce.r-ymttw5.r-9qu9m4")
	private WebElement email;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	private WebElement password;
	
	@FindBy(xpath="(//div[@data-testid='login-cta'])[1]")
	private WebElement loginBtn;
	
	@FindBy(xpath="(//div[text()='Email'])[1]")
	private WebElement emailCheckbox;
	
	@FindBy(xpath="//div[contains(text(),'Hi Naveen')]")
	private WebElement loginText;
	
	@FindBy(xpath="(//div[@class='css-76zvg2 r-jwli3a r-ubezar'])[1]")
	private WebElement loginLink;
	
	@FindBy(xpath="//div[contains(text(),'Please enter valid Email')]")
	private WebElement loginErrortext;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String loginText() {
		return loginText.getText();
		
	}
	
	public String loginErrortext() {
		return loginErrortext.getText();
		
	}
	
	public void login() throws Exception {
		
		wait(loginLink);	
		loginLink.click();
		emailCheckbox.click();
		email.sendKeys(readProperty("email"));
		password.sendKeys(readProperty("password"));
		loginBtn.click();
	}
	
	public void loginInvalid() throws Exception {
		wait(loginLink);	
		loginLink.click();
		emailCheckbox.click();
		email.sendKeys("abcd");
		password.sendKeys(readProperty("password"));
		loginBtn.click();
	}
}
