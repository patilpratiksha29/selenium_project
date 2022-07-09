package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Udacity_HomePageObjects;
import Pages.Udacity_SignInPageObjects;

public class Udacity_RemoveCourses {
	WebDriver driver = null;
	@BeforeMethod
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
		// Code for Home Page Goto course
		Udacity_HomePageObjects HomePageObj = new Udacity_HomePageObjects(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		HomePageObj.settextInButtonHomeCourse();
	
}
/*	@Test
	public void RemoveCourses() {
		//Click to settings
		driver.findElement(By.xpath("//a[@title='Settings']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Click to courses
		driver.findElement(By.xpath("//a[normalize-space()='Courses']")).click();
		//remove course of Al
		driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > section:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > ul:nth-child(3) > li:nth-child(1) > a:nth-child(1)")).click();
		//driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ol:nth-child(2) > li:nth-child(1) > button:nth-child(1)")).click();
		//Confirm remove
		
		driver.findElement(By.xpath("/html[1]/body[1]/aside[1]/div[1]/div[2]/div[1]/div[1]/button[1]/span[1]")).click();
		driver.navigate().refresh();
		List<WebElement> elements = driver.findElements(By.className("_card--card--1vaya"));
		 System.out.println(elements.size());

	        for (WebElement webElement : elements) {
	            String name = webElement.getText();
	            System.out.println(name);
	        }
		

		
	}
	
	/*@AfterMethod
	public void Postrequirement() {
		driver.close();
	}*/
}
