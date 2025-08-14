package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utility.UtilClass;

public class TC002LoginWithInvalidDetailsTest extends BaseClass {

	@BeforeTest
    public void testcaseDetails() {
        testName = "TC002_LoginTest";
        testDescription = "Login to Spicejet with multiple credentials (valid and invalid)";
        testAuthor = "Naveen Korrai";
    }

    @Test(dataProvider = "LoginData")
    public void TC002_LoginTest(String username, String password, String expectedResult) throws Exception {
        LoginPage login = new LoginPage();
        
        // This method should accept username and password from the data provider
        login.loginWithCredentials(username, password);

        if (expectedResult.equalsIgnoreCase("Valid")) {
            // Assertion for successful login
            // You should replace this with a method that confirms a successful login state.
            Assert.assertTrue(login.isLoginSuccessful(), "Login failed for valid user: " + username);
        } else { // Handles "Not valid" cases from your spreadsheet
            String actualError = login.loginErrortext();
            Assert.assertEquals(actualError, "Please enter valid Email", "Error message mismatch for user: " + username);
            if (!actualError.contains("Please enter valid Email")) {
                takeScreenshot("TC002_LoginTest_Failure_" + username);
            }
        }
    }

    /**
     * DataProvider method to read test data from the "Sheto" Excel file.
     * @return A 2D Object array containing username, password, and expected result.
     */
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        String filePath = System.getProperty("user.dir") + "/src/test/java/testData/testda.xls";
        
        // Initialize the Excel utility (assuming you have a 'testData' folder)
        UtilClass.Excelsetupp(filePath, "testda");

        int totalRows = UtilClass.getRowCount();
        int totalCols = UtilClass.getCellCount(0); // Get number of columns from the header row

        Object[][] data = new Object[totalRows][totalCols];

        // Loop through all data rows (starting from row 1 to skip header)
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                data[i - 1][j] = UtilClass.getCellData(i, j);
            }
        }
        
        return data;
    }
}