package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.ZerodhaLogout;
import Pojo.Browser;
import Utility.ExcelData;

public class LogoutTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		driver = Browser.OpenBrowser("https://kite.zerodha.com/");
		
	}
	@Test
	
	public void LoginWithCredentials() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLogout zerodhalogout= new ZerodhaLogout(driver);
		
		String user = ExcelData.getTestData(0, 1, "Credentials");
		zerodhalogout.enteruser(user);
	     String pass= ExcelData.getTestData(1, 1, "Credentials");
		zerodhalogout.enterpass(pass);
		zerodhalogout.ClickOnSubmit();
		Thread.sleep(3000);
		String pin= ExcelData.getTestData(2, 1, "Credentials");
		zerodhalogout.enterpin(pin);
		zerodhalogout.ClicOnLogin();
		Thread.sleep(3000);
		zerodhalogout.clickOnProfile();
		
	}
	
}
