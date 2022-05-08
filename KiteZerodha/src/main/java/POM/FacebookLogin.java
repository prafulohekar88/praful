package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLogin {
	@FindBy(xpath="//input[@type='text']")private WebElement userName;
	@FindBy(xpath="//input[@id=\"pass\"]")private WebElement pass;
	@FindBy(xpath="//button[@name=\"login\"]")private WebElement login;
	@FindBy(xpath="//a[text()='Forgotten password?']")private WebElement forgotpass;
    @FindBy(xpath="(//a[@role=\"button\"])[2]")private WebElement SignUp;
    
    
    public FacebookLogin(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    public void enteruser(WebDriver driver, String usern) {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(5000));
    	wait.until(ExpectedConditions.visibilityOf(userName));
    	userName.sendKeys(usern);
    }
    public void enterpass(String password) {
    	pass.sendKeys(password);
    }
    public void ClickOnLogin() {
    	login.click();
    }
    public void ClickOnForgot() {
    	forgotpass.click();
    }
    public void ClickOnSignUp() {
    	SignUp.click();
    }
}
