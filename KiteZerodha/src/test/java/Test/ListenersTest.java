package Test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Pojo.BaseTest;
import Utility.ScreenShot;

public class ListenersTest extends BaseTest implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Started "+ result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("My Test is successfull "+ result.getName());
	}
	public void onTestFailure (ITestResult result) {
		
		System.out.println("My Test fail "+result.getName());
		try {
			ScreenShot.takescreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("My test skipped "+ result.getName());
	}

}
