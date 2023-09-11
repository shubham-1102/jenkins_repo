package pom_8_9_2023;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject {

	@FindBy(name="username")
	public static WebElement urname;
	
	@FindBy(name="password")
	public static WebElement pwd;
	
	@FindBy(xpath ="//button[text()=' Login ']")
	public static WebElement btnlogin;

}
