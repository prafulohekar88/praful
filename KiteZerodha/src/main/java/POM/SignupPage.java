package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	@FindBy(xpath="//input[@id=\"user_mobile\"]")private WebElement mobNumber;
	@FindBy(xpath="//img[@class=\"logo-img\"]")private WebElement logo;
	
	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public String getPageTitle (WebDriver driver) {
		return driver.getTitle();
	}
	public void enterMobileNumber(String number) {
		mobNumber.sendKeys(number);
	}
	public boolean LogoIsDisplayed() {
		return logo.isDisplayed();
	}

}
