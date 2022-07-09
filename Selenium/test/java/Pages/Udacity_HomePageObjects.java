package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Udacity_HomePageObjects {
	WebDriver driver = null;
	//add course 
	By Button_Home_Selectcourse = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]/div[2]/ol[1]/ol[1]/li[2]/button[1]");
	public Udacity_HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void settextInButtonHomeCourse() {
		driver.findElement(Button_Home_Selectcourse).click();
	}
	public String GetCourseText() {
		return driver.findElement(Button_Home_Selectcourse).getText();
	}
}
