package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.ZerodhaLogin;
import Pojo.BaseTest;
import Pojo.Browser;
import Utility.ExcelData;
import Utility.Reports;
@Listeners(ListenersTest.class)
public class ExtentReportTest extends BaseTest {
	ExtentReports reports;
    ExtentTest test;
   @BeforeClass
   public void setReports() {
	 reports = Reports.addReport();
   }
	
	@BeforeMethod
	public void launchBrowser() {
		driver = Browser.OpenBrowser("https://kite.zerodha.com");
	}
	@Test
	public void loginWithCredentials() throws EncryptedDocumentException, IOException {
		test = reports.createTest("loginWithCredentials");
		ZerodhaLogin zerodhalogin = new ZerodhaLogin(driver);
		
		String user = ExcelData.getTestData(0, 1, "Credentials");
		zerodhalogin.enterUserName(user);
		
		String pass = ExcelData.getTestData(1, 1, "Credentials");
		zerodhalogin.enterPassword(pass);
		
		zerodhalogin.clicklogin(); 
		
		String pin = ExcelData.getTestData(2, 1, "Credentials");
		zerodhalogin.enterPin(pin, driver);
		
		zerodhalogin.clicOnSubmit();
		
}
	@Test 
	public void ClickOnForgotPass() {
		test = reports.createTest("ClickOnForgotPass");
		ZerodhaLogin zerodhalogin = new ZerodhaLogin(driver);
		zerodhalogin.ClickOnForgotPass(null);
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void captureResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}else {
			test.log(Status.SKIP, result.getName());
		}
		
	}
	@AfterClass
	public void flushResults() {
		reports.flush();
		
	}
}