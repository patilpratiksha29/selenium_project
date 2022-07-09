package PageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Udacity_SignInPageObjects;

public class Udacity_SignInPageTest {

	static WebDriver driver = null;

	public static void main(String[] args) {
		Udacity_SignInPageTest(args);
	}

	private static void Udacity_SignInPageTest(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Project\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://auth.udacity.com/sign-in?next=https://classroom.udacity.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Udacity_SignInPageObjects SignInPageObj = new Udacity_SignInPageObjects(driver);
		SignInPageObj.settextInTextboxEmail("pratikshap292001@gmail.com");
		SignInPageObj.settextInTextboxPassword("pratikshap@29");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,350)", "");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		SignInPageObj.settextInButtonLogin();
	}

}
