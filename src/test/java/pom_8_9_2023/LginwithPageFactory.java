package pom_8_9_2023;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LginwithPageFactory {
	WebDriver driver ;
	@Test
  public void f() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  
	  PageFactory.initElements(driver, LoginPageObject.class);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	  LoginPageObject.urname.sendKeys("Admin");
	  LoginPageObject.pwd.sendKeys("admin123");
	  LoginPageObject.btnlogin.click(); 
	  
	  Thread.sleep(7000);
	  driver.quit();
  }
}
