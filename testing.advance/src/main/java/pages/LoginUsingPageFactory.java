package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginUsingPageFactory {

	WebDriver driver;

	public LoginUsingPageFactory(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "userName")
	WebElement username;
	
	@FindBy(how = How.NAME, using = "password")
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "//input[@name='Login']")
	WebElement login;
	
	@FindBy(how = How.LINK_TEXT, using = "SignIn")
	WebElement SignIn;
	public void clickSignInlink() {
		SignIn.click();
	}

	public void login(String un, String paswd) {
		username.sendKeys(un);
		password.sendKeys(paswd);
		login.click();
	}
}
