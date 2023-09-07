package Technical_Assessment_02;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 
public class TestNGCase_03 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 1, description = "Validate HTML5 Forms book price")
    public void testCase1() {
        driver.get("https://practice.automationtesting.in/shop/");
        WebElement bookPriceElement = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[3]/a[1]/span/span"));
        String bookPrice = bookPriceElement.getText();
        Assert.assertEquals(bookPrice, "₹280.00");
    }
    @Test(priority = 2, description = "Click on JS Data Structures and Algorithm")
    public void testCase2() {
        driver.get("https://practice.automationtesting.in/shop/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[5]/a[1]")).click();
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("JS Data Structures"));
    }
    @Test(priority = 3, description = "Click on HTML and validate the number of books")
    public void testCase3() {
        driver.get("https://practice.automationtesting.in/shop/");
        driver.findElement(By.xpath("//*[@id=\"woocommerce_product_categories-2\"]/ul/li[2]/a")).click();
        List<WebElement> books = driver.findElements(By.xpath("//*[@class=\"attachment-shop_catalog size-shop_catalog wp-post-image\"]"));
        int count= 0;
        for(WebElement webelement12:books) {
            count++;
        }
        
        Assert.assertEquals(count, 3, "Number of books displayed is not as expected");

    }

 

    @Test(priority = 4, description = "Sort by Price: Low to High")
    public void testCase4() {
        driver.get("https://practice.automationtesting.in/shop/");
        WebElement sortByDropdown = driver.findElement(By.name("orderby"));
        sortByDropdown.sendKeys("price");
        sortByDropdown.submit();
    }

    @Test(priority = 5, description = "Validate Subscribe button presence")
    public void testCase5() {
        driver.get("https://practice.automationtesting.in/shop/");
        WebElement subscribeButton = driver.findElement(By.xpath("//*[@id=\"mc4wp-form-1\"]/div[1]/p[2]/input"));
        Assert.assertTrue(subscribeButton.isDisplayed());

    }

}