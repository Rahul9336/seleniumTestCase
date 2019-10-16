package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationUsingPageFactory {
	
	WebDriver driver;
	WebDriverWait wait;
	public RegistrationUsingPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy( how=How.LINK_TEXT, using="SignUp" )
	WebElement signUp;
	
	@FindBy( how=How.ID , using="userName" )
	WebElement username;
	
	@FindBy( how = How.NAME ,using="firstName" )
	WebElement firstName;
	
	@FindBy( how = How.NAME ,using="lastName" )
	WebElement lastName;
	
	@FindBy( how = How.NAME ,using="password" )
	WebElement password;
	
	@FindBy( how = How.NAME ,using="confirmPassword" )
	WebElement confirmPassword;
	
	@FindBy( how = How.XPATH,using="//input[@type='radio' and @value='Female']")
	WebElement genderFemale;
	
	@FindBy( how=How.ID , using="emailAddress" )
	WebElement emailAddress;
	
	@FindBy( how=How.ID , using="mobileNumber" )
	WebElement mobileNumber;
	
	@FindBy( how = How.XPATH,using="//*[@class='ui-datepicker-trigger']")
	WebElement datePickerBox;
	
	@FindBy( how= How.CLASS_NAME,using="ui-datepicker-year")
	WebElement selectYear;
	
	@FindBy( how = How.XPATH,using="/html/body/div/table/tbody/tr[3]/td[4]/a")
	WebElement selectDate;
	
	@FindBy( how=How.ID , using="address" )
	WebElement address;
	
	@FindBy( how=How.ID , using="answer" )
	WebElement answer;
	
	@FindBy( how = How.NAME ,using="Submit" )
	WebElement submit;
	
	
	public void doRegistration() {
		wait = new WebDriverWait(driver, 20);
		Assert.assertEquals(driver.getTitle(), "Home");
		driver.findElement(By.linkText("SignUp")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
		Assert.assertEquals(driver.getTitle(), "Sign Up");
		username.sendKeys("rahul12098");
		firstName.sendKeys("Rahul");
		lastName.sendKeys("Gupta");
		password.sendKeys("Rahul123");
		confirmPassword.sendKeys("Rahul123");
		genderFemale.click();
		emailAddress.sendKeys("rahul13469@gmail.com");
		mobileNumber.sendKeys("9560796526");
		datePickerBox.click();
		Select sel = new Select(selectYear);
		sel.selectByIndex(47); //select year 1947
		selectDate.click();
		address.sendKeys("Delhi Delhi Delhi");
		answer.sendKeys("rahul");
		
		submit.click();
		
		Assert.assertEquals("Login", driver.getTitle());

	}


}
