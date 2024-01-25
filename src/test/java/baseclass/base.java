package baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public static WebDriver driver;
	
		public static String getproperties(String keyname) throws IOException {
			Properties pro=new Properties();
			File file=new File("C:\\Users\\praka\\eclipse-workspace\\nopCommerce\\src\\test\\resources\\config.properties");
			FileInputStream stream=new FileInputStream(file);
			pro.load(stream);
			return (String) pro.get(keyname);	
		}
		
		public static WebDriver intialize_browser(String browsername) {
			
			if(browsername.equalsIgnoreCase("chrome")) {
				
				driver=new ChromeDriver();
				
			}
			else if(browsername.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else if(browsername.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else {
				System.out.println("browser is not launched");
			}
			return driver;
		}
		
		public  String screenshot(WebDriver driver) throws IOException {
			Date date=new Date();
			String filename=date.toString().replace(" ", "").replace(":", "");
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File des=new File("./src/test/resources/"+filename+".png");
			String destination=des.getAbsolutePath();
			FileUtils.copyFile(src, des);
			return destination;
		}
		
}
