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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;


public class UtilClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName;
	public String testDescription;
	public String testCategory;
	public String testAuthor;
	 public static HSSFWorkbook workbook;
	    public static HSSFSheet sheet;
	
	private static final Faker faker = new Faker();

	public static String readProperty(String key) throws Exception {
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "//src//test//resources//Config.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop.get(key).toString();
	}

	public static void LaunchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-build-check");
			driver = new ChromeDriver(options);
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
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

	public static void takeScreenshot(String testName) throws IOException {
		String testCaseID = testName.split("_")[0];  // This grabs "TC002"
		String timeStamp = new SimpleDateFormat("dd-MM_HH.mm").format(new Date());
		File screenshotDir = new File(System.getProperty("user.dir") + "/Screenshots");
		if (!screenshotDir.exists()) 
		{
			screenshotDir.mkdirs();
		}
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
	public static  String lasttName() {
		String lName = faker.name().lastName();
		return lName;
	}
	
	public static  String mail() {
		String emailid = faker.internet().emailAddress();
		return emailid;
	}
	
	String fName = faker.name().firstName();
	public static  String city() {
		List<String> cities = Arrays.asList(
				"Delhi", "Mumbai", "Bangalore", "Kolkata", "Chennai", 
				"Hyderabad", "Ahmedabad", "Pune", "Jaipur", "Lucknow", 
				"Kochi", "Chandigarh", "Surat", "Visakhapatnam", "Nagpur"
				);
		Random random = new Random();
		String randomCity = cities.get(random.nextInt(cities.size()));
		System.out.println("Selected City: " + randomCity);
		return randomCity;

	}

	public static String phoneNumber() {
		Random random = new Random();
		StringBuilder phoneNumber = new StringBuilder("9");
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

	
	 public static void Excelsetupp(String filePath, String sheetName) {
	        try {
	            FileInputStream fileInputStream = new FileInputStream(filePath);
	            workbook = new HSSFWorkbook(fileInputStream);
	            sheet = workbook.getSheet(sheetName);
	        } catch (IOException e) {
	            System.err.println("Error setting up Excel utility: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Gets the total number of rows in the sheet.
	     * @return The last row number containing data.
	     */
	    public static int getRowCount() {
	        return sheet.getLastRowNum();
	    }

	    /**
	     * Gets the total number of columns in a specific row.
	     * @param rowNum The row number to check.
	     * @return The number of the last cell in the row.
	     */
	    public static int getCellCount(int rowNum) {
	        return sheet.getRow(rowNum).getLastCellNum();
	    }

	    /**
	     * Gets the data from a specific cell.
	     * @param rowNum The row number (0-indexed).
	     * @param colNum The column number (0-indexed).
	     * @return The cell data as a String. Returns an empty string if cell is null.
	     */
	    public static String getCellData(int rowNum, int colNum) {
	        try {
	            Cell cell = sheet.getRow(rowNum).getCell(colNum);
	            DataFormatter formatter = new DataFormatter();
	            return formatter.formatCellValue(cell);
	        } catch (Exception e) {
	            return "";
	        }
	    }
	}
