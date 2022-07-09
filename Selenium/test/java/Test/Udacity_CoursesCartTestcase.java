package Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Udacity_HomePageObjects;
import Pages.Udacity_SignInPageObjects;

public class Udacity_CoursesCartTestcase {
	WebDriver driver = null;
	@Test
	public void HomeCoursesaddtioninCart() {
		System.setProperty("webdriver.chrome.driver", "D:\\Project\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://classroom.udacity.com/me");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Code for Login
		Udacity_SignInPageObjects SignInPageObj = new Udacity_SignInPageObjects(driver);
		SignInPageObj.settextInTextboxEmail("pratikshap292001@gmail.com");
		SignInPageObj.settextInTextboxPassword("pratikshap@29");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		SignInPageObj.settextInButtonLogin();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Code for Home Page
		Udacity_HomePageObjects HomePageObj = new Udacity_HomePageObjects(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		HomePageObj.settextInButtonHomeCourse();
}
@AfterMethod
public void Postrequirement() {
	driver.close();
}

}
