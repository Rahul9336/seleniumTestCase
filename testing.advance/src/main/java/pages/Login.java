package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;
	By username = By.name("userName");
	By password = By.name("password");
	By signin = By.xpath("//input[@name='Login']");
	By signlink = By.linkText("SignIn");

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignInlink() {
		driver.findElement(signlink).click();
	}

	public void login(String un, String paswd) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(paswd);
		driver.findElement(signin).click();
	}

}
