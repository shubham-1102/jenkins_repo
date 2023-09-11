package demowebshop_8_9_2023;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_user {
	WebDriver driver;
	
	@FindBy(xpath="//a[text()=\"Log in\"]")
	private WebElement login;
	
	@FindBy(name="Email")
	private WebElement Email;
	
	@FindBy(name="Password")
	private WebElement Pass;
	
	@FindBy(xpath="//*[@value=\"Log in\"]")
	private WebElement Btnlogin;

	public void clickLogin() {
		this.login.click();
	}

	public void setEmail(String email) {
		this.Email.sendKeys(email);
	}

	public void setPass(String pass) {
		this.Pass.sendKeys(pass);
	}

	public void setBtnlogin() {
		this.Btnlogin.click();
	}

	public void loginuser1(String email,String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		clickLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		setEmail(email);
		setPass(password);
		setBtnlogin();
	}

	public Login_user(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
