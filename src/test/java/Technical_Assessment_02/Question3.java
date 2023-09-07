package Technical_Assessment_02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Question3 {
	WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up WebDriver and open the browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void validateHTML5FormsBookPrice() {
        // Navigate to the URL
        driver.get("https://practice.automationtesting.in/shop/");
        // Locate the HTML5 Forms book and get its price
        WebElement html5FormsBook = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[3]/a[1]/h3"));
         html5FormsBook.click();
         String priceText =driver.findElement(By.xpath("//*[@id=\"product-181\"]/div[2]/div[1]/p/span")).getText();
         System.out.println(priceText);
        // Validate the price
        Assert.assertEquals(priceText, "₹280.00");
    }

    @Test(priority = 2, dependsOnMethods="validateHTML5FormsBookPrice")
    public void clickJSDataStructuresAndAlgorithm() {
    	driver.get("https://practice.automationtesting.in/shop/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[5]/a[1]")).click();
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("JS Data Structures"));
    }

    @Test(priority = 3, dependsOnMethods = "clickJSDataStructuresAndAlgorithm")
    public void clickHTML3AndValidateBookCount() {
        driver.findElement(By.linkText("HTML (3)")).click();
        List<WebElement> bookCount = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li[5]/a[1]/h3"));
        System.out.println(bookCount.size());
        Assert.assertEquals(bookCount.size(), "3");
    }

    @Test(priority = 4)
    public void sortProductsByPriceLowToHigh() {
        // Open the URL
        driver.get("https://practice.automationtesting.in/shop/");
        // Sort products by Price: Low to High
        driver.findElement(By.name("orderby")).sendKeys("price");
        // Implement verification logic here to validate the sorted results
        // Add appropriate assertions based on your verification criteria
    }

    @Test(priority = 5)
    public void validateSubscribeButtonPresence() {
        // Open the URL
        driver.get("https://practice.automationtesting.in/shop/");
        // Validate the presence of the Subscribe button
        WebElement subscribeButton = driver.findElement(By.xpath("//*[@id=\"mc4wp-form-1\"]/div[1]/p[2]/input"));
        Assert.assertEquals(subscribeButton.isDisplayed(), "Subscribe button is not present");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
