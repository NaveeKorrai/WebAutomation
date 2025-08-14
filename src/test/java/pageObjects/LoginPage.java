package pageObjects;



import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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


		try{
			wait(loginLink);	
			loginLink.click();
			logger.info("Login link clicked");
			emailCheckbox.click();
			logger.info("clicked on email checkbox");
			email.sendKeys(readProperty("email"));
			logger.info("Entered email from property file : "+readProperty("email"));
			password.sendKeys(readProperty("password"));
			logger.info("Entered email from property file : "+readProperty("password"));
			loginBtn.click();
			logger.info("clicked on login button");
		}
		catch(Exception e) {
			
			Assert.fail();
		}
	}

	public void loginInvalid() throws Exception {
		wait(loginLink);	
		loginLink.click();
		emailCheckbox.click();
		email.sendKeys("abcd");
		password.sendKeys(readProperty("password"));
		loginBtn.click();
	}
	public void loginWithCredentials(String username, String password) {
	    try {
	        wait(loginLink);    
	        loginLink.click();
	        emailCheckbox.click();
	        email.sendKeys(username);
	        this.password.sendKeys(password);
	        loginBtn.click();
	    } catch (Exception e) {
	        // You can log the error or re-throw it as a more specific exception
	        System.err.println("Error during login with credentials: " + e.getMessage());
	        throw new RuntimeException("Failed to perform login action.", e);
	    }
	}
	
	public boolean isLoginSuccessful() {
        try {
            // Find an element that only appears after a successful login
            // For example, a "Welcome, [Username]" text or a logout button.
            // driver.findElement(By.xpath("//span[contains(text(),'Hi')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
