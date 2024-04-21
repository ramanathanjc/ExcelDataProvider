package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.ExcelUtil;
import pages.registerPage;

public class RegistrationTest{
	
	public static WebDriver driver;
	public ExcelUtil excel;

	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		excel = new ExcelUtil();
		
	}
	
	@DataProvider
	public Object[][] getRegTestData() {
		Object regData[][] = ExcelUtil.getData("reg");
		return regData;
		
	}
	
	
	@Test(dataProvider = "getRegTestData")
	public void test(String firstName, String lastName, String email ,String telephone, String password) {
		registerPage  rp = new registerPage(driver); 
		
		rp.registerUser(firstName, lastName, email ,telephone, password);
		
	}
	
	@AfterTest
	public void tearDown() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

	

}
