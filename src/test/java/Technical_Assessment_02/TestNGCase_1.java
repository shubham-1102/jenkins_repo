	package Technical_Assessment_02;
	
	import java.time.Duration;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	
	import junit.framework.Assert;
	
	public class TestNGCase_1 {
		WebDriver driver;
		
		@Test(groups = "Group1")
		  public void TestCase_02() {
			  
			  Assert.assertEquals(driver.getCurrentUrl(), "https://www.godaddy.com/en-in");
			  
		  }
		  @Test(groups = "Group1")
		  public void TestCase_01() {
			  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(4));
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//nav[@id='id-631b049a-e9c0-4d24-8710-c504745206dd']")))).click();
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@aria-haspopup=\"true\"]")))).click();
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@data-cy=\"optional-panel-list-anchor\"]")))).click();
			  
			String getext = driver.findElement(By.linkText("Domain Name Search")).getText();
	
			System.out.println(getext);
	
				Assert.assertEquals(getext, "Domain Name Search");
		  }
		  
		  @Test(groups = "Group2")
		  public void TestCase_03() throws InterruptedException {
			  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(4));
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//nav[@id='id-631b049a-e9c0-4d24-8710-c504745206dd']")))).click();
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@aria-haspopup=\"true\"]")))).click();
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@data-cy=\"optional-panel-list-anchor\"]")))).click();
			  
			  
			  Assert.assertEquals(driver.getTitle(),"Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN");
			  Thread.sleep(1000);
		  }
		  
		  @Test(groups = "Group2")
	
			public void test04() {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
				WebElement help = driver.findElement(By.linkText("Help"));
				help.click();
				WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
				contactUs.click();
				WebElement contactNumber = driver.findElement(By.linkText("040-67607600"));
				String num = contactNumber.getText();
	
		 
	
				Assert.assertEquals(num, "040-67607600");
	
			}
		  
		  @BeforeMethod
		  public void beforMethod()
		  {
			//creating instance of chromedrive
			  driver=new ChromeDriver();
			  
			  //Opening the browser
			  driver.get("https://www.godaddy.com/");
			  
			  //maximizing the browser
			  driver.manage().window().maximize();
		  }
		
	
	}
