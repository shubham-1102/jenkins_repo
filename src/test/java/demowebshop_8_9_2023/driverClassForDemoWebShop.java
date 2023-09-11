package demowebshop_8_9_2023;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pom_8_9_2023.LoginPageObject;
import pom_8_9_2023.Loginpage1;

public class driverClassForDemoWebShop {
 
	WebDriver driver;
	Register_user user;
	Login_user log_in;
	String email = "divya122@123.com";
	String pass = "123456";
	
  @Test
  public void f() throws InterruptedException {
	  
	  user = new Register_user(driver);
	  user.registeruser1("Shubham", "Patil", email, pass, pass);
	  Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/registerresult/1");
	  Thread.sleep(5000);
	  user.ClickLogout();

	  log_in = new Login_user(driver);
	  log_in.loginuser1(email, pass);
	  Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
  }
  
  
  @BeforeTest
  public void beforetestmethod() {
	  driver = new ChromeDriver();
	  driver.get("https://demowebshop.tricentis.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));  
	  
  }
  
  @AfterTest
  public void quitdriver() {
	 // driver.quit();
  }
}
