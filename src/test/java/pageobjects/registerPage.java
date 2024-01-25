package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class registerPage {
	WebDriver driver;
	
	public registerPage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "gender-male")
	WebElement gender;
	
	@FindBy(id = "FirstName")
	WebElement f_name;
	
	@FindBy(id = "LastName")
	WebElement l_name;
	
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement day;
	
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement month;
	
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement year;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "FirstName-error")
	WebElement f_name_error;
	
	@FindBy(id = "register-button")
	WebElement register_button;
	
	
	public void click_gender() {
		gender.click();
	}
	public void enter_f_name(String first_name) {
		f_name.sendKeys(first_name);
	}
	public void enter_l_name(String last_name) {
		l_name.sendKeys(last_name);
	}
	public void select_day(String date) {
		Select select=new Select(day);
		select.selectByVisibleText(date);
	}
	public void select_month(String mth) {
		Select select=new Select(month);
		select.selectByVisibleText(mth);
	}
	public void select_year(String yr) {
		Select select=new Select(year);
		select.selectByVisibleText(yr);
	}
	
	public void enter_email(String mail) {
		email.sendKeys(mail);
	}
	
	public void select_date_of_birth(String date,String mth,String yr) {
		select_day(date);
		select_month(mth);
		select_year(yr);
	}
	
	public void click_register_button() {
		register_button.click();
	}
	public void firstname_error(String first_name_error) {
		String error_msg=f_name_error.getText();
		Assert.assertEquals(error_msg, first_name_error);
	}
}
