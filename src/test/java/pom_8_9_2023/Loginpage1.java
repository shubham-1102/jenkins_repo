package pom_8_9_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage1 {
	
	By username = By.name("username");
	By password = By.name("password");
	By login = By.xpath("//button[@type='submit']");
	
	WebDriver driver;
	public Loginpage1(WebDriver driver) {
		this.driver = driver;
	}
	public void setUsername(String uname) {
		driver.findElement(username).sendKeys(uname);
	}
	public void setPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	public void loginpage(String uname,String pass) {
		this.setUsername(uname);
		this.setPassword(pass);
		this.clickLogin();
	}
	
	
	
	

}
