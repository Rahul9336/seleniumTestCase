package selenium.testing.advance;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import selenium.testing.advance.utilityClass.ReadData;
import selenium.testing.advance.utilityClass.RunBrowser;
import selenium.testing.advance.utilityClass.ScreenShotHelper;

public class Demo {
	WebDriver driver;
	String expect = "Home";
	Actions act;
	WebDriverWait wait;

	@BeforeClass
	public void initBrowser() {
		driver = RunBrowser.runBrowser("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		wait = new WebDriverWait(driver, 20);
	}
	@DataProvider
	public Object[][] readData() throws IOException {
		return ReadData.getData();
	}
	@BeforeMethod
	public void testDDT() {
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}
	@Test(priority = 1, enabled = true,dataProvider="readData")
	public void testLogin(String un,String pswd) {
		Assert.assertEquals(driver.getTitle(), "Home");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignIn")));
		driver.findElement(By.linkText("SignIn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));

		driver.findElement(By.name("userName")).sendKeys(un);

		driver.findElement(By.name("password")).sendKeys(pswd);

		driver.findElement(By.xpath("//input[@name='Login']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
		Assert.assertEquals(driver.getTitle(), "Home");
		driver.findElement(By.linkText("SignOut")).click();
	}
	@AfterMethod
	public void getScreenShot(ITestResult result) throws Exception {
		ScreenShotHelper.getScreenshot(driver, result.getName());
	}
	@Test(priority = 2, dependsOnMethods = "testLogin", enabled = false)
	public void testCart() {

		String check = null;
		int cartValue = -1;
		act = new Actions(driver);

		act.moveToElement(driver.findElement(By.linkText("All Categories"))).click().build().perform();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		act.moveToElement(driver.findElement(By.xpath("//span[text()='Electronics']"))).click().build().perform();
		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Head Phone')]")));
		act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Head Phone')]"))).click().build()
				.perform();
		Assert.assertEquals(driver.getTitle(), "Search");

		act.moveToElement(driver.findElement(By.linkText("Add to cart"))).click().build().perform();

		check = driver.findElement(By.partialLinkText("Cart")).getText();
		for (int i = 0; i < check.length(); i++) {
			if (check.charAt(i) == '1') {
				cartValue = Character.getNumericValue(check.charAt(i));
			}
		}
		if (cartValue > 0) {

			Assert.assertEquals("Passed", "Passed");
		} else
			Assert.assertEquals("Passed", "Failed");
	}

	@Test(priority = 3, enabled = false)
	public void dragDrop() {
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement resize = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		act = new Actions(driver);
		act.dragAndDropBy(resize, 200, 200);
	}
	@Test(priority=2,enabled=false)
	public void windowHandle() {
		act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='AboutUs']"))).click().build().perform();
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span"))).click().build().perform();
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/ul/li[1]/a/span"))).click().build().perform();
		String parent=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String s:windows) {
			if(parent.equals(s))
				continue;
			driver.switchTo().window(s);
		}
		driver.switchTo().frame(driver.findElement(By.name("main_page")));
		System.out.println(driver.findElement(By.tagName("address")).getText());
		driver.close();
	}
	@AfterClass
	public void afterClass() {
		driver.close();
		//driver.quit(); //uncomment for multiple window close
	}
}
