package selenium.testing.advance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.LoginUsingPageFactory;
import selenium.testing.advance.utilityClass.RunBrowser;

public class LoginTest {
	WebDriver driver;

	@BeforeClass
	public void initBrowser() {
		driver = RunBrowser.runBrowser("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}

	@Test()
	public void testLogin() {
		//Login l = new Login(driver);
		LoginUsingPageFactory l=PageFactory.initElements(driver, LoginUsingPageFactory.class);
		l.clickSignInlink();
		l.login("lalitha", "Password123");
		l.clickLogin();
		Assert.assertEquals("Home", driver.getTitle());
	}

	@AfterClass
	public void close() {
		driver.close();
	}
}
