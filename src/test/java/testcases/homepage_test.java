package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import baseclass.base;
import pageobjects.homepage;
import pageobjects.registerPage;


public class homepage_test extends base {
	public static ExtentReports report;
	public static ExtentTest test;
	homepage hp;
	registerPage register;
	
	@BeforeMethod(groups = {"unit","register"})
	public void before_method() throws IOException {
		intialize_browser(getproperties("browser"));
		driver.get(getproperties("url"));
		hp=new homepage(driver);
	}
	
	@AfterMethod(groups = {"unit","register"})
	public void after_method() {
		report.flush();
		driver.quit();
	}
	
	@BeforeTest(groups = {"unit","register"})
	public void before() throws IOException {
		report=new ExtentReports("C:\\Users\\praka\\eclipse-workspace\\nopCommerce\\src\\test\\resources\\home_page_report.html");
	}
	@AfterTest(groups = {"unit","register"})
	public void after() {
		report.endTest(test);
	}
	
	@Test(priority = 0,groups = "unit")
	public void navigate_to_registerPage() throws IOException {
		
		test=report.startTest("verify navigated to register page", "must navigate to register page");
		hp.click_register();
		hp.verify_register_page("Register");
		test.log(LogStatus.INFO, "user have navigated to the register page");
		test.log(LogStatus.PASS, test.addScreenCapture(screenshot(driver)));
	}
	@Test(priority = 1,groups = {"register"})
	public void enter_valid_credentials_registerPage() throws IOException {
		register=hp.click_register();
		test=report.startTest("enter valid credentials in Register", "verify that user can able to enter valid credentials");
		register.click_gender();
		test.log(LogStatus.INFO, "user selected gender");
		register.enter_f_name(getproperties("f_name"));
		test.log(LogStatus.INFO, "user entered valid firstname");
		register.enter_l_name(getproperties("l_name"));
		test.log(LogStatus.INFO, "user entered valid lastname");
		register.select_date_of_birth(getproperties("date"), getproperties("month"), getproperties("year"));
		test.log(LogStatus.INFO, "user selected date of birth");
		register.enter_email(getproperties("email"));
		test.log(LogStatus.INFO, "user entered valid email");
		test.log(LogStatus.PASS, test.addScreenCapture(screenshot(driver)));
	}
	@Test(priority = 2)
	public void without_enter_clicking_register() throws IOException {
		register=hp.click_register();
		test=report.startTest("without enter credentials and click Register", "verify that user cannot able to register");
		register.click_register_button();
		register.firstname_error("First name is required.");
		test.log(LogStatus.PASS, test.addScreenCapture(screenshot(driver)));
	}
}
