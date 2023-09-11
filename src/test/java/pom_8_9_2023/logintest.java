package pom_8_9_2023;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class logintest {

	WebDriver driver;
	Loginpage1 objlogin;
	Homepagee1 objhome;
	
  @Test
  public void f() {
	  objlogin = new Loginpage1(driver);
	  objlogin.loginpage("Admin", "admin123");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	  Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	  objhome = new Homepagee1(driver);
	  objhome.clickAdmin();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	  Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
  
  }
  
  
  @BeforeTest
  public void beforetestmethod() {
	  driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));  
  }
}
