package selenium.testing.advance.utilityClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UploadFile {
	@Test
	public void Fileupload() throws AWTException, InterruptedException {
// Start browser
//		System.setProperty("webdriver.ie.driver",
//				"C:\\Users\\A08019DIRP_C2C.04.02\\Desktop\\Testing-Selenium\\Webdriver\\chromedriver\\chromedriver.exe");
//		
		WebDriver driver =RunBrowser.runBrowser("ie");
// maximize browser
		driver.manage().window().maximize();
// Specify the file location with extension
		StringSelection sel = new StringSelection("C:\\Users\\A08019DIRP_C2C.04.02\\Desktop\\Document.docx");
// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		System.out.println("selection" + sel);
// Open Monster.com
		driver.get("file:///C:\\Users\\A08019DIRP_C2C.04.02\\Desktop\\fileupload.html");
		//Thread.sleep(2000);
// This will scroll down the page 
//JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("scroll(0,350)");
// Wait for 5 seconds
//Thread.sleep(30000);
System.out.println("Browse button about to");
// This will click on Browse button
Thread.sleep(2000);
		driver.findElement(By.name("resumeupload")).click();
		Thread.sleep(2000);
		System.out.println("Browse button clicked");
// Create object of Robot class
		Robot robot = new Robot();
		Thread.sleep(1000);
// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);
// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
//Press Enter 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}