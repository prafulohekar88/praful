package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.ZerodhaLogin;
import Pojo.Browser;
import Utility.ExcelData;

public class HomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowserandLogin() throws EncryptedDocumentException, IOException {
		driver= Browser.OpenBrowser("https://kite.zerodha.com");
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
	public void buystok() {
		HomePage homepage = new HomePage(driver);
		//homepage.selectTataCofee(driver);
		homepage.selectStockFromList(driver,3);
		homepage.ClickOnbuy(driver);
	}

}
