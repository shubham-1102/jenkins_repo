package jenkins_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewTest2 {
	
	WebDriver driver;
	@Test
  public void f() {
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.findElement(By.name("q")).sendKeys("Selenium",Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		Assert.assertEquals(driver.getTitle(), "Selenium - Google Search");
				
  }
}
