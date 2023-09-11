package pom_8_9_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepagee1 {
	WebDriver driver;
	By admin = By.xpath("//span[text()='Admin']");
	By PIM = By.xpath("//span[text()='PIM']");
	
	public Homepagee1(WebDriver driver) {
		this.driver = driver;
	}

	
	public void clickAdmin() {
		driver.findElement(admin).click();
	}

	public void clickPIM() {
		driver.findElement(PIM).click();
	}
	
	
}
