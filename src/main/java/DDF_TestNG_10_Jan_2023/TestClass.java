package DDF_TestNG_10_Jan_2023;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	
	WebDriver driver;
	ActiLogin al;
	ActiHome ah;
	Sheet sh;
	
	
	@BeforeClass
	
	public void opeBrowser() throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Nikhil\\Desktop\\Testing Recorded Session and Notes\\All Recorded Lectures\\Jan-2023\\Day-69-10-01-2023\\DDF_TestNG.xlsx");
		sh = WorkbookFactory.create(fis).getSheet("sheet1");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		al = new ActiLogin(driver);
		ah = new ActiHome(driver);
		
	}
	
	@BeforeMethod
	
	public void openApp() {
		
		String username = sh.getRow(0).getCell(0).getStringCellValue();
		al.enterUN(username);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String passward = sh.getRow(0).getCell(1).getStringCellValue();
		al.enterPWD(passward);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		al.clickLogInBTN();
	}
	
	@Test
	
	public void verifyText() {
		String expText= sh.getRow(0).getCell(2).getStringCellValue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actText = ah.verifyText();
		
		Assert.assertEquals(actText, expText);
	}
	

}
