package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

public class UtilClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName;
	public String testDescription;
	public String testCategory;
	public String testAuthor;
	

	public static String readProperty(String key) throws Exception {
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "//src//test//java//resources//data.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop.get(key).toString();
	}

	public static void LaunchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	public static void launch(String url) throws Exception {
		driver.get(url);
	}

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrolltoLast() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,950)");
	}

	public static void elementvisiblitywait(WebElement element) {
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.visibilityOf(element));
	}

	public static void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,450)");
	}
	public static void scrollup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
	}

	public static void wait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/*public static void takeScreenshot(String testName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/" + testName + ".png"));
	}*/
	
	public static void takeScreenshot(String testName) throws IOException {
	    // Extract test case number from full class name (e.g., TC002 from TC002_LoginwithInvalidDetailsTest)
	    String testCaseID = testName.split("_")[0];  // This grabs "TC002"

	    // Format timestamp: dd-MM_HH.mm
	    String timeStamp = new SimpleDateFormat("dd-MM_HH.mm").format(new Date());

	    // Ensure Screenshots folder exists
	    File screenshotDir = new File(System.getProperty("user.dir") + "/Screenshots");
	    if (!screenshotDir.exists()) {
	        screenshotDir.mkdirs();
	    }

	    // Capture and save the screenshot
	    TakesScreenshot screenshot = (TakesScreenshot) driver;
	    File source = screenshot.getScreenshotAs(OutputType.FILE);
	    String screenshotName = "./Screenshots/" + testCaseID + "_" + timeStamp + ".png";
	    FileUtils.copyFile(source, new File(screenshotName));
	}





	public static void selectoptionfromDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	public static void movetoelement(WebElement element) {
		Actions action = new Actions(driver);
		//action.moveToElement(element);
		//action.build().perform();
        action.moveToElement(element).perform();

	}
	public static void popupAlert() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Text: " + alertText);
		alert.accept();
	}
	public static  String firstName() {
		Faker faker = new Faker();
		String fName = faker.name().firstName();
		return fName;

	}
	Faker faker = new Faker();
	String fName = faker.name().firstName();

	public static  String lasttName() {
		Faker faker = new Faker();
		String lName = faker.name().lastName();
		return lName;

	}

	public static  String mail() {
		Faker faker = new Faker();
		String emailid = faker.internet().emailAddress();
		return emailid;

	}
	public static  String city() {
		List<String> cities = Arrays.asList(
				"Delhi", "Mumbai", "Bangalore", "Kolkata", "Chennai", 
				"Hyderabad", "Ahmedabad", "Pune", "Jaipur", "Lucknow", 
				"Kochi", "Chandigarh", "Surat", "Visakhapatnam", "Nagpur"
				);
		//Create a random object to generate a random index
		Random random = new Random();
		//Generate a random index to select a city
		String randomCity = cities.get(random.nextInt(cities.size()));
		//Print the randomly selected city
		System.out.println("Selected City: " + randomCity);
		return randomCity;

	}

	public static String phoneNumber() {
		Random random = new Random();
		// Generate the remaining 9 digits after the initial '9'
		StringBuilder phoneNumber = new StringBuilder("9");
		// Append 9 random digits to make it a 10-digit number
		for (int i = 0; i < 9; i++) {
			phoneNumber.append(random.nextInt(10)); //0-9 
		}
		return phoneNumber.toString();
	}

	public static void switchtochildwindow() {

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
			}

		}
	}

}
