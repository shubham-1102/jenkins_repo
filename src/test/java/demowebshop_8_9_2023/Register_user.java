package demowebshop_8_9_2023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_user {
	WebDriver driver;
	
	//*[text()=\"Confirm password:\"]
	@FindBy(xpath="//a[text()=\"Register\"]")
	private WebElement register;
	
	@FindBy(xpath="//input[@value=\"Register\"]")
	private WebElement btnRegister;
	
	@FindBy(xpath="//*[text()=\"Male\"]")
	private WebElement Male;
	
	@FindBy(xpath="//input[@name=\"FirstName\"]")
	private WebElement fname;
	
	@FindBy(xpath="//*[@name=\"LastName\"]")
	private WebElement lname;
	
	@FindBy(xpath="//*[@name=\"Email\"]")
	private WebElement email;
	
	@FindBy(xpath="//*[@name=\"Password\"]")
	private WebElement pass;
	
	@FindBy(xpath="//*[@name=\"ConfirmPassword\"]")
	private WebElement cpass;
	
	@FindBy(xpath="//a[text()=\"Log out\"]")
	private WebElement Logout;
	
	
	public Register_user(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickbtnRegister() {
		this.btnRegister.click();
	}

	public void ClickRegister() {
		this.register.click();
	}
	
	public void ClickLogout() {
		this.Logout.click();
	}

	public void ClickMale() {
		this.Male.click();
	}

	public void setFname(String firstname) {
		this.fname.sendKeys(firstname);
	}

	public void setLname(String lastname) {
		this.lname.sendKeys(lastname);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setPass(String pass) {
		this.pass.sendKeys(pass);
	}

	public void setCpass(String cpass) {
		this.cpass.sendKeys(cpass);
	}
	
	public void registeruser1(String Fname,String Lname,String Email,String Pass,String CPass) throws InterruptedException {
		ClickRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		setFname(Fname);
		setLname(Lname);
		setEmail(Email);
		setPass(Pass);
		setCpass(CPass);
		ClickbtnRegister();
		
		
	}
	
	
	
	
}
