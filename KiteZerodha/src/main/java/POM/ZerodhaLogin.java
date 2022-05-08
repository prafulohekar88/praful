package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLogin {
	@FindBy(xpath="//input[@id='userid']")private WebElement userName;
	//driver.FindElement
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement Forgotpass;
	@FindBy(xpath="//a[@class='text-light']")private WebElement SignUp;
	@FindBy(xpath="//input[@id='pin']")private WebElement pinNumber;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit1;
	public ZerodhaLogin(WebDriver driver)// Create Constructor
	{
	PageFactory.initElements(driver,this);//pagefactory.initelement will find all the element declared at the start
		
	}
	public void enterUserName(String user) {
		userName.sendKeys(user);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clicOnSubmit() {
		submit.click();
	}

	public void enterPin(String pin,WebDriver driver) {
         @SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver,5);//explicit wait
		wait.until(ExpectedConditions.visibilityOf(pinNumber));
		
//		FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver);//fluent wait
//		wait.withTimeout(Duration.ofMillis(3000));
//		wait.pollingEvery(Duration.ofMillis(50));
//		wait.ignoring(Exception.class);
//		wait.until(ExpectedConditions.visibilityOf(pinNumber));
        pinNumber.sendKeys(pin);
	}
	
	public void clicklogin() {
		submit1.click();
	}
	public void ClickOnForgotPass(String Forgot) {
		Forgotpass.click();
	}
	public void ClickOnSignUp() {
		SignUp.click();
		
	}
}
