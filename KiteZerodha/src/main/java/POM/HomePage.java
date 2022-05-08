package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	Actions act;
	@FindBy(xpath="//span[text()='TATACOFFEE']")private WebElement tatacoffee;
    @FindBy(xpath="//button[@class='button-blue buy']")private WebElement buy;
    @FindBy(xpath="//div[@class=\"vddl-list list-flat\"]//span//span//span[@class='nice-name']")private List<WebElement> stock;
   
           public HomePage(WebDriver driver) {
        	   PageFactory.initElements(driver, this);
	}
           public void selectTataCofee(WebDriver driver) {
        	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
        	   wait.until(ExpectedConditions.visibilityOf(tatacoffee));
        	    act=new Actions(driver);
        	    act.moveToElement(tatacoffee);
        	    act.perform();
        }
           public void selectStockFromList(WebDriver driver,int i ) {
        	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000)); 
        	   wait.until(ExpectedConditions.visibilityOf(tatacoffee));
           
        	   for(int a =0; a<stock.size(); a++) {
        		   System.out.println(stock.size());
        		  // String text = stock.get(a).getText();
        		  // if(text.equalsIgnoreCase(stockName)) {
        			   act=new Actions(driver);
        			   act.moveToElement(stock.get(a));
        			   act.perform();
        		   }
        		   
        	   }
          // }
           public void ClickOnbuy(WebDriver driver) {
        	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000)); 
        	   wait.until(ExpectedConditions.visibilityOf(tatacoffee)); 
        	   buy.click();
           }
}