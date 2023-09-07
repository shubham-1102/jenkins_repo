package data_provider;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class data_provider_class {
	WebDriver driver;
	
	@DataProvider(name="datapro")
    String[][] readExcel() throws BiffException, IOException
    {    //input stream object creation
		   FileInputStream excel= new FileInputStream("C:\\Users\\shupatil\\Downloads\\Data.xls");
	        //getting workbook,sheet,rows and col
	        Workbook workbook=Workbook.getWorkbook(excel);
	        Sheet sheet=workbook.getSheet(0);
	        int row_count=sheet.getRows();
	        int col_count=sheet.getColumns();
	        //create 2d array
	        String[][] data1=new String[row_count-1][col_count];

	        for(int i=1;i<row_count;i++)//row iteration
	        {
	            for(int j=0;j<col_count;j++)//column iteration
	            {data1[i-1][j]=sheet.getCell(j,i).getContents();//getcell(columns,row)
	            }
	        }
	        return data1;  

    }
	

	@Test(dataProvider = "datapro")
    void LoginUsingJXL(String uname1,String pwd1) throws Exception
    {  
		WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver();
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		 WebElement uname = driver.findElement(By.name("username"));
		  WebElement upass = driver.findElement(By.name("password"));
		  WebElement submit = driver.findElement(By.xpath("//button[text()=' Login ']"));
		  uname.sendKeys(uname1);
		  upass.sendKeys(pwd1);
		  submit.sendKeys(Keys.ENTER);

		
    }
}
