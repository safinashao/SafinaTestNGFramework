package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver; // Global
	// Every page must have a constructor to initialize/invite the driver

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library or repository
	@FindBy(how = How.ID, using = "username")
	WebElement userName;
	@FindBy(how = How.ID, using = "password")
	WebElement passWord;
	@FindBy(how = How.NAME, using = "login")
	WebElement logIn;

	// Methods to interact with the elements
	public void login(String email, String password) {
		userName.sendKeys(email);
		passWord.sendKeys(password);
		logIn.click();
	}

}
