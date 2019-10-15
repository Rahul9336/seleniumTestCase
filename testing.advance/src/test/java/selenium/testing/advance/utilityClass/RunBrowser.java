package selenium.testing.advance.utilityClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class RunBrowser {
	static WebDriver rn=null;
	public static WebDriver runBrowser(String input) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\A08019DIRP_C2C.04.02\\Desktop\\Testing-Selenium\\Webdriver\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\Users\\A08019DIRP_C2C.04.02\\Desktop\\Testing-Selenium\\Webdriver\\IEDriver\\IEDriverServer.exe");
		
		if(input.equalsIgnoreCase("chrome")){
			rn=new ChromeDriver();
			
		}else if(input.equalsIgnoreCase("InternetExplorer") || input.equalsIgnoreCase("ie")){
			rn=new InternetExplorerDriver();
		}else{
			System.out.println("You missed Something Try Again");
		}
		return rn;
	}

}
