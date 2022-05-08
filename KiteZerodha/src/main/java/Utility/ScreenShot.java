package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static void takescreenshot(WebDriver driver,String name) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String d = ScreenShot.date();
		File destination = new File("F:\\screenshot\\"+name+d+".jpg");
		FileHandler.copy(source, destination);
		
	}
	public static String date() {
		DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String d=dtf.format(now);
		return d;
	}
	
}
