package Technical_Assessment_02;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Login_and_logout_check {
	WebDriver driver;
	String url_login = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	String url_logout = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeTest
	public void befireMethod() {
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com");
			driver.manage().window().maximize();
	}
	
	@Test
  public void f() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		 WebElement uname = driver.findElement(By.name("username"));
		  WebElement upass = driver.findElement(By.name("password"));
		  WebElement submit = driver.findElement(By.xpath("//button[text()=' Login ']"));
		  uname.sendKeys("Admin");
		  upass.sendKeys("admin123");
		  submit.sendKeys(Keys.ENTER);
		Assert.assertEquals(url_login, driver.getCurrentUrl());
	}
	
	@Test(dependsOnMethods = {"f"})
	public void f1() {
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Assert.assertEquals(url_logout, driver.getCurrentUrl());
	}
	
	@AfterTest
	public void aftertest() throws InterruptedException {
		System.out.println("After test method");
		Thread.sleep(9000);
		driver.quit();
	}
	
}
