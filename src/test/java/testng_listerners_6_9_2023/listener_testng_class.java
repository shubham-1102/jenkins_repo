package testng_listerners_6_9_2023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listerner1.class)
public class listener_testng_class {
	WebDriver driver;
	@BeforeTest
	public void beforeclass() {
		driver = new ChromeDriver();
		driver.get("https://google.com");
	}
	@Test
  public void f() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.findElement(By.name("q")).sendKeys("Selenium",Keys.ENTER);
  }
	
	@Test
	  public void f1() {
			driver.navigate().back();
	  }
		
	@AfterTest
	public void afterclass() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}
