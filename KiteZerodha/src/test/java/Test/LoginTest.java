package Test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.SignupPage;
import POM.ZerodhaLogin;
import Pojo.Browser;
import Utility.ExcelData;

public class LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		driver = Browser.OpenBrowser("https://kite.zerodha.com");
	}
	@Test(priority=1)
	public void loginWithCredentials() throws EncryptedDocumentException, IOException {
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
		ZerodhaLogin zerodhalogin = new ZerodhaLogin(driver);
		zerodhalogin.ClickOnForgotPass(null);
		
	}
	@Test(priority=2)
	public void WithOutCredentials() {
		ZerodhaLogin zerodhalogin = new ZerodhaLogin(driver);
		zerodhalogin.clicOnSubmit();
	}
	@Test(priority=3)
	public void SignUp() {
		ZerodhaLogin zerodhalogin =new ZerodhaLogin(driver);
		zerodhalogin.ClickOnSignUp();
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		SignupPage signup = new SignupPage(driver);
		String actualTitle = signup.getPageTitle(driver);
		String expectedTitle = "Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
		//Assert.assertEquals(actualTitle, expectedTitle);//hard assert will stop execution at this point
		//Assert.assertTrue(signup.LogoIsDisplayed());
		//Assert.assertFalse(signup.LogoIsDisplayed());
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle);
		//softassert.assertTrue(signup.LogoIsDisplayed());
		softassert.assertFalse(signup.LogoIsDisplayed());
		signup.enterMobileNumber("8888114286");
		softassert.assertAll();//shows the all captured failure
	}
	
}
