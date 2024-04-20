package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage {
	public WebDriver driver;
	

	public registerPage(WebDriver driver) {
		this.driver = driver;

	}

	By firstName = By.name("firstname");
	By lastName = By.name("lastname");
	By emailId = By.name("email");
	By telePhone = By.name("telephone");
	By password = By.name("password");
	By confirmPassword = By.name("confirm");
	By agree = By.name("agree");

	public void registerUser(String fname, String lname, String emailString, String phone, String pass) {

		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(emailId).sendKeys(emailString);
		driver.findElement(telePhone).sendKeys(phone);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(confirmPassword).sendKeys(pass);
		driver.findElement(agree).click();

	}

}
