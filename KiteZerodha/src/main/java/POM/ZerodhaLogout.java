package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaLogout {
	@FindBy(xpath="//input[@id='userid']")private WebElement userName;
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	@FindBy(xpath="//input[@id='pin']")private WebElement pinNumber;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit1;
	@FindBy(xpath="//span[@class='user-id']")private WebElement profile;
	
	public ZerodhaLogout(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void enteruser(String user) {
		userName.sendKeys(user);
		
	}
	public void enterpass(String pass) {
		password.sendKeys(pass);
	}
	public void ClickOnSubmit() {
		submit.click();
	}
	public void enterpin(String pin) {
		pinNumber.sendKeys(pin);
		
	}
	public void ClicOnLogin() {
		submit1.click();
	}
	public void clickOnProfile() {
		profile.click();
	}

}
