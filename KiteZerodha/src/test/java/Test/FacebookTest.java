package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.FacebookLogin;
import Pojo.Browser;
import Utility.ExcelDataF;
import Utility.ScreenShot;

public class FacebookTest {
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		driver = Browser.OpenBrowser("https://www.facebook.com/");
	}
	
	
	@Test
	public void LoginWithValidCredentials() throws EncryptedDocumentException, IOException, InterruptedException {
		
		FacebookLogin facebooklogin = new FacebookLogin(driver);
	
		 String user = ExcelDataF.getTestData(0, 1, "Sheet1");
		 facebooklogin.enteruser(driver,user);
		 
		 String pass = ExcelDataF.getTestData(1, 1, "Sheet1");
		 facebooklogin.enterpass(pass);
		 
		 facebooklogin.ClickOnLogin();
		 
		 		
		 ScreenShot.takescreenshot(driver,"Face");
//			ScreenShot.date(); 
	}	
	
		
	
	
		 
	}


