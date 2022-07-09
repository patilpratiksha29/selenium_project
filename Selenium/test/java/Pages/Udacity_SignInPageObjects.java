package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Udacity_SignInPageObjects {
	WebDriver driver = null;
	By TextBox_Email = By.xpath("//input[@class='vds-text-input__input']");
	By TextBox_Password = By.id("revealable-password");
	By Button_Udacity_Login = By.xpath("//button[@class='vds-button vds-button--primary']");

	public Udacity_SignInPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void settextInTextboxEmail(String text) {
		driver.findElement(TextBox_Email).sendKeys(text);
	}

	public void settextInTextboxPassword(String text) {
		driver.findElement(TextBox_Password).sendKeys(text);
	}
	public void settextInButtonLogin() {
		driver.findElement(Button_Udacity_Login).click();
	}
}
