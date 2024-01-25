package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class homepage {
	WebDriver driver;
	public homepage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(className = "ico-register")
	WebElement register;
	
	@FindBy(className = "page-title")
	WebElement verify_title;
	
	
	public registerPage click_register() {
		register.click();
		return new registerPage(driver);
	}
	public String verify_register_page(String title) {
		String actual_title=verify_title.getText();
		Assert.assertEquals(actual_title, title);
		return ("user have navigated to register page ");
	}
}
