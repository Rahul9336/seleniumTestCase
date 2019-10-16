package selenium.testing.advance.cucumberTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginUsingPageFactory;
import selenium.testing.advance.utilityClass.RunBrowser;

public class CucumberTesting {
	
	WebDriver driver;
	LoginUsingPageFactory l;
	
	@Given("User must be on login page")
	public void user_must_be_on_login_page() {
		driver = RunBrowser.runBrowser("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		l=PageFactory.initElements(driver, LoginUsingPageFactory.class);
		l.clickSignInlink();
	}

	@Given("User must register with Application")
	public void user_must_register_with_Application() {
		System.out.println("User Have Valid credentials");
	}

	@When("user enter the username {string} and user enter the password {string}")
	public void user_enter_the_username_and_user_enter_the_password(String string, String string2) {
	    l.login(string, string2);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		l.clickLogin();
	}

	@Then("User Navigate to home page")
	public void user_Navigate_to_home_page() {
		Assert.assertEquals("Home", driver.getTitle());
		driver.close();
	}
}
