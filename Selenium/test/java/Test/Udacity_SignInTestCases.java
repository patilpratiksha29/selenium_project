package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.Udacity_SignInPageObjects;

import org.testng.Assert;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Udacity_SignInTestCases {
	WebDriver driver = null;
	

	@BeforeMethod
	public void prereqirement() {
		System.setProperty("webdriver.chrome.driver", "D:\\Project\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
	    driver.get("chrome://settings/clearBrowserData");
	    driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		driver.get("https://auth.udacity.com/sign-in?next=https://classroom.udacity.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	

	@Test
	public void Validate_URL() {

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://auth.udacity.com/sign-in?next=https://classroom.udacity.com";
		
		
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test
	public void Validate_ErrorForBlankEmailPassword() {

		Udacity_SignInPageObjects SignInPageObj = new Udacity_SignInPageObjects(driver);
		SignInPageObj.settextInTextboxEmail("");
		SignInPageObj.settextInTextboxPassword("");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
		
		SignInPageObj.settextInButtonLogin();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String ActualErorMsg = driver.findElement(By
				.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]"))
				.getText();
		//String ExpectedErrorMsg ="Must solve ReCAPTCHA";
		String ExpectedErrorMsg = "Must specify an email and password";
		Assert.assertEquals(ActualErorMsg, ExpectedErrorMsg);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	@Test
	public void ValidateIncorrectEmailCorrectPassword() {
		Udacity_SignInPageObjects SignInPageObj = new Udacity_SignInPageObjects(driver);
		SignInPageObj.settextInTextboxEmail("pratikshap@gmail.com");
		SignInPageObj.settextInTextboxPassword("pratikshap@29");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
	
		SignInPageObj.settextInButtonLogin();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String Actualerormsg = driver
				.findElement(By.cssSelector("div[class='alert_error__3rDC3 alert__alert__nhpvN ']")).getText();
		//String Expectederormsg ="Must solve ReCAPTCHA";
		String Expectederormsg = "The email or password you entered is invalid";
		Assert.assertEquals(Actualerormsg, Expectederormsg);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	@Test
	public void ValidateCorrectEmailIncorrectPassword() {
		Udacity_SignInPageObjects SignInPageObj = new Udacity_SignInPageObjects(driver);
		SignInPageObj.settextInTextboxEmail("pratikshap292001@gmail.com");
		SignInPageObj.settextInTextboxPassword("pratiksha@29");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
		SignInPageObj.settextInButtonLogin();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String Actualmsg = driver.findElement(By.cssSelector("div[class='alert_error__3rDC3 alert__alert__nhpvN ']")).getText();
		//String Expectedrmsg ="Must solve ReCAPTCHA";
		String Expectedrmsg = "The email or password you entered is invalid";

		Assert.assertEquals(Actualmsg, Expectedrmsg);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	@Test
	public void ValidateCorrectEmailCorrectPassword() {
		Udacity_SignInPageObjects SignInPageObj = new Udacity_SignInPageObjects(driver);
		SignInPageObj.settextInTextboxEmail("pratikshap292001@gmail.com");
		SignInPageObj.settextInTextboxPassword("pratikshap@29");
		SignInPageObj.settextInButtonLogin();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String ActualRedirect=driver.getCurrentUrl();
		String ExpectedRedirect="https://auth.udacity.com/sign-in?next=https://classroom.udacity.com";
		assertEquals(ActualRedirect, ExpectedRedirect);
	}
	

	@AfterMethod
	public void Postrequirement() {
		driver.close();
	}
}
